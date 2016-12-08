import com.google.gson.Gson;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import static spark.Spark.*;

public class Sign {
	Gson gson = new Gson();

	// private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy" + "MM" + "dd");
	// private int i = 0;

	public Sign() {
		signController();
	}

	public void signController() {

		post("/SignUp", (req,res) -> {
			Map<String, Object> user = new HashMap<>();
			String email = req.queryParams("email");
			String name = req.queryParams("name");

			// String id = this.dateFormatter + "user" + i;
			// i++;

			// user.put("id", id);
			user.put("name", name);
			user.put("email", email);
			// user.put("password", )
			return user;
		}, gson::toJson);

		get("/SignIn", (req,res) -> {
			try {
				Map<String, Object> user = new HashMap<>();
				String email = req.queryParams("email");
				String password = req.queryParams("password");
				user.put("email", email);
				user.put("password", password);
				System.out.println("valid user");
				return user;
			} catch(Exception e) {
				System.out.println("There is an exception" + e);
				return res;
			}
		}, gson::toJson);
	}
}
