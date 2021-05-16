import java.io.IOException;

public class ClearConsul {
    /**
     *  Clears Screen in java
     */
    public static void cls() {

        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
            System.out.print("");
        }
    } /**
     *  Clears Screen in java on go to next line
     */
    public static void clsLn() {

        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {System.out.print("");
        }finally {
            System.out.println();
        }
    }

}
