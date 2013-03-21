package servlets;

import factory.DaoFactory;
import model.Dessert;

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
 * Date: 3/14/13
 * Time: 10:30 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/OrderDes")
public class OrderDes extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dessertId = request.getParameter("dessertId");

        int id = Integer.parseInt(dessertId);


        Dessert dessert = new DaoFactory().getDessertDao().find("id", id);
        String address;


        address = "/ShoppingCart.jsp";

        HttpSession session = request.getSession(true);
        session.setAttribute("desId",dessert.getId());
        session.setAttribute("desName",dessert.getName());
        session.setAttribute("desPrice",dessert.getPrice());
        session.setAttribute("desNumber",dessert.getNumber());
        session.setAttribute("desHref",dessert.getHref());

        System.out.println(dessert.getHref());



        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(address);
        dispatcher.forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
