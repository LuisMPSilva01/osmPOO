import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TextUI {
    // o modelo
    private Liga model;
    private NewGame model2;

    //scanner
    private final Scanner sc;

    /**
     * Construtor que cria os menus e o model
     */

    public TextUI() throws LinhaIncorretaException {
        this.model = new Liga();
        this.model2 = new NewGame();
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
                "Adicionar equipa",
                "Fazer um jogo"});

        //registar os handlers
        menuLiga.setHandler(1, this::listaEquipas);
        menuLiga.setHandler(2, () -> alterarEquipa(escolhaEquipa("")));
        menuLiga.setHandler(3, this::adicionarEquipa);
        menuLiga.setHandler(4, () -> {
            makeFormacao(escolhaEquipa("Escolha a equipa da casa:"),"casa");
            makeFormacao(escolhaEquipa("Escolha a equipa de fora:"),"fora");
            executarJogo(LocalDate.now());
        });

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

    private String escolhaEquipa(String msg){
        List<String> strings = this.model.nomeDasEquipas();
        StringHandler h = new StringHandler();
        if (!msg.equals("")) StringHandler.printString(msg);
        int i;
        do {
            StringHandler.printStrings(strings,true);
            h.readString("Ensira o numero da equipa que pretende escolher: ");
            i=Integer.parseInt(h.getLine());
            h.setError(!(i > 0 && i < strings.size()));
        } while (h.isError());

        return strings.get(i);
    }

    private int escolhaJogador(List<Jogador> jogadors){
        StringHandler h = new StringHandler();
        int i;
        do {
            listaJogadores(jogadors);
            h.readString("Ensira o numero do jogador que pretende escolher: ");
            i=Integer.parseInt(h.getLine());
            int finalI = i;
            h.setError(jogadors.stream().noneMatch(j -> j.get_numeroJogador() == finalI));
        } while (h.isError());

        return i;
    }

    private void alterarEquipa(String nomeDaequipa){ //Tem que dar print no view
        NewMenu menuEquipa = new NewMenu(new String[] {"Lista de jogadores",
                "Alterar a equipa de um jogador",
                "Mudar nome da equipa",
                "Criar novo jogador"});
        menuEquipa.addSaida(3);
        //registar os handlers
        menuEquipa.setHandler(1, () ->listaJogadores(model.getEquipas().get(nomeDaequipa).getJogadores()));
        menuEquipa.setHandler(2, () ->alterarEquipaJogador(nomeDaequipa,escolhaJogador(model.getEquipas().get(nomeDaequipa).getJogadores())));
        menuEquipa.setHandler(3, () -> { mudarNomeEquipa(nomeDaequipa); });
        menuEquipa.setHandler(4, () -> makeNewPlayer(nomeDaequipa));

        menuEquipa.run();
    }


    private void adicionarEquipa(){
        StringHandler sh = new StringHandler();
        sh.readString("Ensira o nome da sua equipa:");
        this.model.addicionaEquipa(new Equipa(sh.getLine()));
    }

    private void listaJogadores(List<Jogador> jogadors){
        List<String> jogadores=jogadors.stream().map(Jogador::toString).collect(Collectors.toList());
        StringHandler.printStrings(jogadores,false);
    }
    private void alterarEquipaJogador(String nomeDaEquipa,int numeroJogador){
        StringHandler.printString("escolha a equipa onde pretende colocar o jogador");
        String novaEquipa = escolhaEquipa("");
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

    public void makeNewPlayer(String nomeDaequipa) {
        NewMenu menuCriadorJogador = new NewMenu(new String[] {"Avancado",
                "Defesa",
                "Lateral",
                "Medio",
                "GuardaRedes"});

        //registar os handlers
        menuCriadorJogador.setHandler(1, () -> {
            try {
                model.addJogador(nomeDaequipa,PlayerByIO.criaAvancado());
            } catch (NomeNaoExisteExceptions nomeNaoExisteExceptions) {
                nomeNaoExisteExceptions.printStackTrace();
            }
        });
        menuCriadorJogador.setHandler(2, () -> {
            try {
                model.addJogador(nomeDaequipa,PlayerByIO.criaDefesa());
            } catch (NomeNaoExisteExceptions nomeNaoExisteExceptions) {
                nomeNaoExisteExceptions.printStackTrace();
            }
        });
        menuCriadorJogador.setHandler(3, () -> {
            try {
                model.addJogador(nomeDaequipa,PlayerByIO.criaLateral());
            } catch (NomeNaoExisteExceptions nomeNaoExisteExceptions) {
                nomeNaoExisteExceptions.printStackTrace();
            }
        });
        menuCriadorJogador.setHandler(4, () -> {
            try {
                model.addJogador(nomeDaequipa,PlayerByIO.criaMedio());
            } catch (NomeNaoExisteExceptions nomeNaoExisteExceptions) {
                nomeNaoExisteExceptions.printStackTrace();
            }
        });
        menuCriadorJogador.setHandler(5, () -> {
            try {
                model.addJogador(nomeDaequipa,PlayerByIO.criaGuardaRedes());
            } catch (NomeNaoExisteExceptions nomeNaoExisteExceptions) {
                nomeNaoExisteExceptions.printStackTrace();
            }
        });

        menuCriadorJogador.run();
    }

    public void makeFormacao(String team,String local) {
        NewMenu menuFormacao = new NewMenu(new String[] {"1-4-3-3",
                "1-4-4-2",
                "1-4-2-4"});
        menuFormacao.addSaida(1);
        menuFormacao.addSaida(2);
        menuFormacao.addSaida(3);
        //registar os handlers
        menuFormacao.setHandler(1, () -> setEquipa("1433",team,local));
        menuFormacao.setHandler(2, () -> setEquipa("1442",team,local));
        menuFormacao.setHandler(3, () -> setEquipa("1424",team,local));

        menuFormacao.run();
    }
    public void setEquipa(String formacao,String team,String local){
        switch (formacao) {
            case "1433":
                try {
                    if(local.equals("casa")) model2.setEquipaCasa(new formacao1433(model.getEquipas().get(team).getJogadores(), team));
                    else if(local.equals("fora")) model2.setEquipaFora(new formacao1433(model.getEquipas().get(team).getJogadores(), team));
                } catch (NotEnoughPlayerException e) {
                    e.printStackTrace();
                    makeFormacao(team,local);
                }
                break;
            case "1442":
                try {
                    if(local.equals("casa")) model2.setEquipaCasa(new formacao1442(model.getEquipas().get(team).getJogadores(),team));
                    else if(local.equals("fora")) model2.setEquipaFora(new formacao1442(model.getEquipas().get(team).getJogadores(),team));
                } catch (NotEnoughPlayerException e) {
                    e.printStackTrace();
                    makeFormacao(team,local);
                }
                break;
            case  "1424":
                try {
                    if(local.equals("casa")) model2.setEquipaCasa(new formacao1424(model.getEquipas().get(team).getJogadores(),team));
                    else if(local.equals("fora")) model2.setEquipaFora(new formacao1424(model.getEquipas().get(team).getJogadores(),team));
                } catch (NotEnoughPlayerException e) {
                    e.printStackTrace();
                    makeFormacao(team,local);
                }
        }
    }

    public void executarJogo(LocalDate d) {
        if (model2.getEquipaFora()==null){
            model2= new NewGame();
            return;
        }
        model2.setDataDoJogo(d);
        StringHandler.printStrings(model2.firstHalf(),false);
        substituicoes();
        StringHandler.printStrings(model2.secondHalf(),false);
        model2= new NewGame();
    }

    public void substituicoes() {
        NewMenu menuFormacao = new NewMenu(new String[] {"Fazer substituicoes em casa",
                "Fazer substituicoes fora"});

        //registar os handlers
        menuFormacao.setHandler(1, this::substituicoesCasa);
        menuFormacao.setHandler(2, this::substituicoesFora);
        menuFormacao.run();
    }

    public void substituicoesCasa() {
        if (model2.getEquipaCasa().getSubsDisponiveis()<=0){
            StringHandler.printString("Não tem mais substituições disponiveis");
        }
        else {
            StringHandler sh = new StringHandler();
            do {
                if (sh.error) StringHandler.printString("Substituicao Invalida,tente outra vez");
                StringHandler.printString("Jogador que pretende retirar ↓");
                int antigo=escolhaJogador(model2.getEquipaCasa().getInicial());
                StringHandler.printString("Jogador que pretende enserir ↓");
                int novo=escolhaJogador(model2.getEquipaCasa().getSuplentes());
                try {
                    model2.makeSubstituicoesCasa(novo,antigo);
                    sh.setError(false);
                } catch (JogadorInexistenteExeption|PosicaoInvalidaException e) {
                    e.printStackTrace();
                    sh.setError(true);
                }
            } while (sh.error);
        }
    }

    public void substituicoesFora() {
        if (model2.getEquipaFora().getSubsDisponiveis()<=0){
            StringHandler.printString("Não tem mais substituições disponiveis");
        }
        else {
            StringHandler sh = new StringHandler();
            do {
                if (sh.error) StringHandler.printString("Substituicao Invalida,tente outra vez");
                StringHandler.printString("Jogador que pretende retirar ↓");
                int antigo=escolhaJogador(model2.getEquipaFora().getInicial());
                StringHandler.printString("Jogador que pretende enserir ↓");
                int novo=escolhaJogador(model2.getEquipaFora().getSuplentes());
                try {
                    model2.makeSubstituicoesFora(novo,antigo);
                    sh.setError(false);
                } catch (JogadorInexistenteExeption|PosicaoInvalidaException e) {
                    e.printStackTrace();
                    sh.setError(true);
                }
            } while (sh.error);
        }
    }
}