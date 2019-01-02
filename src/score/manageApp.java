package score;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class manageApp {
	public static void main(String[] args) {
		List<Student> studentArr = new ArrayList<Student>();

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
				System.out.print("이름 : ");
				String name = sc.next();
				System.out.print("학번 : ");
				String studentNum = sc.next();
				System.out.print("국어성적 : ");
				int lang = sc.nextInt();
				System.out.print("영어성적 : ");
				int eng = sc.nextInt();
				System.out.print("수학성적 : ");
				int math = sc.nextInt();

				studentArr.add(new Student(name, studentNum, lang, eng, math));
				System.out.println("성적을 입력하였습니다.");
				System.out.println();
				break;

			case 2:
				if(studentArr.size() != 0) {
					System.out.println(" 이름        학번        국어   영어   수학   총합   평균");
					for (int i = 0; i < studentArr.size(); i++) {
						studentArr.get(i).info();
					}
				} else {
					System.out.println("입력된 정보가 없습니다.");
				}
				System.out.println();
				break;
				
			case 3:
				System.out.println("학생 이름을 입력해주세요.");
				System.out.print("> ");
				String search = sc.next();
				System.out.println();
				System.out.println(" 이름        학번        국어   영어   수학   총합   평균");
				for(int i=0; i<studentArr.size(); i++) {
					if(studentArr.get(i).getName().equals(search)) {
						studentArr.get(i).info();
					}
				}
				System.out.println();
				break;
				
			case 4:
				System.out.println("학생 이름을 입력해주세요.");
				System.out.print("> ");
				String delete = sc.next();
				System.out.println();
				System.out.println(" 이름        학번        국어   영어   수학   총합   평균");
				for(int i=0; i<studentArr.size(); i++) {
					if(studentArr.get(i).getName().equals(delete)) {
						studentArr.get(i).info();
						System.out.println("삭제하시겠습니까?(y/n)");
						System.out.print("> ");
						if(sc.next().equals("y")) {
							studentArr.remove(i);
							System.out.println("삭제되었습니다.");
						}
					}
				}
				System.out.println();
				break;
				
			case 5:
				Student student = null;
				System.out.println("학생 이름을 입력해주세요.");
				System.out.print("> ");
				String update = sc.next();
				System.out.println();
				System.out.println(" 이름        학번        국어   영어   수학   총합   평균");
				
				for(int i=0; i<studentArr.size(); i++) {
					if(studentArr.get(i).getName().equals(update)) {
						student = studentArr.get(i);
					}
				}
				System.out.println("과목을 선택해주세요.");
				System.out.println("1.국어 2.영어 3.수학");
				System.out.print("> ");
				int select = sc.nextInt();
				System.out.println();
				System.out.println("변경할 점수를 입력해주세요.");
				System.out.print("> ");
				int score = sc.nextInt();
				if(select == 1) {
					student.setLang(score);
				}else if(select == 2) {
					student.setEng(score);
				}else {
					student.setMath(score);
				}
				System.out.println();
				break;
				
			case 6:
				return;
			}
		}

	}

}
