import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        System.out.println("Conectando com banco de dados...");
        Connection connection = connectionFactory.recuperarConexao();

        connection.close();
    }
}
