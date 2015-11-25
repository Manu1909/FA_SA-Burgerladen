package Backend;

import java.io.DataInputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {
        try {
			Socket s = new Socket("localhost", 666);
			DataInputStream in = new DataInputStream(s.getInputStream());
			
			System.out.println(in.readUTF());
			s.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
  }


}
