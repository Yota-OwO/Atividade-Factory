public class GerenciadorTema {
    private static GerenciadorTema instancia;
    
    private String temaAtual;

    private GerenciadorTema() {
        this.temaAtual = "claro"; // Tema inicial padrão
        System.out.println("Sistema de Temas Inicializado.");
    }

    public static synchronized GerenciadorTema getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorTema();
        }
        return instancia;
    }

    public String getTema() {
        return temaAtual;
    }

    public void setTema(String novoTema) {
        this.temaAtual = novoTema;
        System.out.println("Tema alterado para: " + novoTema);
    }
}

public class Main {
    public static void main(String[] args) {
        GerenciadorTema g1 = GerenciadorTema.getInstancia();
        GerenciadorTema g2 = GerenciadorTema.getInstancia();

        g1.setTema("escuro");

        System.out.println("Tema no g2: " + g2.getTema());

        if (g1 == g2) {
            System.out.println("Sucesso! g1 e g2 são a mesma instância.");
        }
    }
}