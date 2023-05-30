package board.lecture;

public class BoardDTO {

    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private String bdate;

    public BoardDTO(){}
    public BoardDTO(int bno, String btitle, String bcontent, String bwriter, String bdate) {
        this.bno = bno;
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
        this.bdate = bdate;
    }

    public int getBno() {
        return bno;
    }

    public String getBcontent() {
        return bcontent;
    }

    public String getBdate() {
        return bdate;
    }

    public String getBtitle() {
        return btitle;
    }

    public String getBwriter() {
        return bwriter;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "bno=" + bno +
                ", btitle='" + btitle + '\'' +
                ", bcontent='" + bcontent + '\'' +
                ", bwriter='" + bwriter + '\'' +
                ", bdate='" + bdate + '\'' +
                '}';
    }
}
