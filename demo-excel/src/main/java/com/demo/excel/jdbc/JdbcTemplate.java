package com.demo.excel.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JdbcTemplate {

    private static final String HOST = "jdbc:mysql://rr-2zea03s6v41642ehxo.mysql.rds.aliyuncs.com:3306/market_activity";
    private static final String USER = "aixuexidball";
    private static final String PWD = "aixuexi_2016dball";

    public static List<Map> exeSql(String sql) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        List<Map> list = new LinkedList<>();


        try {
            // 通过驱动管理获取数据库连接
            connection = DriverManager
                    .getConnection(HOST, USER, PWD);

            // 获取预处理statement('?'参数占位符)
            preparedStatement = connection.prepareStatement(sql);
            // 查询结果集
            resultSet = preparedStatement.executeQuery();

            int columnsCount = resultSet.getMetaData().getColumnCount() ;

            while (resultSet.next()) {

                Map m = new HashMap();

                for (int i = 1 ;i < columnsCount + 1; i ++) {
                    m.put(i, resultSet.getObject(i));
                }
                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            //释放资源
            try {
                if (resultSet != null)
                    resultSet.close();

                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list ;
        }
    }
}
