package http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {
	private static final int PORT = 8087;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			//1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			//2. 바인딩
			String localhost = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(localhost, PORT));
			log("bind "+localhost+":"+PORT);
			
			while(true) {
				// 연결 대기
				Socket socket = serverSocket.accept();
				
				new RequestHandler(socket).start();
				
			}
			
		} catch (IOException e) {
			log("error: "+e);
		} finally {
			try {
				if(serverSocket != null && serverSocket.isClosed()==false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				log("error: "+e);
			}
		}
	}
	
	public static void log(String log) {
		System.out.println("[HttpServer"+Thread.currentThread().getId()+"] "+log);
	}
}
