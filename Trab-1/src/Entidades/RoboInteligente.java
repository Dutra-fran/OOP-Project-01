package Entidades;

import java.util.Random;

import Exceptions.MovimentoInvalidoException;

public class RoboInteligente extends Robo {
    private boolean cache;
    private Random random;

    public RoboInteligente(String cor){
        super(cor);
        cache = false;
        random = new Random();
    }

    public boolean mover(int movimento) {
        switch(movimento){
            case 1:
                try{
                    setPosEixoY(posEixoY - 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX, posEixoY - 1));
                    cache = true;
                    return false;
                }
                break;
            case 2:
                try{
                    setPosEixoY(posEixoY + 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX, posEixoY + 1));
                    cache = true;
                    return false;
                }
                break;
            case 3:
                try{
                    setPosEixoX(posEixoX + 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX + 1, posEixoY));
                    cache = true;
                    return false;
                }
                break;
            case 4:
                try{
                    setPosEixoX(posEixoX - 1);
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX - 1, posEixoY));
                    cache = true;
                    return false;
                }
                break;
            default:
                return false;
        }

        while(cache){
            if(mover(random.nextInt(4) + 1)){
                cache = false;
                break;
            }
        }

        return true;
    }
}
