package RelatedObjects;

public class Inquire {

	private String user_id;
	private String content;
	private String create_time;
	
	public Inquire(String user_id,String content,String create_time){
		this.user_id = user_id;
		this.content = content;
		this.create_time = create_time;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
	
}
