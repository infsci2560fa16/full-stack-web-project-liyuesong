
package tripmark.controller;

import tripmark.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.lang.String;

public class UserController {
	private Date date = new Date();

	public void insertUser(User u) throws Exception {
		Connection connection = null;
		try {
			// insert user
		} catch (Exception e) {
			throw new Exception(this.getClass() + " add user: database failure.");
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println(this.getClass() + " add user: could not close connection to database.");
				}
			}
		}
	}
	
	public User selectByEmail(String email, String password) throws Exception {
		Connection connection = null;
		User u = null;
		try {
			// select user by email from database.
			String userName = "";
			u = new User(email, password, userName, true);

			// validation - email
			// if (!email.contains("@")) {
			// 	u = null;
			// }
			return u;
		} catch (Exception e) {
			throw new Exception(this.getClass() + " select user by email: database failure.");
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println(this.getClass() + " select user by email: could not close connection to database.");
				}
			}
		}
	}

	public boolean notExist(String email) throws Exception {
		Connection connection = null;
		try {
			// check existence
		} catch (Exception e) {
			throw new Exception(this.getClass() + " check exist: database failure.");
		}
		return true;
	}

}