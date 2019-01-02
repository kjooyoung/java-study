package score;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMgr {
	List<Student> studentArr = new ArrayList<Student>();
	Scanner sc = new Scanner(System.in);
	
	Student student = null;
	
	public void addStudent() {
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
	}
	
	public void allInfo() {
		if(studentArr.size() != 0) {
			System.out.println(" 이름        학번        국어   영어   수학   총합   평균");
			for (int i = 0; i < studentArr.size(); i++) {
				studentArr.get(i).info();
			}
		} else {
			System.out.println("입력된 정보가 없습니다.");
		}
		System.out.println();
	}
	
	public void studentInfo() {
		System.out.println("학생 이름을 입력해주세요.");
		System.out.print("> ");
		String name = sc.next();
		System.out.println();
		if(getStudent(name)==null) return;
		showInfo(getStudent(name));
	}
	
	public void studentRemove() {
		System.out.println("학생 이름을 입력해주세요.");
		System.out.print("> ");
		String name = sc.next();
		System.out.println();
		student = getStudent(name);
		if(student!=null) {
			showInfo(student);
			System.out.println("삭제하시겠습니까?(y/n)");
			System.out.print("> ");
			if(sc.next().equals("y")) {
				studentArr.remove(student);
				System.out.println("삭제되었습니다.");
			}
		}
	}
	
	public void studentUpdate() {
		System.out.println("학생 이름을 입력해주세요.");
		System.out.print("> ");
		String name = sc.next();
		System.out.println();
		student = getStudent(name);
		if(student!=null) {
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
		}
	}
	
	public Student getStudent(String name) {
		for (int i = 0; i < studentArr.size(); i++) {
			if(name.equals(studentArr.get(i).getName())) {
				return studentArr.get(i);
			}
		}
		System.out.println("해당 이름으로 입력된 정보가 없습니다.");
		return null;
	}
	
	public void showInfo(Student student) {
		if(student != null) {
			System.out.println(" 이름        학번        국어   영어   수학   총합   평균");
			student.info();
		} else {
			System.out.println("해당 이름으로 입력된 정보가 없습니다.");
		}
		
	}

}
