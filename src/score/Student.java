package score;

public class Student {
	private String name;
	private String studentNum;
	private int lang;
	private int eng;
	private int math;
	
	public Student() {}

	public Student(String name, String studentNum, int lang, int eng, int math) {
		super();
		this.name = name;
		this.studentNum = studentNum;
		this.lang = lang;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

	public int getLang() {
		return lang;
	}

	public void setLang(int lang) {
		this.lang = lang;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	public int sum() {
		return lang+eng+math;
	}
	
	public double avg() {
		return sum()/3;
	}
	
	public void info() {
		System.out.println(name + "   " + studentNum 
				+ "  " + lang + "  " + eng + "  " + math
				+ "  " + sum() + "  " + avg());
	}
}
