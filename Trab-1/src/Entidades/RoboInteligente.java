package Entidades;

import Exceptions.MovimentoInvalidoException;

public class RoboInteligente extends Robo {
    private int cache;

    public RoboInteligente(String cor){
        super(cor);
        cache = 0;
    }

    public boolean mover(int movimento) {
        if(acertarMovimento(cache) && cache != 0) {
            erros++;
            return true;
        }

        switch(movimento){
            case 1:
                try{
                    setPosEixoY(posEixoY - 1);
                    cache = 0;
                    return true;
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX, posEixoY - 1));
                    cache = 1;
                }
            case 2:
                try{
                    setPosEixoY(posEixoY + 1);
                    cache = 0;
                    return true;
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX, posEixoY + 1));
                    cache = 2;
                }
            case 3:
                try{
                    setPosEixoX(posEixoX + 1);
                    cache = 0;
                    return true;
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX + 1, posEixoY));
                    cache = 3;
                }
            case 4:
                try{
                    setPosEixoX(posEixoX - 1);
                    cache = 0;
                    return true;
                } catch(MovimentoInvalidoException e) {
                    System.out.println(e.toString(posEixoX - 1, posEixoY));
                    cache = 4;
                }
        }
        
        return false;
    }

    public boolean acertarMovimento(int cache){
        if(cache == 1)
            return mover(2);

        if(cache == 2)
            return mover(1);

        if(cache == 3)
            return mover(4);

        if(cache == 4)
            return mover(3);

        return false;
    }
}