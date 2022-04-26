package server.DAO;

import model.Unterricht;

import java.sql.SQLException;
import java.util.List;

public interface UnterrichtDAO {
    void createTable() throws SQLException;

    void setLessons(List<Unterricht> unterrichtList) throws SQLException;
}
