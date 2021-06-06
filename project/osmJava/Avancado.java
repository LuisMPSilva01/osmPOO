import java.util.concurrent.ThreadLocalRandom;

public class Avancado extends Jogador {
    private int isolamento;

    public Avancado(){
        super();
        isolamento=0;
    }

    public Avancado(String nomeDoJogador,int numeroDoJogador,
                   int velocidade, int resistencia,int destreza,int impulsao,
                   int jogoDeCabeca,int remate,int passe,int isolamento){
        super(nomeDoJogador,numeroDoJogador,velocidade,resistencia,destreza,impulsao,jogoDeCabeca,remate,passe);
        this.isolamento=isolamento;
    }

    public Avancado(Jogador j,int isolamento){
        super(j.get_nomeJogador(), j.get_numeroJogador(),
                j.get_velocidade(), j.get_resistencia(),
                j.get_destreza(), j.get_impulsao(),
                j.get_cabeca(),j.get_remate(),
                j.get_passe());
        this.isolamento=isolamento;
    }

    public Avancado(Avancado avan){
        super(avan.get_nomeJogador(), avan.get_numeroJogador(),
              avan.get_velocidade(), avan.get_resistencia(),
              avan.get_destreza(), avan.get_impulsao(),
              avan.get_cabeca(),avan.get_remate(),
              avan.get_passe());
        this.isolamento=avan.getIsolamento();
    }

    public static Avancado parse(String input){
        String[] campos = input.split(",");
        return new Avancado(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                ThreadLocalRandom.current().nextInt(0, 100+1));
    }

    public Avancado clone(){
        return new Avancado(this);
    }

    public int getIsolamento() {
        return isolamento;
    }

    public void setIsolamento(int isolamento) {
        this.isolamento = isolamento;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        Avancado avan = (Avancado) o;
        return super.equals(o) && this.isolamento==avan.getIsolamento();
    }

    public String toString(){
        return "Avancado\n" +super.toString()+"Isolamento: " + this.getIsolamento() + "\n";
    }

    @Override
    public String posicao(){
        return "Avancado";
    }

    public static int skill(Jogador j){
        int skillBase= (int) (j.overallAsAPlayer()*0.7);
        if (j instanceof Avancado){
            return (int) (((Avancado) j).getIsolamento()*0.3+skillBase);
        }
        if (j instanceof Medio){
            return skillBase;
        }
        if (j instanceof Defesa){
            return (int) (skillBase*0.6);
        }
        else return 0;
    }
}
