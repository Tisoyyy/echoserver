package cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		try (ServerSocket serverSocket = new ServerSocket(6013)){ //pocket 6013 is chosen
	        System.out.println("Waiting for connection.....");
	        Socket clientSocket = serverSocket.accept(); //initialize client Socket
	        System.out.println("Connected to client");
	        
	        try (BufferedReader br = new BufferedReader(
	                new InputStreamReader(
	                clientSocket.getInputStream()));
	            PrintWriter out = new PrintWriter(
	                clientSocket.getOutputStream(), true)) {
	        	String inputLine;
	            while ((inputLine = br.readLine()) != null) {
	                System.out.println(inputLine);
	                out.println(inputLine);
	            }
	        }
	        
	    } catch (IOException ex) {
	    	System.out.println("Failed to connect to client");
	    }
	}

}
