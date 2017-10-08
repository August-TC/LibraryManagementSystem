package Servlet;

import Database.*;
import RelatedObjects.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        LibraryManagementSystem library = LibraryManagementSystem.getInstance();
        String login_id = request.getParameter("user_id");
        String login_pw = request.getParameter("password");
        String[] login_state = request.getParameterValues("state");
        boolean login_result = false;

        String state = "";
        for (int i = 0;login_state!=null && i < login_state.length ; i++)
        {
            state += login_state[i];
        }
        System.out.println(state);

        RequestDispatcher requestDispatcher = null;

        if (state.equals("Librarian"))
        {
            try
            {
                login_result = library.librarianLogin(login_id,login_pw);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            try
            {
                login_result = library.readerLogin(login_id,login_pw);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        if (login_result == true)
        {
            Database database = Database.accessDatabase();
            database.startConnection();
            DBData data = DBData.getInstance();
            try
            {
                if (state.equals("Librarian"))
                {
                    Librarian librarian = data.getLibrarianByID(database.getConnection(),login_id);
                    database.closeConnection();
                    request.setAttribute("librarian",librarian.getLibrarian_name());
                    requestDispatcher = request.getRequestDispatcher("librarian_index.jsp");
                    requestDispatcher.forward(request,response);
                }
                else
                {
                    Reader reader = data.getReaderByID(database.getConnection(),login_id);
                    database.closeConnection();
                    if (reader == null)
                    {
                        request.setAttribute("message","The account may be a librarian account.");
                        requestDispatcher = request.getRequestDispatcher("message.jsp");
                        requestDispatcher.forward(request,response);
                    }
                    request.setAttribute("r_id",reader.getReader_id());
                    request.setAttribute("r_name",reader.getReader_name());
                    request.setAttribute("r_email",reader.getReader_email());
                    request.setAttribute("r_tel",reader.getReader_TEL());
                    request.setAttribute("r_type",reader.getReader_type());
                    request.setAttribute("r_state",reader.getReader_state());
                    request.setAttribute("r_fine",reader.getReader_fine());

                    if (reader instanceof Student)
                    {
                        request.setAttribute("r_max",((Student) reader).getMaxBorrowNum());
                    }
                    else if (reader instanceof Teacher)
                    {
                        request.setAttribute("r_max",((Teacher) reader).getMaxBorrowNum());
                    }
                    else
                    {
                        request.setAttribute("r_max",0);
                    }
                    requestDispatcher = request.getRequestDispatcher("index.jsp");
                    requestDispatcher.forward(request,response);
                }


            } catch (SQLException e)
            {
                e.printStackTrace();
            }

        }
        else
        {
            String message = "Wrong ID or Wrong Password, please check your account.";
            request.setAttribute("message",message);
            requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}
