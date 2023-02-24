package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    JLabel title;   //标题标签
    JLabel usernameLa;      //用户名标签
    JTextField usernameTxt; //用户名输入框
    JLabel passwordLa;          //密码标签
    JPasswordField passwordTxt; //密码输入框
    JButton loginBt;    //登录按钮
    JButton cancelBt;   //取消按钮
    MessageBox messageBox;   //消息框

    public Login() {
        this.setTitle("登录");
        this.setSize(400, 600);
        this.setLocation(600,150);
        this.setLayout(null);
        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void init() {
        title = new JLabel("欢迎使用外观设计专利信息管理系统");
        title.setSize(400,150);
        title.setLocation(40, 20);
        title.setFont(new Font(null, Font.BOLD, 25));
        title.setIcon(new ImageIcon(".\\1.jpg"));
        title.setHorizontalTextPosition(SwingConstants.CENTER);   // 水平方向文本在图片中心
        title.setVerticalTextPosition(SwingConstants.BOTTOM);     // 垂直方向文本在图片下方

        title.setIconTextGap(20);    // 设置图片和文本之间的间隙
        this.add(title);

        usernameLa = new JLabel("用户名");
        usernameLa.setSize(60, 30);
        usernameLa.setLocation(80,200);
        this.add(usernameLa);
        usernameTxt = new JTextField();
        usernameTxt.setSize(150, 30);
        usernameTxt.setLocation(130,200);
        this.add(usernameTxt);

        passwordLa = new JLabel("密码");
        passwordLa.setSize(60, 30);
        passwordLa.setLocation(80,250);
        this.add(passwordLa);
        passwordTxt = new JPasswordField();
        passwordTxt.setSize(150, 30);
        passwordTxt.setLocation(130, 250);
        this.add(passwordTxt);

        loginBt = new JButton("登录");
        loginBt.setSize(60, 30);
        loginBt.setLocation(90, 320);
        loginBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTxt.getText();
                String password = new String(passwordTxt.getPassword());
                Deal deal = new Deal();
                int flag = deal.accountVerify(username, password);
                switch (flag) {
                    case 0: //用户不存在
                        messageBox = new MessageBox(Login.this, "用户不存在");
                        break;
                    case 1: //用户存在且密码正确
                        Home home = new Home();
                        Login.this.dispose();
                        break;
                    case 2: //用户存在但密码错误
                        messageBox = new MessageBox(Login.this, "密码错误,请重新输入");
                        break;
                }
            }
        });
        this.add(loginBt);

        cancelBt = new JButton("取消");
        cancelBt.setSize(60, 30);
        cancelBt.setLocation(240, 320);
        cancelBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.this.dispose();
            }
        });
        this.add(cancelBt);

    }
}
