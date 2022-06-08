package Exceptions;

public class MovimentoInvalidoException extends Exception {
    public String toString(int posEixoX, int posEixoY){
        return "Movimento inválido! Movimento: (" + posEixoX + ", " + posEixoY + ")";
    }
}