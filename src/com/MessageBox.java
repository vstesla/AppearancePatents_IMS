package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//消息框
public class MessageBox {
    public MessageBox(JFrame owner, String message) {
        //消息对话框
        JDialog messDi = new JDialog(owner,"提示",true);
        messDi.setSize(300, 150);
        messDi.setLocation(650,300);
        messDi.setResizable(false); // 设置对话框大小不可改变
        messDi.setLayout(null);

        //消息标签
        JLabel messLa = new JLabel(message);
        messLa.setFont(new Font(null, Font.BOLD,15));
        messLa.setSize(200,30);
        messLa.setLocation(70,20);
        messDi.add(messLa);

        //确认按钮
        JButton messBt = new JButton("确认");
        messBt.setSize(60, 30);
        messBt.setLocation(110, 65);
        messDi.add(messBt);

        //确认按钮监听
        messBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messDi.dispose();
            }
        });

        messDi.setVisible(true);

    }
}