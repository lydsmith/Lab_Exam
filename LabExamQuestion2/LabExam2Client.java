import java.net.*;
import java.io.*;

public class LabExam2Client {

	private static int PORT = 8765;
	private static String server = "127.0.0.1";

	public static void main (String args[]) throws IOException{
		//first instantiate a strings that will be sent to the server to compute
		String [] commands = {
				"5,3,+",
				"5,3,-",
				"5,y,-" //example of invalid input
		};	

	
		Socket client = new Socket(server, PORT);	
		//open a reader to read in messages
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		//open a writer to send messages.
		PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
		
		//variable for incoming messages
		String received ="";
		int i = 0;
		//variable for messages being sent
		String message = "";
		
		//while loop to send commands until end of the array of commands
		while(true){
			
			if (i==commands.length){
				break;
				}
			else 
				{
				message = commands[i];
		
			//write message to server
			writer.println(message);
			
			//saves the received message as a variable.
			received = (String)reader.readLine();
			//prints out the answer to the sum or message to inform that input was incorrect.
			System.out.println(received);
			
				}
			i++;

		}
		writer.println(-1); // -1 is the signal for disconnect so will always be the last message sent.
		client.close(); //close client, reader and writer.
		reader.close();
		writer.close();

	}


}
