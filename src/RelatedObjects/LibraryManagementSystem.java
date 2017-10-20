package RelatedObjects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.*;

public class LibraryManagementSystem
{
    private Reader crt_reader = null;
    private Librarian crt_librarian = null;
    private static LibraryManagementSystem ourInstance = new LibraryManagementSystem();

    public static LibraryManagementSystem getInstance()
    {
        return ourInstance;
    }

    private LibraryManagementSystem()
    {
    }

    public Reader getCrt_reader()
    {
        return crt_reader;
    }

    public Librarian getCrt_librarian()
    {
        return crt_librarian;
    }

    private Librarian current_librarian;
    // [R1-45] Register librarian account
    public void registerLibrarian(String id, String name, String password, String state, String email, String mobile)
    {
        //connect database
        Database database = Database.accessDatabase();
        database.startConnection();
        Connection connection = database.getConnection();
        //Insert
        try
        {
            Statement statement = connection.createStatement();
            statement.executeUpdate( "INSERT INTO reader "
                    + "(reader_id, reader_name, reader_type, reader_password, reader_state, reader_email, reader_mobile,reader_fine) VALUES "
                    + "('" + id + "','" + name + "','Librarian','" + password + "','" + state + "','" + email + "','"
                    + mobile + "','0')" );
            statement.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                connection.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

        }
        //close database


    }

    // [R1-44] Register teacher account
    public void registerTeacher(String id, String name, String password, String state, String email, String mobile) throws SQLException
    {

        Database database = Database.accessDatabase();
        database.startConnection();
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate( "INSERT INTO reader "
                + "(reader_id, reader_name, reader_type, reader_password, reader_state, reader_email, reader_mobile,reader_fine) VALUES "
                + "('" + id + "','" + name + "','Teacher','" + password + "','" + state + "','" + email + "','"
                + mobile + "','0')" );
        statement.close();
        connection.close();
    }

    // [R1-46] Register student account
    public void registerStudent(String id, String name, String password, String state, String email, String mobile) throws SQLException
    {

        Database database = Database.accessDatabase();
        database.startConnection();
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate( "INSERT INTO reader "
                + "(reader_id, reader_name, reader_type, reader_password, reader_state, reader_email, reader_mobile,reader_fine) VALUES "
                + "('" + id + "','" + name + "','Student','" + password + "','" + state + "','" + email + "','"
                + mobile + "','0')" );
        statement.close();
        connection.close();
    }

    // [R1-44] Reader Login
    public boolean readerLogin(String id, String password) throws SQLException
    {

        //DB connection
        Database database = Database.accessDatabase();
        database.startConnection();
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();

        //query
        ResultSet rs = statement.executeQuery("SELECT * FROM reader where reader_id = " + id);

        if (rs.next())
        {
            //if the id is exist
            rs = statement.executeQuery("SELECT * FROM reader where reader_id =" + id);
            while ( rs.next() )
            {
                if ( rs.getString("reader_password").equals(password))
                {
                    //password correct
                    System.out.println(id+"Login Successful");
                    switch (rs.getString("reader_type"))
                    {
                        case "Teacher":
                            Reader teacher = new Teacher(
                                    rs.getString("reader_id"),
                                    rs.getString("reader_name"),
                                    rs.getString("reader_password"),
                                    rs.getString("reader_state"),
                                    rs.getString("reader_email"),
                                    rs.getString("reader_mobile"),
                                    rs.getInt("reader_fine")
                            );
                            crt_reader = teacher;
                            break;
                        case "Student":
                            Reader student = new Student(
                                    rs.getString("reader_id"),
                                    rs.getString("reader_name"),
                                    rs.getString("reader_password"),
                                    rs.getString("reader_state"),
                                    rs.getString("reader_email"),
                                    rs.getString("reader_mobile"),
                                    rs.getInt("reader_fine")
                            );
                            crt_reader = student;
                            break;
                    }
                    rs.close();
                    statement.close();
                    connection.close();
                    return true;
                }
                else
                {
                    //wrong pw
                    System.out.println(id+"input a wrong Password");
                    rs.close();
                    statement.close();
                    connection.close();
                    return false;
                }
            }
        }
        else
        {
            //id doesn't exist
            System.out.println("The ID doesn't exist");
        }
        rs.close();
        statement.close();
        connection.close();
        return false;
    }

    // [R1-00] Librarian Login
    public boolean librarianLogin(String id, String password) throws SQLException
    {

        //DB
        Database database = Database.accessDatabase();
        database.startConnection();
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();

        //query
        ResultSet rs = statement.executeQuery("SELECT * FROM reader where reader_id =" + id);
        if (rs.next())
        {
            //id exist
            rs = statement.executeQuery("SELECT reader_password,reader_type FROM reader where reader_id =" + id);
            while ( rs.next() )
            {
                if ( rs.getString("reader_password").equals(password)&&rs.getString("reader_type").equals("Librarian"))
                {
                    System.out.println("Login Succesful");
                    current_librarian = DBData.getInstance().getLibrarianByID(connection,id);
                    rs.close();
                    statement.close();
                    connection.close();
                    return true;
                }
                else
                {
                    System.out.println("Wrong Password");
                    rs.close();
                    statement.close();
                    connection.close();
                    return false;
                }
            }
        }
        else
        {
            //not exist
            System.out.println("The ID doesn't exist");
        }
        rs.close();
        statement.close();
        connection.close();
        return false;
    }

