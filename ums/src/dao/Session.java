package dao;

import java.util.HashMap;

public class Session {
	private static HashMap<String, Object> datas = new HashMap<>();
	
//							"loginUser",	UserDTO loginUser
	public static void setAttr(String key, Object value) {
		datas.put(key, value);
	}
	
	public static Object getAttr(String key) {
		return datas.get(key);
	}
}
