package Servlet;

import RelatedObjects.LibraryManagementSystem;
import RelatedObjects.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        LibraryManagementSystem library = LibraryManagementSystem.getInstance();
        String register_id = request.getParameter("useridsignup");
        String register_name = request.getParameter("usernamesignup");
        String register_pw = request.getParameter("passwordsignup");
        String register_pw_comfirm = request.getParameter("passwordsignup_confirm");
        String register_tel = request.getParameter("usertelsignup");
        System.out.println(register_tel.length());
        String register_email = request.getParameter("useremailsignup");
        String register_type = request.getParameter("type");

        RequestDispatcher requestDispatcher = null;

        if (register_pw.equals(register_pw_comfirm))
        {
            try
            {
                switch (register_type)
                {
                    case "Student":
                        library.registerStudent(
                                register_id,
                                register_name,
                                register_pw,
                                "Normal",
                                register_email,
                                register_tel
                        );
                        break;
                    case "Teacher":
                        library.registerTeacher(
                                register_id,
                                register_name,
                                register_pw,
                                "Normal",
                                register_email,
                                register_tel
                        );
                        break;
                    case "Librarian":
                        library.registerLibrarian(
                                register_id,
                                register_name,
                                register_pw,
                                "Normal",
                                register_email,
                                register_tel
                        );
                }
                request.setAttribute("message","Succeeded in signning up.");
                requestDispatcher = request.getRequestDispatcher("message.jsp");
                requestDispatcher.forward(request,response);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

        }
        else
        {
            String message = "Two password you just entered is not matched. Please enter the same password.";
            request.setAttribute("message",message);
            requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}
