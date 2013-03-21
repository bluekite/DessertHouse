package model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 3/19/13
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class Staff implements Serializable {

    private String workid;
    private String password;
    private String name;
    private int level;
    private String workshop;

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }
}
