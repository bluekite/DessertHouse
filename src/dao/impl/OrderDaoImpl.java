package dao.impl;

import dao.DaoHelper;
import dao.OrderDao;
import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 3/19/13
 * Time: 6:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrderDaoImpl implements OrderDao {

    private static OrderDaoImpl orderDao=new OrderDaoImpl();
    private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();

    private OrderDaoImpl()
    {

    }

    public static OrderDaoImpl getInstance()
    {
        return orderDao;
    }

    public void save(Order order) {
        Connection conn = daoHelper.getConnection();
        PreparedStatement stmt = null  ;
        try
        {
            stmt=conn.prepareStatement("insert into orders (customerid,dessertid,number,totalprice,ordertime,status,shop) values(?,?,?,?,?,?,?)");
            stmt.setString(1,order.getCustomerid());
            stmt.setInt(2,order.getDessertid());
            stmt.setInt(3, order.getNumber());
            stmt.setDouble(4, order.getTotalprice());
            stmt.setDate(5, order.getOrdertime());

            stmt.setInt(6, 0);
            stmt.setString(7,order.getShop());

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

    public ArrayList<Order> getByCustomer(String cid){
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        ResultSet result=null;
        ArrayList<Order> orList = new ArrayList<Order>();

        try
        {
            stmt=con.prepareStatement("select * from orders where customerid = ?");
            stmt.setString(1,cid);
            result=stmt.executeQuery();
            while(result.next())
            {
                Order order = new Order();
                order.setId(result.getInt(1));
                order.setCustomerid(result.getString(2));
                order.setDessertid(result.getInt(3)) ;
                order.setNumber(result.getInt(4));
                order.setTotalprice(result.getDouble(5));
                order.setOrdertime(result.getDate(6));
                order.setSendtime(result.getDate(7));
                order.setStatus(result.getInt(8));
                orList.add(order);

            }
            return orList;
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

    public ArrayList<Order> getByShop(String shop){
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        ResultSet result=null;
        ArrayList<Order> orList = new ArrayList<Order>();

        try
        {
            stmt=con.prepareStatement("select * from orders where shop = ?");
            stmt.setString(1,shop);
            result=stmt.executeQuery();
            while(result.next())
            {
                Order order = new Order();
                order.setId(result.getInt(1));
                order.setCustomerid(result.getString(2));
                order.setDessertid(result.getInt(3)) ;
                order.setNumber(result.getInt(4));
                order.setTotalprice(result.getDouble(5));
                order.setOrdertime(result.getDate(6));
                order.setSendtime(result.getDate(7));
                order.setStatus(result.getInt(8));
                orList.add(order);

            }
            return orList;
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

    public ArrayList<Order> getAll(){
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        ResultSet result=null;
        ArrayList<Order> orList = new ArrayList<Order>();

        try
        {
            stmt=con.prepareStatement("select * from orders ");
            result=stmt.executeQuery();
            while(result.next())
            {
                Order order = new Order();
                order.setId(result.getInt(1));
                order.setCustomerid(result.getString(2));
                order.setDessertid(result.getInt(3)) ;
                order.setNumber(result.getInt(4));
                order.setTotalprice(result.getDouble(5));
                order.setOrdertime(result.getDate(6));
                order.setSendtime(result.getDate(7));
                order.setStatus(result.getInt(8));
                order.setShop(result.getString(9));
                orList.add(order);

            }
            return orList;
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

    public int getBig(){

        Connection con = daoHelper.getConnection();
        PreparedStatement stmt = null  ;
        ResultSet result = null;
        try
        {
            stmt=con.prepareStatement("select dessertid,count(dessertid) as num from orders order by num ");

            result=stmt.executeQuery();
            if(result.next())
            {
                int id =   result.getInt(1);

                return id;
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
        return 1;

    }


    public Order find(String column, String value) {
        Connection con = daoHelper.getConnection();
        PreparedStatement stmt = null  ;
        ResultSet result = null;
        try
        {
            stmt=con.prepareStatement("select * from orders where "+column+"=?");
            stmt.setString(1,value);
            result=stmt.executeQuery();
            if(result.next())
            {
                Order order=new Order();
                order.setId(result.getInt(1));
                order.setCustomerid(result.getString(2));
                order.setDessertid(result.getInt(3));
                order.setNumber(result.getInt(4));
                order.setTotalprice(result.getDouble(5));
                order.setOrdertime(result.getDate(6));
                order.setSendtime(result.getDate(7));
                order.setStatus(result.getInt(8));
                return order;
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

    public void readySell(int id){
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        try
        {
            stmt=con.prepareStatement("update orders set sendtime=?,status=? where id=?");
            stmt.setInt(3, id);
            java.util.Date date = new java.util.Date();
            java.sql.Date senddate = new java.sql.Date(date.getTime());
            stmt.setDate(1,senddate);
            stmt.setInt(2,1);
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

    public void updateByOrderid(Order order) {
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        try
        {
            stmt=con.prepareStatement("update orders set customerid=?,dessertid=?,number=?,totalprice=?,ordertime=?,sendtime=?,status=? where id=?");
            stmt.setInt(8,order.getId());
            stmt.setString(1,order.getCustomerid());
            stmt.setInt(2,order.getDessertid());
            stmt.setInt(3, order.getNumber());
            stmt.setDouble(4, order.getTotalprice());
            stmt.setDate(5, order.getOrdertime());
            stmt.setDate(6,order.getSendtime());
            if(order.getSendtime()!=null){
                stmt.setInt(7,2);
            }else if(order.getOrdertime()!=null){
                stmt.setInt(7,1);
            }else{
                stmt.setInt(7,0);
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
}
