
public abstract  class Jogador {
    private String nomeJogador;
    private int numeroJogador;
    private int velocidade, resistencia, destreza, impulsao, cabeca, remate, passe;
    
    public Jogador(){
        this.nomeJogador ="";
        this.numeroJogador = 0;
        this.velocidade=0;
        this.resistencia=0;
        this.destreza=0;
        this.impulsao=0;
        this.cabeca=0;
        this.remate=0;
        this.passe=0;
    }


    public Jogador(String nomeDoJogador,int numeroDoJogador,
                   int velocidade, int resistencia,int destreza,int impulsao,
                   int jogoDeCabeca,int remate,int passe){
        this.nomeJogador = nomeDoJogador;
        this.numeroJogador = numeroDoJogador;
        this.velocidade=velocidade;
        this.resistencia=resistencia;
        this.destreza=destreza;
        this.impulsao=impulsao;
        this.cabeca=jogoDeCabeca;
        this.remate=remate;
        this.passe=passe;
    }
    
    public Jogador(Jogador player){
        this.nomeJogador = player.get_nomeJogador();
        this.numeroJogador = player.get_numeroJogador();
        this.velocidade= player.get_velocidade();
        this.resistencia=player.get_resistencia();
        this.destreza=player.get_destreza();
        this.impulsao=player.get_impulsao();
        this.cabeca=player.get_cabeca();
        this.remate=player.get_remate();
        this.passe=player.get_passe();
    }

//////////////////////////////////////////////////////////////////////////////////
    
    public String get_nomeJogador(){
        return this.nomeJogador;
    }
    public int get_numeroJogador(){
        return this.numeroJogador;
    };
    public int get_velocidade(){
        return this.velocidade;
    }
    public int get_resistencia(){
        return this.resistencia;
    }
    public int get_destreza(){
        return this.destreza;
    }
    public int get_impulsao(){
        return this.impulsao;
    }
    public int get_cabeca(){
        return this.cabeca;
    }
    public int get_remate(){
        return this.remate;
    }
    public int get_passe(){
        return this.passe;
    }

////////////////////////////////////////////////////////////////////////////////77

    public void set_nomeJogador(String nomeJogador){
        this.nomeJogador=nomeJogador;
    }

    public void set_numeroJogador(int numeroJogador){
        this.numeroJogador=numeroJogador;
    }

    public void set_velocidade(int velocidade){
        this.velocidade=velocidade;
    }

    public void set_resistencia(int resistencia){
        this.resistencia=resistencia;
    }

    public void set_destreza(int destreza){
        this.destreza=destreza;
    }

    public void set_impulsao(int impulsao){
        this.impulsao=impulsao;
    }

    public void set_jogoDeCabeca(int jogoDeCabeca){
        this.cabeca=jogoDeCabeca;
    }
    
    public void set_remate(int remate){
        this.remate=remate;
    }

    public void set_passe(int passe){
        this.passe=passe;
    }

////////////////////////////////////////////////////////////////////////////////////////////

    public abstract Jogador clone();

    public boolean equals(Object o){
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        Jogador j = (Jogador) o;
        return this.get_nomeJogador().equals(j.get_nomeJogador()) &&
               this.get_numeroJogador()==j.get_numeroJogador() &&
               this.get_velocidade()==j.get_velocidade() &&
               this.get_resistencia()==j.get_resistencia() &&
               this.get_destreza()==j.get_destreza() &&
               this.get_impulsao()==j.get_impulsao() &&
               this.get_cabeca()==j.get_cabeca() &&
               this.get_remate()==j.get_remate() &&
               this.get_passe()==j.get_passe();
    }

    public String toString(){
        StringBuffer sb = new StringBuffer("Nome Do Jogador:\n");
        sb.append("Nome: ").append(this.get_nomeJogador()).append(";\n");
        sb.append("Numero: ").append(this.get_numeroJogador()).append(";\n");
        sb.append("Velocidade: ").append(this.get_velocidade()).append(";\n");
        sb.append("Resistencia: ").append(this.get_resistencia()).append(";\n");
        sb.append("Destreza: ").append(this.get_destreza()).append("\n");
        sb.append("Impulsao: ").append(this.get_impulsao()).append("\n");
        sb.append("Cabeca: ").append(this.get_cabeca()).append("\n");
        sb.append("Remate: ").append(this.get_remate()).append("\n");
        sb.append("Passe: ").append(this.get_passe()).append("\n");
        return sb.toString();
    }
}
