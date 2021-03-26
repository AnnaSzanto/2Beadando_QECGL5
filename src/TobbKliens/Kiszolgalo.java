package TobbKliens;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Kiszolgalo implements Runnable {
	
	private Socket s;

	public Kiszolgalo(Socket s) {
		this.s=s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader bf;
		
		Date d = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
		String datum = df.format(d);
		
			try {
				bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String line = bf.readLine();
				System.out.println(datum+":"+line);
				
				String dokumentacio = "dokumentum.txt";
				FileWriter fw = new FileWriter(dokumentacio, true);
				fw.write(datum+":"+line);
				fw.close();
				
				PrintWriter pw = new PrintWriter(s.getOutputStream());
				pw.println("A szerver reakciója megtörtént");
				
				pw.flush();
				bf.close();
				pw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
	}

	

}

