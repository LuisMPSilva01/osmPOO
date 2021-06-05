import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TextUI {
    // o modelo
    private Liga model;

    //scanner
    private Scanner sc;

    /**
     * Construtor que cria os menus e o model
     */

    public TextUI() throws LinhaIncorretaException {
        this.model = new Liga();
        this.model = Liga.fromParse();
        sc = new Scanner(System.in);
    }


    /**
     * Método que executa o menu principal.
     * Coloca a interface em execução.
     */

    public void run() {
        NewMenu menu = new NewMenu(new String[] {
                " Liga de futebol",
                " Dar nome a liga"
        });

        //expressões lambda (interface funcional)
        menu.setHandler(1, this::gestaoDeEquipas);
        menu.setHandler(2, this::alterarNomeLiga);

        //colocar o menú em visualização e esperar leitura de opção
        menu.run();
    }

    /**
     * Métodos associados ao handler
     */
    private void gestaoDeEquipas() {
        NewMenu menuLiga = new NewMenu(new String[] {"Lista de equipas",
                "Alterar equipa",
                "Adicionar equipa"});

        //registar os handlers
        menuLiga.setHandler(1, this::listaEquipas);
        menuLiga.setHandler(2, () -> alterarEquipa(escolhaEquipa()));
        menuLiga.setHandler(3, this::adicionarEquipa);

        menuLiga.run();
    }


    private void alterarNomeLiga() { //Tem que dar print no view
        System.out.println("Novo nome da Liga: ");
        String nome = sc.nextLine();
        this.model.setNome(nome);
    }

    private void listaEquipas(){ //Tem que dar print no view
        System.out.println("Liga: " + this.model.getNome() + "\n");
        int i=1;
        for (String e : this.model.nomeDasEquipas()){
            System.out.println("Equipa" + i + ": " + e + "\n");
            i++;
        }
    }

    private String escolhaEquipa(){
        List<String> strings = this.model.nomeDasEquipas();
        StringHandler h = new StringHandler();
        int i;
        do {
            h.printStrings(strings);
            h.readString("Ensira o numero da equipa que pretende escolher: ");
            i=Integer.parseInt(h.getLine());
            if(!(i>0&&i<strings.size())) h.setError(true);
            else h.setError(false);
        } while (h.isError());

        return strings.get(i);
    }
    private int escolhaJogador(String equipa){
        StringHandler h = new StringHandler();
        int i;
        do {
            listaJogadores(equipa);
            h.readString("Ensira o numero do jogador que pretende escolher: ");
            i=Integer.parseInt(h.getLine());
            if(this.model.getEquipas().get(equipa).getJogador(i)==null) h.setError(true);
            else h.setError(false);
        } while (h.isError());

        return i;
    }

    private void alterarEquipa(String nomeDaequipa){ //Tem que dar print no view
        NewMenu menuEquipa = new NewMenu(new String[] {"Lista de jogadores",
                "Alterar a equipa de um jogador",
                "Mudar nome da equipa"});

        //registar os handlers
        menuEquipa.setHandler(1, () ->listaJogadores(nomeDaequipa));
        menuEquipa.setHandler(2, () ->alterarEquipaJogador(nomeDaequipa,escolhaJogador(nomeDaequipa)));
        menuEquipa.setHandler(3, () -> mudarNomeEquipa(nomeDaequipa));

        menuEquipa.run();
    }


    private void adicionarEquipa(){
        StringHandler sh = new StringHandler();
        sh.readString("Ensira o nome da sua equipa:");
        this.model.addicionaEquipa(new Equipa(sh.getLine()));
    }

    private void listaJogadores(String nomeDaEquipa){
        List<String> jogadores=this.model.getEquipas().get(nomeDaEquipa).getJogadores()
                                   .stream().map(Jogador::toString).collect(Collectors.toList());
        StringHandler.printStrings(jogadores);
    }
    private void alterarEquipaJogador(String nomeDaEquipa,int numeroJogador){
        StringHandler.printString("escolha a equipa onde pretende colocar o jogador");
        String novaEquipa = escolhaEquipa();
        try {
            this.model.alteraJodadorDeEquipa(numeroJogador,nomeDaEquipa,novaEquipa);
        } catch (JogadorInexistenteExeption|NomeNaoExisteExceptions e) {
            e.printStackTrace();
        }
    }

    private void mudarNomeEquipa(String nomeAtual){
        StringHandler sh= new StringHandler();
        sh.readString("Novo nome da equipa:");
        try {
            String s=sh.getLine();
            this.model.mudaNomeDeUmaEquipa(nomeAtual,s);
        }
        catch (NomeJaExisteException|NomeNaoExisteExceptions e) {e.printStackTrace();}
    }

}