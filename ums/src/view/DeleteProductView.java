package view;

import java.util.Scanner;

import dao.ProductDAO;
import dao.Session;
import dto.UserDTO;

public class DeleteProductView {
	 public DeleteProductView() {
		 Scanner scan = new Scanner(System.in);
		 ProductDAO pdao = new ProductDAO();
		 UserDTO loginUser = (UserDTO)Session.getAttr("loginUser");
		 
		 String list = pdao.getList(loginUser.getUserid());
		 int prodnum = 0;
		 if(list.equals("")) {
			 System.out.println("올린 상품이 없습니다.");
		 } else {
			 System.out.println(list);
			 System.out.print("삭제할 상품 번호 :");
			 prodnum = scan.nextInt();
			 
			 if(pdao.removeProduct(prodnum)) {
				 //삭제성공
				 System.out.println("상품 삭제 성공!");
				 
			 }else {
				 System.out.println("상품 삭제 실패 / 다음에 다시 시도해 주세요.");
			 }
		 }
		 
	}
}
