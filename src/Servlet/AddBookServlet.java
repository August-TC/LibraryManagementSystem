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

@WebServlet(name = "AddBookServlet")
public class AddBookServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String add_copy = request.getParameter("add_id");
        String add_name = request.getParameter("add_name");
        String add_author = request.getParameter("add_author");
        String add_location = request.getParameter("add_location");
        String add_quantity = request.getParameter("add_quantity");
        String add_press = request.getParameter("add_press");
        String add_state = "Available";//request.getParameter("add_state");
        String add_intro = request.getParameter("add_intro");
        //String add_tag = request.getParameter("add_tag");

        int quantity = Integer.parseInt(add_quantity);

        LibraryManagementSystem library = LibraryManagementSystem.getInstance();
        Librarian librarian = library.getCurrent_librarian();
        String message = "";
        try
        {
            boolean result = librarian.addBook(add_copy,add_name,add_author,add_intro,add_location,add_press,add_state,quantity);
            if (result == true)
            {
                message = "Successfully adding a book!";
            }
            else
            {
                message = "Fail to add a book......";
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
            message = "Fail to add a book cause "+e.getMessage();
        }
        finally
        {
            request.setAttribute("message",message);
            request.getRequestDispatcher("librarian_message.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
