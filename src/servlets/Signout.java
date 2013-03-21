package servlets;

import javax.servlet.ServletContext;
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
 * Time: 4:18 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/Signout")
public class Signout extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        request.removeAttribute("signin");
        ServletContext context = request.getServletContext();
        response.sendRedirect(context.getContextPath() + "/manage/Signin.jsp");

    }
}
