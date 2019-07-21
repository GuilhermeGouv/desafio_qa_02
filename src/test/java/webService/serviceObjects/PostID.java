package webService.serviceObjects;

public class PostID {
	private String ID;
	
	public PostID() {
	}
	
	public void setID(String iD) {
		ID = iD;
	}

	public String getID() {
		return "{\n" + "    \"ID\": "+ID+",\r\n";
	}
	
	
}
