package chapter06;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-------------------------------------------");
			System.out.println("선택> ");
			
			int selectNo = sc.nextInt();
			
			if(selectNo == 1) {
				createAccount();
			} else if(selectNo == 2) {
				accountList();
			} else if(selectNo == 3) {
				deposit();
			} else if(selectNo == 4) {
				withdraw();
			} else if(selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}

	//계좌생성하기
	private static void createAccount() {
		System.out.println("-------");
		System.out.println("계좌생성");
		System.out.println("-------");
		System.out.print("계좌번호 : ");
		String ano = sc.nextLine();
		System.out.print("예금주 : ");
		String owner = sc.nextLine();
		System.out.print("초기입금액 : ");
		int balance = sc.nextInt();
		
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i]==null) {
				accountArray[i] = new Account(ano, owner, balance); 
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			}
		}
		
	}

	//계좌목록보기
	private static void accountList() {
		System.out.println("-------");
		System.out.println("계좌목록");
		System.out.println("-------");
		
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i] != null) {
				System.out.println(accountArray[i].getAno()+"   "
								+accountArray[i].getOwner()+"   "
								+accountArray[i].getBalance());
			}
			else break;
		}
	}

	//예금하기
	private static void deposit() {
		System.out.println("-------");
		System.out.println("예금하기");
		System.out.println("-------");
		if(accountArray[0] == null) {
			System.out.println("등록된 계좌가 없습니다.");
			return;
		}else {
			System.out.print("계좌번호 : ");
			String ano = sc.nextLine();
			Account a1 = findAccount(ano);
			if(a1 == null) {
				System.out.println("입력하신 계좌는 찾을 수 없습니다.");
			}else {
				System.out.print("예금액 : ");
				int balance = sc.nextInt();
				a1.setBalance(a1.getBalance()+balance);
				System.out.println("예금이 성공하였습니다.");
				System.out.println("잔액 : "+a1.getBalance());
			}
		}
	}

	//출금하기
	private static void withdraw() {
		System.out.println("-------");
		System.out.println("출금하기");
		System.out.println("-------");
		if(accountArray[0] == null) {
			System.out.println("등록된 계좌가 없습니다.");
			return;
		}else {
			System.out.print("계좌번호 : ");
			String ano = sc.nextLine();
			Account a1 = findAccount(ano);
			if(a1 == null) {
				System.out.println("입력하신 계좌는 찾을 수 없습니다.");
			}else {
				System.out.println("잔액 : "+a1.getBalance());
				System.out.print("출금액 : ");
				int balance = sc.nextInt();
				if(balance > a1.getBalance()) {
					System.out.println("잔액보다 많은 금액을 출금할 수 없습니다.");
					return;
				}else {
					a1.setBalance(a1.getBalance()-balance);
					System.out.println("출금이 성공하였습니다.");
					System.out.println("잔액 : "+a1.getBalance());
				}
			}
		}
	}
	
	//Account 배열에서 ano와 동일한 Account 객체 찾기
	private static Account findAccount(String ano) {
		
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i].getAno().equals(ano)) {
				return accountArray[i];
			}else if(accountArray[i]==null) {
				return null;
			}
		}
		return null;
	}
}
