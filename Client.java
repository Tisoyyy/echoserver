package cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
	        System.out.println("Waiting for connection.....");
	        InetAddress localAddress = InetAddress.getLocalHost();

	        try (Socket clientSocket = new Socket(localAddress, 6013);
	        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	        		clientSocket.getInputStream()))) {
	        	System.out.println("Successfully connected to server");
	            Scanner scanner = new Scanner(System.in);
	            while (true) {
	                System.out.print("Enter text (Type quit to quit):");
	                String inputLine = scanner.nextLine();
	                if ("quit".equalsIgnoreCase(inputLine)) {
	                	scanner.close();
	                    break;
	                }
	                out.println(inputLine);
	                String response = br.readLine();
	                System.out.println("Server response: " + response);
	            }
	        }
	    } catch (IOException ex) {
	    	System.out.println("Failed to connecto to Server");
	    }
	}

}
