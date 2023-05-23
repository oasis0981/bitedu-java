package student.manager;

public class StudentVO {
    private int stdNo;
    private String email;
    private int kor;

    private int math;
    private int eng;
    private int sci;
    private int hist;
    private String locCode;
    private int total;
    private String teacherCode;
    private String accCode;

    public StudentVO(int stdNo, String email, int kor, int eng, int math, int sci, int hist, int total, String locCode, String accCode, String teacherCode) {
        this.stdNo = stdNo;
        this.email = email;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.sci = sci;
        this.hist = hist;
        this.total = total;
        this.locCode = locCode;
        this.accCode = accCode;
        this.teacherCode = teacherCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
