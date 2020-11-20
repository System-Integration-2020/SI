package dk.mh.si.rpcintegration;

import java.sql.*;
import java.util.List;


public class CustomerDAO {
    public static String url = "jdbc:h2:file:/users/malenehansen/soft2020/SI/RPC/src/main/resources/db/bank;AUTO_SERVER=true";
    public static String user = "sa";
    public static String password = "";
    public static String driver = "org.h2.Driver";

public String testMetode() throws SQLException{

        //Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = con.prepareStatement("select * from Customer where amount >= 100000;");
        ResultSet rs = ps.executeQuery();
        String name = rs.getString("NAME");

    return name;


}
}