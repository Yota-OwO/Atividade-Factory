interface Botao {
    void render();
}

interface Menu {
    void render();
}

class BotaoClaro implements Botao {
    @Override
    public void render() { 
        System.out.println("Renderizando Botão no Estilo Claro."); 
    }
}

class MenuClaro implements Menu {
    @Override
    public void render() { 
        System.out.println("Renderizando Menu no Estilo Claro."); 
    }
}

class BotaoEscuro implements Botao {
    @Override
    public void render() { 
        System.out.println("Renderizando Botão no Estilo Escuro."); 
    }
}

class MenuEscuro implements Menu {
    @Override
    public void render() { 
        System.out.println("Renderizando Menu no Estilo Escuro."); 
    }
}

interface TemaFactory {
    Botao criarBotao();
    Menu criarMenu();
}

class TemaClaroFactory implements TemaFactory {
    @Override
    public Botao criarBotao() { return new BotaoClaro(); }
    @Override
    public Menu criarMenu() { return new MenuClaro(); }
}

class TemaEscuroFactory implements TemaFactory {
    @Override
    public Botao criarBotao() { return new BotaoEscuro(); }
    @Override
    public Menu criarMenu() { return new MenuEscuro(); }
}

class Aplicacao {
    private Botao botao;
    private Menu menu;

    public Aplicacao(TemaFactory factory) {
        this.botao = factory.criarBotao();
        this.menu = factory.criarMenu();
    }

    public void renderizarInterface() {
        botao.render();
        menu.render();
    }
}

public class Main {
    public static void main(String[] args) {
        TemaFactory factory = new TemaEscuroFactory(); 
        
        Aplicacao app = new Aplicacao(factory);
        app.renderizarInterface();
    }
}