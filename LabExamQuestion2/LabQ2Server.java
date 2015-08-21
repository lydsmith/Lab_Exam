import java.net.*;
import java.io.*;
/*Protocol:
 * The server connects and waits for a message from the client. 
 * To disconnect, the client informs the server (message is a '-1'), and then the client immediately closes.
 */
public class LabQ2Server {
	private static int PORT = 8765;

	public static void main(String args[]) throws IOException {

		// instantiate server, client a writer & reader
		ServerSocket server = null;
		Socket client = null;
		PrintWriter writer = null;
		BufferedReader reader = null;

		try {
			server = new ServerSocket(PORT);
			client = server.accept();
			// set writer to write OUT to client
			writer = new PrintWriter(client.getOutputStream(), true);

			// set reader to read INPUT from client
			reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));

			while (true) {

				// save the incoming string as a variable
				String inputNums = (String) reader.readLine();
				
				//if -1 received, this will break as this is the signal to disconnect.
				if (inputNums.equals("-1")) {
					break;
				}
				
				//else the message will be split and calculate in the method below
				String writerReturnMessage = calculateAnswer(inputNums);

				//the answer is then written back to the client
				writer.println(writerReturnMessage);

			}

		} catch (IOException e) {
		} finally {
			try {
				server.close();
				client.close();
				writer.close();
				reader.close();
			} catch (Exception e) {
			}

		}
	}

	public static String calculateAnswer(String inputMessage) {

		// break down the string and store each part in a string array
		String[] tokenisedString = inputMessage.split(",");
		try {
			// make a variable in which to store the answer
			int answerToSum = 0;
			// if the symbol is a minus, proceed thusly
			if (tokenisedString[2].equals("+")) {
				answerToSum = Integer.parseInt(tokenisedString[0])
						+ Integer.parseInt(tokenisedString[1]);

				// if plus...
			} else if (tokenisedString[2].equals("-")) {
				answerToSum = Integer.parseInt(tokenisedString[0])
						- Integer.parseInt(tokenisedString[1]);

				// else if the last entry of array is neither, inform user there
				// is a mistake
			} else
				return ("incorrect invalid input");

			return "" + answerToSum;
		} catch (Exception e) {
			return ("incorrect invalid input");
		}

	}

}
