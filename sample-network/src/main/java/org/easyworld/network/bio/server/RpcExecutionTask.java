package org.easyworld.network.bio.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RpcExecutionTask implements Runnable {

	private Socket client = null;
	
	public RpcExecutionTask(Socket client){
		this.client = client;
	}
	public void run() {
		// TODO Auto-generated method stub
		ObjectInputStream input = null;
		ObjectOutputStream output = null;
		
		try {
			input = new ObjectInputStream(client.getInputStream());
			String serviceInterfaceName = input.readUTF();
			System.out.println("Called interface name:" + serviceInterfaceName);
			String serviceMethodName =input.readUTF();
			System.out.println("Called method name:" + serviceMethodName);
			Class<?>[] parameterTypes = (Class<?>[])input.readObject();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
