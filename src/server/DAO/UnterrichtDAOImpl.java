package server.DAO;

import model.Unterricht;
import server.Database.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UnterrichtDAOImpl implements UnterrichtDAO{
    DatabaseConnection dbConnection;
    Statement statement;
    ResultSet resultSet;

    public UnterrichtDAOImpl(DatabaseConnection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        this.dbConnection.connect();

        statement = dbConnection.getConnection().createStatement();
        createTable();
    }


    @Override
    public void createTable() throws SQLException {
        System.out.println("DBHandler: Create Table");
        statement.execute("CREATE TABLE IF NOT EXISTS lessons (wochentag INT NOT NULL,einheit INT NOT NULL,klasse varchar(255) NOT NULL,fach varchar(255))");
    }

    @Override
    public void setLessons(List<Unterricht> unterrichtList) throws SQLException {
        System.out.println("DBHandler: Insert Data in Table");
        for (Unterricht unterricht: unterrichtList) {
            statement.executeUpdate("INSERT INTO lessons VALUES (" + unterricht.getWochentag() + ", " + unterricht.getEinheit() + ", '" + unterricht.getKlasse() + "', '" + unterricht.getFach() + "')");
        }
        resultSet = statement.executeQuery("SELECT * FROM lessons");

        while (resultSet.next()){
            System.out.println(resultSet.getString("klasse"));
        }
    }
}
