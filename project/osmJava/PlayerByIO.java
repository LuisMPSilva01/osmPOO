public class PlayerByIO{
    public static Jogador criaJogador(){
        String nomeJogador ="";
        int numeroJogador = 0,velocidade=0,resistencia=0,destreza=0,impulsao=0,cabeca=0,remate=0,passe=0;
        StringHandler sh = new StringHandler();
        sh.readString("Ensira o nome do Jogador: ");
        nomeJogador= sh.getLine();
        numeroJogador= sh.forceInt(0,100,"Ensira o numero do jogador");
        velocidade= sh.forceInt(0,100,"Ensira a velocidade do jogador");
        resistencia= sh.forceInt(0,100,"Ensira a resistencia do jogador");
        destreza= sh.forceInt(0,100,"Ensira a destreza do jogador");
        impulsao= sh.forceInt(0,100,"Ensira a impulsao do jogador");
        cabeca= sh.forceInt(0,100,"Ensira a qualidade de cabeca do jogador");
        remate= sh.forceInt(0,100,"Ensira o remate do jogador");
        passe= sh.forceInt(0,100,"Ensira o passe do jogador");

        return new Jogador(nomeJogador,numeroJogador,velocidade,resistencia,destreza,impulsao,cabeca,remate,passe);
    }

    public static Avancado criaAvancado() {
        Jogador j = criaJogador();

        StringHandler sh = new StringHandler();
        int isolamento = sh.forceInt(0,100,"Ensira o isolamento do jogador");

        return new Avancado(j,isolamento);
    }

    public static Defesa criaDefesa() {
        Jogador j = criaJogador();

        StringHandler sh = new StringHandler();
        int marcacao = sh.forceInt(0,100,"Ensira a marcacao do jogador");

        return new Defesa(j,marcacao);
    }

    public static Lateral criaLateral() {
        Jogador j = criaJogador();

        StringHandler sh = new StringHandler();
        int cruzamento = sh.forceInt(0,100,"Ensira o cruzamento do jogador");

        return new Lateral(j,cruzamento);
    }

    public static GuardaRedes criaGuardaRedes() {
        Jogador j = criaJogador();

        StringHandler sh = new StringHandler();
        int elasticidade = sh.forceInt(0,100,"Ensira a elasticidade do jogador");

        return new GuardaRedes(j,elasticidade);
    }

    public static Medio criaMedio() {
        Jogador j = criaJogador();

        StringHandler sh = new StringHandler();
        int rec = sh.forceInt(0,100,"Ensira a recuperacao do jogador");

        return new Medio(j,rec);
    }
}
