/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResourcesPools;

/**
 *
 * @author Nephross
 */
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class SysThreadPool extends ThreadPoolExecutor{
	
	//Use threadpool executer instead! - http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ThreadPoolExecutor.html
	
	private static SysThreadPool instance;
	
	public SysThreadPool(int corePoolSize, int maxPoolSize){
		
		super(corePoolSize, maxPoolSize, 21600, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		if (instance != null){
			throw new IllegalStateException("Cannot make new instance of DBWrapper");
		}
		
	}

	public static synchronized SysThreadPool getInstance(){
		if (instance == null){
			instance = new SysThreadPool(10, 25);
		}
		return instance;
	}
	
}
