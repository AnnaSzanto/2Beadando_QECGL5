package TobbKliens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Kliens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket s = new Socket("127.0.0.1",1234);
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			String szoveg="Fûre lépni szabad!";
			System.out.println("Fûre lépni szabad!");
			pw.println(szoveg);
			pw.flush();
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String valasz = bf.readLine();
			System.out.println(valasz); 
			bf.close();
			pw.close();
			
		} 
		
		
		
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
