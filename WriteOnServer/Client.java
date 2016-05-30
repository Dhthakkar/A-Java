import java.io.*;
import java.net.*;
class Client
{
	public static void main(String args[]) throws Exception
	{
		Socket client_socket=new Socket("tarun-pc",1234);
		BufferedReader user_input=new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream server_out=new DataOutputStream(client_socket.getOutputStream());
		String Str;
		Str=user_input.readLine();
		server_out.writeBytes(Str+"\n");
		client_socket.close();
	}
}
