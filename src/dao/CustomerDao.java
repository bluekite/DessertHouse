package dao;


import model.Customer;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-3-8
 * Time: 下午8:35
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerDao  {

    public void save(Customer customer);
    public Customer find(String column,String value);
    public void updateByUserid(Customer customer);
    public void levelByUserid(String id,int level);
    public void recharge(Customer customer,double money);
    public ArrayList<Customer> getAll();
    public void stop(Customer customer);

}
