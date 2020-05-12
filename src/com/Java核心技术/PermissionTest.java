package com.Java核心技术;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class PermissionTest {
    public static void main(String[] args) {
        System.setProperty("java.security.policy","Permissions/PermissionTest.policy");
        System.setSecurityManager(new SecurityManager());
        EventQueue.invokeLater(() ->{
            JFrame frame = new PermissionTestFrame();
            frame.setTitle("PermissionTest");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);

        });
    }
}
class PermissionTestFrame extends JFrame{
    private JTextField textField;
    private WordCheckTextArea textArea;
    private static final int TEXT_ROWS = 20;
    private static final int TEXT_COLUMNS = 20;

    public PermissionTestFrame(){
        textField = new JTextField(20);
        JPanel panel  = new JPanel();
        panel.add(textField);
        JButton button = new JButton("Insert");
        panel.add(button);
        button.addActionListener(event->insertWords(textField.getText()));

        add(panel, BorderLayout.NORTH);

        textArea = new WordCheckTextArea();
        textArea.setRows(TEXT_ROWS);
        textArea.setColumns(TEXT_COLUMNS);
        add(new JScrollPane(textArea),BorderLayout.CENTER);
        pack();

    }

    public void insertWords(String words){
        try
        {
            textArea.append(words +"\n");
        }catch (SecurityException ex){
            JOptionPane.showMessageDialog(this,"I am sorry,but i cannot do that");
            ex.printStackTrace();
        }
    }
}

class WordCheckTextArea extends JTextArea{
    @Override
    public void append(String text) {
        WordCheckPermission p = new WordCheckPermission(text, "insert") {
            @Override
            public String getActions() {
                return null;
            }
        };
         SecurityManager manager = System.getSecurityManager();
         if (manager != null) manager.checkPermission(p);
         super.append(text);
    }
}