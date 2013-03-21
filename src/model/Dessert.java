package model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-3-8
 * Time: 下午8:36
 * To change this template use File | Settings | File Templates.
 */
public class Dessert implements Serializable {

    private int id;
    private String name;
    private double price;
    private int number;
    private String href;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
