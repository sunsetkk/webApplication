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


	public boolean login(String userid, String userpw) {
		HashSet<String> rs = conn.select(0, userid);
		for (String line : rs) {
			String[] datas = line.split("\t");
			if(userpw.equals(datas[1])) {
				//로그인 성공
				UserDTO loginUser = new UserDTO(datas);
				Session.setAttr("loginUser", loginUser);
				return true;
			}
		}
		//로그인 실패
		return false;
	}

	
	
}
