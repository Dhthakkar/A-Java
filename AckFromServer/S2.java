import java.io.*;
import java.net.*;

class S2
{
	public static void main(String z[]) throws Exception
	{
		String Str;
		String client_Str;
		ServerSocket ss=new ServerSocket(1234);
		while(true)
		{
			Socket Listen_socket=ss.accept();
			BufferedReader c_input=new BufferedReader(new InputStreamReader(Listen_socket.getInputStream()));
			DataOutputStream s_out=new DataOutputStream(Listen_socket.getOutputStream());
			client_Str=c_input.readLine();
			Str=client_Str+"----Receved"+"\n";
			s_out.writeBytes(Str);
		}
	}
}