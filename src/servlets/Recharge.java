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

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 3/19/13
 * Time: 11:01 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/Recharge")
public class Recharge extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String userid=(String)session.getAttribute("loginid");
        Customer customer1 =  new DaoFactory().getCustomerDao().find("userid",userid);
        String smoney = request.getParameter("money");
        double money = Double.parseDouble(smoney);
        new DaoFactory().getCustomerDao().recharge(customer1,money);
        Customer customer2 = new DaoFactory().getCustomerDao().find("userid",userid);
        session.setAttribute("custatus",customer2.getStatus());
        session.setAttribute("cuaccount",customer2.getAccount());

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/customer/Recharge.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
