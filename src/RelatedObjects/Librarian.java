package RelatedObjects;

import java.sql.Connection;
import java.sql.SQLException;

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
     * 增加书本
     * @param 书本各属性
     * @return 我觉得应该改成Boolean来确定操作成功了没
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
     * 增加读者
     * @param 读者各属性
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
     * 删除书本
     * @param id 书本的主键
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
     * 删除读者
     * @param id 读者的主键
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
}
