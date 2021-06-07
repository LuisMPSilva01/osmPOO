import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class NewGame {
    private LocalDate dataDoJogo;
    private GameTeams equipaCasa;
    private int golosCasa;
    private GameTeams equipaFora;
    private int golosFora;

    public NewGame(){
        this.equipaCasa=null;
        this.equipaFora=null;
        golosCasa=0;
        golosFora=0;
        this.dataDoJogo=null;
    }

    public NewGame(GameTeams equipaCasa, GameTeams equipaFora,LocalDate dataDoJogo){
        this.equipaCasa=equipaCasa;
        this.equipaFora=equipaFora;
        golosCasa=0;
        golosFora=0;
        this.dataDoJogo=dataDoJogo;
    }



    public List<String> firstHalf(){
        List<String> list = new ArrayList<>();
        list.add("Relato da primeira parte:\n");
        list.add(goloContraCasa());
        list.add(goloContraFora());
        list.add(goloContraCasa());
        list.add(goloContraFora());
        list.add(goloContraCasa());
        list.add(goloContraFora());
        list.add(goloContraCasa());
        list.add(goloContraFora());
        list.add(goloContraCasa());
        list.add(goloContraFora());
        list.add(goloContraCasa());
        list.add(goloContraFora());
        return list;
    }

    public List<String> secondHalf(){
        List<String> list = new ArrayList<>();
        list.add("Relato da segunda parte:\n");
        list.add(goloContraFora());
        list.add(goloContraCasa());
        list.add(goloContraFora());
        list.add(goloContraCasa());
        list.add(goloContraFora());
        list.add(goloContraCasa());
        list.add(goloContraFora());
        list.add(goloContraCasa());
        list.add(goloContraFora());
        list.add(goloContraCasa());
        list.add(goloContraFora());
        list.add("Fim do Jogo!!!\n");
        list.add("Resultado:"+this.equipaCasa.getNomeEquipa()+ " " + golosCasa + " - " + golosFora + " " + this.equipaFora.getNomeEquipa());
        return list;
    }

    public void makeSubstituicoesCasa(int NewPlayer,int OldPlayer) throws JogadorInexistenteExeption, PosicaoInvalidaException {
        this.equipaCasa.makeSubstituicao(NewPlayer,OldPlayer);
    }

    public void makeSubstituicoesFora(int NewPlayer,int OldPlayer) throws JogadorInexistenteExeption, PosicaoInvalidaException {
        this.equipaFora.makeSubstituicao(NewPlayer,OldPlayer);
    }

    public String goloContraCasa(){
        double roll=ThreadLocalRandom.current().nextDouble(0, 1);
        if(roll<ataqueContraCasa()){
            this.golosFora++;
            return generateGoal(this.equipaFora.getNomeEquipa());
        }
        else return generateMissedAtack(this.equipaFora.getNomeEquipa());
    }
    public String goloContraFora(){
        double roll=ThreadLocalRandom.current().nextDouble(0, 1);
        if(roll<ataqueContraFora()){
            this.golosCasa++;
            return generateGoal(this.equipaCasa.getNomeEquipa());
        }
        else return generateMissedAtack(this.equipaCasa.getNomeEquipa());
    }

    public double ataqueContraCasa(){ //Devolve chance de marcar
        int skillCasa = equipaCasa.getTeamSkill();
        int skillFora = equipaFora.getTeamSkill();
        return ((double)skillFora)/(skillCasa+skillFora)*0.15;
    }
    public double ataqueContraFora(){ //Devolver chance de marcar
        int skillCasa = equipaCasa.getTeamSkill();
        int skillFora = equipaFora.getTeamSkill();
        return (((double)skillCasa)/(skillCasa+skillFora))*0.25;
    }

    public String generateGoal(String equipa){
        int random=ThreadLocalRandom.current().nextInt(0, 4);
        String s="";
        switch (random){
            case 0: {
                s=equipa + " marcou com grande golo de cabeça!!";
                break;
            }
            case 1: {
                s=equipa + " esta a fazer um penalti e ... marcou!";
                break;
            }
            case 2: {
                s=equipa + " fez um passe para um jogador isolado e conseguiu o golo!";
                break;
            }
            case 3: {
                s=equipa + " fintou todos os adversarios e marcou";
                break;
            }
        }
        return s;
    }
    public String generateMissedAtack(String equipa){
        int random=ThreadLocalRandom.current().nextInt(0, 10);
        String s="";
        switch (random){
            case 0: {
                s=equipa + " perdeu a bola num passe falhado.";
                break;
            }
            case 1: {
                s=equipa + " esta a fazer um penalti e ... foi ao lado!";
                break;
            }
            case 2: {
                s=equipa + " fez um passe para um jogador isolado, que nao conseguiu marcar!";
                break;
            }
            case 3: {
                s=equipa + " fintou todos os adversarios e ... falhou miseravelmente.";
                break;
            }
            case 4: {
                s=equipa + " fez um cruzamento e o passe foi curtado pela defesa.";
                break;
            }
            case 5: {
                s=equipa + " remata a baliza mas o Guarda Redes defende!!";
                break;
            }
            case 6: {
                s=equipa + " perdeu a bola depois de uma finta falhada.";
                break;
            }
            case 7: {
                s=equipa + " rematou a baliza e, a bola bate no poste e vai para fora!";
                break;
            }
            case 8: {
                s=equipa + " passou para o arbitro que se desvia da bola, perdendo assim a posse de bola.";
                break;
            }
            case 9: {
                s=equipa + " passou para um jogador fora de jogo.";
                break;
            }
        }
        return s;
    }

    public void setDataDoJogo(LocalDate dataDoJogo) {
        this.dataDoJogo = dataDoJogo;
    }

    public void setEquipaCasa(GameTeams equipaCasa) {
        this.equipaCasa = equipaCasa.clone();
    }

    public void setGolosCasa(int golosCasa) {
        this.golosCasa = golosCasa;
    }

    public void setEquipaFora(GameTeams equipaFora) {
        this.equipaFora = equipaFora.clone();
    }

    public void setGolosFora(int golosFora) {
        this.golosFora = golosFora;
    }

    public LocalDate getDataDoJogo() {
        return dataDoJogo;
    }

    public GameTeams getEquipaCasa() {
        return equipaCasa.clone();
    }

    public int getGolosCasa() {
        return golosCasa;
    }

    public GameTeams getEquipaFora() {
        return equipaFora.clone();
    }

    public int getGolosFora() {
        return golosFora;
    }
}
