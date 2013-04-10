package matva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 29.03.13
 * Time: 11:52
 * To change this template use File | Settings | File Templates.
 */
public class DBManager {
    private Connection c;

    private String dbUrl = "jdbc:mysql://localhost/Tools/phpmyadmin/index.php?db=testjava";
    private String user = "testjava";
    private String password = "testjava";

    public DBManager(){
        try {
            c = DriverManager.getConnection(dbUrl,user,password);
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addNextValue(String nameTable, long timeLabel, double value) throws SQLException {
        String query = "INSERT INTO ? (`time_label`, `value`) VALUES (?, ?);";
        PreparedStatement preparedStatement = c.prepareStatement(query);
        preparedStatement.setString(1,nameTable);
        preparedStatement.setLong(2,timeLabel);
        preparedStatement.setDouble(3,value);
        preparedStatement.execute();
        preparedStatement.close();
    }

}
