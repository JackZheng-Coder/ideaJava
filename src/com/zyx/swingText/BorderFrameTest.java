package com.zyx.swingText;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class BorderFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new BorderFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class BorderFrame extends JFrame{
    private JPanel demoPanel;
    private JPanel buttonPanel;
    private ButtonGroup group;

    public BorderFrame(){
        demoPanel = new JPanel();
        buttonPanel = new JPanel();
        group = new ButtonGroup();

        addRadioButton("1",BorderFactory.createLoweredBevelBorder());
        addRadioButton("2",BorderFactory.createRaisedBevelBorder());
        addRadioButton("3",BorderFactory.createEtchedBorder());
        addRadioButton("4",BorderFactory.createLineBorder(Color.BLUE));
        addRadioButton("5",BorderFactory.createMatteBorder(10,10,10,10,Color.BLUE));
        addRadioButton("6",BorderFactory.createEmptyBorder());

        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched,"Border types");
        buttonPanel.setBorder(titled);

        setLayout(new GridLayout(2,1));
        add(buttonPanel);
        add(demoPanel);
        pack();
    }

    public void addRadioButton(String buttonName, Border b){
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(event-> demoPanel.setBorder(b));
        group.add(button);
        buttonPanel.add(button);
    }
}
