package com;

public class Patent {
    String pno;      //专利号
    String pname;    //专利名
    String applicant; //申请人
    int Approtime;   //批准年限
    String pclass;   //专利类别
    int Duration;    //专利有效期

    public Patent(String pno, String pname, String applicant, int Approtime, String pclass, int Duration) {
        this.pno = pno;
        this.pname = pname;
        this.applicant = applicant;
        this.Approtime = Approtime;
        this.pclass = pclass;
        this.Duration = Duration;
    }

    @Override
    public String toString() {
        return this.pno +
                "\t|" + this.pname +
                "\t|" + this.applicant +
                "\t|" + this.Approtime +
                "\t|" + this.pclass +
                "\t|" + this.Duration;
    }
}
