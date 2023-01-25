import java.sql.*;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        connection.setAutoCommit(false); //controlando o momento do commit da aplicacao

        PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

        try {
            adicionalVariavel("SmartTV", "45 polegadas", stm);
            adicionalVariavel("Radio", "Radio de bateria", stm);

            connection.commit();

            stm.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ROLLBACK EXECUTADO");
            connection.rollback();
        }
    }

    private static void adicionalVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);


        if (nome.equals("Radio")) {
            throw new RuntimeException("Não foi possível adicionar o produto.");
        }


        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();

        while (rst.next()) {
            Integer id = rst.getInt(1);
            System.out.println("O id criado foi: " + id);
        }
    }
}
