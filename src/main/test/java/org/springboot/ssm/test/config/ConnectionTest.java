package org.springboot.ssm.test.config;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class ConnectionTest {

    public static void main(String[] args) {
        Connection conn = null;
        String sql;
//        String url = "jdbc:mysql://localhost:3306/test?" +
//                "user=root&password=root&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT";
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT";
        String user = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            log.info("成功加载MySql驱动程序");
            conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            sql = "create table student(No char(20), name varchar(20), primary key(No))";
            int result = stmt.executeUpdate(sql);
            if (result != -1) {
                log.info("创建数据表成功");
                sql = "insert into student(no, name) values ('201201', 'lu123')";
                result = stmt.executeUpdate(sql);
                sql = "insert into student(no, name) values ('201202', 'ya123')";
                result = stmt.executeUpdate(sql);
                sql = "select * from student";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    log.info(rs.getString(1) + "\t" + rs.getString(2));
                }
            }
        } catch (ClassNotFoundException e) {
            log.error("没有找到驱动类");
            throw new RuntimeException("没有找到加载类");
        } catch (SQLException e) {
            log.error("sql不正确", e.getMessage(), e);
            throw new RuntimeException("sql不正确");
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                log.error("关闭连接失败");
                throw new RuntimeException("关闭连接失败");
            }
        }
    }
}
