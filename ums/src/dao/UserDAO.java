package dao;

import java.util.HashSet;

import dto.UserDTO;

public class UserDAO {
	DBConnection conn;
	
	//UserDAO 호출시 DB는 자동으로 UserTable로 연결
	public UserDAO() {
		conn = new DBConnection("UserTable.txt");
	}


	public boolean join(UserDTO newUser) {
		return conn.insert(newUser.toString());
	}


	public boolean checkId(String userId) {
		HashSet<String> rs = conn.select(0, userId);
		return rs.size() == 0;
	}
	
	
}
