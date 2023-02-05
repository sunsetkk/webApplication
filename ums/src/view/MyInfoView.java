package view;

import java.util.Scanner;

import dao.ProductDAO;
import dao.Session;
import dao.UserDAO;
import dto.UserDTO;

public class MyInfoView {
	public MyInfoView() {
		Scanner scan = new Scanner(System.in);
		UserDAO udao = new UserDAO();
		UserDTO loginUser = (UserDTO)Session.getAttr("loginUser");
		ProductDAO pdao = new ProductDAO();
		
		System.out.printf("=====%s님의 회원정보=====\n아이디 : %s\n비밀번호 : %s\n핸드폰번호 : %s\n주소 : %s\n",
				loginUser.getUsername(), loginUser.getUserid(), loginUser.getUserpw(),loginUser.getUserphone(), loginUser.getUseraddr());			
		System.out.println("=====================");
		System.out.println("1. 비밀번호 수정\n2. 핸드폰번호 수정\n3. 주소 수정\n4. 수정 취소\n5. 회원탈퇴");
		int choice = scan.nextInt();
		if(choice==4) {
			System.out.println("메인으로 돌아갑니다.");
		} else if(choice == 5) {
			//회원탈퇴
			System.out.println("비밀번호 재입력 : ");
			String userpw = scan.next();
			if(loginUser.getUserpw().equals(userpw)) {
				if(pdao.removeAll(loginUser.getUserid())) {
					if(udao.leaveId(loginUser.getUserid())) {
						System.out.println("그동안 이용해 주셔서 감사합니다...");
					}
				}
			}else {
				System.out.println("비밀번호 오류 / 다음에 다시 시도해주세요.");
			}
			
		}else {
			//정보수정
			System.out.print("새로운 정보 : ");
			scan = new Scanner(System.in);
			String newData = scan.nextLine();
			
			boolean check = false;
			switch (choice) {
			case 1: 
				//비밀번호 수정
				check = udao.modifyUesr(loginUser.getUserid(),1, newData);
				break;
//			case 2:
//				//핸드폰번호 수정
//				udao.modifyUesr(loginUser.getUserid(),4, newData);
//				break;
//			case 3:
//				//주소 수정
//				udao.modifyUesr(loginUser.getUserid(),5, newData);
//				break;
			case 2:case 3:
				check = udao.modifyUesr(loginUser.getUserid(), choice+2, newData);
				break;
			}
			if(check) {
				System.out.println("정보 수정 완료!");
			}else {
				System.out.println("정보 수정 실패 / 다시 시도해 주세요.");
			}
		}
	}
}
