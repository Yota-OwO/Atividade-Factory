class PersonagemBuilder{
    private String nome;
    private String classe;
    private String arma;
    private int armadura;
    private String habilidades;
}

public personagemBuilder comNome(String n) {
    this.nome = n;
    return this;
}
public personagemBuilder comClasse(String c){
    this.classe = c;
    return this;
}
public personagemBuilder comArma(String a){
    this.arma = a;
    return this;
}
public personagemBuilder comArmadura(int ar){
    this.armadura = ar;
    return this;
}
public personagemBuilder comHabilidades(String h){
    this.habilidades = h;
    return this;
}
public class main {
    public static void main(String[] args) {
        
        Personagem personagem = new PersonagemBuilder()
        .comNome("Aragorn")
        .comClasse("Guerreiro")
        .comArma("Espada")
        .comArmadura(100)
        .comHabilidades("Liderança, Combate corpo a corpo")
        .build();

        personagem.exibirDetalhes();
    }
}