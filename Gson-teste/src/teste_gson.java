import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.google.gson.Gson;


public class teste_gson {
public static void main(String[] args) throws IOException {
	User user = new User();
	user.setId(123);
	user.setName("João da Silva");

	    
	//código que faz o trabalho 
	Gson gson = new Gson();
	String userJSONString = gson.toJson(user);

	
	//Para ver o resultado salvo na máquina    
	

		FileOutputStream out = null;
		out = new FileOutputStream("User.json");
		
		out.write(userJSONString.getBytes());
		
		out.close();


}
}
