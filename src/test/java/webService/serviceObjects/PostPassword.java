package webService.serviceObjects;

public class PostPassword {
	private String Password;
	
	public PostPassword() {
		
	}
	
	public void setPassword(String password) {
		Password = password;
	}
	
	public String getPassword() {
		return "    \"Password\": \""+Password+"\"" + "\n}";
	}
	
	
}
