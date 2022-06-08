package Services;

import Entidades.Robo;
import Entidades.RoboInteligente;

public abstract class Cor {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CIANO = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static Robo corRobo(Robo robo, int cor){
        switch(cor){
            case 1:
                robo = new Robo(Cor.ANSI_BLUE);
                break;
            case 2:
                robo = new Robo(Cor.ANSI_GREEN);
                break;
            case 3:
                robo = new Robo(Cor.ANSI_CIANO);
                break;
            case 4:
                robo = new Robo(Cor.ANSI_RED);
                break;
            case 5:
                robo = new Robo(Cor.ANSI_BLACK);
                break;
            case 6:
                robo = new Robo(Cor.ANSI_YELLOW);
                break;
            case 7:
                robo = new Robo(Cor.ANSI_PURPLE);
                break;
            default:
                System.out.println("Opção inválida! A cor ciano será a cor padrão.");
                robo = new Robo(Cor.ANSI_CIANO);
        }

        return robo;
    }

    public static Robo corRoboInteligente(Robo robo, int cor){
        switch(cor){
            case 1:
                robo = new RoboInteligente(Cor.ANSI_BLUE);
                break;
            case 2:
                robo = new RoboInteligente(Cor.ANSI_GREEN);
                break;
            case 3:
                robo = new RoboInteligente(Cor.ANSI_CIANO);
                break;
            case 4:
                robo = new RoboInteligente(Cor.ANSI_RED);
                break;
            case 5:
                robo = new RoboInteligente(Cor.ANSI_BLACK);
                break;
            case 6:
                robo = new RoboInteligente(Cor.ANSI_YELLOW);
                break;
            case 7:
                robo = new RoboInteligente(Cor.ANSI_PURPLE);
                break;
            default:
                System.out.println("Opção inválida! A cor ciano será a cor padrão.");
                robo = new RoboInteligente(Cor.ANSI_CIANO);
        }

        return robo;
    }

    public static void catalogarCores(){
        System.out.println("\t1. Azul");
        System.out.println("\t2. Verde");
        System.out.println("\t3. Ciano");
        System.out.println("\t4. Vermelho");
        System.out.println("\t5. Preto");
        System.out.println("\t6. Amarelo");
        System.out.println("\t7. Roxo");
        System.out.println();
    }
}