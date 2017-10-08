package RelatedObjects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.*;

public class Librarian
{
    private String librarian_id;

    public String getLibrarian_id()
    {
        return librarian_id;
    }

    public void setLibrarian_id(String librarian_id)
    {
        this.librarian_id = librarian_id;
    }

    public String getLibrarian_name()
    {
        return librarian_name;
    }

    public void setLibrarian_name(String librarian_name)
    {
        this.librarian_name = librarian_name;
    }

    public String getLibrarian_email()
    {
        return librarian_email;
    }

    public void setLibrarian_email(String librarian_email)
    {
        this.librarian_email = librarian_email;
    }

    public String getLeader_TEL()
    {
        return leader_TEL;
    }

    public void setLeader_TEL(String leader_TEL)
    {
        this.leader_TEL = leader_TEL;
    }

    private String librarian_name;
    private String librarian_password;
    private String librarian_email;
    private String leader_TEL;

    public Librarian(String librarian_id, String librarian_name, String librarian_password, String librarian_email, String leader_TEL)
    {
        this.librarian_id = librarian_id;
        this.librarian_name = librarian_name;
        this.librarian_password = librarian_password;
        this.librarian_email = librarian_email;
        this.leader_TEL = leader_TEL;
    }

    // [R1-03] Librarian adds books to Library
    /*
     * 澧炲姞涔︽湰
     * @param 涔︽湰鍚勫睘鎬�
     * @return 鎴戣寰楀簲璇ユ敼鎴怋oolean鏉ョ‘瀹氭搷浣滄垚鍔熶簡娌�
     */
    public boolean addBook(String book_id,String book_name,String book_author,String book_introduction,String book_location,String book_publish,String book_state) throws SQLException
    {
    	Database database = Database.accessDatabase();
    	database.startConnection();
    	DBData dbData = DBData.getInstance();
        Book book = new Book(book_id, book_name, book_author, book_introduction, book_location, book_publish, book_state);
    	boolean res = dbData.addBook( database.getConnection(), book);
        database.closeConnection();
        return res;
    }
    /*
     * 澧炲姞璇昏��
     * @param 璇昏�呭悇灞炴��
     */

    // [R1-03] Librarian adds readers to Library
    public boolean addReader(String reader_id, String reader_name, String reader_type, String reader_password, String reader_state, String reader_email, String reader_TEL, int reader_fine) throws SQLException
    {
    	Database database = Database.accessDatabase();
    	database.startConnection();
    	DBData dbData = DBData.getInstance();
        boolean isSucceed;
        if (reader_type.equals("Teacher")) {
            Teacher reader = new Teacher(reader_id, reader_name, reader_password, reader_state, reader_email, reader_TEL, reader_fine);
            isSucceed = dbData.addReader(database.getConnection(), reader);
        } else {
            Student reader = new Student(reader_id, reader_name, reader_password, reader_state, reader_email, reader_TEL, reader_fine);
            isSucceed = dbData.addReader(database.getConnection(), reader);
        }
        database.closeConnection();
        return isSucceed;
    }
    /*
     * 鍒犻櫎涔︽湰
     * @param id 涔︽湰鐨勪富閿�
     */
    // [R1-08] Librarian deletes books to Library
    public boolean deleteBook(String id) throws SQLException
    {
    	Database database = Database.accessDatabase();
    	database.startConnection();
    	DBData dbData = DBData.getInstance();
    	boolean res = dbData.deleteBook(database.getConnection(), id);
    	database.closeConnection();
    	return res;
    }
    /*
     * 鍒犻櫎璇昏��
     * @param id 璇昏�呯殑涓婚敭
     */
    // [R1-14] Librarian deletes readers to Library
    public boolean deleteReader(String id) throws SQLException
    {
    	Database database = Database.accessDatabase();
    	database.startConnection();
    	DBData dbData = DBData.getInstance();
    	boolean res = dbData.deleteReader(database.getConnection(), id);
    	database.closeConnection();
    	return res;
    }
    // [R2-4] Librarian modify borrowing status of books
    public void modifyStatusofBorrowedBooks(String id, String state) throws SQLException
    {
        //DB
        Database database = Database.accessDatabase();
        database.startConnection();
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();

        //SQL
        String sql = "UPDATE reader set reader_state=" + state + "where id =" + id;

        //execute
        statement.executeUpdate(sql);

        //close
        statement.close();
        connection.close();
    }

