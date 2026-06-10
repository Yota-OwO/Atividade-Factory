
interface FreteStrategy {
    double calcular(double valorPedido);
}

class FreteNormal implements FreteStrategy {
    @Override
    public double calcular(double valorPedido) {
        return 15.00;
    }
}

class FreteExpresso implements FreteStrategy {
    @Override
    public double calcular(double valorPedido) {
        return valorPedido * 0.10;
    }
}

class FreteRetirada implements FreteStrategy {
    @Override
    public double calcular(double valorPedido) {
        return 0.0;
    }
}

class Pedido {
    private double valorPedido;
    private FreteStrategy freteStrategy;

    public Pedido(double valorPedido, FreteStrategy freteStrategy) {
        this.valorPedido = valorPedido;
        this.freteStrategy = freteStrategy;
    }

    public void setFreteStrategy(FreteStrategy freteStrategy) {
        this.freteStrategy = freteStrategy;
    }

    public double calcularTotal() {

        double valorFrete = freteStrategy.calcular(this.valorPedido);
        return this.valorPedido + valorFrete;
    }
}

public class Strategy {
    public static void main(String[] args) {
        double valorDaCompra = 100.00;

        Pedido pedido = new Pedido(valorDaCompra, new FreteNormal());
        System.out.println("Total com Frete Normal: R$ " + pedido.calcularTotal());

        pedido.setFreteStrategy(new FreteExpresso());
        System.out.println("Total com Frete Expresso: R$ " + pedido.calcularTotal());

        pedido.setFreteStrategy(new FreteRetirada());
        System.out.println("Total com Retirada: R$ " + pedido.calcularTotal());

    }
}