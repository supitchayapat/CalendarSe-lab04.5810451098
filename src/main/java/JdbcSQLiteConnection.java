/**
 * Created by 708 on 9/1/2017.
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
public class JdbcSQLiteConnection {


    public ObservableList loadDB(){
        ObservableList<Dbshow> data = FXCollections.observableArrayList();
        try{
            //setup
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:bookstore.db";
            Connection conn = DriverManager.getConnection(dbURL);
            if(conn != null){
                System.out.println("Connected to the database....");
                // display database information
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                //execute SQL statements
                System.out.println("----- Data in Book table -----");
                String query = "select * from calendardb";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    String date = resultSet.getString(1);
                    String topic = resultSet.getString(2);
                    String main = resultSet.getString(3);
                    int id = resultSet.getInt( 4 );
                    data.add(new Calendar( date, topic, main, id ));
                }
                //close connection
                conn.close();
            }
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return data;
    }

    public void saveDB(String dateString, String topic, String main, int id){
        try{
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:bookstore.db";
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null){
                String query = "insert into calendardb(Date, Topic, main, ID) values (\'" +dateString+ "\' ,\'" +topic+ "\' ,\'" +main+ "\' ,\'" +id+ "')";
                PreparedStatement p = connection.prepareStatement(query);
                p.executeUpdate();
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void editDB(int id, String dateString, String textTopic, String textmain){
//        try{
//            Class.forName("org.sqlite.JDBC");
//            String dbURL = "jdbc:sqlite:bookstore.db";
//            Connection connection = DriverManager.getConnection(dbURL);
//            if (connection != null){
//                String query = "update event set Date=\'" +dateString+ "\' ,Topic=\'" +textTopic+ "\' ,main=\'" +textmain+ "\' where ID == \'" +id+ "\'";
//                PreparedStatement p = connection.prepareStatement(query);
//                p.executeUpdate();
//                connection.close();
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void deleteDB(int id){
        try{
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:bookstore.db";
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null){
                String query = "Delete from calendardb where ID == \'" +id+ "\'";
                PreparedStatement p = connection.prepareStatement(query);
                p.executeUpdate();
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCreateID(){
        try{
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:bookstore.db";
            Connection connection = DriverManager.getConnection(dbURL);
            if (connection != null){
                String query = "Select max(id) from calendardb";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                int minID = resultSet.getInt(1);
                connection.close();
                return  minID+1;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    }

