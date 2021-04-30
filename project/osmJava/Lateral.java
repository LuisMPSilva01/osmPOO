public class Lateral extends Jogador{
    private Double cruzamento;

    public Lateral(){
        super();
        this.cruzamento = 0.0;
    }

    public Lateral(String ID,String nome){
        super(ID,nome);
        this.cruzamento = 0.0;
    }

    public Lateral(String ID,String nome, Double cruzamento){
        super(ID,nome);
        this.cruzamento = cruzamento;
    }

    public Lateral(Lateral lat){
        super(lat.get_ID(), lat.get_nome(),
              lat.get_velocidade(), lat.get_resistencia(),
              lat.get_destreza(), lat.get_impulsao(),
              lat.get_jogoDeCabeca(),lat.get_remate(),
              lat.get_passe());

        this.cruzamento = lat.lateral_get_cruzamento();
    }

    public Double lateral_get_cruzamento(){
        return this.cruzamento;
    }

    public void lateral_set_cruzamento(Double cruzamento){
        this.cruzamento=cruzamento;
    }

    public Lateral clone(){
        return new Lateral(this);
    }

    public boolean equals(Lateral j){
        return super.equals(j) && this.lateral_get_cruzamento() == j.lateral_get_cruzamento();
    }
}
