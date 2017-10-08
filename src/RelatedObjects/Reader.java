package RelatedObjects;

import Database.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Reader
{
    private String reader_id;
    private String reader_name;
    private String reader_type;
    private String reader_password;
    private String reader_state;
    private String reader_email;
    private String reader_TEL;
    private int reader_fine;

    public Reader(String reader_id, String reader_name, String reader_type, String reader_password, String reader_state, String reader_email, String reader_TEL, int reader_fine)
    {
        this.reader_id = reader_id;
        this.reader_name = reader_name;
        this.reader_type = reader_type;
        this.reader_password = reader_password;
        this.reader_state = reader_state;
        this.reader_email = reader_email;
        this.reader_TEL = reader_TEL;
        this.reader_fine = reader_fine;
    }

    public String modifyPW(String old_pw, String new_pw, String check_pw) throws SQLException
    {
        System.out.println(getReader_password());
        if (old_pw == null || new_pw == null || check_pw == null)
        {
            return "You need to enter all the three contents";
        }
        if (old_pw.equals(getReader_password()))
        {
            if (check_pw.equals(new_pw))
            {
                //DB
                Database database = Database.accessDatabase();
                database.startConnection();
                Connection connection = database.getConnection();
                Statement statement = connection.createStatement();

                //SQL
                String sql = "UPDATE reader set reader_password= \'" + new_pw + "\' where reader_id = \'"+ getReader_id()+"\'" ;

                //execute
                statement.executeUpdate(sql);

                //close
                statement.close();
                connection.close();
                setReader_password(new_pw);
                return "Successfully modify the password.";
            }
            else
            {
                return "The password you retyped is not matched with the new password";
            }
        }
        else
        {
            return "The original password you entered is wrong.";
        }
    }

    public String modifyInfo(String name, String email, String tel)throws SQLException
    {
        if (name == null || tel == null)
        {
            return "The name and the tel cannot be empty.";
        }
        //DB
        Database database = Database.accessDatabase();
        database.startConnection();
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement();

        //SQL
        String sql_name = "UPDATE reader set reader_name= \'" + name + "\' where reader_id = \'"+ getReader_id()+"\'" ;
        String sql_email = "UPDATE reader set reader_email= \'" + email + "\' where reader_id = \'"+ getReader_id()+"\'" ;
        String sql_tel = "UPDATE reader set reader_mobile= \'" + tel + "\' where reader_id = \'"+ getReader_id()+"\'" ;

        //execute
        statement.executeUpdate(sql_name);
        statement.executeUpdate(sql_email);
        statement.executeUpdate(sql_tel);

        //close
        statement.close();
        connection.close();
        setReader_name(name);
        setReader_email(email);
        setReader_TEL(tel);
        return "Successfully modify the information.";
    }

    /**
     * The getter and setters of attributes
     */

    public String getReader_id()
    {
        return reader_id;
    }

    public void setReader_id(String reader_id)
    {
        this.reader_id = reader_id;
    }

    public String getReader_name()
    {
        return reader_name;
    }

    public void setReader_name(String reader_name)
    {
        this.reader_name = reader_name;
    }

    public String getReader_password()
    {
        return reader_password;
    }

    public void setReader_password(String reader_password)
    {
        this.reader_password = reader_password;
    }

    public String getReader_state()
    {
        return reader_state;
    }

    public void setReader_state(String reader_state)
    {
        this.reader_state = reader_state;
    }

    public String getReader_email()
    {
        return reader_email;
    }

    public void setReader_email(String reader_email)
    {
        this.reader_email = reader_email;
    }

    public String getReader_TEL()
    {
        return reader_TEL;
    }

    public void setReader_TEL(String reader_TEL)
    {
        this.reader_TEL = reader_TEL;
    }

    public int getReader_fine()
    {
        return reader_fine;
    }

    public void setReader_fine(int reader_fine)
    {
        this.reader_fine = reader_fine;
    }

    public String getReader_type()
    {
        return reader_type;
    }
}
