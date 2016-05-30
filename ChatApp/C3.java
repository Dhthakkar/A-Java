import java.io.*;
import java.net.*;
class C3
{
	public static void main(String args[]) throws Exception
	{
		System.out.println("Enter for comunication");
		while(true)
		{
				
			String Str;
			String Str2;
			Socket client_socket=new Socket("tarun-pc",1234);
			BufferedReader user_input=new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream server_out=new DataOutputStream(client_socket.getOutputStream());
			BufferedReader s_in=new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
			Str=user_input.readLine();
			server_out.writeBytes(Str+"\n");
			Str2=s_in.readLine();
			System.out.println("Dhruv:\t"+Str2);
			client_socket.close();
		}

	}
}
