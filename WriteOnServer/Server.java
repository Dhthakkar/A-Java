import java.io.*;
import java.net.*;

class Server
{
	public static void main(String z[]) throws Exception
	{
		ServerSocket ss=new ServerSocket(1234);
		while(true)
		{
			Socket Listen_socket=ss.accept();
			BufferedReader c_input=new BufferedReader(new InputStreamReader(Listen_socket.getInputStream()));
			String client_Str=c_input.readLine();
			System.out.println(client_Str);
		}
	}
}