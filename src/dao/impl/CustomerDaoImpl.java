package dao.impl;

import dao.CustomerDao;
import dao.DaoHelper;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-3-8
 * Time: 下午8:42
 * To change this template use File | Settings | File Templates.
 */
public class CustomerDaoImpl implements CustomerDao{


    private static CustomerDaoImpl customerDao=new CustomerDaoImpl();
    private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();

    private CustomerDaoImpl()
    {

    }

    public static CustomerDaoImpl getInstance()
    {
        return customerDao;
    }

    public void save(Customer customer) {
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        try
        {
            stmt=con.prepareStatement("insert into customers(userid,name,password,birthday,gender,address) values(?,?,?,?,?,?)");
            stmt.setString(1,customer.getUserid());
            stmt.setString(2,customer.getName());
            stmt.setString(3,customer.getPasswd());
            stmt.setDate(4,customer.getBirthday());
            stmt.setString(5, customer.getGender());
            stmt.setString(6,customer.getAddress());


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

    public Customer find(String column, String value) {

        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        ResultSet result=null;
        try
        {
            stmt=con.prepareStatement("select * from customers where "+column+"=?");
            stmt.setString(1,value);
            result=stmt.executeQuery();
            if(result.next())
            {
                Customer customer=new Customer();
                customer.setUserid(result.getString(1));
                customer.setName(result.getString(2));
                customer.setPasswd(result.getString(3));
                customer.setBirthday(result.getDate(4));
                customer.setGender(result.getString(5));
                customer.setAddress(result.getString(6));
                customer.setAccount(result.getDouble(7));
                customer.setStatus(result.getInt(8));
                customer.setLevel(result.getInt(9));
                return customer;
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

    public void updateByUserid(Customer customer) {
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        try
        {
            stmt=con.prepareStatement("update customers set name=?,password=?,gender=?,address=? where userid=?");
            stmt.setString(5,customer.getUserid());
            stmt.setString(1,customer.getName());
            stmt.setString(2,customer.getPasswd());
            stmt.setString(3,customer.getGender());
            stmt.setString(4,customer.getAddress());
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


    public void levelByUserid(String id,int level) {
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        try
        {
            stmt=con.prepareStatement("update customers set level=? where userid=?");
            stmt.setString(2,id);
            stmt.setInt(1,level);
            System.out.println(id+"   =.=   "+level);
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

    public void stop(Customer customer){
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        try
        {
            stmt=con.prepareStatement("update customers set status=? where userid=?");
            stmt.setString(2,customer.getUserid());
            stmt.setInt(1,2);


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


    public void recharge(Customer customer,double money) {
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        java.util.Date date = new java.util.Date();
        java.sql.Date birthday = new java.sql.Date(date.getTime());
        try
        {
            stmt=con.prepareStatement("update customers set birthday=?,account=?,status=? where userid=?");
            stmt.setString(4,customer.getUserid());
            if(customer.getStatus()==2){
                stmt.setDate(1, customer.getBirthday());
                stmt.setDouble(2,customer.getAccount());
                stmt.setInt(3,2);
            }else if(customer.getStatus()==1){
                stmt.setDate(1, customer.getBirthday());
                double account = money+customer.getAccount();
                stmt.setDouble(2,account);
                stmt.setInt(3,1);
            }else{
                if (money>=100){
                    stmt.setDate(1, birthday);
                    stmt.setDouble(2,money+customer.getAccount());
                    stmt.setInt(3,1);
                }else{
                    stmt.setDate(1, customer.getBirthday());
                    stmt.setDouble(2,money+customer.getAccount());
                    stmt.setInt(3,0);
                }

            }


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

    public ArrayList<Customer> getAll(){
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        ResultSet result=null;
        ArrayList<Customer> cList = new ArrayList<Customer>();

        try
        {
            stmt=con.prepareStatement("select * from customers");

            result=stmt.executeQuery();
            while(result.next())
            {
                Customer customer = new Customer();
                customer.setUserid(result.getString(1));
                customer.setName(result.getString(2));
                customer.setPasswd(result.getString(3));
                customer.setBirthday(result.getDate(4));
                customer.setGender(result.getString(5));
                customer.setAddress(result.getString(6));
                customer.setAccount(result.getDouble(7));
                customer.setStatus(result.getInt(8));
                customer.setLevel(result.getInt(9));
                cList.add(customer);

            }
            return cList;
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


}
