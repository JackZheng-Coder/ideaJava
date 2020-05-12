package com.zyx.threadWork;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class BlockingQueueTest {
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREAD = 100;
    private static final File DUMMY = new File("");
    private static final BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)){
            System.out.print("请输入文件名或者目录名:");
            String directory = in.nextLine();
            System.out.print("请输入关键字:");
            String keyword = in.nextLine();

            Runnable enumerator = ()->{
                try {
                    enumerate(new File(directory));
                    queue.put(DUMMY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            new Thread(enumerator).start();
            for (int i = 1;i<SEARCH_THREAD;i++){
                Runnable searcher = ()->{
                    try {
                        boolean done = false;
                        while (!done){
                            File file = queue.take();
                            if(file == DUMMY){
                                queue.put(file);
                                done = true;
                            }else search(file,keyword);
                        }
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                };
                new Thread(searcher).start();
            }
        }
    }

    public static void enumerate(File directory) throws InterruptedException{
        File[] files = directory.listFiles();
        for (File file:files) {
            if (file.isDirectory()) enumerate(file);
            else queue.put(file);
        }
    }

    public static void search(File file,String keyword) throws IOException{
        try(Scanner in = new Scanner(file,"Utf-8")) {
            int lineNumber = 0;
            while (in.hasNext()){
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword))
                    System.out.printf("%s:%d:%s/n",file.getPath(),lineNumber,line);
            }
        }
    }
}
