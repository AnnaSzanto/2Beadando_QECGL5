package TobbKliens;

import java.io.IOException;
import java.net.*;

public class Szerver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ServerSocket ss = new ServerSocket(1234);
			
		while (true) {
			
			new Thread(new Kiszolgalo(ss.accept())).start();
			
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
