package dao.impl;

import dao.DaoHelper;
import dao.WorkshopDao;
import model.Workshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 3/20/13
 * Time: 7:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class WorkshopDaoImpl implements WorkshopDao {

    private static WorkshopDaoImpl workshopDao=new WorkshopDaoImpl();
    private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();

    private WorkshopDaoImpl()
    {

    }

    public static WorkshopDaoImpl getInstance()
    {
        return workshopDao;
    }

    public ArrayList<Workshop> getAll(){
        Connection con=daoHelper.getConnection();
        PreparedStatement stmt=null;
        ResultSet result=null;
        ArrayList<Workshop> wkList = new ArrayList<Workshop>();

        try
        {
            stmt=con.prepareStatement("select * from workshop");

            result=stmt.executeQuery();
            while(result.next())
            {
                Workshop workshop = new Workshop();
                workshop.setId(result.getInt(1));
                workshop.setName(result.getString(2));

                wkList.add(workshop);

            }
            return wkList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            daoHelper.closeConnection(con);
            daoHelper.closePreparedStatement(stmt);
            daoHelper.closeResult(result);
        }
        return null;

    }
}
