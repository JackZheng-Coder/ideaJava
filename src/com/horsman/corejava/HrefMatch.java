package com.horsman.corejava;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.rmi.server.ExportException;
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
public class HrefMatch {
    public static void main(String[] args) {
        try {
            String urlString;
            if (args.length > 0) urlString = args[0];
            else urlString = "http://java.sun.com";

            InputStreamReader in = new InputStreamReader(new URL(urlString).openStream(),StandardCharsets.UTF_8);

            StringBuilder input = new StringBuilder();
            int ch ;
            while ((ch = in.read()) != -1){
                input.append((char) ch);
            }
            String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
            Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){
                String match = matcher.group();
                System.out.println(match);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