    // [R2-5] Librarian modify number of books
    public void modifyNumberofBooks(String name, int num) throws SQLException
    {
        //DB
        Database database = Database.accessDatabase();
        database.startConnection();
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();

        //SQL_count
        String sql = "select count(*) from books where name =" + name;

        //execute
        int actualnum = statement.executeUpdate(sql);

        //compare numbers
        if( num > actualnum )
        {
            //add book
            int i = num - actualnum;
            for ( ; i > 0; i-- )
            {
                String book_id = null;
                String book_name = null, book_author = null, book_introduction = null, book_location = null, book_publish = null, book_state = null;
                addBook(book_id, book_name, book_author, book_introduction, book_location, book_publish, book_state);
            }
        }
        else if ( num < actualnum)
        {
            //delete book
            int i = actualnum - num;
            for ( ; i > 0; i-- )
            {
                ResultSet getid;

                //sql
                String get_id = "select book_id form books where name =" + name;

                //ex
                getid = statement.executeQuery(get_id);

                //sql
                String delete = "DELETE from books where id = " + getid;

                //ex
                statement.executeUpdate(delete);
            }

        }

        //execute
        statement.executeUpdate(sql);

        //close
        statement.close();
        connection.close();
    }

    // [R2-7] Librarian modify information of books
    public void modifyInfomationofBooks(String id, String info) throws SQLException
    {
        //DB
        Database database = Database.accessDatabase();
        database.startConnection();
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();

        //SQL
        String sql = "UPDATE books set book_introduction=" + info + "where id =" + id;

        //execute
        statement.executeUpdate(sql);

        //close
        statement.close();
        connection.close();
    }

    // [R2-10] Librarian modify number of books which users can borrow
    public void modifyNumberofBooksUsersCanBorrow(String id, int num) throws SQLException
    {
        //DB
        Database database = Database.accessDatabase();
        database.startConnection();
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();

        //SQL
        String sql = "UPDATE reader set reader_=" + num + "where id =" + id;

        //execute
        statement.executeUpdate(sql);

        //close
        statement.close();
        connection.close();
    }

    // [R2-11] Librarian modify number of books which users have borrowed
    public void modifyNumberofBooksUsersBorrowed(String id, int num) throws SQLException
    {
        //DB
        Database database = Database.accessDatabase();
        database.startConnection();
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();

        //SQL
        String sql = "UPDATE reader set reader_=" + num + "where id =" + id;

        //execute
        statement.executeUpdate(sql);

        //close
        statement.close();
        connection.close();
    }

    // [R2-12] Librarian modify Borrowing times of readers
    public void modifyNumberofUsersBorrowingTimes(String id, int num) throws SQLException
    {
        //DB
        Database database = Database.accessDatabase();
        database.startConnection();
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();

        //SQL
        String sql = "UPDATE reader set reader_=" + num + "where id =" + id;

        //execute
        statement.executeUpdate(sql);

        //close
        statement.close();
        connection.close();
    }

    // [R2-13] Librarian modify password of reader
    public void modifyPasswordofUsers(String id, String password) throws SQLException
    {
        //DB
        Database database = Database.accessDatabase();
        database.startConnection();
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();

        //SQL
        String sql = "UPDATE reader set reader_password=" + password + "where reader_id =" + id;

        //execute
        statement.executeUpdate(sql);

        //close
        statement.close();
        connection.close();
    }
}
