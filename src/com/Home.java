package com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Home extends JFrame {
    //增删改组件
    JButton addBt;      //增加按钮
    JButton delBt;      //删除按钮
    JButton upBt;       //修改按钮
    JButton orderBt;     //排序按钮

    //查询组件
    JLabel pnoLa;      //专利号标签
    JTextField pnoTxt; //专利号文本框
    JButton pnoBt;     //专利号查询按钮

    JLabel pnameLa;      //专利名称标签
    JTextField pnameTxt; //专利名称文本框
    JButton pnameBt;     //专利名称查询按钮

    JLabel applicantLa;      //专利申请人标签
    JTextField applicantTxt; //专利申请人文本框
    JButton applicantBt; //专利申请人查询按钮

    JLabel pclassLa;      //专利类别标签
    JComboBox pclassCom;  //专利类别下拉框
    JButton pclassBt;     //专利类别查询按钮

    JLabel FirstApprotimeLa;        //最早批准时间
    JTextField FirstApprotimeTxt;   //最早批准时间文本框
    JLabel LastApprotimeLa;        //最晚批准时间
    JTextField LastApprotimeTxt;   //最晚批准时间文本框
    JButton ApprotimeBt;          //批准时间查询按钮

    JLabel minDurationLa;        //最短专利有效期
    JTextField minDurationTxt;   //最短专利有效期文本框
    JLabel maxDurationLa;        //最长最长专利有效期
    JTextField maxDurationTxt;   //最长专利有效期文本框
    JButton DurationBt;          //专利有效期查询按钮

    //显示组件(表格）
    JTable table;
    JScrollPane tablePn;//用来放表格的面板(带有滚动条)

    //提示框
    MessageBox messageBox;

    public Home() {
        this.setSize(800,1000);
        this.setLocation(370,150);
        this.setTitle("外观设计专利信息管理系统");
        this.setLayout(null);
        init();//初始化界面
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    //初始化界面
    public void init() {
        pnoLa=new JLabel("专利号");
        pnoLa.setSize(60, 30);
        pnoLa.setLocation(80, 30);
        this.add(pnoLa);
        pnoTxt=new JTextField();
        pnoTxt.setSize(60, 30);
        pnoTxt.setLocation(120, 30);
        this.add(pnoTxt);
        pnoBt=new JButton("专利号查询");
        pnoBt.setSize(100, 30);
        pnoBt.setLocation(200, 30);
        this.add(pnoBt);

        pnameLa=new JLabel("专利名称");
        pnameLa.setSize(60, 30);
        pnameLa.setLocation(65, 80);
        this.add(pnameLa);
        pnameTxt=new JTextField();
        pnameTxt.setSize(60, 30);
        pnameTxt.setLocation(120, 80);
        this.add(pnameTxt);
        pnameBt=new JButton("专利名称查询");
        pnameBt.setSize(120, 30);
        pnameBt.setLocation(200, 80);
        this.add(pnameBt);

        applicantLa=new JLabel("申请人");
        applicantLa.setSize(60, 30);
        applicantLa.setLocation(75, 130);
        this.add(applicantLa);
        applicantTxt=new JTextField();
        applicantTxt.setSize(60, 30);
        applicantTxt.setLocation(120, 130);
        this.add(applicantTxt);
        applicantBt=new JButton("申请人查询");
        applicantBt.setSize(100, 30);
        applicantBt.setLocation(200, 130);
        this.add(applicantBt);

        pclassLa=new JLabel("专利类别");
        pclassLa.setSize(60, 30);
        pclassLa.setLocation(370, 30);
        this.add(pclassLa);
        pclassCom=new JComboBox();
        pclassCom.setSize(110, 30);
        pclassCom.setLocation(430, 30);
        pclassCom.addItem("家具外观");
        pclassCom.addItem("日用品外观");
        pclassCom.addItem("服装外观");
        this.add(pclassCom);
        pclassBt=new JButton("专利类别查询");
        pclassBt.setSize(140, 30);
        pclassBt.setLocation(570, 30);
        this.add(pclassBt);

        FirstApprotimeLa=new JLabel("最早批准年限");
        FirstApprotimeLa.setSize(90,30);
        FirstApprotimeLa.setLocation(40, 180);
        this.add(FirstApprotimeLa);
        FirstApprotimeTxt=new JTextField();
        FirstApprotimeTxt.setSize(60, 30);
        FirstApprotimeTxt.setLocation(120, 180);
        this.add(FirstApprotimeTxt);
        LastApprotimeLa=new JLabel("最晚批准年限");
        LastApprotimeLa.setSize(90,30);
        LastApprotimeLa.setLocation(40, 230);
        this.add(LastApprotimeLa);
        LastApprotimeTxt=new JTextField();
        LastApprotimeTxt.setSize(60, 30);
        LastApprotimeTxt.setLocation(120, 230);
        this.add(LastApprotimeTxt);
        ApprotimeBt=new JButton("批准年限查询");
        ApprotimeBt.setSize(120, 30);
        ApprotimeBt.setLocation(200, 205);
        this.add(ApprotimeBt);

        minDurationLa=new JLabel("最短专利有效期");
        minDurationLa.setSize(100,30);
        minDurationLa.setLocation(335, 80);
        this.add(minDurationLa);
        minDurationTxt=new JTextField();
        minDurationTxt.setSize(60, 30);
        minDurationTxt.setLocation(430, 80);
        this.add(minDurationTxt);
        maxDurationLa=new JLabel("最长专利有效期");
        maxDurationLa.setSize(100,30);
        maxDurationLa.setLocation(335, 130);
        this.add(maxDurationLa);
        maxDurationTxt=new JTextField();
        maxDurationTxt.setSize(60, 30);
        maxDurationTxt.setLocation(430, 130);
        this.add(maxDurationTxt);
        DurationBt=new JButton("专利有效期查询");
        DurationBt.setSize(140, 30);
        DurationBt.setLocation(510, 105);
        this.add(DurationBt);

        delBt=new JButton("删除选中专利");
        delBt.setSize(120, 30);
        delBt.setLocation(430, 180);
        this.add(delBt);

        upBt=new JButton("修改选中专利");
        upBt.setSize(140, 30);
        upBt.setLocation(570, 180);
        this.add(upBt);

        addBt=new JButton("增加专利信息");
        addBt.setSize(120, 30);
        addBt.setLocation(430, 230);
        this.add(addBt);

        orderBt=new JButton("按照批准年限排序");
        orderBt.setSize(140, 30);
        orderBt.setLocation(570, 230);
        this.add(orderBt);

        //表格
        Deal deal = new Deal();
        InitTable(deal.findAllPats());

        //响应
        respond();

    }

    //初始化表格
    public void InitTable(ArrayList<Patent> list) {
        //第一次面板为空，第二次面板不为空，清除面板
        if(tablePn!=null) {
            this.remove(tablePn);
        }

        String[] titles={"专利号","专利名称","申请人","批准年限","专利类别","专利有效期"};//列名
        String[][] values=new String[list.size()][6];//数据
        for(int i = 0; i < list.size(); i++) {  //通过循环将查询到的学生记录赋给存储值的二维数组
            Patent pat=list.get(i);
            values[i][0]=pat.pno;
            values[i][1]=pat.pname;
            values[i][2]=pat.applicant;
            values[i][3]=String.valueOf(pat.Approtime);
            values[i][4]=pat.pclass;
            values[i][5]=String.valueOf(pat.Duration);
        }
        table = new JTable(values,titles);
        tablePn = new JScrollPane();
        tablePn.setViewportView(table);//将表格添加到JScrollPane中
        tablePn.setSize(800, 700);
        tablePn.setLocation(0, 300);
        this.add(tablePn);    //把JScrollPane添加到JFrame中
    }

    //添加监听事件
    public void respond() {
        //专利号查询监听
        pnoBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deal deal = new Deal();
                String pno = pnoTxt.getText();
                InitTable(deal.findPatentsByPno1(pno));
            }
        });
        //专利名称查询监听
        pnameBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deal deal = new Deal();
                InitTable(deal.findPatentsByPname(pnameTxt.getText().trim()));
            }
        });

        //申请人查询监听
        applicantBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deal deal = new Deal();
                InitTable(deal.findPatentsByApplicant(applicantTxt.getText().trim()));
            }
        });

        //专利类别查询监听
        pclassBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deal deal = new Deal();
                InitTable(deal.findPatentsByPclass(pclassCom.getSelectedItem().toString()));
            }
        });

        //批准年限查询监听
        ApprotimeBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deal deal = new Deal();
                int FAT = Integer.parseInt(FirstApprotimeTxt.getText());
                int LAT = Integer.parseInt(LastApprotimeTxt.getText());
                InitTable(deal.findPatentsByApprotime(FAT, LAT));
            }
        });

        //专利有效期查询监听
        DurationBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deal deal = new Deal();
                int mind = Integer.parseInt(minDurationTxt.getText());
                int maxd = Integer.parseInt(maxDurationTxt.getText());
                InitTable(deal.findPatentsByDuration(mind, maxd));
            }
        });

        //删除信息监听
        delBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    messageBox = new MessageBox(Home.this, "请选中要删除的专利信息");
                }else {
                    Deal deal = new Deal();
                    String sno = table.getValueAt(row, 0).toString();
                    deal.deletePat(sno);
                    InitTable(deal.findAllPats());
                }
            }
        });

        //更新信息监听
        upBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    messageBox = new MessageBox(Home.this, "请选中要修改的专利信息");
                }else {
                    Deal deal = new Deal();
                    String pno = table.getValueAt(row, 0).toString();
                    Alter alter = new Alter(pno, Home.this);
                }
            }
        });

        //增加信息监听
        addBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add add = new Add(Home.this);
            }
        });

        //排序信息监听
        orderBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deal deal = new Deal();
                InitTable(deal.orderAllPats());
            }
        });

    }
}