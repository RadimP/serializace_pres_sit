package network_serialization;

import java.net.*;
import java.io.*;
import java.io.*;
public class server {

	public static void main(String[] args) {
		
		//The client is used to handle connections with a client once a connection is
		//established.
		Socket client = null;
		
		//The following two objects handles our Serialization operations, ObjectOutputStream
		//writes an object to the stream. ObjectInputStream reads an object from the stream.
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		
		try {
			ServerSocket server = new ServerSocket(8888);
			client = server.accept();
			out = new ObjectOutputStream(client.getOutputStream());
			in = new ObjectInputStream(client.getInputStream());
			
			//Student student = (Student) in.readObject();
			//System.out.println("Average: " + student.getStudentAvg() + " Name: " + student.getStudentName());
                        
                        Car receivedObject = (Car) in.readObject();
			System.out.println(receivedObject);
			// close resources
			out.close();
			in.close();
			client.close();
			server.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
