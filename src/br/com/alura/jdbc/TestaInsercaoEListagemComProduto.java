package br.com.alura.jdbc;

import br.com.alura.jdbc.modelo.Produto;
import br.com.alura.jdbc.dao.ProdutoDAO;

import java.util.List;
import java.sql.*;

public class TestaInsercaoEListagemComProduto {
    public static void main(String[] args) throws SQLException {
        Produto comoda = new Produto("Comoda", "Comoda Vertical");
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            ProdutoDAO produtoDao = new ProdutoDAO(connection);
            produtoDao.salvar(comoda);
            List<Produto> listaDeProdutos = produtoDao.listar();
            listaDeProdutos.stream().forEach(lp -> System.out.println(lp));

        }
    }
}
