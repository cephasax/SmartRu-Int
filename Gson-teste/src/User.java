import com.google.gson.Gson;

public class User {

	int id;
	String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public User loadUserFromJSONGson(String jsonString) {
	    Gson gson = new Gson();
	    User user = (User) gson.fromJson(jsonString, User.class);
	    return user;
	}

}
