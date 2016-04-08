package me.rigi.acceptrules;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;

import org.bukkit.Location;

public class AcceptRulesPreferences {
	static String mainDirectory = "plugins/AcceptRules";
	static File Users = new File(mainDirectory + File.separator + "users.dat");
	static File Rules = new File(mainDirectory + File.separator + "rules.txt");
	public static String AcceptedMsg;
	public static String AcceptedAllreadyMsg;
	public static boolean TpAfterAccept;
	public static Location TpPosition;	
	
	public void createDir() {
			new File(mainDirectory).mkdir();	
				if (!Users.exists()) {				
				try {
					Users.createNewFile();					
					} catch (IOException ex) {
					ex.printStackTrace();
				}
				}
				if (!Rules.exists()) {				
					try {
						Rules.createNewFile();					
						} catch (IOException ex) {
						ex.printStackTrace();
					}
					}
			}

	 static void UserWriter(String username) {
			// TODO Auto-generated method stub
		 boolean append = true;
			try{
				  FileWriter fstream = new FileWriter(Users, append);
				  PrintWriter out = new PrintWriter(fstream, true); 
				  out.write(username + "\n");					  
				  out.close(); //Close the output stream
				  }catch (Exception e){//Catch exception if any
				  System.err.println("Error: " + e.getMessage());
				  }
		}		
	 static void UserReader() {		 
		 try{
		 	
			List<String> lines = Files.readAllLines(Users.toPath());
				
			for(String line: lines)
			{
				AcceptRulesMain.players.add(line);
			}
			
		 }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
	 }
	 
	 static void RulesReader() {		 
		 try{
			List<String> lines = Files.readAllLines(Rules.toPath());
			
			for(String line: lines)
			{
				AcceptRulesMain.rules.add(line);
			}
			
//		 FileReader fstream = new FileReader(Rules);			
//			BufferedReader in = new BufferedReader(fstream);
//			String rule = null;
//			 while ((rule = in.readLine()) != null) {
//				 AcceptRulesMain.rules.add(rule);
//		        }

		 }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
	 }
}
