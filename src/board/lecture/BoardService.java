package board.lecture;

import java.sql.SQLException;
import java.util.ArrayList;

public class BoardService {
    // DB 관련 작업이 아니므로 DB 관련 용어(insert, delete 등) 용어는 지양함
    // 처리 성공 여부, 예외에 대한 처리 등은 서비스단에서 함

    private BoardDAO dao;

    public BoardService(){
        this.dao = new BoardDAO();
    }

    public void register(BoardDTO item){
        // 글쓰기
        try {
            dao.insert(item);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public BoardDTO read(int bno){
        // 게시글 id를 받아서 글을 조회하는 메소드
        BoardDTO item = null;
        try {
            item = dao.select(bno);
        } catch (SQLException e){
            e.printStackTrace();
        }

        return item;
    }

    public ArrayList<BoardDTO> readAll(){
        ArrayList<BoardDTO> list = null;
        try {
            list = dao.selectAll();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    public boolean modify(BoardDTO item){
        boolean flag = false;
        try {
            flag = dao.update(item);
        } catch (SQLException e){
            e.printStackTrace();
        }

        return flag;
    }

    public boolean remove(int bno){
        // 게시글 id를 바아서 지우기
        boolean flag = false;
        String sql = "delete from posts where bno="+bno;
        try {
            flag = dao.delete(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean removeAll(){
        // 게시글 모두 지우기
        boolean flag = false;
        String sql = "delete from posts";
        try {
            flag = dao.delete(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }

        return flag;
    }


}
