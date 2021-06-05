import java.util.List;
import java.util.Scanner;

public class StringHandler {
    String line;
    boolean quit;
    boolean error;

    public StringHandler() {
        this.line = "";
        this.quit= false;
        this.error=false;
    }

    public void readString(String mensagem) {
        if (error) System.out.print("Opção invalida tente outra vez\n");
        Scanner is = new Scanner(System.in);
        if (quit) System.out.print("Escreva '-1' caso queira sair\n");
        System.out.print(mensagem);
        String s=is.nextLine();
        this.line=s;
    }

    public void resetString() {
        this.line = "";
        this.quit= false;
        this.error=false;
    }

    public static void printStrings(List<String> strings){
        for(int i=0;i<strings.size();i++){
            System.out.println("Indice "+i+":"+strings.get(i)+"\n");
        }
    }

    public static void printString(String s){
        System.out.println(s);
    }


    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public boolean isQuit() {
        return quit;
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
