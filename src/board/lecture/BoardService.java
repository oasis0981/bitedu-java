package board.lecture;

import java.sql.SQLException;
import java.util.ArrayList;

public class BoardService {
    // DB 관련 작업이 아니므로 DB 관련 용어(insert, delete 등) 용어는 지양함

    private BoardDAO dao;

    public BoardService(){
        this.dao = new BoardDAO();
    }

    public void register(BoardDTO item) throws SQLException {
        // 글쓰기
        dao.insert(item);
    }

    public BoardDTO read(int bno) throws SQLException {
        // 게시글 id를 받아서 글을 조회하는 메소드
        BoardDTO item = null;
        item = dao.select(bno);

        return item;
    }

    public ArrayList<BoardDTO> readAll() throws SQLException {
        ArrayList<BoardDTO> list = null;
        list = dao.selectAll();

        return list;
    }

    public boolean modify(BoardDTO item){
        boolean flag = false;
        flag = dao.update(item);

        return flag;
    }

    public boolean remove(int bno){
        // 게시글 id를 바아서 지우기
        boolean flag;
        String sql = "delete from posts where bno=?";
        flag = dao.delete(sql);
        return flag;
    }

    public boolean removeAll(){
        // 게시글 모두 지우기
        boolean flag;
        String sql = "delete from posts";
        flag = dao.delete(sql);

        return flag;
    }


}
