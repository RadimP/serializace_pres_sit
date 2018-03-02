package network_serialization;

import java.net.*;
import java.io.*;

public class client {
	
	public static void main(String[] args) {
		Socket client = null;
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		
		try {
			
			client = new Socket("127.0.0.1", 8888);
			out = new ObjectOutputStream(client.getOutputStream());
			in = new ObjectInputStream(client.getInputStream());
			
			//Student student = new Student(96, "John");
                        Car car = new Car("Volkswagen", "Passat", 2015, "čtyřválec", 200);
			out.writeObject(car);
			out.flush();
			
			out.close();
			in.close();
			client.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
}
