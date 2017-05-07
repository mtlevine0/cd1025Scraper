package com.devwed.cd1025scraper.util;

import com.devwed.cd1025scraper.service.Scraper;

public class WorkerThread implements Runnable {

    private int index;

    public WorkerThread(int index){
        this.index=index;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Index = "+Integer.toString(index));
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void processCommand() {
        Scraper scraper = new Scraper();
        scraper.scrapeSongs(index);    }

}