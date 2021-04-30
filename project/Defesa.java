public class Defesa extends Jogador{
    private Double marcacaoDeOponente;

    public Defesa(){
        super();
        this.marcacaoDeOponente = 0.0;
    }

    public Defesa(String ID,String nome){
        super(ID,nome);
        this.marcacaoDeOponente = 0.0;
    }

    public Defesa(String ID,String nome, Double marcacaoDeOponente){
        super(ID,nome);
        this.marcacaoDeOponente = marcacaoDeOponente;
    }

    public Defesa(Defesa def){
        super(def.get_ID(), def.get_nome(),
              def.get_velocidade(), def.get_resistencia(),
              def.get_destreza(), def.get_impulsao(),
              def.get_jogoDeCabeca(),def.get_remate(),
              def.get_passe());

        this.marcacaoDeOponente = def.defesa_get_marcacaoDeOponente();
    }

    public Double defesa_get_marcacaoDeOponente(){
        return this.marcacaoDeOponente;
    }

    public void defesa_set_marcacaoDeOponente(Double marcacaoDeOponente){
        this.marcacaoDeOponente=marcacaoDeOponente;
    }

    public Defesa clone(){
        return new Defesa(this);
    }

    public boolean equals(Defesa j){
        return super.equals(j) && this.defesa_get_marcacaoDeOponente() == j.defesa_get_marcacaoDeOponente();
    }
}
