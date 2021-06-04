public class Lateral extends Jogador{
    private int cruzamento;

    public Lateral(){
        super();
        this.cruzamento=0;
    }

    public Lateral(String nomeDoJogador,int numeroDoJogador,
                       int velocidade, int resistencia,int destreza,int impulsao,
                       int jogoDeCabeca,int remate,int passe,int cruzamento){
        super(nomeDoJogador,numeroDoJogador,velocidade,resistencia,destreza,impulsao,jogoDeCabeca,remate,passe);
        this.cruzamento=cruzamento;
    }

    public Lateral(Lateral lat){
        super(lat.get_nomeJogador(), lat.get_numeroJogador(),
                lat.get_velocidade(), lat.get_resistencia(),
                lat.get_destreza(), lat.get_impulsao(),
                lat.get_cabeca(),lat.get_remate(),
                lat.get_passe());
        this.cruzamento=lat.getCruzamento();
    }

    public int getCruzamento() {
        return cruzamento;
    }

    public void setCruzamento(int cruzamento) {
        this.cruzamento = cruzamento;
    }


    public static Lateral parse(String input){
        String[] campos = input.split(",");
        return new Lateral(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
    }

    public Lateral clone(){
        return new Lateral(this);
    }

    public String toString(){
        return super.toString()+"Cruzamento: " + this.getCruzamento() + "\n";
    }
}
