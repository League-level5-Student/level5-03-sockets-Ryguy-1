package _01_Intro_To_Sockets.server;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;

public class ServerGreeter extends Thread {
	//1. Create an object of the ServerSocket class
	ServerSocket serverSocket;
	public ServerGreeter() throws IOException {
		//2. Initialize the ServerSocket object. In the parameters,
		//   you must define the port at which the server will listen for connections.
		 serverSocket = new ServerSocket(8080);
		//*OPTIONAL* you can set a time limit for the server to wait by using the 
		//  ServerSocket's setSoTimeout(int timeInMilliSeconds) method
	}

	public void run() {
		//3. Create a boolean variable and initialize it to true.
		boolean bool = true;
		//4. Make a while loop that continues looping as long as the boolean created in the previous step is true.
		
		//5. Make a try-catch block that checks for two types Exceptions: SocketTimeoutException and IOException.
		//   Put steps 8 - 15 in the try block.
	
			
		//6. If the program catches a SockeTimeoutException, let the user know about it and set loop's boolean variable to false.

		//7. If the program catches a IOException, let the user know about it and set the loop's boolean variable to false.

	
			while (bool==true) {
				try {
					//8. Let the user know that the server is waiting for a client to connect.
					JOptionPane.showMessageDialog(null, "Server waiting for client to connect...");
					//9. Create an object of the Socket class and initialize it to serverSocket.accept();
					//   Change serverSocket to match the ServerSocket member variable you created in step 1.
					//   The program will wait her until either a client connects or the timeout expires.
					Socket connection = serverSocket.accept();
					//this.serverSocket = serverSocket;
					
					//10. Let the user know that the client has connected.
					JOptionPane.showMessageDialog(null, "Client Accpeted.");
					//11. Create a DataInputStream object. When initializing it, use the Socket object you created in step 9 to call the getInputStream() method.
					DataInputStream is = new DataInputStream(connection.getInputStream());
					//12. Print the message from the DataInputStream object using the readUTF() method
					JOptionPane.showMessageDialog(null, is.readUTF());
					//13. Create a DataOutputStream object. When initializing it, use the Server object you created in step 9 to call the getOutputStream() method.
					DataOutputStream os = new DataOutputStream(connection.getOutputStream());
					//14. Use the DataOutputStream object to send a message to the client using the writeUTF(String message) method.
					os.writeUTF("Message Recieved");
					//15. Close the client server
					connection.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
	}

	public static void main(String[] args) {
		//16. In a new thread, create an object of the ServerGreeter class and start the thread. Don't forget the try-catch.
				Thread t1 = new Thread(() -> {
			try {
				ServerGreeter greeter = new ServerGreeter();
				greeter.run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		t1.start();
		}
	}

