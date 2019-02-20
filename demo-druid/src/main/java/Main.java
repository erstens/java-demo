import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DruidDataSource ds = new DruidDataSource() ;
        ds.setUrl("jdbc:mysql://mysql.aixuexi.com:3306/test?autoReconnect=true");
        ds.setUsername("gsadmin");
        ds.setPassword("Gaosi2012");
        DruidPooledConnection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement("select version()");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }
}
