package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.ProductDAO;
import dao.Session;
import dto.UserDTO;

public class MainView {
	public MainView() {
		Scanner scan = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
		int prodnum = 0;
		
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
				//상품수정(가격, 재고, 설명)
				new UpdateProductView();
				break;
			case 3:
				//상품삭제
				new DeleteProductView();
				break;
			case 4:
				//내상품보기
				new MyProductView();
				break;
			case 5:
				//상품검색(키워드 입력받아서 이름, 내용에 포함되어 있는 상품들 목록 띄워주기
				//		번호 선택시 상품의 상세한 정보 보여주기
				//		좋아요 누르기)
				System.out.print("검색어를 입력하세요 : ");
				scan = new Scanner(System.in);
				String keyword = scan.nextLine();
				ArrayList<String> result = pdao.search(keyword);
				System.out.println("\"" + keyword + "\"로 검색된 결과");
				if(result.size()==0) {
					System.out.println("검색된 결과가 없습니다.");
				}else {
					for(String line : result) {
						String[] datas = line.split("\t");
						System.out.printf("%s. %s - %s원(남은수량 : %s개)\n",
								datas[0], datas[1], datas[2], datas[3]);
					}
				}
				System.out.println("==============================");
				System.out.println("자세히 볼 상품번호(나가시려면 0번)");
				prodnum = scan.nextInt();
				new ProductInfoView(prodnum);
				break;
			case 6:
				//내정보수정
				new MyInfoView();
				break;
			}
		}
	}
}






















