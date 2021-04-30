public class GuardaRedes extends Jogador{
    private Double elasticidade;

    public GuardaRedes(){
        super();
        this.elasticidade = 0.0;
    }

    public GuardaRedes(String ID,String nome){
        super(ID,nome);
        this.elasticidade = 0.0;
    }

    public GuardaRedes(String ID,String nome, Double elasticidade){
        super(ID,nome);
        this.elasticidade = elasticidade;
    }

    public GuardaRedes(GuardaRedes gr){
        super(gr.get_ID(), gr.get_nome(),
              gr.get_velocidade(), gr.get_resistencia(),
              gr.get_destreza(), gr.get_impulsao(),
              gr.get_jogoDeCabeca(),gr.get_remate(),
              gr.get_passe());

        this.elasticidade = gr.guardaRedes_get_elasticidade();
    }

    public Double guardaRedes_get_elasticidade(){
        return this.elasticidade;
    }

    public void guardaRedes_set_elasticidade(Double elasticidade){
        this.elasticidade=elasticidade;
    }

    public GuardaRedes clone(){
        return new GuardaRedes(this);
    }

    public boolean equals(GuardaRedes j){
        return super.equals(j) && this.guardaRedes_get_elasticidade() == j.guardaRedes_get_elasticidade();
    }
}

