package Backend;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket ss;
		try {
			ss = new ServerSocket(666);
			Socket s;
	        int i = 0;
			
			
			while(true){
                s = ss.accept();

                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                out.writeUTF("Hallo Welt :P | " + i++);
                s.close();
          }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        


	}

}
