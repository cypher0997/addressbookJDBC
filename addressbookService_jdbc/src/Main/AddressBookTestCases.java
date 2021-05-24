package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import Dao.AddressBookDbOperations;
import Model.AddressBookData;
import Util.DataBaseConnection;
import junit.framework.Assert;

public class AddressBookTestCases {
    
    static Connection con;
        
   
    @Test
    @SuppressWarnings( "deprecation" )
    public void connectTest(){
        Assert.assertEquals(true,DataBaseConnection.setConnection()); 
    }

    @Test
    @SuppressWarnings( "deprecation" )
    public void testDbUpdation() throws SQLException{
        AddressBookDbOperations addressBookDbOperations = new AddressBookDbOperations(); 
        DataBaseConnection.setConnection();
        con = DataBaseConnection.getConnection();
        String empName=null;
        try{
            String querryNext = "SELECT first_name FROM addressbook_table where id=10";
            PreparedStatement pst = con.prepareStatement(querryNext);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                AddressBookData emp = new AddressBookData();
                empName = emp.setEmpName(rs.getString("first_name"));
            } 
        }catch(SQLException e){
            e.printStackTrace();
        }
        Assert.assertEquals(empName,addressBookDbOperations.empCheckWithId(con));
    }

    @Test
    @SuppressWarnings( "deprecation" )
    public void testCityCount() throws SQLException{
        AddressBookDbOperations addressBookDbOperations = new AddressBookDbOperations(); 
        DataBaseConnection.setConnection();
        con = DataBaseConnection.getConnection();
        Assert.assertEquals(4,addressBookDbOperations.empCheckcity(con));
    }

    @Test
    @SuppressWarnings( "deprecation" )
    public void testing_for_multipleEntries_in_addressbookTable_whenUsingWithThreads() throws SQLException{
        AddressBookDbOperations addressBookDbOperations = new AddressBookDbOperations(); 
        Assert.assertEquals(16,addressBookDbOperations.getLastEntry());
    }
}
