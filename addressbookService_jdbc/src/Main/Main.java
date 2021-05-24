package Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import Dao.AddressBookDbOperations;
import Util.DataBaseConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataBaseConnection.setConnection();
        Connection con = DataBaseConnection.getConnection();
        AddressBookDbOperations epd = new AddressBookDbOperations();
        System.out.println("enter your choice :"+"\n"+
                            "press 1 for addressbook_table updation"+"\n"+
                            "press 2 for multiple insertion in addressbook_table and other tables associated with it");          
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                epd.update(con);
                break;
            
            case 2:
                ImplementThreads t1=new ImplementThreads();
                ImplementThreads t2=new ImplementThreads();
                t1.start();
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t2.start();
                break;
            
            default:
                break;
        }
        
    }
    
}

class ImplementThreads extends Thread{
    public void run(){  
        AddressBookDbOperations epd = new AddressBookDbOperations();
        try {
            epd.addContactAndAddressBookTypeName();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }  
   }  
