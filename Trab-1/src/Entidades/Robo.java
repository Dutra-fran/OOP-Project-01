package Entidades;

import Exceptions.MovimentoInvalidoException;

public class Robo {
    private int posEixoX;
    private int posEixoY;
    private String cor;

    public Robo(String cor){
        posEixoX = 0;
        posEixoY = 0;
        this.cor = cor;
    }

    public boolean mover(String movimento) {
        movimento = movimento.toLowerCase();

        switch(movimento){
            case "up":
                try{
                    setPosEixoY(posEixoY - 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX, posEixoY - 1));
                }
                break;
            case "down":
                try{
                    setPosEixoY(posEixoY + 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX, posEixoY + 1));
                }
                break;
            case "right":
                try{
                    setPosEixoX(posEixoX + 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX + 1, posEixoY));
                }
                break;
            case "left":
                try{
                    setPosEixoX(posEixoX - 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX - 1, posEixoY));
                }
                break;
            default:
                return false;
        }

        // retorna true msm depois de capturar uma exceção
        return true;
    }

    public boolean mover(int movimento) {
        switch(movimento){
            case 1:
                try{
                    setPosEixoY(posEixoY - 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX, posEixoY - 1));
                }
                break;
            case 2:
                try{
                    setPosEixoY(posEixoY + 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX, posEixoY + 1));
                }
                break;
            case 3:
                try{
                    setPosEixoX(posEixoX + 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX + 1, posEixoY));
                }
                break;
            case 4:
                try{
                    setPosEixoX(posEixoX - 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX - 1, posEixoY));
                }
                break;
            default:
                return false;
        }

        // retorna true msm depois de capturar uma exceção
        return true;
    }

    public boolean RobotFoundFood(int posEixoXComida, int posEixoYComida){
        if(posEixoX == posEixoXComida && posEixoY == posEixoYComida)
            return true;

        return false;
    }

    public String getPosEixoXY(){
        return "(" + posEixoX + ", " + posEixoY + ")";
    }

    public int getPosEixoX(){
        return posEixoX;
    }

    public int getPosEixoY(){
        return posEixoY;
    }

    public void setPosEixoX(int posEixoX) throws MovimentoInvalidoException {
        if(posEixoX > 2 || posEixoX < 0)
            throw new MovimentoInvalidoException();

        this.posEixoX = posEixoX;
    }

    public void setPosEixoY(int posEixoY) throws MovimentoInvalidoException {
        if(posEixoY > 2 || posEixoY < 0)
            throw new MovimentoInvalidoException();
        
        this.posEixoY = posEixoY;
    }
}
