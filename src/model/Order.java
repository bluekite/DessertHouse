package model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 3/19/13
 * Time: 11:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class Order implements Serializable {

    private int id;
    private String customerid;
    private int dessertid;
    private int number;
    private double totalprice;
    private Date ordertime;
    private Date sendtime;
    private int status;
    private String shop;

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public int getDessertid() {
        return dessertid;
    }

    public void setDessertid(int dessertid) {
        this.dessertid = dessertid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
