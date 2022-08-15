package ua.mk.berkut.p1508.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {
    private static DBManager instance;

    private Connection connection;

    private DBManager(){}

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void initConnection(DataSource ds) throws SQLException {
        connection = ds.getConnection();
    }
}
