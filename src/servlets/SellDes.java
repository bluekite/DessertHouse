package servlets;

import factory.DaoFactory;
import model.Dessert;
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
 * Date: 3/20/13
 * Time: 6:22 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/SellDes")
public class SellDes extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String s= request.getParameter("desid");
        String shop =(String) session.getAttribute("signinshop");
        int desid = Integer.parseInt(s)  ;

        new DaoFactory().getOrderDao().readySell(desid);
        ArrayList<Order> orlist = new DaoFactory().getOrderDao().getByShop(shop);
        session.setAttribute("orders",orlist);

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/manage/personnel/Sell.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
