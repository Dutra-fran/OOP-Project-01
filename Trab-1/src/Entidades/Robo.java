package Entidades;

import Exceptions.MovimentoInvalidoException;
import Services.Cor;

public class Robo {
    protected int posEixoX;
    protected int posEixoY;
    protected int erros=0;

    protected String cor;

    public Robo(String cor){
        posEixoX = 0;
        posEixoY = 0;
        this.cor = cor + "R" + Cor.ANSI_RESET;
    }

    public boolean mover(String movimento) {
        try {
            if(mover(Integer.parseInt(movimento)))
                return true;
        } catch(Exception e) { }
        movimento = movimento.toLowerCase();

        switch(movimento){
            case "up":
                try{
                    setPosEixoY(posEixoY - 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX, posEixoY - 1));
                    erros++;
                }
                break;
            case "down":
                try{
                    setPosEixoY(posEixoY + 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX, posEixoY + 1));
                    erros++;
                }
                break;
            case "right":
                try{
                    setPosEixoX(posEixoX + 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX + 1, posEixoY));
                    erros++;
                }
                break;
            case "left":
                try{
                    setPosEixoX(posEixoX - 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX - 1, posEixoY));
                    erros++;
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
                    erros++;
                }
                break;
            case 2:
                try{
                    setPosEixoY(posEixoY + 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX, posEixoY + 1));
                    erros++;
                }
                break;
            case 3:
                try{
                    setPosEixoX(posEixoX + 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX + 1, posEixoY));
                    erros++;
                }
                break;
            case 4:
                try{
                    setPosEixoX(posEixoX - 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX - 1, posEixoY));
                    erros++;
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
        if(posEixoX > 4 || posEixoX < 0) {
            throw new MovimentoInvalidoException();
        } else {
            this.posEixoX = posEixoX;
        }
    }

    public void setPosEixoY(int posEixoY) throws MovimentoInvalidoException {
        if(posEixoY > 4 || posEixoY < 0) {
            throw new MovimentoInvalidoException();
        } else {
            this.posEixoY = posEixoY;
        }
    }

    public String getCor(){
        return cor;
    }

    public int getErros() {
        return erros;
    }
}