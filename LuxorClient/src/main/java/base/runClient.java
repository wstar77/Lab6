package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class runClient {

	JFrame frame = new JFrame("Chatter");
    BufferedReader in;
    PrintWriter out;
    
    public static void main(String[] args) throws Exception {
    	runClient client = new runClient();
        client.run();
    }

    private String getServerAddress() {
        return "localhost";
    }
    
    public void run() throws IOException {

        // Make connection and initialize streams
        String serverAddress = getServerAddress();
        Socket socket = new Socket(serverAddress, 9001);
        in = new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // Process all messages from server, according to the protocol.
        
        out.println("Command 1");
        out.println("Command 2");
        
        while (true) {        	
            String line = in.readLine();   
            System.out.println("running");
            if (line == null)
            {
            	 return;
            }
        }
    }
}
