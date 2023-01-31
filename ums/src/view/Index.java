package view;

import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Java 최종 프로젝트 UMS");
		while(true) {
			System.out.println("1. 회원가입\n2. 로그인\n3. 나가기");
			int choice = scan.nextInt();
			
			if(choice == 1) {
				//회원가입
				new JoinView();
			} else if(choice == 2) {
				//로그인
				new LoginView();
			} else if(choice == 3) {
				//나가기
				break;
			}
			
			
		}
	}
}
