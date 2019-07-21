package webService.serviceObjects;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class GET {
	
	HttpURLConnection con;
	private  final String USER_AGENT = "Chrome/75.0.3770.142";
	private String dadosJson; 
	
	public GET(HttpURLConnection con) {
		this.con = con;
	}
	
	
	public void EnviarReq() throws ProtocolException {
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
	}
	
	
	public void Receberdados() throws IOException {
		String url = "https://jsonplaceholder.typicode.com/todos";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		System.out.println(response.toString());
		dadosJson = response.toString();
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void ExibirDados() throws ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(dadosJson);
        
        JSONArray userlist = (JSONArray) obj;
        userlist.stream().filter(user ->  ( ( JSONObject ) user ).get("completed").toString().equals("true")  ) .forEach ( user -> parseUserObject ( ( JSONObject )user ) );
        
		
	}
	
    private static void parseUserObject(JSONObject user)
    {
    	System.out.println( "id : " + user.get("id") + "   title :" + user.get("title"));
    }
	
	

}
