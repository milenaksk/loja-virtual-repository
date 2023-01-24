import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection recuperarConexao() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/loja_virtual?serverTimezone=Brazil/East", "root", "root");
    }
}
