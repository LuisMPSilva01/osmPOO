import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public int forceInt(int min,int max,String msg){
        Scanner is = new Scanner(System.in);
        int i;
        this.error=false;
        do {
            if (error) System.out.print("Numero invalido, tente outra vez\n");
            System.out.println("Ensira um numero de "+min+" a "+max);
            System.out.println(msg);
            i=is.nextInt();
            if (i<min||i>max) this.error=true;
            else this.error=false;
        } while (error);
        return i;
    }

    public static void printStrings(List<String> strings,boolean printIndice){
        for(int i=0;i<strings.size();i++){
            System.out.println((printIndice ? "Indice" + i + ":" : "") + strings.get(i) + "\n");
        }
    }

    public static Date readADate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ensira uma data com o formato: dd-mm-yyyy");
        String dataString = scanner.nextLine();
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(dataString);
        } catch (ParseException e) {
            e.printStackTrace();
            return readADate();
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
