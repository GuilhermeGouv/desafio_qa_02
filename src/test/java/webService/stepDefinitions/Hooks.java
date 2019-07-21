package webService.stepDefinitions;



import java.io.IOException;


import java.net.HttpURLConnection;
import java.net.URL;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks  {
	protected String url ;
	protected static HttpURLConnection con;
	private static URL obj;
	
	
	@Before()
	public static void Start() {		
			try {
				obj = new URL("http://fakerestapi.azurewebsites.net/api/Users");
				con = (HttpURLConnection) obj.openConnection();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	public static HttpURLConnection getCon() {
		return con;
	}
	@After
	private void close() {
		con.disconnect();
	}
	

		
}
