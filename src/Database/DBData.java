package Database;

import RelatedObjects.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class DBData
{
    private static DBData ourInstance = new DBData();

    public static DBData getInstance()
    {
        return ourInstance;
    }

    private DBData()
    {
    }

    private ArrayList<Reader> readers = new ArrayList<>();

    public ArrayList<Reader> getReaders(Connection connection) throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM reader");
        while (resultSet.next())
        {
            switch (resultSet.getString("reader_type"))
            {
                case "Teacher":
                    Reader teacher = new Teacher(
                            resultSet.getString("reader_id"),
                            resultSet.getString("reader_name"),
                            resultSet.getString("reader_password"),
                            resultSet.getString("reader_state"),
                            resultSet.getString("reader_email"),
                            resultSet.getString("reader_mobile"),
                            resultSet.getInt("reader_fine")
                    );
                    readers.add(teacher);
                    break;
                case "Student":
                    Reader student = new Student(
                            resultSet.getString("reader_id"),
                            resultSet.getString("reader_name"),
                            resultSet.getString("reader_password"),
                            resultSet.getString("reader_state"),
                            resultSet.getString("reader_email"),
                            resultSet.getString("reader_mobile"),
                            resultSet.getInt("reader_fine")
                    );
                    readers.add(student);
                    break;
            }
        }
        resultSet.close();
        statement.close();
        return readers;
    }

    public Librarian getLibrarianByID(Connection connection, String id) throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM reader WHERE reader_id="+id);
        Librarian librarian = null;
        if (resultSet.next() && resultSet.getString("reader_type").equals("Librarian"))
        {
            System.out.println("TYPE: "+resultSet.getString("reader_type"));
            librarian = new Librarian(
                    resultSet.getString("reader_id"),
                    resultSet.getString("reader_name"),
                    resultSet.getString("reader_password"),
                    resultSet.getString("reader_email"),
                    resultSet.getString("reader_mobile"));
            resultSet.close();
            statement.close();
            return librarian;
        }
        else
        {
            resultSet.close();
            statement.close();
            return null;
        }
    }

    public Reader getReaderByID(Connection connection, String id) throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM reader WHERE reader_id="+id);
        Reader reader = null;
        while (resultSet.next())
        {
            switch (resultSet.getString("reader_type"))
            {
                case "Teacher":
                    reader = new Teacher(
                            resultSet.getString("reader_id"),
                            resultSet.getString("reader_name"),
                            resultSet.getString("reader_password"),
                            resultSet.getString("reader_state"),
                            resultSet.getString("reader_email"),
                            resultSet.getString("reader_mobile"),
                            resultSet.getInt("reader_fine")
                    );
                    break;
                case "Student":
                    reader = new Student(
                            resultSet.getString("reader_id"),
                            resultSet.getString("reader_name"),
                            resultSet.getString("reader_password"),
                            resultSet.getString("reader_state"),
                            resultSet.getString("reader_email"),
                            resultSet.getString("reader_mobile"),
                            resultSet.getInt("reader_fine")
                    );
                    break;
            }
        }
        resultSet.close();
        statement.close();
        return reader;
    }

    public Book getBookByID(Connection connection, String id) throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books WHERE book_id='"+id+"'");
        Book book = null;
        while (resultSet.next())
        {
            book = new Book(
                    resultSet.getString("book_id"),
                    resultSet.getString("book_name"),
                    resultSet.getString("book_author"),
                    resultSet.getString("book_introduction"),
                    resultSet.getString("book_location"),
                    resultSet.getString("book_publish"),
                    resultSet.getString("book_state")
            );
        }
        return book;
    }
    
    /*
     * 删除特定用户函数
     * @param id 读者的主键，用于找到要被删除的读者
     * @return boolean 当只删除了一个读者时，判断为删除成功，返回true；其余情况返回false。
     */
    public Boolean deleteReader(Connection connection, String id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM reader WHERE reader_id=?");
        statement.setString(1, id);
        int count = statement.executeUpdate();
        return count == 1;
    }
