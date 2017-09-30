package Servlet;

import RelatedObjects.Librarian;
import RelatedObjects.LibraryManagementSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddReaderServlet")
public class AddReaderServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String ar_id = request.getParameter("ar_id");
        String ar_name = request.getParameter("ar_name");
        String ar_pw = request.getParameter("ar_pw");
        String ar_email = request.getParameter("ar_email");
        String ar_tel = request.getParameter("ar_tel");
        String ar_type = request.getParameter("ar_type");
        String ar_state = request.getParameter("ar_state");

        LibraryManagementSystem library = LibraryManagementSystem.getInstance();
        Librarian librarian = library.getCurrent_librarian();
        String message = "";
        try
        {
            boolean result = librarian.addReader(ar_id,ar_name,ar_type,ar_pw,ar_state,ar_email,ar_tel,0);
            if (result == true)
            {
                message = "Successfully adding a Reader!";
            }
            else
            {
                message = "Fail to add a Reader......";
            }
            request.setAttribute("message",message);
            request.getRequestDispatcher("librarian_message.jsp").forward(request,response);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
