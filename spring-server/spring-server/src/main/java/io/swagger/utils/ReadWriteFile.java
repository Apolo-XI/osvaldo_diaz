package io.swagger.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadWriteFile {
	
	FileReader fr = null;	
	String response = "";
	
	public void writeOnFile(String dato) {
		try {
	         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("registroID.txt"));
	         bufferedWriter.append(dato);
	         bufferedWriter.flush(); 
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	}
	
	public void escribir(String value) {
		File f;//crear objeto tipo archivo
		f = new File("registroID.txt");//Asgnar el  nombre del archivo
		try {
			FileWriter w = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);
			wr.write(value);
			wr.close();
			bw.close();
		}catch(Exception e) {}
	}
	
	public String readofFile() {
		try {
			 fr = new FileReader("registroID.txt");
	         BufferedReader bufferedReader = new BufferedReader(fr);
	         String line = "";
	         while((line =bufferedReader.readLine())!=null) {
	        	 response = line;	        	 
	         }
		     
	      }catch(Exception e){
		         e.printStackTrace();
		  }finally{
		         try{                    
		            if( null != fr ){   
		               fr.close();     
		            }                  
		         }catch (Exception e2){ 
		            e2.printStackTrace();
		         }
		      }	
	return response;
	}

}
