package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-3-8
 * Time: 下午8:43
 * To change this template use File | Settings | File Templates.
 */
public interface DaoHelper {

    public Connection getConnection();
    public void closeConnection(Connection con);
    public void closePreparedStatement(PreparedStatement stmt);
    public void closeResult(ResultSet result);
}
