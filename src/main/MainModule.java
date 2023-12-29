package main;

import java.sql.Connection;


import menu.Menu;
import util.DBConnection;

public class MainModule {
    public static void main(String[] args) {
    
    	@SuppressWarnings("unused")
		Connection connection=  DBConnection.getConnection();
    	
    	Menu.menu();
       
    }
}