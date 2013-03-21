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
 * Date: 3/20/13
 * Time: 1:09 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/AlterCustomer")
public class AlterCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession(true);
        String userid=(String)session.getAttribute("loginid");
        Customer customer1 =  new DaoFactory().getCustomerDao().find("userid",userid);
        String name = request.getParameter("name");
        String password = request.getParameter("passwd");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        customer1.setName(name);
        customer1.setGender(gender);
        customer1.setAddress(address);
        customer1.setPasswd(password);

        new DaoFactory().getCustomerDao().updateByUserid(customer1);
        Customer customer2 =  new DaoFactory().getCustomerDao().find("userid",userid);
        session.setAttribute("login",customer2.getName());
        session.setAttribute("cugender",customer2.getGender());
        session.setAttribute("cuaddress",customer2.getAddress());
        session.setAttribute("cupasswd",customer2.getPasswd());


        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/customer/PIM.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
