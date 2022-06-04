package Entidades;

public class GraficoPosicao {
    private int posEixoXComida;
    private int posEixoYComida;
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CIANO = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public GraficoPosicao(int posEixoXComida, int posEixoYComida){
        this.posEixoXComida = posEixoXComida;
        this.posEixoYComida = posEixoYComida;
    }

    public void RoboPosicao(Robo robo){
        for(int i=0; i < 5; i++) {
            for(int j=0; j < 5; j++) {
                if(robo.getPosEixoX() == j && robo.getPosEixoY() == i) {
                    System.out.print(ANSI_CIANO + "R   " + ANSI_RESET);
                } else if(posEixoXComida == j && posEixoYComida == i) {
                    System.out.print(ANSI_GREEN + "C   " + ANSI_RESET);
                }
                else {
                    System.out.print("*   ");
                }
            }
            System.out.println();
        }
    }

    public void RoboPosicao(Robo r1, Robo r2){
        for(int i=0; i < 5; i++) {
            for(int j=0; j < 5; j++) {
                if(r1.getPosEixoX() == j && r1.getPosEixoY() == i && r2.getPosEixoX() == j && r2.getPosEixoY() == i) {
                    System.out.print(ANSI_BLUE + "R" + ANSI_RESET + ANSI_RED + "R  " + ANSI_RESET);
                } else if(r1.getPosEixoX() == j && r1.getPosEixoY() == i){
                    System.out.print(ANSI_BLUE + "R   " + ANSI_RESET);
                } else if(r2.getPosEixoX() == j && r2.getPosEixoY() == i){
                    System.out.print(ANSI_RED + "R   " + ANSI_RESET);
                } else if(posEixoXComida == j && posEixoYComida == i) {
                    System.out.print(ANSI_GREEN + "C   " + ANSI_RESET);
                } else {
                    System.out.print("*   ");
                }
            }
            System.out.println();
        }
    }
}
