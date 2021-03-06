package tripmark;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class User {
	// Gson gson = new Gson();
	private String name;
	private String email;
	private String password;
	private Date date = new Date();
	private Boolean status; // has not sign in.

	// public UserController(final UserService UserService) {
	// 	get("/users", new Route() {
	// 		@Override
	// 		public Object handle(Request Request, Response Response) {
	// 			// process request
	// 			return UserService.getAllUsers();
	// 		}
	// 	});

	// 	// more routes
	// }
	
	public User(String email, String password, String name, Boolean status) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
