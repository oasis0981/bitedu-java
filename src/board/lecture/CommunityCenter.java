package board.lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class CommunityCenter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommunityCenter center = new CommunityCenter();
		center.openCenter();
	}
	
	public void openCenter() {
		boolean isClose = false;
		System.out.println("");
		System.out.println("안녕하세요! 커뮤니티 센터입니다.\n\n");
		Scanner scan = new Scanner(System.in);
		String command;
		while(!isClose) {
			this.displayList();
			this.displayMainMenu();
			command = scan.nextLine();
			switch(command) {
				case "1" : create(scan); break;
				case "2" : read(scan); break;
				case "3" : clear(scan); break;
				case "4" : isClose = true;
			}
		}
		scan.close();
		System.out.println("\n\n이용해 주셔서 감사합니다.");
	}
	

	private void clear(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("전체 삭제작업을 시작합니다.");
		boolean flag = this.displayConfirm(scan);
		if(flag) {
			//삭제작업
			System.out.println("전체 삭제작업을 완료했습니다.");
		} else {
			System.out.println("전체 삭제작업을 취소했습니다.");
		}
	}

	private void read(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("[게시물 읽기]");
		System.out.print("bno: "); 
		String command = scan.nextLine();
		this.displayDetail(Integer.parseInt(command),scan);
	}

	private void create(Scanner scan) {
		// TODO Auto-generated method stub
		BoardDTO board = new BoardDTO();
		System.out.println("[새 게시물 입력]");
		System.out.print("제목: "); 	
		board.setBtitle(scan.nextLine());
		System.out.print("내용: "); 	
		board.setBcontent(scan.nextLine());
		System.out.print("글쓴이: "); 	
		board.setBwriter(scan.nextLine());
		
		System.out.println();
		boolean flag = this.displayConfirm(scan);
		BoardService service = new BoardService();
		if(flag) {
			service.register(board);
			System.out.println("삽입완료");
		} else {
			System.out.println("삽입취소");
		}
		
	}

	private void displayList() {
		System.out.println("======================== 게시물 목록 ========================");
		System.out.printf("%-6s%-30s%-20s%-15s\n", "bno", "제목", "작성일", "작성자");
		BoardService service = new BoardService();
		ArrayList<BoardDTO> list = service.readAll();
		for( BoardDTO post: list){
			System.out.printf("%-6s%-30s%-20s%-15s\n", post.getBno(), post.getBtitle(), post.getBdate(), post.getBwriter());
		}
	}
	
	private void displayDetail(int bno,Scanner scan) {
		System.out.println();
		System.out.println("[" + bno+"번 상세 내용 조회]");
		BoardService service = new BoardService();
		BoardDTO post = service.read(bno);

		System.out.println("제목  : " + post.getBtitle());
		System.out.println("작성자: " + post.getBwriter());
		System.out.println("-----------------------------------------------------------------------");
		System.out.println(post.getBcontent());

		System.out.println();
		this.displaySubMenu();
		String command = scan.nextLine();
		boolean flag = false;
		if(command.equals("1")) {
			System.out.println("수정작업");
			flag = this.displayConfirm(scan);
			if(flag) {
				//수정작업
				System.out.println("수정완료");
			} else {
				System.out.println("수정취소");
				this.displayDetail(bno, scan);
			}
		} else if(command.equals("2")) {
			System.out.println("삭제작업");
			flag = this.displayConfirm(scan);
			if(flag) {
				//삭제작업
				System.out.println("삭제완료");
			} else {
				System.out.println("삭제취소");
				this.displayDetail(bno, scan);
			}
		} 
	}
	
	private void displayMainMenu() {
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("메인메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("메뉴선택: ");
	}	
	
	private boolean displayConfirm(Scanner scan) {
		boolean flag = false;
		System.out.println("-------------------------------------------------------------------");
		System.out.println("보조메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴선택: ");
		String command = scan.nextLine();
		if(command.equals("1")) {
			flag = true;
		}
		return flag;
	}
	
	private void displaySubMenu() {
		System.out.println("-------------------------------------------------------------------");
		System.out.println("보조메뉴: 1.Update | 2.Delete | 3.List");
		System.out.print("메뉴선택: ");
	}

}
