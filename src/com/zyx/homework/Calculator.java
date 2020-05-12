package com.zyx.homework;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.TransferQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
/*
    输入四个数字的加减乘除表达式, 输出运算结果
    样例输入 6.5-4*3+3
    样例输出 -2.5
 */
    /*
        思路分析：1、求值表达式主要包括加减乘除四种基本运算，其实表达式可以看做由一个个二元运算构成，前一个二元运算的结果作为后一个二元运算的输入。
举个例子： “1+2-4=”，“1+2”就是一个二元运算，1和2是操作数，+是运算符，它们的运算结果3作为下一个二元运算的输入，所以下一个二元运算是“3-4”，这样经过两次二元运算后得出结果-1，此时碰到表达式结束符号“=”，那么表达式运算结束，最终值为-1。当然有时候表达式不是以等号作为结束符号的，这种场景要特别注意下。
2、加减乘除四种运算符是有优先级的，乘法和除法同级，且比加法和减法优先级高，也就是说同级的运算顺序是从左到右，高优先级的二元运算优先执行。
        举个例子：“1+2*3=”，“2*3”这个二元运算因为乘法的优先级高，所以优先执行，执行结果作为+二元运算的第二个操作数。
3、括号运算其实相当于嵌套一个子表达式，而子表达式的优先级比括号外的加减乘数二元运算高，子表达式的计算结果作为主表达式的一个操作数。
4、由上面的说明可知，表达式有两个基本元素，那就是操作数和运算符，运算符一般占用一个字符，而操作数可能是1, 2, 3这样的个位整数，也可能是1.0, 1.89这样的浮点数，也可能是100, 189这样的多位整数。所以我们在从表达式解析出操作数时要完整的解析出整个操作数。
5、表达式一般以等号作为表达式结束标记，当然有不以等号作为结束标记的场景，详情看下面代码处理逻辑。
     */
    /*
        算法分析：
            1.表达式由正则模式 "[0-9\\.+-/*()= ]+" 来校验合法性。
            2.表达式中的数值被push到数值栈中，而操作符被push到操作符栈当中，解析表达式时，采用逐个读取字符的形式，
            特别注意操作数是多位字符的场景，可以采用一个追加器将字符先缓存起来，当完整读取一个数值时再讲数值push到数值栈中。
            3.当准备push到运算符栈的当前运算符，优先级同级于或低于栈顶运算符时，将触发一次二元运算，
            参与二元运算的为运算符栈的栈顶元素以及数值栈栈顶的两个操作数。二元运算得支持高精度运算，同时避免精度丢失问题。
            4括号运算，相等于子表达式运算，当表达式解析到左括号时，将左括号push到栈中，当解析到右括号，将递归运算整个表达式的所有
            二次运算操作，直到碰到左括号才停止，此时子表达式的计算结果作为新的操作数push到数值栈中。

         举个例子： “2 * (3 - 1*2)=”，在解析到右括号“)”前，运算符栈中已有元素[“*”，“-”，“(”，“*”]，
         数值栈已有元素[“2”、“1”、“3”、“2”]。
        当碰到右括号时，触发一次二元运算，即“1*2”，运算符栈的栈顶元素“*”出栈，数值栈的栈顶元素“2”和“1”分别出栈，
        二元运算得出结果“2”，结果值push到数值栈。此时运算符栈中已有元素[“-”，“(”，“*”]，数值栈已有元素[“2”、“3”、“2”]。

        子表达式还没运算结束，继续递归触发二元运算，即“3-2”，运算符栈的栈顶元素“-”出栈，数值栈的栈顶元素“2”和“3”分别出栈，
        二元运算得出结果“1”，结果值push到数值栈。此时运算符栈中已有元素[“(”，“*”]，数值栈已有元素[“1”、“2”]。

        继续读取运算符栈顶元素，发现是左括号“(”，此时栈顶元素出栈，而无需触发二元计算，此时运算符栈中已有元素[“*”]，
         数值栈已有元素[“1”、“2”]。

        表达式继续解析，此时发现读取到等号“=”，递归触发表达式的所有二元运算，即“2*1”，得出最终结果2，计算结束。
     */

public class Calculator {
    //表达式字符合法校验正则表达式，静态常量化可以降低每次使用都要编译地消耗
    private  static final Pattern EXPRESSION_PATTERN = Pattern.compile("[0-9\\.+-/*()= ]+");

    //运算符优先级
    public static final Map<String,Integer> OPT_PRIORITY_MAP = new HashMap<>(){
      private static final long serialVersionUID = 6968472606692771458L;
        {
            put("(", 0);
            put("+", 2);
            put("-", 2);
            put("*", 3);
            put("/", 3);
            put(")", 7);
            put("=", 20);
        }
    };

    /**
     *  priority = 0  表示两个运算符同级别
     *  priority = 1  表示第2个运算符同级高,负数则相反
     * @param opt1
     * @param opt2
     * @return
     */
    public static int getPriority(String opt1,String opt2){
        int priority =  OPT_PRIORITY_MAP.get(opt2) - OPT_PRIORITY_MAP.get(opt1);
        return priority;
    }

    /**
     * 不丢失精度的二元运算，支持高精度计算
     * @param opt   //操作符
     * @param bigDecimal1
     * @param bigDecimal2
     * @return
     */
    public static BigDecimal floatingPointCalc(String opt,BigDecimal bigDecimal1,BigDecimal bigDecimal2){
        BigDecimal resultBigDecimal = new BigDecimal(0); //存放结果值，初始化0
        switch (opt){
            case "+":
                resultBigDecimal = bigDecimal1.add(bigDecimal2);
                break;
            case "-":
                resultBigDecimal = bigDecimal1.subtract(bigDecimal2);
                break;
            case "*" :
                resultBigDecimal = bigDecimal1.multiply(bigDecimal2);
                break;
            case "/"://进行四舍五入的操作  scale:表示四舍五入的位数，ROUND_DOWN：趋向零方向舍入。向0方向靠拢，也就是说，向绝对值最小的方向输入，注意：所有的位都舍弃，不存在进位情况。
                resultBigDecimal = bigDecimal1.divide(bigDecimal2,10,BigDecimal.ROUND_HALF_DOWN);
                break;
            default:
                break;
        }
        return resultBigDecimal;
    }

