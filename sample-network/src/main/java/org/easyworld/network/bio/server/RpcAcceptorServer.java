package org.easyworld.network.bio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * This is a RPC provider
 * @author zhe.d.wang
 *
 */
public class RpcAcceptorServer {
	/*
	 * create thread pool by Executor
	 */
	static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	
	public static void bootstrapRpcServer(String hostName,int port) throws IOException{
		ServerSocket server = new ServerSocket();
		server.bind(new InetSocketAddress(hostName,port));
		
		try{
			while(true){
				executor.execute(new RpcExecutionTask(server.accept()));
			}
		}finally{
			server.close();
		}
	}
}
