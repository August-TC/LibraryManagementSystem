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
        String add_id = request.getParameter("add_id");
        String add_name = request.getParameter("add_name");
        String add_author = request.getParameter("add_author");
        String add_location = request.getParameter("add_location");
        String add_price = request.getParameter("add_price");
        String add_press = request.getParameter("add_press");
        String add_state = request.getParameter("add_state");
        String add_intro = request.getParameter("add_intro");
        String add_tag = request.getParameter("add_tag");

        LibraryManagementSystem library = LibraryManagementSystem.getInstance();
        Librarian librarian = library.getCurrent_librarian();
        String message = "";
        try
        {
            boolean result = librarian.addBook(add_id,add_name,add_author,add_intro,add_location,add_press,add_state);
            if (result == true)
            {
                message = "Successfully adding a book!";
            }
            else
            {
                message = "Fail to add a book......";
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
