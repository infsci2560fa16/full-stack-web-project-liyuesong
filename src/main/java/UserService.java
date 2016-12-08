import User;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	ArrayList<User> db = new ArrayList<User>();

	public UserService() {
		User user = new User();
		user.setId("2016120720-user1");
		user.setName("amber");
		user.setEmail("amber1207@pitt.edu");
		db.add(user);

		user = new User();
		user.setId("2016120720-user2");
		user.setName("mike");
		user.setEmail("mike1207@pitt.edu");
		db.add(user);

		user = new User();
		user.setId("2016120720-user3");
		user.setName("frank");
		user.setEmail("frank1207@pitt.edu");
		db.add(user);
	}

	// returns a list of all users
	public List<User> getAllUSers() { return db; }

	// return a single user by id
	public User getUser(String id) { 
		return db.stream().filter(u -> u.getId().compareTo(id) == 0).findFirst().get();
	}

	// create a new user
	public User createUser(String name, String email) {
		return new User();
	}

	// updates an existing user
	public User updateUser(String id, String name, String email) {
		return new User();
	}
}
