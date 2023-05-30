package board.lecture;

import gisa.lesson4.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// 나중에 팀별로 할때는 쿼리 모두 DAO 에서 하세요~
public class BoardDAO {

    //CR(all)R(cond)UD

    public boolean insert(BoardDTO item) throws SQLException {
        // 하고자하는 일을 하나 처리했다면 커넥션 끊어야함(최소가 되도록)
        boolean flag = false;
        Connection con = ConnectionManager.getConnection();

        String sql = "insert into posts(title,content,writer) values(?,?,?) ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, item.getBtitle());
        pstmt.setString(2, item.getBcontent());
        pstmt.setString(3, item.getBwriter());

        int affectedCount = pstmt.executeUpdate(); // 몇개의 record 변화시켰는지
        if(affectedCount>0){
            flag=true;
        }

        ConnectionManager.closeConnection(null, pstmt, con);

        return flag;
    }

    public BoardDTO select(int bno) throws SQLException {
        BoardDTO item = null;

        Connection con = ConnectionManager.getConnection();
        String sql = "select * from posts where bno = ? ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, bno);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            // 로직이 들어오지 않는다 !
            // DB의 내용을 로컬데이터셋(java beans)으로 저장하는 것이 주 목적
            item = new BoardDTO(bno, rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getDate(4));
        }

        ConnectionManager.closeConnection(rs, pstmt, con);

        return item;
    }

    public boolean delete(String sql) {
        // 게시글삭제(개별, 전체 모두처리)
        boolean flag = false;

        return flag;
    }

    public ArrayList<BoardDTO> selectAll() throws SQLException {
        ArrayList<BoardDTO> list = new ArrayList<>();

        Connection con = ConnectionManager.getConnection();
        String sql = "select * from posts ";
        PreparedStatement pstmt = con.prepareStatement(sql); // statement 상속하므로 써도 문제없음
        ResultSet rs = pstmt.executeQuery();
        BoardDTO item;

        while(rs.next()){
            // 로직이 들어오지 않는다 !
            // DB의 내용을 로컬데이터셋(java beans)으로 저장하는 것이 주 목적
            item = new BoardDTO(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getDate(5));
            list.add(item);
        }

        ConnectionManager.closeConnection(rs, pstmt, con);

        return list;
    }

    public boolean update(BoardDTO item) {
        boolean flag = false;

        return flag;
    }
}
