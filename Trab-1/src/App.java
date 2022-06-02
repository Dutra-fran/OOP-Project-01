import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int posEixoXComida, posEixoYComida;

        System.out.println("Informe a posição X da comida: ");
        posEixoXComida = Integer.parseInt(scan.next());

        System.out.println("Informe a posição Y da comida: ");
        posEixoYComida = Integer.parseInt(scan.next());


        scan.close();
    }
}
