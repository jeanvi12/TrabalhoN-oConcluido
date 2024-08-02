import java.sql.*;

public class Produtos {
    ////////////(creo que aqui va un link)
    private Connection connection;

    public void createTable() {
        try (Statement statement = BancoDeDados.connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Produto (Nome do produto VARCHAR, Valor VARCHAR, Quantidade VARCHAR)");
            //Insira seu código aqui(promto)
            BancoDeDados.connection.commit();
            System.out.println("Tabela criada ou já existe.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
    public void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão fechada.");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

    public void inserirProdutos(String nomeProduto,float valorProduto,int quantidadeProduto) {
        try (PreparedStatement insertStatement = BancoDeDados.connection.prepareStatement("INSERT INTO Produto (Nome) VALUES (?),(Valor) VALUES (?), (Quantidade) VALUES (?) ")) {

            insertStatement.setString(1, nomeProduto);
            insertStatement.setFloat(2, valorProduto);
            insertStatement.setInt(3, quantidadeProduto);
            insertStatement.executeUpdate();
            BancoDeDados.connection.commit();
            System.out.println("Nome do produto, valor e a quantidade foram inseridos com sucesso!.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    public void lerProduto(String nomeProduto, String nomeQuery) {
        try (PreparedStatement selectStatement = BancoDeDados.connection.prepareStatement("INSERT INTO Produto (Nome) VALUES (?)" "SELECT * FROM Produto WHERE Nome = ?")) {
            //Insira seu código aqui
            ResultSet resultSet = selectStatement.executeQuery();
            System.out.println("Produtos:");
            while (resultSet.next()) {
                insertStatement.setString(1, nomeProduto);
                String nomeProduto = resultSet.getString("Nome");
                float valorProduto = resultSet.getFloat("Valor");
                int quantidadeProduto = resultSet.getInt("Quantidade");

                System.out.println("Nome: " + nomeProduto + ", Valor: " + valorProduto+", Quantidade"+quantidadeProduto);
            }


        } catch (SQLException e) {
            System.out.println("Erro ao consultar produto: " + e.getMessage());
        }
    }

    public void deleteProduto(String nomeProduto) {
        try (PreparedStatement deleteStatement = BancoDeDados.connection.prepareStatement("DELETE FROM Produto WHERE Nome = ?")) {
            //Insira seu código aqui(pronto)
            deleteStatement.setString(1, nomeProduto);
            deleteStatement.executeUpdate();
            BancoDeDados.connection.commit();
            System.out.println("Produto deletado.");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar produtos: " + e.getMessage());
        }
    }
}
