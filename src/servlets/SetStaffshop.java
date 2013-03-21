package servlets;

import factory.DaoFactory;
import model.Staff;

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
@WebServlet("/SetStaffshop")
public class SetStaffshop extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String stid = request.getParameter("stid");
        String shop = request.getParameter("shop");
        new DaoFactory().getStaffDao().shopByUserid(stid,shop);


        ArrayList<Staff> slist = new DaoFactory().getStaffDao().getAll();
        session.setAttribute("staffs",slist);

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/manage/admin/SetStaff.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
