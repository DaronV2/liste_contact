package fr.daron.louis;

public class CredentialsBdd{

    CredentialsBdd(){}

    static private String IpServSql = "jdbc:mysql://127.0.0.1/listecontact";

    static public String getIpServSql() {
        return IpServSql;
    }

    static private String userBdd = "exemple";

    static public String getUserBdd() {
        return userBdd;
    }

    static private String mdpUserBdd = "Jesuisl'exemple.";

    static public String getMdpUserBdd() {
        return mdpUserBdd;
    }

    
}