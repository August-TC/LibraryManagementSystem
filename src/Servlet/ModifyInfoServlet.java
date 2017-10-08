package Servlet;

import RelatedObjects.LibraryManagementSystem;
import RelatedObjects.Reader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ModifyInfoServlet")
public class ModifyInfoServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name,email,tel,message = "";
        RequestDispatcher requestDispatcher = null;
        name = request.getParameter("name");
        email = request.getParameter("email");
        tel = request.getParameter("tel");
        Reader reader = LibraryManagementSystem.getInstance().getCrt_reader();
        try
        {
            message = reader.modifyInfo(name,email,tel);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        request.setAttribute("message",message);
        requestDispatcher = request.getRequestDispatcher("message.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }
}
