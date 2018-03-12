package model.mapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.data.User;
import model.db.DB;

public class UserMapper {
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		ResultSet res = DB.getDBInstance().executeQuery("select * from users;");
		try {
			while (res.next()) {
				User user = new User();
				user.setUsername(res.getString("username"));
				user.setPassword(res.getString("password"));
				user.setType(res.getString("type"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public void updateUser(User oldUser, User newUser) {
		StringBuilder query = new StringBuilder();
		query.append("update users set username='");
		query.append(newUser.getUsername());
		query.append("',password='");
		query.append(newUser.getPassword());
		query.append("',type='");
		query.append(newUser.getType());
		query.append("' where username='");
		query.append(oldUser.getUsername());
		query.append("';");
		DB.getDBInstance().executeUpdate(query.toString());
	}

	public void createUser(User user) {
		StringBuilder query = new StringBuilder();
		query.append("insert into users (username,password,type) values ('");
		query.append(user.getUsername());
		query.append("','");
		query.append(user.getPassword());
		query.append("','");
		query.append(user.getType());
		query.append("');");
		DB.getDBInstance().executeUpdate(query.toString());
	}

	public void deleteUser(User user) {
		StringBuilder query = new StringBuilder();
		query.append("delete from users where username='");
		query.append(user.getUsername());
		query.append("';");
		DB.getDBInstance().executeUpdate(query.toString());
	}
}
