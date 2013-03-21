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
 * Date: 3/20/13
 * Time: 5:04 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/EditDes")
public class EditDes extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        int desid = Integer.parseInt(request.getParameter("desid"))  ;
        String desname = request.getParameter("desname");
        double desprice = Double.parseDouble(request.getParameter("desprice"));
        int desnumber = Integer.parseInt(request.getParameter("desnumber"));
        String deshref =  request.getParameter("deshref");

        String function = request.getParameter("function");

        Dessert dessert = new Dessert();
        dessert.setId(desid);
        dessert.setName(desname);
        dessert.setPrice(desprice);
        dessert.setNumber(desnumber);
        dessert.setHref(deshref);



        if(function.equals("edit")){
            new DaoFactory().getDessertDao().updateByDesid(dessert);
        }
        if(function.equals("delete")){
            new DaoFactory().getDessertDao().deleteByDesid(desid);
        }

        ArrayList<Dessert> delist = new DaoFactory().getDessertDao().getAll();
        session.setAttribute("desserts",delist);

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/manage/personnel/desInfo.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request,response);
    }
}
