package backend;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private static int counter = 500;

	public static void main(String[] args) {
		ServerSocket ss;
		try {
			ss = new ServerSocket(666);
			Socket s;
			Socket clientS = new Socket("localhost", 666);
	        int i = 0;
			
			
			while(true){
                s = ss.accept();
                DataInputStream in = new DataInputStream(clientS.getInputStream());
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                out.writeUTF("Hallo Welt :P | " + i++);
                counter -= in.readInt();
                if(in.readInt()!=0)
                System.out.println(counter);
                s.close();
          }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        


	}

}
