package board.lecture;

import java.util.ArrayList;

public class BoardService {

    public void register(BoardDTO item){
        // 글쓰기
    }

    public BoardDTO read(int bno){
        // 게시글 id를 받아서 글을 조회하는 메소드
        BoardDTO item = null;

        return item;
    }

    public ArrayList<BoardDTO> readAll(){
        ArrayList<BoardDTO> list = null;

        return list;
    }

    public boolean modify(BoardDTO item){
        boolean flag = false;

        return flag;
    }

    public boolean delete(int bno){
        // 게시글 id를 바아서 지우기
        boolean flag = false;
        return flag;
    }

    public boolean deleteAll(){
        // 게시글 모두 지우기
        boolean flag = false;

        return flag;
    }


}
