package Services;

import Entidades.Robo;

public class GraficoPosicao {
    private int posEixoXComida;
    private int posEixoYComida;

    public GraficoPosicao(int posEixoXComida, int posEixoYComida){
        this.posEixoXComida = posEixoXComida;
        this.posEixoYComida = posEixoYComida;
    }

    public void RoboPosicao(Robo robo){
        for(int i=0; i < 5; i++) {
            for(int j=0; j < 5; j++) {
                if(robo.getPosEixoX() == j && robo.getPosEixoY() == i) {
                    System.out.print(robo.getCor() + "   ");
                } else if(posEixoXComida == j && posEixoYComida == i) {
                    System.out.print(Cor.ANSI_GREEN + "C   " + Cor.ANSI_RESET);
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
                    System.out.print(r1.getCor() + r2.getCor() + "  ");
                } else if(r1.getPosEixoX() == j && r1.getPosEixoY() == i){
                    System.out.print(r1.getCor() + "   ");
                } else if(r2.getPosEixoX() == j && r2.getPosEixoY() == i){
                    System.out.print(r2.getCor() + "   ");
                } else if(posEixoXComida == j && posEixoYComida == i) {
                    System.out.print(Cor.ANSI_GREEN + "C   " + Cor.ANSI_RESET);
                } else {
                    System.out.print("*   ");
                }
            }
            System.out.println();
        }
    }
}