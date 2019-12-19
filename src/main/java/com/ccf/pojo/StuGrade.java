package com.ccf.pojo;

public class StuGrade {

    private String sid;

    private int grade;

    private int session;

    private int First;

    private int Second;

    private int Third;

    private int Fourth;

    private int Fifth;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public int getFirst() {
        return First;
    }

    public void setFirst(int first) {
        First = first;
    }

    public int getSecond() {
        return Second;
    }

    public void setSecond(int second) {
        Second = second;
    }

    public int getThird() {
        return Third;
    }

    public void setThird(int third) {
        Third = third;
    }

    public int getFourth() {
        return Fourth;
    }

    public void setFourth(int fourth) {
        Fourth = fourth;
    }

    public int getFifth() {
        return Fifth;
    }

    public void setFifth(int fifth) {
        Fifth = fifth;
    }

    @Override
    public String toString() {
        return "StuGrade{" +
                "sid='" + sid + '\'' +
                ", grade=" + grade +
                ", session=" + session +
                ", First=" + First +
                ", Second=" + Second +
                ", Third=" + Third +
                ", Fourth=" + Fourth +
                ", Fifth=" + Fifth +
                '}';
    }
}
