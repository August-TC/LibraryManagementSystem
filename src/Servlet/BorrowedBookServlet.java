package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import RelatedObjects.Librarian;
import RelatedObjects.LibraryManagementSystem;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * author ��
 * �鿴�����
 * ***/

public class BorrowedBookServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       
        String user_id = request.getParameter("user_id");
        /*try
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
        }*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
