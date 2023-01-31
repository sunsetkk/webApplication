package view;

import dao.ProductDAO;
import dao.Session;
import dto.UserDTO;

public class MyProductView {
	public MyProductView() {
		
		ProductDAO pdao = new ProductDAO();
		UserDTO loginUser = (UserDTO)Session.getAttr("loginUser");
		
		System.out.println("=====내가 올린 상품 목록=====");
		String list = pdao.getList(loginUser.getUserid());
		if(list.equals("")) {
			System.out.println("올린 상품이 없습니다.");
		} else {
			System.out.println(list);
		}
		System.out.println("=========================");
	}
}
