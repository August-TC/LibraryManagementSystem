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

@WebServlet(name = "ModifyPWServlet")
public class ModifyPWServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String old_pw,new_pw,check_pw,message="";
        RequestDispatcher requestDispatcher = null;
        old_pw = (String) request.getParameter("old_passwd");
        new_pw = (String) request.getParameter("new_passwd");
        check_pw = (String) request.getParameter("chk_passwd");
        //System.out.println(old_pw+new_pw+check_pw);
        Reader reader = LibraryManagementSystem.getInstance().getCrt_reader();
        if (reader != null)
        {
            try
            {
                message = reader.modifyPW(old_pw,new_pw,check_pw);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            message = "Please log in your account first.";
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
