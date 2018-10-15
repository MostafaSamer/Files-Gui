package form;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Files extends mainFrame{
	
	private int id = 1;
	
	public Files(String name,String email, int age) {
		
		while (true) {
			
			String nameFile = Integer.toString(id);
			File fenter = new File(nameFile + ".txt");
			if (fenter.exists())
				id++;
			else {
				
				try {
					PrintWriter in = new PrintWriter(fenter);
					in.println(name);
					in.println(email);
					in.println(age);
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			}
			
		}
		
	}
}
