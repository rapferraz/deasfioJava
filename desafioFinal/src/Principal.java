import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        List<Produto> carrinho = new ArrayList<>();
        Scanner resp = new Scanner(System.in);
        int exit;

        //entrada de limite do cartão
        System.out.println("Digite o limite do cartão: ");
        double limiteCartao = resp.nextDouble();

        do {
            System.out.println("Digite qual produto você quer comprar: ");
            String produtinho = resp.next();

            System.out.println("Digite o valor do produto: ");
            double valorzinho = resp.nextDouble();
            if (valorzinho > limiteCartao) {
                System.out.println("Limite do cartão insuficiente");
                break;
            }
            limiteCartao -= valorzinho;

            Produto produto = new Produto(produtinho, valorzinho);
            carrinho.add(produto);

                do {
                    System.out.println("Se deseja adicionar um novo produto digite 1, para encerrar digite 0.");
                    exit = resp.nextInt();
                    if (exit < 0 && exit > 1) {
                        System.out.println("Digite uma resposta válida!");
                    }
                } while (exit < 0 && exit > 1);
        } while (exit != 0);

        System.out.println("********************");
        System.out.println("Compras realizadas");
        System.out.println("********************");

        double precoTotal = 0;
        for(Produto item : carrinho) {
            System.out.println("Produto: " + item.toString() + "\nValor: R$" + item.getPreco());
            precoTotal +=  item.getPreco();
        }

        System.out.println("Total das compras: R$" + precoTotal);
        System.out.println("\nLimite restante do cartão: " + limiteCartao);
    }
}
