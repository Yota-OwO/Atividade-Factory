class ComputadorBuilder{
    private String processador;
    private int memoria;
    private int armazenamento;
    private boolean placaVideo;
    private String sistemaOperacional;
}

 public ComputadorBuilder comProcessador(String p) {
    this.processador = p;
    return this;
 }

 public ComputadorBuilder comMemoria(int q){
    this.memoria = q
    return this;
 }
 public ComputadorBuilder comArmazenamento(int r){
    this.armazenamento = r;
    return this;
 }
public ComputadorBuilder comPlacaVideo(boolean u){
    this.placaVideo = u;
    return this;
}
public ComputadorBuilder comSistemaOperacional(String v){
    this.sistemaOperacional = v;
    return this;
}

Public class Main {
    public static void main(String[] args) {
        
        Computador pc = new ComputadorBuilder ()
        .comProcessador ("Intel i7")
        .comMemoria ("16")
        .comArmazenamento ("1024")
        .comPlacaVideo(true)
        .comSistemaOperacional("windows 11")
        .build();

        pc.exibirConfiguracao();
    }
}