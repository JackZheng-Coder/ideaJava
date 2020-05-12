package com.horsman.corejava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Properties;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class PropertiesTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            try {
                JFrame frame = new PropertiesFrame();
                frame.setVisible(true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        });
    }
}
class PropertiesFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private File propertiesFile;
    private Properties settings;

   public PropertiesFrame() throws FileNotFoundException {
       String userDir = System.getProperty("user.home");
       File propertiesDir = new File(userDir,".corejava");
       if (!propertiesDir.exists()) propertiesDir.mkdir();
       propertiesFile = new File(propertiesDir,"program.properties");

       Properties defaultSettings = new Properties();
       defaultSettings.setProperty("left","0");
       defaultSettings.setProperty("top","0");
       defaultSettings.setProperty("width",""+DEFAULT_WIDTH);
       defaultSettings.setProperty("height",""+DEFAULT_HEIGHT);
       defaultSettings.setProperty("tittle","");

       settings = new Properties(defaultSettings);

       if (propertiesFile.exists()){
           try(InputStream in = new FileInputStream(propertiesFile)){
               settings.load(in);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       int left = Integer.parseInt(settings.getProperty("left"));
       int top = Integer.parseInt(settings.getProperty("top"));
       int width = Integer.parseInt(settings.getProperty("width"));
       int height = Integer.parseInt(settings.getProperty("height"));
       setBounds(left,top,width,height);

       String tittle = settings.getProperty("tittle");
       if (tittle.equals(""))
           tittle = JOptionPane.showInputDialog("请申请一个窗口名");
       if (tittle==null) tittle = "";
       setTitle(tittle);

       addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               settings.setProperty("left",""+getX());
               settings.setProperty("top",""+getY());
               settings.setProperty("width",""+getWidth());
               settings.setProperty("height",""+getHeight());
               settings.setProperty("tittle",""+getTitle());
               try (OutputStream out = new FileOutputStream(propertiesFile)){
                   settings.store(out,"Program Properties");
               } catch (FileNotFoundException ex) {
                   ex.printStackTrace();
               } catch (IOException ex) {
                   ex.printStackTrace();
               }
               System.exit(0);
           }
       });

   }
}
