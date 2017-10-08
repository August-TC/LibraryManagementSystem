package Servlet;

import RelatedObjects.LibraryManagementSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "GetPWServlet")
public class GetPWServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        LibraryManagementSystem library = LibraryManagementSystem.getInstance();
        String gpw_email = null;
        String gpw_tel = null;
        try
        {
            gpw_email = library.refindPWByEmail(request.getParameter("pwresetemail"));
            gpw_tel = library.refindPWByTEL(request.getParameter("pwresettel"));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        String message = "";

        if (gpw_email != null && gpw_tel != null)
        {
            message = "Your password has been sent to both your mobile and email. Please check it.";
            System.out.println("From Email: "+gpw_email);
            System.out.println("From TEL: "+gpw_tel);
        }
        else if (gpw_email == null && gpw_tel != null)
        {
            message = "Your password has been sent to your mobile . Please check it.";
            System.out.println("From TEL: "+gpw_tel);
        }
        else if (gpw_email != null && gpw_tel == null)
        {
            message = "Your password has been sent to email. Please check it.";
            System.out.println("From Email: "+gpw_email);
        }
        else if (gpw_email == null && gpw_tel == null)
        {
            message = "You have entered wrong mobile number and email address. Please correct one of them.";
        }

        request.setAttribute("message",message);
        request.getRequestDispatcher("message.jsp").forward(request,response);
    }
}
