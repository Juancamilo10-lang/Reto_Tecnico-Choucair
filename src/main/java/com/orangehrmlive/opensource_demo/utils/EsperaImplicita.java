package com.orangehrmlive.opensource_demo.utils;

public class EsperaImplicita {

    public static void esperaImplicita (int segundos){
        try {
            Thread.sleep(segundos*1000);
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }
    }
}
