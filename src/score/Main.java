package score;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("----------------------");
			System.out.println("성적 관리 프로그램 입니다.");
			System.out.println("----------------------");
			System.out.println("1. Input student info");
			System.out.println("2. Print out all students");
			System.out.println("3. Search student info");
			System.out.println("4. Delete student info");
			System.out.println("5. Correct student ");
			System.out.println("6. Exit ");
			System.out.print("선택 > ");
			int num = sc.nextInt();
			System.out.println();

			switch (num) {
			case 1:
				StudentMgr.addStudent();
				break;

			case 2:
				StudentMgr.allInfo();
				break;
				
			case 3:
				StudentMgr.studentInfo();
				break;
				
			case 4:
				StudentMgr.studentRemove();
				break;
				
			case 5:
				StudentMgr.studentUpdate();
				break;
				
			case 6:
				return;
			}
		}

	}
}
