package webService.serviceObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;


public class POST  {
	PostID postID = new PostID();
	PostUserName postUserName = new PostUserName();
	PostPassword postPassword = new PostPassword();
	private HttpURLConnection con;
    int responseCode ;
    StringBuilder response ;
	
	public POST(HttpURLConnection con) {
		this.con = con;
	}


	public void EnviarValores(String string, String string2, String string3) {
		String POST_PARAMS = string + string2 + string3;
		System.out.println("\nJSON Enviado:");
		System.out.println(POST_PARAMS+"\n");
		try {
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);
			con.setDoOutput(true);
		    OutputStream os = con.getOutputStream();
		    os.write(POST_PARAMS.getBytes());
			os.flush();
		    os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void ExtrairResponse() throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
	   responseCode = con.getResponseCode();
	    response = new StringBuilder();
	    String currentLine;
	    while ((currentLine = br.readLine()) != null) 
	        response.append(currentLine);
	    System.out.println("POST Response JSON :  " + response);
	    System.out.println("POST Response Code :  " + responseCode);
	    System.out.println("POST Response Message : " + con.getResponseMessage());
	}


	public void ValidarResponse() {
		if(responseCode != 200) {
			System.out.println("Response Code invalidado");
		}else {
			System.out.println("Response Code validado");			
		}
	}	
}
