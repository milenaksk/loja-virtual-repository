import java.sql.*;


public class TestaListagem {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja_virtual?serverTimezone=Brazil/East", "root", "root");

        Statement stm = conn.createStatement();
        stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");

        ResultSet rst = stm.getResultSet();

        while (rst.next()) {
            Integer id = rst.getInt("ID");
            System.out.println(id);

            String nome = rst.getString("NOME");
            System.out.println(nome);

            String descricao = rst.getString("DESCRICAO");
            System.out.println(descricao);
        }

        conn.close();
    }
}
