package listener;

import model.Customer;

import java.util.Timer;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 3/21/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class timerManager {
    Timer t = null;
    public timerManager(long delay,Customer customer)
    {
        this.time(delay,customer);
    }

    public void time(long delay,Customer customer)
    {
        t= new Timer();
        memberTask mt = new memberTask(customer);
        t.schedule(mt,delay,3000);
    }
    public void destoryTimer()
    {
        t.cancel();
    }
}
