
public abstract  class Jogador {
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
        this.ID = player.get_ID();
        this.nomeDoJogador = player.get_nome();
        this.velocidade= player.get_velocidade();
        this.resistencia=player.get_resistencia();
        this.destreza=player.get_destreza();
        this.impulsao=player.get_impulsao();
        this.jogoDeCabeca=player.get_jogoDeCabeca();
        this.remate=player.get_remate();
        this.passe=player.get_passe();
    }

//////////////////////////////////////////////////////////////////////////////////

    public String get_ID(){
        return this.ID;
    }
    
    public String get_nome(){
        return this.nomeDoJogador;
    }

    public Double get_velocidade(){
        return this.velocidade;
    }

    public Double get_resistencia(){
        return this.resistencia;
    }

    public Double get_destreza(){
        return this.destreza;
    }

    public Double get_impulsao(){
        return this.impulsao;
    }

    public Double get_jogoDeCabeca(){
        return this.jogoDeCabeca;
    }
    
    public Double get_remate(){
        return this.remate;
    }

    public Double get_passe(){
        return this.passe;
    }

////////////////////////////////////////////////////////////////////////////////77

    public void set_ID(String ID){
        this.ID=ID;
    }

    public void set_nome(String nomeDoJogador){
        this.nomeDoJogador=nomeDoJogador;
    }

    public void set_velocidade(Double velocidade){
        this.velocidade=velocidade;
    }

    public void set_resistencia(Double resistencia){
        this.resistencia=resistencia;
    }

    public void set_destreza(Double destreza){
        this.destreza=destreza;
    }

    public void set_impulsao(Double impulsao){
        this.impulsao=impulsao;
    }

    public void set_jogoDeCabeca(Double jogoDeCabeca){
        this.jogoDeCabeca=jogoDeCabeca;
    }
    
    public void set_remate(Double remate){
        this.remate=remate;
    }

    public void set_passe(Double passe){
        this.passe=passe;
    }

////////////////////////////////////////////////////////////////////////////////////////////

    public abstract Jogador clone();

    public boolean equals(Object o){
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        Jogador j = (Jogador) o;
        return this.get_ID().equals(j.get_ID()) &&
               this.get_nome().equals(j.get_nome()) &&
               this.get_velocidade()==j.get_velocidade() &&
               this.get_resistencia()==j.get_resistencia() &&
               this.get_destreza()==j.get_destreza() &&
               this.get_impulsao()==j.get_impulsao() &&
               this.get_jogoDeCabeca()==j.get_jogoDeCabeca() &&
               this.get_remate()==j.get_remate() &&
               this.get_passe()==j.get_passe();
    }
}
