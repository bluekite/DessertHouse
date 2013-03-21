package servlets;

import factory.DaoFactory;
import model.Customer;
import model.Order;
import sun.org.mozilla.javascript.internal.regexp.SubString;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Kite
 * Date: 13-3-8
 * Time: 下午9:10
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/Login")
public class Login extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userid = request.getParameter("userid");
        String passwd = request.getParameter("passwd");
        Customer customer = new DaoFactory().getCustomerDao().find("userid",userid);

        HttpSession session = request.getSession(true);
        session.setAttribute("curcus",customer);
        java.util.Date date = new java.util.Date();
        java.sql.Date today = new java.sql.Date(date.getTime());
        long did =(today.getTime())-( customer.getBirthday().getTime()  );
        if(did/1000000>(long)31536){
            new DaoFactory().getCustomerDao().stop(customer);
        }
        customer = new DaoFactory().getCustomerDao().find("userid",userid);
        session.setAttribute("due",did);

        String address;

        if(customer == null||!customer.getPasswd().equals(passwd)){
            //response.sendRedirect("/a.jsp")
            address = "/unknown.jsp";
        }else{
            address = "/index.jsp";

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

            ArrayList<Order> orlist = new DaoFactory().getOrderDao().getByCustomer(userid);
            session.setAttribute("orders",orlist);

        }


        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(address);
        dispatcher.forward(request,response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
