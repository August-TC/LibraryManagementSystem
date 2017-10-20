package Database;

import RelatedObjects.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

    public ArrayList<Reader> getReaders(Connection connection, String kw) throws SQLException
    {
        ArrayList<Reader> list = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM reader WHERE reader_id like '%"+kw+"%' or reader_name like '%"+kw+"%' or reader_email like '%"+kw+"%' or reader_name like '%"+kw+"%'");
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
                    list.add(teacher);
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
                    list.add(student);
                    break;
            }
        }
        resultSet.close();
        statement.close();
        return list;
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
                    resultSet.getString("book_copy"),
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
        PreparedStatement statement = connection.prepareStatement("INSERT INTO books (book_copy,book_name,book_author,book_introduction,book_location,book_publish,book_state) VALUES(?,?,?,?,?,?,?)");
        System.out.println(book.getBook_copy());
        statement.setString(1,book.getBook_copy());
        statement.setString(2,book.getBook_name());
        statement.setString(3,book.getBook_author());
        statement.setString(4,book.getBook_introduction());
        statement.setString(5,book.getBook_location());
        statement.setString(6,book.getBook_publish());
        statement.setString(7,book.getBook_state());
        //statement.setString(8,book.getBook_id());
        int count = statement.executeUpdate();
        return count == 1;
    }
    /*******预定书籍*****/
    public boolean reserveBook(Connection connection, int reader_id, String reader_type, String book_copy) throws SQLException {
        Statement statement = connection.createStatement();
        Boolean flag = false;
        String sql = "SELECT COUNT(book_id) FROM reserve_books WHERE user_id = " + reader_id + "AND state = 1";//sql查询用户已预定书的数量
        String sql2 = "SELECT book_id FROM books WHERE book_copy = " + book_copy + "AND book_state = 'Available'";
        ResultSet resultSet = statement.executeQuery(sql);
        /*****不同读者的限制***/
        while(resultSet.next()) {
            switch (reader_type) {
                case "Teacher":
                    if (resultSet.getInt(0) < 15) {
                        flag = true;
                    } else {
                        System.out.println("预定书达到限额");
                    }
                    break;
                case "Student":
                    if (resultSet.getInt(0) < 10) {
                        flag = true;
                    } else {
                        System.out.println("预定书达到限额");
                    }
                    break;
            }
        }
        resultSet.close();
        statement.close();

        if (flag) {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql2);
            if (resultSet.first()) {
                String book_id = resultSet.getString(0);
                Date now = new Date();
                String insertSql = "INSERT INTO reserve_books VALUES("+reader_id + ", "+book_id + ", "+ now.toString() + ", 1"+")";
                String updateSql = "UPDATE books SET book_state = Reserved WHERE book_id = " + book_id;
                statement.executeUpdate(insertSql);
                statement.executeUpdate(updateSql);
            } else {
                System.out.println("本书已被预约完或借空");
            }
            resultSet.close();
            statement.close();
        }
        return true;
    }

    /*******取消预定书籍*****/
    public boolean cancelReverse(Connection connection, int reader_id, String book_id)throws SQLException
    {
        Statement statement = connection.createStatement();
        String updateSql = "UPDATE reverse_books SET state = 0 WHERE user_id = " + reader_id +"AND book_id = "+ book_id + "AND state = 1";
        statement.executeUpdate(updateSql);
        String sql = "UPDATE books SET book_state = Available WHERE book_id = " + book_id;
        statement.executeUpdate(sql);
        System.out.println("取消预约成功");
        statement.close();
        return true;
    }

    /*******借书*****/
    public boolean borrowBook(Connection connection, int reader_id, String reader_type, String book_id) throws SQLException
    {
        /*********判断读者是否有欠款*******/
        float reader_fine = 0;
        boolean bool_alike = false;
        Statement check_statement = connection.createStatement();
        String check_sql = "SELECT reader_fine FROM reader WHERE reader_id=" + reader_id;
        ResultSet check = check_statement.executeQuery(check_sql);
        while(check.next()){
            reader_fine = check.getFloat("reader_fine");
        }
        /*********判断是否结果相同的书*******/
        Statement alike_check = connection.createStatement();
        String alike_sql = "select * from borrow_books where book_id in (select book_id from books where book_copy = (SELECT book_copy from books where book_id = " + book_id + ")) and user_id = " + reader_id;
        ResultSet alike = alike_check.executeQuery(alike_sql);
        if(alike.next()){
            bool_alike = true;
        }
        /******************/
        if(reader_fine==0 && bool_alike==false){
            Statement statement = connection.createStatement();
            String sql = "SELECT COUNT(user_id) FROM borrow_books WHERE reader_id = " + reader_id + "AND borrow_state = 1";//sql鏌ヨ鐢ㄦ埛宸插�熶功鐨勬暟閲�
            ResultSet resultSet = statement.executeQuery(sql);
            /*****涓嶅悓璇昏�呯殑闄愬埗***/
            while(resultSet.next())
            {
                switch (reader_type) {
                    case "Teacher":
                        if (resultSet.getInt(0) < 15) {
                            Date now = new Date();
                            String insertSql = "INSERT INTO borrow_books VALUES("+reader_id + ", "+book_id + ", "+ now.toString() + ", 1"+")";
                            statement.executeUpdate(insertSql);
                        }else {
                            System.out.println("鍊熶功杈惧埌闄愰");
                        }
                        break;

                    case "Student":
                        if (resultSet.getInt(0) < 10) {
                            Date now = new Date();
                            String insertSql = "INSERT INTO borrow_books VALUES("+reader_id + ", "+book_id + ", "+ now.toString() + ", 1"+")";
                            statement.executeUpdate(insertSql);
                        }else {
                            System.out.println("鍊熶功杈惧埌闄愰");
                        }
                        break;
                }
            }
            resultSet.close();
            statement.close();
            return true;
        }else{
            return false;
        }
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
    
    /********获取用户借的书
     * author fei
     * ******/
    public BorrowedItemList getBorrowedBooks(Connection connection, String reader_id)throws SQLException
    {
    	BorrowedItemList books = BorrowedItemList.getInstance();
    	Statement statement = connection.createStatement();
    	String sql = "SELECT * FROM borrow_books WHERE user_id = '" + reader_id+"'";
    	ResultSet rSet = statement.executeQuery(sql);
    	while (rSet.next()) {
    		int id = Integer.parseInt(rSet.getString("id"));
			BorrowedItem borrowedItem = new BorrowedItem( id, rSet.getString("book_id"), rSet.getString("borrow_date"),rSet.getString("borrow_state"),reader_id);
			books.addBorrowedBook(borrowedItem);
		}
    	return books;
    }
    
    /******获取图书过期目录
     * author fei
     * ***/
    public BorrowedItemList getExpiredBooks(Connection connection, String reader_id)throws SQLException
    {
    	BorrowedItemList books = null;
    	Statement statement = connection.createStatement();
    	String sql = "SELECT * FROM borrow_books WHERE user_id = " + reader_id;
     	ResultSet rSet = statement.executeQuery(sql);
     	while (rSet.next()) {
     		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
     		int id = Integer.parseInt(rSet.getString("id"));
     		try {
 				Date borrow_date = sDateFormat.parse(rSet.getString("borrow_date"));
 				String s = sDateFormat.format(borrow_date);
 				Date now = new Date();
 				Calendar cal = Calendar.getInstance();    
 	            cal.setTime(borrow_date);    
 	            long time1 = cal.getTimeInMillis();                 
 	            cal.setTime(now);    
 	            long time2 = cal.getTimeInMillis();         
 	            long between_days=(time2-time1)/(1000*3600*24);
 	            
 	            if (between_days>=30) {
 	            	BorrowedItem borrowedItem = new BorrowedItem( id, rSet.getString("book_id"), rSet.getString("borrow_date"),rSet.getString("borrow_state"),reader_id);
 	 	 			books.addBorrowedBook(borrowedItem);
				}
 			} catch (ParseException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
    		
 		}
    	return books;
    }
    
    /****获取查询历史
     * author fei
     * ****/
    public InquireList getInquire(Connection connection, String reader_id) throws SQLException
    {
		InquireList inquireList = new InquireList();
		Statement statement = connection.createStatement();
    	String sql = "SELECT * FROM inquire WHERE user_id = " + reader_id;
     	ResultSet rSet = statement.executeQuery(sql);
     	while (rSet.next()) {
			Inquire inquire = new Inquire(reader_id, rSet.getString("content"), rSet.getString("create_time"));
			inquireList.addInquire(inquire);
		}
     	return inquireList;
	}
    /****根据用户喜欢作者获取书籍
     * author xuan
     * @throws SQLException 
     * ***/
    public BookList getBooksByFA(Connection connection,String reader_id) throws SQLException {
    	BookList books = new BookList();
    	Statement statement = connection.createStatement();
    	String sql = "SELECT * FROM borrow_books WHERE user_id = " + reader_id + "favourite_type = \"book_author\"";
     	ResultSet rSet = statement.executeQuery(sql);
     	while (rSet.next()) 
     	{
     		Statement statement2 = connection.createStatement();
     		String author = rSet.getString("content");
     		String booksql = "SELECT * FROM books WHERE book_author = " + author;
     		ResultSet rSet2 = statement2.executeQuery(booksql);
     		/*while (rSet2.next()) {
    			Book book = new Book(rSet2.getString("book_id"), rSet2.getString("book_name"), rSet2.getString("book_author"), rSet2.getString("book_introduction"), rSet2.getString("book_location"), rSet2.getString("book_publish"), rSet2.getString("book_state"));
    			books.addBook(book);
			}*/
 		}
    	return books;
	}
    /****根据分类获取书籍
     * author xuan
     * @throws SQLException 
     * ***/
    public BookList getBooksByType(Connection connection,String tag_id) throws SQLException {
    	BookList books = new BookList();
    	Statement statement = connection.createStatement();
    	String sql = "SELECT * FROM book_tag WHERE tag_id=" + tag_id;
     	ResultSet rSet = statement.executeQuery(sql);
     	while (rSet.next()) 
     	{
     		Statement statement2 = connection.createStatement();
     		String book_id = rSet.getString("book_id");
     		String booksql = "SELECT * FROM books WHERE book_id = " + book_id;
     		ResultSet rSet2 = statement2.executeQuery(booksql);
     		/*while (rSet2.next()) {
    			Book book = new Book(rSet2.getString("book_id"), rSet2.getString("book_name"), rSet2.getString("book_author"), rSet2.getString("book_introduction"), rSet2.getString("book_location"), rSet2.getString("book_publish"), rSet2.getString("book_state"));
    			books.addBook(book);
			}*/
 		}
    	return books;
	}
}
