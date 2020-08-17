package practicedays_JAVA;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Find_IP_Address {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub

		InetAddress myIP = InetAddress.getLocalHost();

		System.out.println("My IP Address is :"+myIP.getHostAddress());
	}

}
