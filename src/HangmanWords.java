

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

/**
 * This class HangmanWords handels :1. random word maker
 * 									2. return String words
 * 									2. hidden word maker
 *		 	
 * @author ifat traubas

 */
public class HangmanWords {

	String s="";
	
	public HangmanWords() {
		this.s="";
	}
	
	public HangmanWords(String word) {
		this.s=word;
	}
	/**this Function CatchWordFromFile open a text file
	 *1. random select a word from file
	 * @return String line
	 * 
	 */
	public String CatchWordFromFile(String line) {

		int Numlines = 0;	 
	    	try{    
	    		String filePath = new File("").getAbsolutePath();
	            filePath=filePath.concat("\\animals.txt");
	    		File file2 =new File(filePath);
	    		File file =new File(filePath);
	    		if(file.exists()){
	    		    FileReader filewords = new FileReader(file);
	    		    LineNumberReader i = new LineNumberReader(filewords);	//amount of lines in file    		       		    
	    	            while (i.readLine() != null){
	    	        	Numlines++;    //count lines
	    	            }    	
	    	            int numline= (int)(Math.random() *Numlines);  //random line from file
	    	            FileReader filewords2 = new FileReader(file2);
		    		    LineNumberReader i2 = new LineNumberReader(filewords2);
	    	            for (int j = 1; j<Numlines; j++) {
	    					if (numline == j) {
	    						line = i2.readLine();// take random word from file 
	    						return line;
	    					} else	   	i2.readLine();
	    	            }
	    	            i2.close();
	    	            
	    	            i.close();
	    	   	} 		
	    		else System.out.println("File does not exists!");
	    		
	    	}catch(IOException e){
	    		e.printStackTrace();
	    	}
			return line;
		
	    }
	/*
	 * This Function UserVisibleWord update string/word to a string that
	 * is hidden from the user
	 * @returns hidden word
	 */
	public String UserVisibleWord(String original) {
		
		int i=0;
		String hidden=new String();
		while (i<original.length())
		{
            hidden=hidden+"_";
			i++;
		}	
		return hidden;
	}
/*
 * This Function getword gets the object string/word
 * @returns string
 */
	public String getword() {
		return this.s;
	}
	/*
	 * This Function setword update the object string/word
	 * @returns string s
	 */
	public void setword(String word) {
		this.s=word;
	}
	public int length(String s) {
		return s.length();
	}
	
 public String toString() {
		 
	 int max=s.length();
		 for(int i=0;i<max;i++)
		 {
			 System.out.print(" "+s.charAt(i));
		 }
		return s;
	}

 }
