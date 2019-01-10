package http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class RequestHandler extends Thread{
	private Socket socket;
	
	public RequestHandler(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			log("connected from"+inetSocketAddress.getAddress().getHostAddress()
					+":"+inetSocketAddress.getPort());
			
			OutputStream os = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			
			String request = null;
			while(true) {
				String line = br.readLine();
				
				if(line == null) {
					break;
				}
				
				if("".equals(line)) {
					break;
				}
				
				if(request == null) {
					request = line;
				}
			}
			
			String[] tokens = request.split(" ");
			if("GET".equals(tokens[0])) {
				responseStaticResource(os, tokens[1], tokens[2]);
			} else {
				response400Error(os,tokens[2]);
			}
			
		} catch (Exception e) {
			log("error: "+e);
		} finally {
			try {
				if(socket != null && socket.isClosed()==false) {
					socket.close();
				}
			} catch (Exception e) {
				log("error: "+e);
			}
		}
	}
	
	private void response400Error(OutputStream os, String string) {
		// TODO Auto-generated method stub
		
	}

	private void responseStaticResource(OutputStream os, String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	public void log(String log) {
		System.out.println("[RequestHandler#"+getId()+"] "+log);
	}
	
}
