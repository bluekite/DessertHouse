package listener;

import factory.DaoFactory;
import model.Customer;

import javax.servlet.http.HttpSession;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 3/21/13
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class memberTask extends TimerTask {

    public static long runTime = 1;

    private  java.sql.Date cday;
    Customer ccustomer;

    public memberTask(Customer customer){

        ccustomer = customer;
    }

    public void run() {
        Timer t = new Timer();
        if(runTime>=100)
            runTime = 0;
        System.out.println("  ");


        java.util.Date date = new java.util.Date();
        java.sql.Date today = new java.sql.Date(date.getTime());
        long did =(today.getTime())-( ccustomer.getBirthday().getTime()  );
        if(did/1000000>(long)31536){
            new DaoFactory().getCustomerDao().stop(ccustomer);
        }

    }
}
