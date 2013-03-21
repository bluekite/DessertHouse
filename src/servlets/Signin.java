package servlets;

import factory.DaoFactory;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 3/11/13
 * Time: 10:27 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/Signin")
public class Signin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String staffid = request.getParameter("staffid");
        String staffpasswd = request.getParameter("staffpasswd");
        Staff staff = new DaoFactory().getStaffDao().find("workid",staffid);
        HttpSession session = request.getSession(true);

        String address;

        if(staff == null||!staff.getPassword().equals(staffpasswd)){

            address = "/manage/Signin.jsp";
        }else{

            if (staff.getLevel()==0){

                address = "/manage/Administrator.jsp";
            }else if(staff.getLevel()==1){
                address = "/manage/Manager.jsp";
            }else{
                address = "/manage/Personnel.jsp";
            }

            ArrayList<Dessert> delist = new DaoFactory().getDessertDao().getAll();

            session.setAttribute("signin", staff.getName());
            session.setAttribute("signinshop",staff.getWorkshop());
            session.setAttribute("desserts",delist);
            ArrayList<Order> orlist = new DaoFactory().getOrderDao().getByShop(staff.getWorkshop());
            session.setAttribute("orders",orlist);
            ArrayList<Order> olist = new DaoFactory().getOrderDao().getAll();
            session.setAttribute("allorders",olist);
            int big =   new DaoFactory().getOrderDao().getBig();
            session.setAttribute("big",big);
            ArrayList<Workshop> wklist = new DaoFactory().getWorkshopDao().getAll();
            session.setAttribute("workshops",wklist);
            ArrayList<Staff> slist = new DaoFactory().getStaffDao().getAll();
            session.setAttribute("staffs",slist);
            ArrayList<Customer> clist = new DaoFactory().getCustomerDao().getAll();
            session.setAttribute("customers",clist);
        }


        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(address);
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
