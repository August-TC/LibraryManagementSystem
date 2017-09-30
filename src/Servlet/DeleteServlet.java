package Servlet;

import RelatedObjects.LibraryManagementSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String book_delete = request.getParameter("book_delete");
        String reader_delete = request.getParameter("reader_delete");
        System.out.println(book_delete+"\t"+reader_delete);
        LibraryManagementSystem library = LibraryManagementSystem.getInstance();
        Boolean result = false;
        if (book_delete != null)
        {
            try
            {
                result = library.getCurrent_librarian().deleteBook(book_delete);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if (reader_delete != null)
        {
            try
            {
                result = library.getCurrent_librarian().deleteReader(reader_delete);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        if (result == true)
        {
            request.setAttribute("message","Successfully delete!");
            request.getRequestDispatcher("librarian_message.jsp").forward(request,response);
        }
        else
        {
            request.setAttribute("message","Fail to delete!");
            request.getRequestDispatcher("librarian_message.jsp").forward(request,response);
        }
    }
}
