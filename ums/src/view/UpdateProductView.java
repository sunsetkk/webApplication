package view;

import java.util.Scanner;

import dao.ProductDAO;
import dao.Session;
import dto.UserDTO;

public class UpdateProductView {
	public UpdateProductView() {
		Scanner scan = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
		UserDTO loginUser = (UserDTO) Session.getAttr("loginUser");
		int choice = 0;
		int prodnum = 0;
		String newData = "";

		System.out.printf("=====%s님 상품 목록=====\n", loginUser.getUsername());
		String list = pdao.getList(loginUser.getUserid());
		if (list.equals("")) {
			System.out.println("올린 상품이 없습니다.");
		} else {
			System.out.println(list);
			System.out.println("=====================");
			
			System.out.print("수정할 상품 번호 : ");
			prodnum = scan.nextInt();
			System.out.println("1.가격수정\n2.재고수정\n3.설명수정\n4.수정취소");
			choice = scan.nextInt();

			if (choice == 4) {
				System.out.println("메인으로 돌아갑니다.");
			} else {
				System.out.print("\n새로운 정보 : ");
				scan = new Scanner(System.in);
				newData = scan.nextLine();
				if(pdao.modifyProduct(prodnum, choice, newData)) {
					System.out.println(prodnum + "번 상품이 정상적으로 수정되었습니다.");
				}else {
					System.out.println("상품 수정 실패 / 다음에 다시 시도해 주세요.");
				}
			}
		}

	}
}
