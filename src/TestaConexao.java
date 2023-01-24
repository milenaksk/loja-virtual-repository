import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {

        System.out.println("Estabelecendo conexão com banco de dados...");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja_virtual?serverTimezone=Brazil/East", "root", "root");


        System.out.println("Encerrando conexão");
        conn.close();
        System.out.println("Conexão encerrada");

    }
}
