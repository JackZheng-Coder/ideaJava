package com.http;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient extends JFrame {

    public static void main(String[] args) {
        //EventQueue事件队列，封装了异步事件指派机制
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyClient client = new MyClient("向服务器发送数据");
                client.setSize(400,400);
                client.setVisible(true);
                client.connect();
            }
        });
    }

    private PrintWriter writer;
    Socket socket;
    private JTextArea ta = new JTextArea();
    private JTextField tf = new JTextField();
    Container cc;
    public MyClient(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cc = this.getContentPane();

        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(scrollPane,BorderLayout.CENTER);
        scrollPane.setViewportView(ta);
        cc.add(tf,"South");

        tf.addFocusListener(new JTextFieldListener(tf,"请在此输入内容"));
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(tf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(MyClient.this,"请输入内容！");
                }else {
                    writer.println(tf.getText());

                    ta.append(tf.getText()+"\n");
                    ta.setSelectionEnd(ta.getText().length());
                    tf.setText("");
                }
            }
        });
    }

    private void connect(){
        ta.append("尝试连接\n");
        try{
            socket = new Socket("127.0.0.1",8998);
            writer = new PrintWriter(socket.getOutputStream(),true);
            ta.append("完成连接\n");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //焦点监听器
    class JTextFieldListener implements FocusListener {
        private String hintText; //提示文字
        private JTextField textField;
        public JTextFieldListener(JTextField textField,String hintText) {
            this.textField=textField;
            this.hintText=hintText;
            textField.setText(hintText);   //默认直接显示
            textField.setForeground(Color.GRAY);
        }

        @Override
        public void focusGained(FocusEvent focusEvent) {
            //获取焦点时，清空提示内容
            String temp = textField.getText();
            if (temp.equals(hintText)){
                textField.setText("");
                textField.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent focusEvent) {
            //失去焦点时，没有输入内容，显示提示内容
            String temp = textField.getText();
            if(temp.equals("")){
                textField.setForeground(Color.GRAY);
                textField.setText(hintText);
            }
        }
    }
}