/*
 * 删除特定书籍函数
 * @param id 书籍的主键，用于找到要被删除的书籍
 * @return boolean 当只删除了一个书籍时，判断为删除成功，返回true；其余情况返回false。
 */
  public Boolean deleteBook(Connection connection, String id) throws SQLException {
      PreparedStatement statement = connection.prepareStatement("DELETE FROM books WHERE book_id=?" );
      statement.setString(1, id);
      int count = statement.executeUpdate();
      return count == 1;
  }
  /*
   * 增加特定用户函数
   * @param reader_x Reader的x属性 
   * @return boolean 当只增加了一个读者时，判断为增加成功，返回true；其余情况返回false。
   */
  public Boolean addReader(Connection connection, Reader reader) throws SQLException {
      if(getReaderByID(connection,reader.getReader_id()) != null)
      {
          return false;
      }
	  PreparedStatement statement = connection.prepareStatement("INSERT INTO reader (reader_id,reader_name,reader_type,reader_password,reader_state,reader_email,reader_mobile,reader_fine) VALUES (?,?,?,?,?,?,?,?)");
	  statement.setString(1,reader.getReader_id());
	  statement.setString(2,reader.getReader_name());
	  statement.setString(3,reader.getReader_type());
	  statement.setString(4,reader.getReader_password());
	  statement.setString(5,reader.getReader_state());
	  statement.setString(6,reader.getReader_email());
	  statement.setString(7,reader.getReader_TEL());
	  statement.setInt(8,reader.getReader_fine());
      int count = statement.executeUpdate();
      return count == 1;
  }
 /*
   * 增加特定书籍函数
   * @param book_x book的x属性 
   * @return boolean 当只增加了一个书籍时，判断为增加成功，返回true；其余情况返回false。
   */
  public Boolean addBook(Connection connection, Book book) throws SQLException {
      if (getBookByID(connection,book.getBook_id()) != null)
      {
          return false;
      }
      PreparedStatement statement = connection.prepareStatement("INSERT INTO books (book_id,book_name,book_author,book_introduction,book_location,book_publish,book_state) VALUES(?,?,?,?,?,?,?)");
	  statement.setString(1,book.getBook_id());
	  statement.setString(2,book.getBook_name());
	  statement.setString(3,book.getBook_author());
	  statement.setString(4,book.getBook_introduction());
	  statement.setString(5,book.getBook_location());
	  statement.setString(6,book.getBook_publish());
	  statement.setString(7,book.getBook_state());
      int count = statement.executeUpdate();
	  return count == 1;
  }

    /*******借书*****/
    public boolean borrowBook(Connection connection, int reader_id, String reader_type, String book_id) throws SQLException
    {
        Statement statement = connection.createStatement();
        String sql = "SELECT COUNT(user_id) FROM borrow_books WHERE reader_id = " + reader_id + "AND borrow_state = 1";//sql查询用户已借书的数量
        ResultSet resultSet = statement.executeQuery(sql);
        /*****不同读者的限制***/
        while(resultSet.next())
        {
            switch (reader_type) {
                case "Teacher":
                    if (resultSet.getInt(0) < 15) {
                        Date now = new Date();
                        String insertSql = "INSERT INTO borrow_books VALUES("+reader_id + ", "+book_id + ", "+ now.toString() + ", 1"+")";
                        statement.executeUpdate(insertSql);
                    }else {
                        System.out.println("借书达到限额");
                    }
                    break;

                case "Student":
                    if (resultSet.getInt(0) < 10) {
                        Date now = new Date();
                        String insertSql = "INSERT INTO borrow_books VALUES("+reader_id + ", "+book_id + ", "+ now.toString() + ", 1"+")";
                        statement.executeUpdate(insertSql);
                    }else {
                        System.out.println("借书达到限额");
                    }
                    break;
            }
        }
        resultSet.close();
        statement.close();
        return true;
    }

    /*******还书****/
    public boolean returnBook(Connection connection, int reader_id, String book_id)throws SQLException
    {
        Statement statement = connection.createStatement();
        String updateSql = "UPDATE borrow_books SET borrow_state = 0 WHERE reader_id = " + reader_id +"AND book_id = "+ book_id + "AND borrow_state = 1";
        statement.executeUpdate(updateSql);
        System.out.println("还书成功");
        statement.close();
        return true;
    }
}
