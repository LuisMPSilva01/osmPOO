public class Medio extends Jogador{
    private Double recuperacaoDeBola;

    public Medio(){
        super();
        this.recuperacaoDeBola = 0.0;
    }

    public Medio(String ID,String nome){
        super(ID,nome);
        this.recuperacaoDeBola = 0.0;
    }

    public Medio(String ID,String nome, Double recuperacaoDeBola){
        super(ID,nome);
        this.recuperacaoDeBola = recuperacaoDeBola;
    }

    public Medio(Medio med){
        super(med.get_ID(), med.get_nome(),
              med.get_velocidade(), med.get_resistencia(),
              med.get_destreza(), med.get_impulsao(),
              med.get_jogoDeCabeca(),med.get_remate(),
              med.get_passe());

        this.recuperacaoDeBola = med.medio_get_recuperacaoDeBola();
    }

    public Double medio_get_recuperacaoDeBola(){
        return this.recuperacaoDeBola;
    }

    public void medio_set_recuperacaoDeBola(Double recuperacaoDeBola){
        this.recuperacaoDeBola=recuperacaoDeBola;
    }

    public Medio clone(){
        return new Medio(this);
    }

    public boolean equals(Medio j){
        return super.equals(j) && this.medio_get_recuperacaoDeBola() == j.medio_get_recuperacaoDeBola();
    }
}
