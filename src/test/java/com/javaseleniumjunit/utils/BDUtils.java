package com.javaseleniumjunit.utils;


import java.sql.*;

public class BDUtils {

   public static String status = "Não conectou...";

   public static java.sql.Connection getConexaoMySQL() {
       Connection connection = null;          //atributo do tipo Connection
       try {

           Class.forName("com.mysql.jdbc.Driver");
           String url = "jdbc:mysql://localhost:3306/bugtracker";
           String username = "root";        //nome de um usuário de seu BD
           String password = "root";      //sua senha de acesso
           connection = DriverManager.getConnection(url, username, password);
           return connection;

           //Testa sua conexão//

       } catch (ClassNotFoundException e) {  //Driver não encontrado
           System.out.println("O driver expecificado nao foi encontrado.");
           return null;
       } catch (SQLException e) {
           System.out.println("Nao foi possivel conectar ao Banco de Dados.");
           return null;
       }
   }

    public void DBRunQuery(String query)
    {   Connection cmd = null;          //atributo do tipo Connection
        try {
            Statement stmt = null;
            cmd = getConexaoMySQL();
            stmt = cmd.createStatement();
            stmt.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }  finally{
            try {
                cmd.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void criarProjetoCarga(){

        String query = "select id from mantis_project_table order by id desc limit 1;";
        DBRunQuery(query);
    }


}
