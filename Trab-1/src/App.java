import java.util.Scanner;
import Entidades.*;
import java.util.Random;

public class App {
    public static void main(String[] args){
        //questao1();
        //questao2();
        questao3();
    }

    public static void questao1() {
        // Questão 1
        // Fazer um switch case, perguntando a cor do Robô
        Scanner scan = new Scanner(System.in);
        Robo robo = new Robo("ciano");
        int posEixoXComida, posEixoYComida;
        String movimento;

        System.out.println("Informe a posição X da comida: ");
        posEixoXComida = Integer.parseInt(scan.next());

        System.out.println("Informe a posição Y da comida: ");
        posEixoYComida = Integer.parseInt(scan.next());

        System.out.println();

        GraficoPosicao grafico = new GraficoPosicao(posEixoXComida, posEixoYComida);
        grafico.RoboPosicao(robo);
        System.out.println();

        while(true){    
            System.out.println("Movimentos válidos:");
            System.out.println("\t1. up");
            System.out.println("\t2. down");
            System.out.println("\t3. right");
            System.out.println("\t4. left");

            System.out.println("\nQual seu próximo movimento: ");
            movimento = scan.next();

            System.out.println();

            if(robo.mover(movimento)) {
                grafico.RoboPosicao(robo);
                if(robo.RobotFoundFood(posEixoXComida, posEixoYComida)){
                    System.out.println("Comida encontrada!");
                    break;
                }
            }
        }

        scan.close();
    }

    public static void questao2(){
        Robo r1 = new Robo("Azul"), r2 = new Robo("Vermelho");
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int posEixoXComida, posEixoYComida;
        int passosR1=0, passosR2=0;
        

        System.out.println("Informe a posição X da comida: ");
        posEixoXComida = Integer.parseInt(scan.next());

        System.out.println("Informe a posição Y da comida: ");
        posEixoYComida = Integer.parseInt(scan.next());

        GraficoPosicao grafico = new GraficoPosicao(posEixoXComida, posEixoYComida);

        while(true){
            if(r1.mover(random.nextInt(4) + 1)) {
                grafico.RoboPosicao(r1, r2);
                passosR1++;
            }

            System.out.println();

            if(r1.RobotFoundFood(posEixoXComida, posEixoYComida)){
                System.out.println("Robô 1 encontrou a comida!");
                break;
            }
            
            if(r2.mover(random.nextInt(4) + 1)) {
                grafico.RoboPosicao(r1, r2);
                passosR2++;
            }

            System.out.println();

            if(r2.RobotFoundFood(posEixoXComida, posEixoYComida)){
               System.out.println("Robô 2 encontrou a comida!");
               break; 
            }
        }

        System.out.println("Números de passos do " + GraficoPosicao.ANSI_BLUE + "Robô 1" + GraficoPosicao.ANSI_RESET + ": " + passosR1);
        System.out.println("Números de passos do " + GraficoPosicao.ANSI_RED + "Robô 2" + GraficoPosicao.ANSI_RESET + ": " + passosR2);

        scan.close();
    }

    public static void questao3(){
        Robo r1 = new Robo("Azul"), r2 = new RoboInteligente("Vermelho");
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int posEixoXComida, posEixoYComida;
        int passosR1=0, passosR2=0;
        

        System.out.println("Informe a posição X da comida: ");
        posEixoXComida = Integer.parseInt(scan.next());

        System.out.println("Informe a posição Y da comida: ");
        posEixoYComida = Integer.parseInt(scan.next());

        GraficoPosicao grafico = new GraficoPosicao(posEixoXComida, posEixoYComida);

        while(true){
            if(r1.mover(random.nextInt(4) + 1)) {
                grafico.RoboPosicao(r1, r2);
                passosR1++;
            }

            System.out.println();

            if(r1.RobotFoundFood(posEixoXComida, posEixoYComida)){
                System.out.println("Robô não inteligente encontrou a comida!");
                break;
            }
            
            if(r2.mover(random.nextInt(4) + 1)) {
                grafico.RoboPosicao(r1, r2);
                passosR2++;
            }

            System.out.println();

            if(r2.RobotFoundFood(posEixoXComida, posEixoYComida)){
               System.out.println("Robô Inteligente encontrou a comida!");
               break; 
            }
        }

        System.out.println("Números de passos do " + GraficoPosicao.ANSI_BLUE + "Robô não inteligente" + GraficoPosicao.ANSI_RESET + ": " + passosR1);
        System.out.println("Números de passos do " + GraficoPosicao.ANSI_RED + "Robô Inteligente" + GraficoPosicao.ANSI_RESET + ": " + passosR2);

        scan.close();
    }
}
