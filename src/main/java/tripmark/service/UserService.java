package tripmark.service;

import com.google.gson.Gson;
import tripmark.User;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.*;

public class UserService {
	ArrayList<User> db = new ArrayList<User>();
	private Gson gson = new Gson();
	private String getUserName = "user";
	
	public UserService() {
		// initiate three users
		User user = new User();
		user.setName("amber");
		user.setEmail("amber1207@pitt.edu");
		db.add(user);

		user = new User();
		user.setName("mike");
		user.setEmail("mike1207@pitt.edu");
		db.add(user);

		user = new User();
		user.setName("frank");
		user.setEmail("frank1207@pitt.edu");
		db.add(user);

		Serve();
	}

	// returns a list of all users
	// public List<User> getAllUSers() { return db; }

	// // return a single user by id
	// public User getUser(String id) { 
	// 	return db.stream().filter(u -> u.getId().compareTo(id) == 0).findFirst().get();
	// }

	// // create a new user
	// public User createUser(String name, String email) {
	// 	return new User();
	// }

	// // updates an existing user
	// public User updateUser(String id, String name, String email) {
	// 	return new User();
	// }

	// Server
	public void Serve() {
		get("/index", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("userName", getUserName);
			return new ModelAndView(attributes, "index.ftl");
		}, new FreeMarkerEngine());
		
		// signin, add user to database.
		get("/signin", (request, response) -> {
			Map<String,Object> user = new HashMap<>();
			String email = request.queryParams("email");
			String password = request.queryParams("password");
			System.out.println(password + "," + email);
			// user.setEmail(email);
			// validation
			return user;
		}, gson::toJson);

		post("/signup", (request, response) -> {
			try {
				Map<String, Object> user = new HashMap<>();
				String email = request.queryParams("email");
				String name = request.queryParams("name");
				String password = request.queryParams("password");

				user.put("email", email);
				user.put("name", name);
				user.put("password", password);
				getUserName = name;

				System.out.println(name + "," + email);
				return user;
			} catch(Exception e) {
				System.out.println("There is an exception" + e);
				return response;
			}
		}, gson::toJson);
	}
}
