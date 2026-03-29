interface PagamentoModerno {
    void processarPagamento(double valor);
}

class PagamentoLegado {
    public void fazerPagamentoAntigo(String detalhes, double quantia) {
        System.out.println("--- Sistema Legado ---");
        System.out.println("Processando: " + detalhes);
        System.out.println("Valor: R$ " + quantia);
        System.out.println("Status: Transação concluída com sucesso.");
        System.out.println("----------------------");
    }
}

class PagamentoAdapter implements PagamentoModerno {
    private PagamentoLegado pagamentoLegado;

    public PagamentoAdapter(PagamentoLegado pagamentoLegado) {
        this.pagamentoLegado = pagamentoLegado;
    }

    @Override
    public void processarPagamento(double valor) {
        String infoTransacao = "Pagamento processado via Adapter em " + java.time.LocalDateTime.now();
        pagamentoLegado.fazerPagamentoAntigo(infoTransacao, valor);
    }
}

public class Main {
    public static void main(String[] args) {
        PagamentoLegado servicoAntigo = new PagamentoLegado();

        PagamentoModerno sistemaDePagamento = new PagamentoAdapter(servicoAntigo);

        System.out.println("Iniciando processamento de venda...");
        sistemaDePagamento.processarPagamento(599.90);
        
        System.out.println("\nProcessamento finalizado.");
    }
}