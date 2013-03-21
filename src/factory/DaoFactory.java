package factory;

import dao.*;
import dao.impl.*;


/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-3-8
 * Time: 下午9:08
 * To change this template use File | Settings | File Templates.
 */
public class DaoFactory {
    public static WorkshopDao getWorkshopDao()
    {
        return WorkshopDaoImpl.getInstance();
    }
    public static OrderDao getOrderDao()
    {
        return OrderDaoImpl.getInstance();
    }
    public static StaffDao getStaffDao()
    {
        return StaffDaoImpl.getInstance();
    }
    public static CustomerDao getCustomerDao()
    {
        return CustomerDaoImpl.getInstance();
    }
    public static DessertDao getDessertDao()
    {

        return DessertDaoImpl.getInstance();
    }
}
