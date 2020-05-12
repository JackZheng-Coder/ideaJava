package com.http;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",8888);
            //构件io
            InputStream is = s.getInputStream();
            OutputStream os  = s.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            Scanner sc = new Scanner(System.in);
            Thread readThread = new Thread(){
                @Override
                public void run() {
                    while (true){
                        String msg = null;
                        try {
                            msg = br.readLine();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            };
            Thread writeThread = new Thread(){
                @Override
                public void run() {
                    while (true){
                        try {
                            bw.write(sc.next() +"\n");
                            bw.flush();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            };
            readThread.start();
            writeThread.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
