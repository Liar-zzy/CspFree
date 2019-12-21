package com.ccf.pojo;

public class StuGrade {

    private String sid;

    private int grade;

    private int session;

    private int first;

    private int second;

    private int third;

    private int fourth;

    private int fifth;

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
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getThird() {
        return third;
    }

    public void setThird(int third) {
        this.third = third;
    }

    public int getFourth() {
        return fourth;
    }

    public void setFourth(int fourth) {
        this.fourth = fourth;
    }

    public int getFifth() {
        return fifth;
    }

    public void setFifth(int fifth) {
        this.fifth = fifth;
    }

    @Override
    public String toString() {
        return "StuGrade{" +
                "sid='" + sid + '\'' +
                ", grade=" + grade +
                ", session=" + session +
                ", First=" + first +
                ", Second=" + second +
                ", Third=" + third +
                ", Fourth=" + fourth +
                ", Fifth=" + fifth +
                '}';
    }
}