    /**
     * 拿当前运算符和栈顶运算符对比，如果栈顶运算符优先级高于或同级于当前运算符，
     * 则执行一次二元运算(递归比较计算) 否则当前运算符入栈
     * @param optStack 运算符栈
     * @param numStack 数值栈
     * @param curOpt 当前运算符
     */
    public static void compareAndCalc(Stack<String> optStack,Stack<BigDecimal> numStack,String curOpt){
        //比较当前运算符和占顶运算符的优先级
        String peekOpt = optStack.peek();
        int priority = getPriority(peekOpt,curOpt);
        if (priority == 0 || priority == -1){
            // 栈顶运算符优先级大或同级，触发一次二元运算
            String opt = optStack.pop();    //参与当前计算运算符
            BigDecimal num2 = numStack.pop();  // 当前参与计算数值2
            BigDecimal num1 = numStack.pop();// 当前参与计算数值1
            BigDecimal bigDecimal = floatingPointCalc(opt,num1,num2);

            numStack.push(bigDecimal);//计算结果当做操作数放入栈中

            // 运算完栈顶还有运算符，则还需要再次触发一次比较判断是否需要再次二元计算
            if (optStack.empty()){
                optStack.push(curOpt);
            }else {
                compareAndCalc(optStack,numStack,curOpt);
            }
        }else {
            // 当前运算符优先级高，则直接入栈

            optStack.push(curOpt);
        }
    }

    /**
     * 遇到右括号和等号执行的连续计算操作(递归计算)
     * @param optStack 运算符栈
     * @param numStack 数值栈
     * @param isBracket true表示为括号类型计算
     */
    public static void directCalc(Stack<String> optStack,Stack<BigDecimal> numStack,boolean isBracket){
        String opt = optStack.pop();    //参与当前计算运算符
        BigDecimal num2 = numStack.pop();  // 当前参与计算数值2
        BigDecimal num1 = numStack.pop();// 当前参与计算数值1
        BigDecimal bigDecimal = floatingPointCalc(opt,num1,num2);

        numStack.push(bigDecimal);

        if(isBracket){
          if ("(".equals(optStack.peek())){
              // 括号类型则遇左括号停止计算，同时将左括号从栈中移除
              optStack.pop();
          }else {
              directCalc(optStack,numStack,isBracket);
          }
        }else {
            if (!optStack.empty()){
                // 等号类型只要栈中还有运算符就继续计算
                directCalc(optStack,numStack,isBracket);
            }
        }

    }

    /**
     * 输入字符串表达式，返回计算结果
     * @param expression
     * @return
     */
    public static double executeExpression(String expression){
        //非空校验
        if (expression == null || "".equals(expression.trim())){
            throw  new IllegalArgumentException("表达式不能为空");
        }
        //表达式字符合法性校验
        Matcher matcher = EXPRESSION_PATTERN.matcher(expression);
        if (!matcher.matches()){
            throw new IllegalArgumentException("表达式含有非法字符");
        }

        Stack<String> optStack = new Stack<>();//运算符栈
        Stack<BigDecimal> numStack = new Stack<>(); // 数值栈
        StringBuilder curNumBuilder = new StringBuilder(16);// 当前正在读取中的数值字符追加器

        for (int i = 0; i<expression.length();i++){
            char c = expression.charAt(i);
            if (c != ' '){ //空白字符直接丢弃
                if ((c >= '0' && c <= '9') || c == '.'){
                    curNumBuilder.append(c); //持续读取一个数值的各个字符
                }else {
                    if (curNumBuilder.length() > 0){
                        // 如果追加器有值，说明之前读取的字符是数值，而且此时已经完整读取完一个数值
                        numStack.push(new BigDecimal(curNumBuilder.toString()));
                        curNumBuilder.delete(0,curNumBuilder.length());
                    }
                    String curOpt = String.valueOf(c);
                    if (optStack.empty()){
                        //运算符栈顶为空直接入栈
                        optStack.push(curOpt);
                    }else {
                        if (curOpt.equals("(")){
                            //当前运算符为左括号，直接入栈
                            optStack.push(curOpt);
                        }else if (curOpt.equals(")")){
                            //当运算符为右括号，触发括号内的表达式进行计算
                            directCalc(optStack,numStack,true);
                        }else if (curOpt.equals("=")){
                            // 当前运算符为等号，触发整个表达式剩余计算，并返回总的计算结果
                            directCalc(optStack,numStack,false);
                            return numStack.pop().doubleValue();
                        }else {
                            // 当前运算符为加减乘除之一，要与栈顶运算符比较，判断是否要进行一次二元计算
                            compareAndCalc(optStack,numStack,curOpt);
                        }
                    }
                }
            }
        }
        //表达式不是以等号结尾的场景
        if (curNumBuilder.length() > 0){
            // 如果追加器有值，说明之前读取的字符是数值，而且此时已经完整读取完一个数值
            numStack.push(new BigDecimal(curNumBuilder.toString()));
        }
        directCalc(optStack,numStack,false);
        return numStack.pop().doubleValue();
    }
    private Calculator(){};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入表达式:");
        String str = in.nextLine();
        System.out.println(executeExpression(str));
    }


}
