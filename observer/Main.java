import java.util.ArrayList;
import java.util.List;

interface Observer {

    void atualizar(String nomeProduto, double novoPreco);
}

class ClienteInteressado implements Observer {
    private String nome;

    public ClienteInteressado(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String nomeProduto, double novoPreco) {

        System.out.println(
                "Olá " + nome + "! O produto " + nomeProduto + " entrou em promoção por R$ " + novoPreco + "!");
    }
}

class Produto {
    private String nome;
    private double preco;

    private List<Observer> clientesInteressados;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.clientesInteressados = new ArrayList<>();
    }

    public void adicionar(Observer observer) {
        clientesInteressados.add(observer);
    }

    public void remover(Observer observer) {
        clientesInteressados.remove(observer);
    }

    public void notificar() {

        for (Observer cliente : clientesInteressados) {
            cliente.atualizar(this.nome, this.preco);
        }
    }

    public void entrarEmPromocao(double novoPreco) {
        System.out.println("\n--- ATUALIZAÇÃO NO SISTEMA: " + this.nome + " entrou em promoção! ---");
        this.preco = novoPreco;

        notificar();
    }
}

public class Main {
    public static void main(String[] args) {

        Produto smartphone = new Produto("Smartphone XYZ", 2500.00);

        ClienteInteressado cliente1 = new ClienteInteressado("Ana");
        ClienteInteressado cliente2 = new ClienteInteressado("Carlos");
        ClienteInteressado cliente3 = new ClienteInteressado("Beatriz");

        smartphone.adicionar(cliente1);
        smartphone.adicionar(cliente2);
        smartphone.adicionar(cliente3);

        smartphone.entrarEmPromocao(1999.99);

        System.out.println("\n[Carlos removeu sua inscrição de alertas]");
        smartphone.remover(cliente2);

        smartphone.entrarEmPromocao(1799.00);
    }
}