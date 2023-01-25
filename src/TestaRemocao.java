import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > 2");
        stm.setInt(1, 2);
        stm.execute();

        int linhasModificadas = stm.getUpdateCount();

        System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);

    }
}
