package view;

import java.util.Scanner;

import dao.Session;
import dto.UserDTO;

public class MainView {
	public MainView() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("-----메인화면-----");
		while(true){
			UserDTO loginUser = (UserDTO)Session.getAttr("loginUser");
			if(loginUser == null) {
				System.out.println("로그인 후 이용하세요.");
				break;
			}
			System.out.println("1. 상품추가");
			System.out.println("2. 상품수정");
			System.out.println("3. 상품삭제");
			System.out.println("4. 내 상품 보기");
			System.out.println("5. 상품검색");
			System.out.println("6. 내 정보 수정");
			System.out.println("7. 로그아웃");
			int choice = scan.nextInt();
			
			if(choice == 7) {
				//로그아웃
				System.out.println(loginUser.getUsername() + "님 다음에 또 오세요~");
				Session.setAttr("loginUser", null);
				break;
			}
			
			switch(choice) {
			case 1:
				//상품추가
				new AddProductView();
				break;
			case 2:
				//상품수정
				break;
			case 3:
				//상품삭제
				break;
			case 4:
				//내상품보기
				new MyProductView();
				break;
			case 5:
				//상품검색
				break;
			case 6:
				//내정보수정
				break;
			}
		}
	}
}






















