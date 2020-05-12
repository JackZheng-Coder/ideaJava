package com.horsman.corejava;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.prefs.BackingStoreException;
import java.util.prefs.InvalidPreferencesFormatException;
import java.util.prefs.Preferences;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class PreferencesTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new PreferencesFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class PreferencesFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private Preferences root = Preferences.userRoot();
    private Preferences node = root.node("/com/horsman/corejava");

   public PreferencesFrame(){
       int left = node.getInt("left",0);
       int top = node.getInt("top",0);
       int width = node.getInt("width",DEFAULT_WIDTH);
       int hight = node.getInt("hight",DEFAULT_HEIGHT);
       setBounds(left,top,width,hight);

       String tittle = node.get("tittle","");
       if (tittle.equals(""))
           tittle = JOptionPane.showInputDialog("请申请一个窗口名");
       if (tittle==null) tittle = "";
       setTitle(tittle);

       final JFileChooser chooser = new JFileChooser();
       chooser.setCurrentDirectory(new File("."));
       chooser.setFileFilter(new FileNameExtensionFilter("XML files","xml"));

       JMenuBar menuBar = new JMenuBar();
       setJMenuBar(menuBar);
       JMenu menu = new JMenu("File");
       menuBar.add(menu);

       JMenuItem exportItem = new JMenuItem("Export preferences");
       menu.add(exportItem);
       exportItem.addActionListener(event->{
           if (chooser.showOpenDialog(PreferencesFrame.this)== JFileChooser.APPROVE_OPTION){
               try {
                   savePreferences();
                   OutputStream out = new FileOutputStream(chooser.getSelectedFile());
                   node.exportSubtree(out);
                   out.close();
               } catch (FileNotFoundException e) {
                   e.printStackTrace();
               } catch (BackingStoreException e) {
                   e.printStackTrace();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       });
       JMenuItem importItem = new JMenuItem("Import preferences");
       menu.add(importItem);
       importItem.addActionListener(event->{
           if (chooser.showOpenDialog(PreferencesFrame.this)== JFileChooser.APPROVE_OPTION){
               try{
                   InputStream in = new FileInputStream(chooser.getSelectedFile());
                   Preferences.importPreferences(in);
                   in.close();
               } catch (FileNotFoundException e) {
                   e.printStackTrace();
               } catch (InvalidPreferencesFormatException e) {
                   e.printStackTrace();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       });
       JMenuItem exitItem = new JMenuItem("Exit");
       menu.add(exitItem);
       exitItem.addActionListener(event->{
           savePreferences();
           System.exit(0);
       });
   }

   public void savePreferences(){
       node.putInt("left",getX());
       node.putInt("top",getY());
       node.putInt("width",getWidth());
       node.putInt("height",getHeight());
       node.put("tittle",getTitle());
   }
}