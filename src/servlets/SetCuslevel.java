package servlets;

import factory.DaoFactory;
import model.Customer;

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
 * Date: 3/20/13
 * Time: 8:22 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/SetCuslevel")
public class SetCuslevel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String cusid = request.getParameter("cusid");
        int level = Integer.parseInt(request.getParameter("level"));
        new DaoFactory().getCustomerDao().levelByUserid(cusid,level);
        System.out.println(cusid+"   -.-   "+level);

        ArrayList<Customer> clist = new DaoFactory().getCustomerDao().getAll();
        session.setAttribute("customers",clist);

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/manage/admin/SetCustomer.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
