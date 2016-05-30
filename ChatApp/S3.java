import java.io.*;
import java.net.*;
class S3
{
	public static void main(String z[]) throws Exception
	{
		System.out.println("server started");
		String Str;
		String client_Str;
		ServerSocket ss=new ServerSocket(1234);
		while(true)
		{
			Socket Listen_socket=ss.accept();
			BufferedReader c_input=new BufferedReader(new InputStreamReader(Listen_socket.getInputStream()));
			BufferedReader s_input=new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream s_out=new DataOutputStream(Listen_socket.getOutputStream());
			client_Str=c_input.readLine();
			System.out.println("mukesh:\t"+client_Str);
			Str=s_input.readLine();
			s_out.writeBytes(Str+"\n");
		}
	}
}