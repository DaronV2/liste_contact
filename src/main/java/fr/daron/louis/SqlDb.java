package fr.daron.louis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlDb {

    static String url = CredentialsBdd.getIpServSql();

    static String user = CredentialsBdd.getUserBdd();

    static String mdp = CredentialsBdd.getMdpUserBdd();

    SqlDb(){

    }

    @SuppressWarnings("exports")
    public static ResultSet execRequetes(String requete) throws SQLException{
        //Connection c = DriverManager.getConnection(CredentialsBdd.getIpServSql(), CredentialsBdd.getUserBdd(), CredentialsBdd.getMdpUserBdd());
        Connection c = DriverManager.getConnection(url,user,mdp);
        PreparedStatement prepare = c.prepareStatement(requete);
        ResultSet res = prepare.executeQuery(); 
        return res;
    }

    @SuppressWarnings("exports")
    public static String execUpdate(String requete) throws SQLException{
        Connection c = DriverManager.getConnection(url,user,mdp);
        PreparedStatement prepare = c.prepareStatement(requete);
        prepare.executeUpdate(); 
        return "Update effectué";
       
        
        
    }
    
}