    // [R1-23] Inquire book by book's name
    public ArrayList<Book> inquireByName(Connection conn,String name)
    {
        Statement stmt = null;
        ArrayList<Book> books = new ArrayList();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT *"
                    + "FROM books "
                    +"WHERE book_name LIKE '%"+name+"%' "
                    +"group by book_copy";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                String string1 = rs.getString("book_id");
                String string2 = rs.getString("book_name");
                String string3 = rs.getString("book_author");
                String string4 = rs.getString("book_introduction");
                String string5 = rs.getString("book_location");
                String string7 = rs.getString("book_state");
                String string6 = rs.getString("book_publish");
                String string8 = rs.getString("book_copy");
                Book book = new Book(string1, string2, string3, string8, string4, string5, string6, string7);
                books.add(book);
                //System.out.println(string1+string2+string3+string4+string5+string6+string7);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return books;
    }

    // [R1-24] Inquire book by book's ISBN
    public ArrayList<Book> inquireByISBN(Connection conn, String id)
    {
        Statement stmt = null;
        ArrayList<Book> books = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT *"
                    + "FROM books "
                    +"WHERE book_copy LIKE '%"+id+"%' group by book_name";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                String string1 = rs.getString("book_id");
                String string2 = rs.getString("book_name");
                String string3 = rs.getString("book_author");
                String string4 = rs.getString("book_introduction");
                String string5 = rs.getString("book_location");
                String string7 = rs.getString("book_state");
                String string6 = rs.getString("book_publish");
                String string8 = rs.getString("book_copy");
                Book book = new Book(string1, string2, string3, string8, string4, string5, string6, string7);
                books.add(book);
                //System.out.println(string1+string2+string3+string4+string5+string6+string7);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return books;
    }

    // [R1-22] Inquire book by book's author
    public ArrayList<Book> inquireByAuthor(Connection conn, String auther)
    {
        Statement stmt = null;
        ArrayList<Book> books = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT *"
                    + "FROM books "
                    +"WHERE book_author LIKE '%"+auther+"%' group by book_name";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                String string1 = rs.getString("book_id");
                String string2 = rs.getString("book_name");
                String string3 = rs.getString("book_author");
                String string4 = rs.getString("book_introduction");
                String string5 = rs.getString("book_location");
                String string7 = rs.getString("book_state");
                String string6 = rs.getString("book_publish");
                String string8 = rs.getString("book_copy");
                Book book = new Book(string1, string2, string3, string8, string4, string5, string6, string7);
                books.add(book);
                //System.out.println(string1+string2+string3+string4+string5+string6+string7);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return books;
    }

    // [R1-25] Inquire book by book's press
    public ArrayList<Book> inquireByPress(Connection conn, String press)
    {
        Statement stmt = null;
        ArrayList<Book> books = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT *"
                    + "FROM books "
                    +"WHERE book_press LIKE '%"+press+"%' group by book_name";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                String string1 = rs.getString("book_id");
                String string2 = rs.getString("book_name");
                String string3 = rs.getString("book_author");
                String string4 = rs.getString("book_introduction");
                String string5 = rs.getString("book_location");
                String string7 = rs.getString("book_state");
                String string6 = rs.getString("book_publish");
                String string8 = rs.getString("book_copy");
                Book book = new Book(string1, string2, string3, string8, string4, string5, string6, string7);
                books.add(book);
                //System.out.println(string1+string2+string3+string4+string5+string6+string7);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return books;
    }

    /*refindPW main
    public String refindPW()
    {
        String choice;
        String password = null;
        Scanner sc = new Scanner(System.in);

        while ( true )
        {
            //choose way
            System.out.println("By phone number or By Email"
                    + "A : By phone number" + "\n"
                    + "B : By Email" + "\n");
            choice = sc.nextLine();
            //Tel
            if (choice.equals("A"))
            {
                try {
                    return refindPWByTEL();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            //Email
            else if (choice.equals("B"))
            {
                try {
                    return refindPWByEmail();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else
            {
                System.out.println("Please Ennter correct choice");
            }
        }
    }*/

    // [R1-41] Refind password by phone number
    public String refindPWByTEL(String Tel) throws SQLException
    {
        String password = null;

        //DB
        Database database = Database.accessDatabase();
        database.startConnection();
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT reader_password FROM reader where reader_mobile = '"+ Tel + "'");
        while ( rs.next())
        {
            password = rs.getString("reader_password");
        }
        rs.close();
        statement.close();
        connection.close();
        return password;
    }

    // [R1-42] Refind password by email A
    public String refindPWByEmail(String email) throws SQLException
    {
        String password = null;

        Database database = Database.accessDatabase();
        database.startConnection();
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT reader_password FROM reader where reader_email = '"+ email + "'");
        while ( rs.next())
        {
            password = rs.getString("reader_password");
        }
        return password;
    }

    // [R1-01] Teacher borrow books
    public void teacherBorrow()
    {

    }

    // [R1-02] Student borrow books
    public void studentBorrow()
    {

    }

    // [R1-49] System check the book's state
    public void checkBookState()
    {

    }

    public void setCrt_reader(Reader crt_reader)
    {
        this.crt_reader = crt_reader;
    }

    public void setCurrent_librarian(Librarian current_librarian)
    {
        this.current_librarian = current_librarian;
    }

    // [R1-18] Teacher retrun books
    public void teacherReturn()
    {

    }

    // [R1-19] Student return books
    public void studentReturn()
    {

    }

    // [R1-19] Readers view the books they borrowed
    public void viewBorrowedBooks()
    {

    }

    public Librarian getCurrent_librarian()
    {
        return current_librarian;
    }
}
