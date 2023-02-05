package view;

import java.util.Scanner;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductInfoView {
	public ProductInfoView(int prodnum) {
		Scanner scan = new Scanner(System.in);
		ProductDAO pdao = new ProductDAO();
		ProductDTO product = pdao.get(prodnum);
		if (product == null) {
			System.out.println("잘못된 페이지 입니다 / 다음에 다시 시도");
		} else {
			while (true) {
				product = pdao.get(prodnum);
				System.out.println("============================");
				System.out.println("상품명 : " + product.getProdname());
				System.out.println("올린이 : " + product.getUserid() + "\t♥ : " + product.getLikecnt());
				System.out.println("가격 : " + product.getProdprice() + "원");
				System.out.println("남은 수량 : " + product.getProdamount());
				System.out.println("상세설명\n" + product.getProdinfo());
				System.out.println("=============================");
				System.out.println("1. 좋아요 누르기\n2. 구매하기\n3. 뒤로가기");
				int choice = scan.nextInt();
				if (choice == 1) {
					// 좋아요 누르기 진행(보고있는 상품의 번호 넘기기)
					if (pdao.updateLikeCnt(prodnum)) {
						System.out.println("좋아요~");
					} else {
						System.out.println("좋아요 누르기 실패 / 다음에 다시 시도해주세요");
					}
				}else if(choice == 3) {
					break;
				}
			}
		}
	}
}
