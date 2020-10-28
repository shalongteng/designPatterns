package com.slt.designpatterns.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {
        //字节流
        FileInputStream fis = new FileInputStream("c:/test.text");
        //转接器
        InputStreamReader isr = new InputStreamReader(fis);
        //字符
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null && !line.equals("")) {
            System.out.println(line);
        }
        br.close();

    }
}
