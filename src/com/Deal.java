package com;

import java.sql.*;
import java.util.ArrayList;

public class Deal {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet res = null;

    //创建数据库连接
    public Deal() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //加载驱动
            String url = "jdbc:mysql://localhost:3306/wgsjzl?&useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url,user,password);  //连接数据库
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //添加专利信息
    public void addPat(Patent pat) {
        try {
            String sql = "insert into patents values (?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,pat.pno);
            ps.setString(2,pat.pname);
            ps.setString(3,pat.applicant);
            ps.setInt(4,pat.Approtime);
            ps.setString(5,pat.pclass);
            ps.setInt(6,pat.Duration);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //删除专利信息
    public void deletePat(String pno) {
        try {
            String sql = "delete from patents where pno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,pno);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改专利信息
    public void alterPat(Patent pat) {
        try {
            String sql = "update patents set pname = ?, applicant = ?, Approtime = ?, pclass = ?, Duration = ? where pno = ?";
            ps = conn.prepareStatement(sql);
//            System.out.println(pat);
            ps.setString(1,pat.pname);
            ps.setString(2,pat.applicant);
            ps.setInt(3,pat.Approtime);
            ps.setString(4,pat.pclass);
            ps.setInt(5,pat.Duration);
            ps.setString(6,pat.pno);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //专利号查询
    public ArrayList<Patent> findPatentsByPno1(String pno) {
        ArrayList<Patent> result = new ArrayList<>();
        try {
            String sql = "select * from patents where pno = '" + pno + "'";
            ps = conn.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                Patent pat = new Patent(res.getString("pno"), res.getString("pname"), res.getString("applicant"),
                        res.getInt("Approtime"), res.getString("pclass"), res.getInt("Duration"));
                result.add(pat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //通过专利号查找专利信息以便作为修改的参考值
    public Patent findPatentsByPno2(String pno) {
        Patent pat = null;
        try {
            String sql = "select * from patents where pno = '" + pno + "'";
            ps = conn.prepareStatement(sql);
            res = ps.executeQuery();
            if (res.next()) {
                pat = new Patent(res.getString("pno"), res.getString("pname"), res.getString("applicant"),
                        res.getInt("Approtime"), res.getString("pclass"), res.getInt("Duration"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pat;
    }

    //通过名称查找专利（模糊查询）
    public ArrayList<Patent> findPatentsByPname(String pname) {
        ArrayList<Patent> result = new ArrayList<>();
        try {
            String sql = "select * from patents where pname like  '%" + pname + "%'";
            ps = conn.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                Patent pat = new Patent(res.getString("pno"), res.getString("pname"), res.getString("applicant"),
                        res.getInt("Approtime"), res.getString("pclass"), res.getInt("Duration"));
                result.add(pat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //通过申请人查找专利（模糊查询）
    public ArrayList<Patent> findPatentsByApplicant(String applicant) {
        ArrayList<Patent> result = new ArrayList<>();
        try {
            String sql = "select * from patents where applicant like  '%" + applicant + "%'";
            ps = conn.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                Patent pat = new Patent(res.getString("pno"), res.getString("pname"), res.getString("applicant"),
                        res.getInt("Approtime"), res.getString("pclass"), res.getInt("Duration"));
                result.add(pat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //通过类别查找专利
    public ArrayList<Patent> findPatentsByPclass(String pclass) {
        ArrayList<Patent> result = new ArrayList<>();
        try {
            String sql = "select * from patents where pclass = '" + pclass + "'";
            ps = conn.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                Patent pat = new Patent(res.getString("pno"), res.getString("pname"), res.getString("applicant"),
                        res.getInt("Approtime"), res.getString("pclass"), res.getInt("Duration"));
                result.add(pat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //通过批准年限范围查找专利
    public ArrayList<Patent> findPatentsByApprotime(int FAT, int LAT) {
        ArrayList<Patent> result = new ArrayList<>();
        try {
            String sql = "select * from patents where Approtime between ? and ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,FAT);
            ps.setInt(2,LAT);

            res = ps.executeQuery();
            while (res.next()) {
                Patent pat = new Patent(res.getString("pno"), res.getString("pname"), res.getString("applicant"),
                        res.getInt("Approtime"), res.getString("pclass"), res.getInt("Duration"));
                result.add(pat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //通过专利有效期范围查找专利
    public ArrayList<Patent> findPatentsByDuration(int mind, int maxd) {
        ArrayList<Patent> result = new ArrayList<>();
        try {
            String sql = "select * from patents where Duration between ? and ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,mind);
            ps.setInt(2,maxd);

            res = ps.executeQuery();
            while (res.next()) {
                Patent pat = new Patent(res.getString("pno"), res.getString("pname"), res.getString("applicant"),
                        res.getInt("Approtime"), res.getString("pclass"), res.getInt("Duration"));
                result.add(pat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //查找全体学生
    public ArrayList<Patent> findAllPats() {
        ArrayList<Patent> result = new ArrayList<>();
        try {
            String sql = "select * from patents";
            ps = conn.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                Patent pat = new Patent(res.getString("pno"), res.getString("pname"), res.getString("applicant"),
                        res.getInt("Approtime"), res.getString("pclass"), res.getInt("Duration"));
                result.add(pat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //给所有专利信息按照批准年限排序
    public ArrayList<Patent> orderAllPats() {
        ArrayList<Patent> result = new ArrayList<>();
        try {
            String sql = "select * from patents order by Approtime";
            ps = conn.prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                Patent pat = new Patent(res.getString("pno"), res.getString("pname"), res.getString("applicant"),
                        res.getInt("Approtime"), res.getString("pclass"), res.getInt("Duration"));
                result.add(pat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }



    //账户验证
    public int accountVerify(String username, String password) {
        int flag = 0;   //默认用户不存在
        try {
            String sql = "select password from accounts where username = '" + username + "'";
            ps = conn.prepareStatement(sql);
            res = ps.executeQuery();
            if (res.next()) {
                if (password.equals(res.getString("password")) ) {
                    flag = 1;   //用户存在且密码正确
                }else {
                    flag = 2;   //用户存在但密码错误
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    //回收数据库资源
    public void destroy() {
        try {
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res = null;

        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ps = null;

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn = null;
    }
}