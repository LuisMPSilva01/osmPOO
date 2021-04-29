
public class Jogador {
    private String ID;
    private String nomeDoJogador;
    private Double velocidade;
    private Double resistencia;
    private Double destreza;
    private Double impulsao;
    private Double jogoDeCabeca;
    private Double remate;
    private Double passe;

    public Jogador(){
        this.ID ="";
        this.nomeDoJogador = "";
        this.velocidade=0.0;
        this.resistencia=0.0;
        this.destreza=0.0;
        this.impulsao=0.0;
        this.jogoDeCabeca=0.0;
        this.remate=0.0;
        this.passe=0.0;
    }

    public Jogador(String ID,String nomeDoJogador){
        this.ID = ID;
        this.nomeDoJogador = nomeDoJogador;
        this.velocidade=0.0;
        this.resistencia=0.0;
        this.destreza=0.0;
        this.impulsao=0.0;
        this.jogoDeCabeca=0.0;
        this.remate=0.0;
        this.passe=0.0;
    }

    public Jogador(String ID,String nomeDoJogador,Double velocidade,
                   Double resistencia,Double destreza,Double impulsao,
                   Double jogoDeCabeca,Double remate,Double passe){
        this.ID = ID;
        this.nomeDoJogador = nomeDoJogador;
        this.velocidade=velocidade;
        this.resistencia=resistencia;
        this.destreza=destreza;
        this.impulsao=impulsao;
        this.jogoDeCabeca=jogoDeCabeca;
        this.remate=remate;
        this.passe=passe;
    }
    
    public Jogador(Jogador player){
        this.ID = player.jogador_get_ID();
        this.nomeDoJogador = player.jogador_get_nome();
        this.velocidade= player.jogador_get_velocidade();
        this.resistencia=player.jogador_get_resistencia();
        this.destreza=player.jogador_get_destreza();
        this.impulsao=player.jogador_get_impulsao();
        this.jogoDeCabeca=player.jogador_get_jogoDeCabeca();
        this.remate=player.jogador_get_remate();
        this.passe=player.jogador_get_passe();
    }

//////////////////////////////////////////////////////////////////////////////////

    public String jogador_get_ID(){
        return this.ID;
    }
    
    public String jogador_get_nome(){
        return this.nomeDoJogador;
    }

    public Double jogador_get_velocidade(){
        return this.velocidade;
    }

    public Double jogador_get_resistencia(){
        return this.resistencia;
    }

    public Double jogador_get_destreza(){
        return this.destreza;
    }

    public Double jogador_get_impulsao(){
        return this.impulsao;
    }

    public Double jogador_get_jogoDeCabeca(){
        return this.jogoDeCabeca;
    }
    
    public Double jogador_get_remate(){
        return this.remate;
    }

    public Double jogador_get_passe(){
        return this.passe;
    }

////////////////////////////////////////////////////////////////////////////////77

    public void jogador_set_ID(String ID){
        this.ID=ID;
    }

    public void jogador_set_nome(String nomeDoJogador){
        this.nomeDoJogador=nomeDoJogador;
    }

    public void jogador_set_velocidade(Double velocidade){
        this.velocidade=velocidade;
    }

    public void jogador_set_resistencia(Double resistencia){
        this.resistencia=resistencia;
    }

    public void jogador_set_destreza(Double destreza){
        this.destreza=destreza;
    }

    public void jogador_set_impulsao(Double impulsao){
        this.impulsao=impulsao;
    }

    public void jogador_set_jogoDeCabeca(Double jogoDeCabeca){
        this.jogoDeCabeca=jogoDeCabeca;
    }
    
    public void jogador_set_remate(Double remate){
        this.remate=remate;
    }

    public void jogador_set_passe(Double passe){
        this.passe=passe;
    }

////////////////////////////////////////////////////////////////////////////////////////////

    public Jogador clone(){
        return new Jogador(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        Jogador j = (Jogador) o;
        return this.jogador_get_ID().equals(j.jogador_get_ID()) &&
               this.jogador_get_nome().equals(j.jogador_get_nome()) &&
               this.jogador_get_velocidade()==j.jogador_get_velocidade() &&
               this.jogador_get_resistencia()==j.jogador_get_resistencia() &&
               this.jogador_get_destreza()==j.jogador_get_destreza() &&
               this.jogador_get_impulsao()==j.jogador_get_impulsao() &&
               this.jogador_get_jogoDeCabeca()==j.jogador_get_jogoDeCabeca() &&
               this.jogador_get_remate()==j.jogador_get_remate() &&
               this.jogador_get_passe()==j.jogador_get_passe();
    }
}
