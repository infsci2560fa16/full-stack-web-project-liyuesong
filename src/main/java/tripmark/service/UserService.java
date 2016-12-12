package tripmark.service;

import tripmark.User;
import tripmark.Place;
import tripmark.controller.UserController;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
// import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import spark.Session;
import static spark.Spark.*;

public class UserService {
	ArrayList<User> db = new ArrayList<User>();
	private Gson gson = new Gson();
	private String getUserName = "";
	private UserController uc = new UserController();
	
	public UserService() {
		// initiate three users
		// User user = new User();
		// user.setName("amber");
		// user.setEmail("amber1207@pitt.edu");
		// db.add(user);

		// user = new User();
		// user.setName("mike");
		// user.setEmail("mike1207@pitt.edu");
		// db.add(user);

		// user = new User();
		// user.setName("frank");
		// user.setEmail("frank1207@pitt.edu");
		// db.add(user);

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
			Session session = request.session(true);
			User u = (User) session.attribute("user");
			// System.out.println(u);
			attributes.put("user", u);
			return new ModelAndView(attributes, "index.ftl");
		}, new FreeMarkerEngine());

		get("/checkLogin", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			Session session = request.session(true);
			User u = (User) session.attribute("user");
			attributes.put("user", u);
			return attributes;
		}, gson::toJson);
		
		// signin, add user to database.
		get("/signin", (request, response) -> {
			Map<String,Object> newUser = new HashMap<>();
			String email = request.queryParams("email");
			String password = request.queryParams("password");
			boolean status = Boolean.parseBoolean(request.queryParams("status"));
			Session session = request.session(true);

			// System.out.println(password + "," + email);
			newUser.put("email", email);
			newUser.put("password", password);
			newUser.put("status", status);	// wether sign in
			// System.out.println(newUser);
			// validation
			User u = null;
			try {
				u = uc.selectByEmail(email, password);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (u == null) {
				// user does not exist.
				// return user;
			} else {
				session.attribute("user", u);
			}
			// System.out.println(session);
			return newUser;
		}, gson::toJson);

		post("/signup", (request, response) -> {
			Map<String, Object> newUser = new HashMap<>();
			String email = request.queryParams("email");
			String name = request.queryParams("name");
			String password = request.queryParams("password");
			boolean status = Boolean.parseBoolean(request.queryParams("status"));

			newUser.put("email", email);
			newUser.put("name", name);
			newUser.put("password", password);
			newUser.put("status", status);
			// getUserName = name;
			
			try {
				if (this.checkNotExist(email)) {
					// user does not exist, insert into database
					User u = new User(email, password, name, status);
					uc.insertUser(u);
					newUser.put("notExist", true);
				} else {
					// user already exists, go to signin page.
					newUser.put("notExist", false);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return newUser;
		}, gson::toJson);

		get("/stories", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			Session session = request.session(true);
			String text = request.queryParams("text");
			attributes.put("text", text);
			// System.out.println(attributes);
			session.attribute("text", text);
			return attributes;
		}, gson::toJson);

		get("/addStories", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			Session session = request.session(true);
			User u = (User) session.attribute("user");
			String text = session.attribute("text");
			System.out.println(text);
			int count = 3;

			attributes.put("user", u);
			attributes.put("text", text);
			if (text.equals("Stories In Time")) {
				attributes.put("count", count);
			}
			// System.out.println(attributes.count);
			return new ModelAndView(attributes, "addStories.ftl");
		}, new FreeMarkerEngine());
	}

	private boolean checkNotExist(String email) {
		boolean notExist = true;
		try {
			notExist = uc.notExist(email);
		} catch (Exception e) {
			System.out.println(this.getClass() + "check Existence.");
			e.printStackTrace();
		}
		return notExist;
	}
}
