package com.horsman.corejava;

import java.applet.Applet;
import java.awt.*;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class VerifierTest extends Applet {
    public static void main(String[] args) {
        System.out.println("1 + 2 ==" + fun());
    }

    public static int fun(){
        int m;
        int n;
        m = 1;
        n = 2;
        int r = m + n;
        return r;
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("1 + 2 ==" +fun(),20,20);
    }

}
