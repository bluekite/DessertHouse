package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-3-8
 * Time: 下午8:36
 * To change this template use File | Settings | File Templates.
 */
public class Customer implements Serializable {

    private String userid;
    private String name;
    private String passwd;
    private String gender;
    private String address;
    private Date birthday;
    private double account;
    private int status;
    private int level;

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setIdByDate()
    {
        Calendar datetime=Calendar.getInstance();
        this.userid=datetime.toString();
        System.out.println(this.userid);
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
