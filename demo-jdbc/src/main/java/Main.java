import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 加载驱动
//            Class.forName("com.mysql.jdbc.Driver");
//            new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            // 通过驱动管理获取数据库连接
            connection = DriverManager
                    .getConnection("jdbc:mysql://mysql.aixuexi.com:3306/tiku", "test", "test123");

            // 获取预处理statement('?'参数占位符)
            String sqlString = "select 2 from topic where 1=? limit 1 ";
            preparedStatement = connection.prepareStatement(sqlString);
            // 查询结果集
            preparedStatement.setString(1, "2 or 1=1");
//            preparedStatement.setInt(1,1);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
            while (true) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {/*
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

        */}
        }
    }
