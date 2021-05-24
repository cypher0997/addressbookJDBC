package Dao;
import java.sql.Connection;
import java.sql.SQLException;


public interface AddressBookDbInterface{
    public void update(Connection conTake) throws SQLException;
    public String empCheckWithId(Connection conTake) throws SQLException;
    public int empCheckcity(Connection conTake) throws SQLException;
    public void addContactAndAddressBookTypeName() throws SQLException;
    public int getLastEntry() throws SQLException;
}
