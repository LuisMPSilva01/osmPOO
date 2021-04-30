
// Uma SmartBulb tem uma tonalidade (WARM, NEUTRAL, COLD) que pode ser controlada.

public class Avancado extends Jogador{
    private Double posicaoDeAtaque;

    public Avancado(){
        super();
        this.posicaoDeAtaque = 0.0;
    }

    public Avancado(String ID,String nome){
        super(ID,nome);
        this.posicaoDeAtaque = 0.0;
    }

    public Avancado(String ID,String nome, Double posicaoDeAtaque){
        super(ID,nome);
        this.posicaoDeAtaque = posicaoDeAtaque;
    }

    public Avancado(Avancado avan){
        super(avan.get_ID(), avan.get_nome(),
              avan.get_velocidade(), avan.get_resistencia(),
              avan.get_destreza(), avan.get_impulsao(),
              avan.get_jogoDeCabeca(),avan.get_remate(),
              avan.get_passe());

        this.posicaoDeAtaque = avan.avancado_get_posicaoDeAtaque();
    }

    public Double avancado_get_posicaoDeAtaque(){
        return this.posicaoDeAtaque;
    }

    public void avancado_set_posicaoDeAtaque(Double posicaoDeAtaque){
        this.posicaoDeAtaque=posicaoDeAtaque;
    }

    public Avancado clone(){
        return new Avancado(this);
    }

    public boolean equals(Avancado j){
        return super.equals(j) && this.avancado_get_posicaoDeAtaque() == j.avancado_get_posicaoDeAtaque();
    }
}
