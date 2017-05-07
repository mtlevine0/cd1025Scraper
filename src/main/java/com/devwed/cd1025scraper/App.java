package com.devwed.cd1025scraper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.devwed.cd1025scraper.repository.HibernateUtil;
import com.devwed.cd1025scraper.util.WorkerThread;

public class App {
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
		long startTime = System.currentTimeMillis();
        
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 50; i++) {
		    Runnable worker = new WorkerThread(i*50);
		    executor.execute(worker);
		  }
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		
		HibernateUtil.shutdown();
    }
}
