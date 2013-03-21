package dao;

import model.Order;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 3/19/13
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */
public interface OrderDao {

    public void save(Order order);
    public Order find(String column,String value);
    public ArrayList<Order> getByCustomer(String cid);
    public void updateByOrderid(Order order);
    public ArrayList<Order> getByShop(String shop);
    public void readySell(int id);
    public ArrayList<Order> getAll();
    public int getBig();

}
