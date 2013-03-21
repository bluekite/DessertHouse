package dao.impl;

import dao.DaoHelper;
import dao.StaffDao;
import model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 3/19/13
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class StaffDaoImpl implements StaffDao{

    private static StaffDaoImpl staffDao=new StaffDaoImpl();
    private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();

    private StaffDaoImpl()
    {

    }

    public static StaffDaoImpl getInstance()
    {
        return staffDao;
    }



    public void savePersonnel(Staff staff) {
        Connection conn = daoHelper.getConnection();
        PreparedStatement stmt = null  ;
        try
        {
            stmt=conn.prepareStatement("insert into staff (workid,password,name,level,workshop) values(?,?,?,?,?)");
            stmt.setString(1,staff.getWorkid());
            stmt.setString(2,staff.getPassword());
            stmt.setString(3,staff.getName());
            stmt.setInt(4, 2);
            stmt.setString(5, staff.getWorkshop());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            daoHelper.closeConnection(conn);
            daoHelper.closePreparedStatement(stmt);
        }
    }

    public void saveManager(Staff staff) {
        Connection conn = daoHelper.getConnection();
        PreparedStatement stmt = null  ;
        try
        {
            stmt=conn.prepareStatement("insert into staff (workid,password,name,level) values(?,?,?,?)");
            stmt.setString(1,staff.getWorkid());
            stmt.setString(2,staff.getPassword());
            stmt.setString(3,staff.getName());
            stmt.setInt(4,1);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            daoHelper.closeConnection(conn);
            daoHelper.closePreparedStatement(stmt);
        }
    }



    public Staff find(String column, String value) {
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        ResultSet result=null;
        try
        {
            stmt=con.prepareStatement("select * from staff where "+column+"=?");
            stmt.setString(1,value);
            result=stmt.executeQuery();
            if(result.next())
            {
                Staff staff=new Staff();
                staff.setWorkid(result.getString(1));
                staff.setPassword(result.getString(2));
                staff.setName(result.getString(3));
                staff.setLevel(result.getInt(4));
                staff.setWorkshop(result.getString(5));
                return staff;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            daoHelper.closeConnection(con);
            daoHelper.closePreparedStatement(stmt);
            daoHelper.closeResult(result);
        }
        return null;
    }


    public void updateByUserid(Staff staff) {
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        try
        {
            stmt=con.prepareStatement("update staff set password=?,name=?,level=?,workshop=? where workid=?");
            stmt.setString(5,staff.getWorkid());
            stmt.setString(1,staff.getPassword());
            stmt.setString(2,staff.getName());

            stmt.setString(4,staff.getWorkshop());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            daoHelper.closeConnection(con);
            daoHelper.closePreparedStatement(stmt);
        }

    }

    public ArrayList<Staff> getAll(){
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        ResultSet result=null;
        ArrayList<Staff> sList = new ArrayList<Staff>();

        try
        {
            stmt=con.prepareStatement("select * from staff");

            result=stmt.executeQuery();

            while(result.next())
            {

                Staff workshop = new Staff();
                workshop.setWorkid(result.getString(1));
                workshop.setPassword(result.getString(2));
                workshop.setName(result.getString(3));
                workshop.setLevel(result.getInt(4));

                workshop.setWorkshop(result.getString(5));
                if(result.getInt(4)==2){
                    sList.add(workshop);
                }


            }
            return sList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            daoHelper.closeConnection(con);
            daoHelper.closePreparedStatement(stmt);
            daoHelper.closeResult(result);
        }
        return null;

    }

    public void shopByUserid(String id, String shop) {
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        try
        {
            stmt=con.prepareStatement("update staff set workshop=? where workid=?");
            stmt.setString(2,id);
            stmt.setString(1,shop);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            daoHelper.closeConnection(con);
            daoHelper.closePreparedStatement(stmt);
        }
    }

}
