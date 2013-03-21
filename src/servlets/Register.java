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
import java.sql.Date;


/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 3/10/13
 * Time: 8:25 PM
 * To change this template use File | Settings | File Templates.
 */

@WebServlet("/Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String userid = request.getParameter("userid");
        String passwd = request.getParameter("passwd");
        String name = request.getParameter("name");

        java.util.Date date = new java.util.Date();
        java.sql.Date birthday = new java.sql.Date(date.getTime());
        String gender = request.getParameter("gender");
        System.out.println(gender);
        String address = request.getParameter("address");
        Customer customer = new Customer();
        customer.setUserid(userid);
        customer.setName(name);
        customer.setPasswd(passwd);
        customer.setGender(gender);
        customer.setAddress(address);
        customer.setBirthday(birthday);
        customer.setLevel(0);
        customer.setAccount(0);
        customer.setStatus(0);
        DaoFactory daoFactory = new DaoFactory();
        daoFactory.getCustomerDao().save(customer);


        HttpSession session = request.getSession(true);
        session.setAttribute("login",customer.getName());
        session.setAttribute("loginid",customer.getUserid());
        session.setAttribute("custatus",customer.getStatus());
        session.setAttribute("cupasswd",customer.getPasswd());
        session.setAttribute("cugender",customer.getGender());
        session.setAttribute("cuaccount",customer.getAccount());
        session.setAttribute("cuaddress",customer.getAddress());
        session.setAttribute("culevel",customer.getLevel());
        double discount =  (double)1-(double)customer.getLevel()/(double)10;
        session.setAttribute("discount",discount);

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
