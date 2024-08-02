import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Funcionarios {

    public void createTable() {
        try (Statement statement = BancoDeDados.connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Funcionario (Nome VARCHAR, telefone VARCHAR, Data de de contratação VARCHAR)");
        //Insira seu código aqui
            BancoDeDados.connection.commit();
            System.out.println("Tabela criada ou já existe.");

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void inserirFuncionario(List<String[]> lista) {
        try (PreparedStatement insertStatement = BancoDeDados.connection.prepareStatement("INSERT INTO Funcionario (Nome, Telefone, contratacao) VALUES(?, ?, ?)")) {
                //Insira seu código aqui
            for (String[] s : lista) {
                insertStatement.setString(1, s[0]);
                insertStatement.setInt(2, Integer.parseInt(s[1]));
                insertStatement.setString(1, s[0]);

                insertStatement.executeUpdate();
            }
            BancoDeDados.connection.commit();
            System.out.println("Clientes inseridos.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Funcionario: " + e.getMessage());
        }
    }

    public void lerFuncionario(String nomeQuery) {
        try (PreparedStatement selectStatement = BancoDeDados.connection.prepareStatement("SELECT * FROM Funcionario... //Insira seu código aqui ")) {

            //Insira seu código aqui

        } catch (SQLException e) {
            System.out.println("Erro ao consultar Funcionario: " + e.getMessage());
        }
    }

    public void deleteFuncionario(String nome) {
        try (PreparedStatement deleteStatement = BancoDeDados.connection.prepareStatement("DELETE FROM Funcionario... //Insira seu código aqui")) {

            //Insira seu código aqui

        } catch (SQLException e) {
            System.out.println("Erro ao deletar Funcionario: " + e.getMessage());
        }
    }
}
