package com.zyx.text;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class Jishiben {
    public static void main(String[] args) {
        TextEdit TE = new TextEdit("记事本");
    }
}
class TextEdit extends JFrame implements ActionListener{
    JMenuBar m;
    JMenu m1,m2;
    JMenuItem xinjian,dakai,baocun,tuichu,jiangqie,fuzhi,zhantie;
    JTextArea text;
    String filename;
    FileDialog openFD,saveFD;
    BufferedReader in;
    FileReader read;
    BufferedWriter out;
    FileWriter write;
    Clipboard cb;
    TextEdit(String s){
        super(s);
        m = new JMenuBar();
        m1 = new JMenu("文件");
        xinjian = new JMenuItem("新建");
        dakai = new JMenuItem("打开");
        baocun = new JMenuItem("保存");
        tuichu = new JMenuItem("退出");
        m2 = new JMenu("编辑");
        jiangqie = new JMenuItem("剪切");
        fuzhi = new JMenuItem("复制");
        zhantie = new JMenuItem("粘贴");
        text = new JTextArea();
        openFD = new FileDialog(this,"打开",FileDialog.LOAD);
        saveFD = new FileDialog(this,"打开",FileDialog.SAVE);
        filename = "NoName";

        m1.add(xinjian);
        m1.addSeparator();
        m1.add(dakai);
        m1.addSeparator();
        m1.add(baocun);
        m1.addSeparator();
        m1.add(tuichu);
        m2.add(jiangqie);
        m2.addSeparator();
        m2.add(fuzhi);
        m2.addSeparator();
        m2.add(zhantie);
        m.add(m1);
        m.add(m2);
        //关键部分，没有为cb申请内存，下面对cb操作会出错
        cb = new Clipboard("nothing");

        setJMenuBar(m);
        setSize(300,400);
        setVisible(true);
        add(text,"Center");

        xinjian.addActionListener(this);
        dakai.addActionListener(this);
        baocun.addActionListener(this);
        tuichu.addActionListener(this);
        jiangqie.addActionListener(this);
        fuzhi.addActionListener(this);
        zhantie.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == xinjian){
            text.setText("");
        }
        if(e.getSource() == dakai){
            openFD.show();
            String s;
            filename = openFD.getDirectory()+openFD.getFile();
            if(filename != null){
                try {
                    File file = new File(filename);
                    read = new FileReader(file);
                    in = new BufferedReader(read);
                    while ((s = in.readLine())!=null){
                        text.append(s+'\n');
                    }
                    in.close();
                    read.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        if (e.getSource() == baocun){
            saveFD.show();
            filename = saveFD.getDirectory() + saveFD.getFile();
            if(filename != null){
                try {
                    File file = new File(filename);
                    write = new FileWriter(file);
                    out = new BufferedWriter(write);
                    out.write(text.getText(),0,(text.getText()).length());

                    out.close();
                    write.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        if (e.getSource() == jiangqie){
            //类text中没有cut方法，不能使用text.cut
            String s = text.getSelectedText();
            StringSelection select =new StringSelection(s);
            cb.setContents(select,null);
            text.replaceRange("",text.getSelectionStart(),text.getSelectionEnd());
        }
        if (e.getSource() == fuzhi){
            //同上，没有copy这个方法
            String s = text.getSelectedText();
            StringSelection select =new StringSelection(s);
            cb.setContents(select,null);
        }
        if (e.getSource() == zhantie){
            //同上，没有paste方法
            String s = "";
            Transferable t = cb.getContents(null);
            try {
                if(t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)){
                    // 因为原系的剪贴板里有多种信息, 如文字, 图片, 文件等
                    // 先判断开始取得的可传输的数据是不是文字, 如果是, 取得这些文字

                    s = (String)t.getTransferData(DataFlavor.stringFlavor);
                    // 同样, 因为Transferable中的DataFlavor是多种类型的,
                    // 所以传入DataFlavor这个参数, 指定要取得哪种类型的Data.
                    //System.out.println(s);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
            text.insert(s,text.getCaretPosition());
        }
    }
}
