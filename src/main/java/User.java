
public class User {
	// Gson gson = new Gson();
	private String id;
	private String name;
	private String email;

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
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Stirng getName() {
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
}