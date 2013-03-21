package model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 3/19/13
 * Time: 12:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class Workshop implements Serializable {
    private int id;
    private String name;

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
}
