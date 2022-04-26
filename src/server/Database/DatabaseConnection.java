package server.Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    Connection connection;
    String url;
    Properties dbProperties = new Properties();
    String user;
    String password;

    public DatabaseConnection(String path) throws IOException {
        try (FileInputStream in = new FileInputStream(path)){
            dbProperties.load(in);
        }
        this.url = dbProperties.getProperty("url");
        this.user = dbProperties.getProperty("user");
        this.password = dbProperties.getProperty("password");
    }

    public void connect() throws SQLException {
        try {
            Class.forName(dbProperties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("DBConnection: Create Connection to DB");
        connection = DriverManager.getConnection(this.url, this.user, this.password);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getConnection() {
        return connection;
    }
}
