
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
        super(avan.jogador_get_ID(), avan.jogador_get_nome(),
              avan.jogador_get_velocidade(), avan.jogador_get_resistencia(),
              avan.jogador_get_destreza(), avan.jogador_get_impulsao(),
              avan.jogador_get_jogoDeCabeca(),avan.jogador_get_remate(),
              avan.jogador_get_passe());

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
