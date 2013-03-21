package dao.impl;

import dao.DaoHelper;
import dao.DessertDao;
import model.Customer;
import model.Dessert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 3/17/13
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class DessertDaoImpl implements DessertDao{

    private static DessertDaoImpl dessertDao=new DessertDaoImpl();
    private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();

    private DessertDaoImpl()
    {

    }

    public static DessertDaoImpl getInstance()
    {
        return dessertDao;
    }



    public void save(Dessert dessert) {
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        try
        {
            stmt=con.prepareStatement("insert into desserts(name,price,number,href) values(?,?,?,?)");

            stmt.setString(1,dessert.getName());
            stmt.setDouble(2, dessert.getPrice());
            stmt.setInt(3, dessert.getNumber());
            stmt.setString(4, dessert.getHref());
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

    public ArrayList<Dessert> getAll(){
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        ResultSet result=null;
        ArrayList<Dessert> deList = new ArrayList<Dessert>();

        try
        {
            stmt=con.prepareStatement("select * from desserts");

            result=stmt.executeQuery();
            while(result.next())
            {
                Dessert dessert = new Dessert();
                dessert.setId(result.getInt(1));
                dessert.setName(result.getString(2));
                dessert.setPrice(result.getDouble(3));
                dessert.setNumber(result.getInt(4));
                dessert.setHref(result.getString(5));
                deList.add(dessert);

            }
            return deList;
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


    public Dessert find(String column, int value) {
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        ResultSet result=null;

        try
        {
            stmt=con.prepareStatement("select * from desserts where "+column+"=?");
            stmt.setInt(1, value);
            result=stmt.executeQuery();
            if(result.next())
            {
                Dessert dessert = new Dessert();
                dessert.setId(result.getInt(1));
                dessert.setName(result.getString(2));
                dessert.setPrice(result.getDouble(3));
                dessert.setNumber(result.getInt(4));
                dessert.setHref(result.getString(5));
                return dessert;
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



    public void sellByDesid(int id,int number,int sellnum){
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;

        try
        {
            stmt=con.prepareStatement("update desserts set number=? where id=?");
            stmt.setInt(2, id);
            stmt.setInt(1,number-sellnum);

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

    public void deleteByDesid(int id){

        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        try
        {
            stmt=con.prepareStatement("delete from desserts where id=?");
            stmt.setInt(1, id);
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

    public void updateByDesid(Dessert dessert) {

        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;

        try
        {
            stmt=con.prepareStatement("update desserts set name=?,price=?,number=?,href=? where id=?;");
            stmt.setInt(5, dessert.getId());

            stmt.setString(1,dessert.getName());

            stmt.setDouble(2, dessert.getPrice());
            stmt.setInt(3, dessert.getNumber());
            stmt.setString(4, dessert.getHref());
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
