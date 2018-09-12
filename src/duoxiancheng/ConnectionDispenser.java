package duoxiancheng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: xk
 * @Date: 2018/9/10
 * @Version 1.0
 */
public class ConnectionDispenser {
    static String DB_URL = "jdbc:mysql://localhost/mydatabase";

    private ThreadLocal<Connection> connectionHolder
            = new ThreadLocal<Connection>() {
        public Connection initialValue() {
            try {
                return DriverManager.getConnection(DB_URL);
            } catch (SQLException e) {
                throw new RuntimeException("Unable to acquire Connection, e");
            }
        }
    };

    public Connection getConnection() {
        return connectionHolder.get();
    }
}
