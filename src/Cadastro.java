import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    String nomeProduto;
    float valorProduto;
    int quantidadeProduto;
    Scanner scanner = new Scanner(System.in);
    BancoDeDados bancoDeDados = new BancoDeDados();
    Produtos produtos = new Produtos();
    Funcionarios funcionarios = new Funcionarios();


    void adicionarProduto(){
        bancoDeDados.connect();
        produtos.createTable();
        //Insira seu código aqui(Pronto)
        System.out.println("Digite o nome do produto a ser adicionado: ");
        this.nomeProduto = scanner.nextLine();
        System.out.println("Digite o valor desse produto: ");
        this.valorProduto = scanner.nextFloat();
        System.out.println("Digite a quantidade do produto a ser adicionado: ");
        this.quantidadeProduto = scanner.nextInt();
        produtos.inserirProdutos(nomeProduto, valorProduto, quantidadeProduto);
        produtos.close();

        System.out.println("O produto "+ nomeProduto +"com o valor de "+valorProduto+" e quantidade "+quantidadeProduto+" foi registrado com sucesso!" );

        bancoDeDados.close();
    }

    void lerProduto(){
        bancoDeDados.connect();
        //Insira seu código aqui
        System.out.println("Digite o nome do produto : ");
        this.nomeProduto = scanner.nextLine();

        bancoDeDados.close();
    }
    void deletarProduto(){
        bancoDeDados.connect();
        //Insira seu código aqui
        System.out.println("Digite o nome do produto a ser removido: ");
        String produtoDelete = scanner.nextLine();
        if(produtoDelete.equals(nomeProduto)){
            this.nomeProduto = "";
            System.out.println("Produto "+ produtoDelete +" deletado com sucesso!" );
        } else {
            System.out.println("Produto "+ produtoDelete +" não encontrado!" );
        }
        bancoDeDados.close();
    }




    void adicionarFuncionario(){
        List<String[]> lista = new ArrayList<>();
        bancoDeDados.connect();
        funcionarios.createTable();

        //Insira seu código aqui

        bancoDeDados.close();
    }

    void lerFuncionario(){
        bancoDeDados.connect();

        //Insira seu código aqui

        bancoDeDados.close();
    }
    void deletarFuncionário(){
        bancoDeDados.connect();

        //Insira seu código aqui

        bancoDeDados.close();
    }

    void imprimirMenu(){
        System.out.println("Escolha uma opção:");
        System.out.println("1- Inserir produto");
        System.out.println("2- Deletar produto");
        System.out.println("3- Consultar produto");
        System.out.println("4- Inserir funcionário");
        System.out.println("5- Consultar funcionário");
        System.out.println("6- Deletar funcionário");
        System.out.println("7- Sair");
    }
}
