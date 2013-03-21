package servlets;

import factory.DaoFactory;
import model.Order;

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
 * Date: 3/18/13
 * Time: 6:09 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/OrderGen")
public class OrderGen extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        int desid = (Integer) session.getAttribute("desId");
        String customer = (String) session.getAttribute("loginid");
        double price =(Double) session.getAttribute("desPrice");
        int number = (Integer)session.getAttribute("desNumber") ;
        int sellnum = Integer.parseInt( request.getParameter("quantity"));
        double discount = (Double) session.getAttribute("discount");
        String shop = request.getParameter("shop");
        double totalprice =price*(double)sellnum*discount;
        session.setAttribute("totalprice",totalprice);

        Order order = new Order();
        order.setCustomerid(customer);
        order.setDessertid(desid);
        order.setNumber(sellnum);
        order.setTotalprice(totalprice);
        order.setShop(shop);
        java.util.Date date = new java.util.Date();
        java.sql.Date ordertime = new java.sql.Date(date.getTime());
        order.setOrdertime(ordertime);

        new DaoFactory().getOrderDao().save(order);
        new DaoFactory().getDessertDao().sellByDesid(desid,number,sellnum);


        ArrayList<Order> orlist = new DaoFactory().getOrderDao().getByCustomer(customer);
        session.setAttribute("orders",orlist);


        session.removeAttribute("desHref");
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/customer/Orders.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
