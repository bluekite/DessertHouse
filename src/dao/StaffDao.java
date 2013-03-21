package dao;

import model.Staff;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 3/19/13
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public interface StaffDao {
    public void savePersonnel(Staff staff) throws SQLException;
    public void saveManager(Staff staff);
    public Staff find(String column,String value);
    public void updateByUserid(Staff staff);
    public ArrayList<Staff> getAll();
    public void shopByUserid(String id,String shop);
}
