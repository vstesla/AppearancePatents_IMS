package com;

import javax.swing.*;
import java.awt.event.*;

public class Alter extends JFrame {
    JLabel pnoLa,pnameLa,applicantLa,ApprotimeLa,pclassLa,DurationLa;
    JTextField pnoTxt,pnameTxt,applicantTxt,ApprotimeTxt,DurationTxt;
    JComboBox pclassCom;
    JButton bt;

    Home home;

    public Alter(String pno, Home home) {
        this.setSize(300, 400);
        this.setLocation(200,100);
        this.setTitle("修改专利信息");
        this.setLayout(null);
        this.init(pno);
        this.setVisible(true);
        this.home=home;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(String pno) {
        Deal deal = new Deal();
        Patent pat = deal.findPatentsByPno2(pno);
        pnoLa=new JLabel("专利号");
        pnoLa.setSize(60, 30);
        pnoLa.setLocation(30,30);
        this.add(pnoLa);
        pnoTxt=new JTextField();
        pnoTxt.setSize(120, 30);
        pnoTxt.setLocation(100,30);
        pnoTxt.setEnabled(false);
        pnoTxt.setText(pat.pno);
        this.add(pnoTxt);

        pnameLa=new JLabel("专利名");
        pnameLa.setSize(60, 30);
        pnameLa.setLocation(30,80);
        this.add(pnameLa);
        pnameTxt=new JTextField();
        pnameTxt.setSize(120, 30);
        pnameTxt.setLocation(100,80);
        pnameTxt.setText(pat.pname);
        this.add(pnameTxt);

        applicantLa=new JLabel("申请人");
        applicantLa.setSize(60, 30);
        applicantLa.setLocation(30,130);
        this.add(applicantLa);
        applicantTxt=new JTextField();
        applicantTxt.setSize(120, 30);
        applicantTxt.setLocation(100,130);
        applicantTxt.setText(pat.applicant);
        this.add(applicantTxt);


        ApprotimeLa=new JLabel("批准年限");
        ApprotimeLa.setSize(60, 30);
        ApprotimeLa.setLocation(30,180);
        this.add(ApprotimeLa);
        ApprotimeTxt=new JTextField();
        ApprotimeTxt.setSize(120, 30);
        ApprotimeTxt.setLocation(100,180);
        ApprotimeTxt.setText(String.valueOf(pat.Approtime));
        this.add(ApprotimeTxt);

        pclassLa=new JLabel("专利类别");
        pclassLa.setSize(60, 30);
        pclassLa.setLocation(30,230);
        this.add(pclassLa);
        pclassCom=new JComboBox();
        pclassCom.setSize(120, 30);
        pclassCom.setLocation(100,230);
        pclassCom.addItem("家具外观");
        pclassCom.addItem("日用品外观");
        pclassCom.addItem("服装外观");
        pclassCom.setSelectedItem(pat.pclass);
        this.add(pclassCom);

        DurationLa=new JLabel("专利有效期");
        DurationLa.setSize(70, 30);
        DurationLa.setLocation(30,280);
        this.add(DurationLa);
        DurationTxt=new JTextField();
        DurationTxt.setSize(120, 30);
        DurationTxt.setLocation(100,280);
        DurationTxt.setText(String.valueOf(pat.Duration));
        this.add(DurationTxt);

        bt=new JButton("修改");
        bt.setSize(60, 30);
        bt.setLocation(160,320);

        //为修改按钮添加监听器
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pno = pnoTxt.getText().trim();
                String pname = pnameTxt.getText().trim();
                String applicant = applicantTxt.getText().trim();
                int Approtime = Integer.parseInt(ApprotimeTxt.getText().trim());
                String pclass = pclassCom.getSelectedItem().toString();
                int Duration = Integer.parseInt(DurationTxt.getText().trim());
                Patent pat = new Patent(pno, pname, applicant, Approtime, pclass, Duration);
//                System.out.println(pat);
                Deal deal = new Deal();
                deal.alterPat(pat);
                home.InitTable(deal.findAllPats());
            }
        });
        this.add(bt);
    }
}
