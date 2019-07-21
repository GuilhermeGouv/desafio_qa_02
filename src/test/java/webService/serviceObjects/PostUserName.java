package webService.serviceObjects;

public class PostUserName {
	private String UserName;
	
	public PostUserName() {
	}

	public void setUserName(String userName) {
		UserName = userName;
	}
	
	public String getUsername() {
		return "    \"UserName\": \""+UserName+"\",\r\n";
	}
	
	
}
