import java.util.Random;
import java.util.Scanner;

import Entidades.Robo;
import Services.Cor;
import Services.GraficoPosicao;

public class App {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int escolha=0;

        System.out.println("Deseja visualizar qual questão?");
        System.out.println("\t1. Questão 1");
        System.out.println("\t2. Questão 2");
        System.out.println("\t3. Questão 3");

        try {
            escolha = Integer.parseInt(scan.next());
        } catch(NumberFormatException e){
            System.out.println("Insira um número inteiro para escolher a questão!");
        }

        switch(escolha){
            case 1:
                questao1();
                break;
            case 2:
                questao2();
                break;
            case 3:
                questao3();
                break;
            default:
                System.out.println("Opção inválida!");
        }

        scan.close();
    }

    public static void questao1() {
        // Questão 1
        Scanner scan = new Scanner(System.in);
        Robo robo=null;
        int posEixoXComida, posEixoYComida, cor;
        String movimento;

        System.out.println("Escolha uma cor:");
        Cor.catalogarCores();

        cor = Integer.parseInt(scan.next());
        robo = Cor.corRobo(robo, cor);

        while(true) {
            System.out.println("Informe a posição X da comida: ");
            posEixoXComida = Integer.parseInt(scan.next());

            if(posEixoXComida <= 4 && posEixoXComida >= 0)
                break;
        }

        while(true) {
            System.out.println("Informe a posição Y da comida: ");
            posEixoYComida = Integer.parseInt(scan.next());

            if(posEixoYComida <= 4 && posEixoYComida >= 0)
                break;
        }

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
            } else {
                System.out.println("Opção inválida!");
            }
        }

        scan.close();
    }

    public static void questao2(){
        // Questão 2
        Robo r1 = null, r2 = null;
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int posEixoXComida, posEixoYComida;
        int passosR1=0, passosR2=0;
        int cor;
        
        System.out.println("Escolha uma cor para o Robô 1:");
        Cor.catalogarCores();

        cor = Integer.parseInt(scan.next());
        r1 = Cor.corRobo(r1, cor);

        System.out.println();

        System.out.println("Escolha uma cor para o Robô 2:");
        Cor.catalogarCores();

        cor = Integer.parseInt(scan.next());
        r2 = Cor.corRobo(r2, cor);

        while(true) {
            System.out.println("Informe a posição X da comida: ");
            posEixoXComida = Integer.parseInt(scan.next());

            if(posEixoXComida <= 4 && posEixoXComida >= 0)
                break;
        }

        while(true) {
            System.out.println("Informe a posição Y da comida: ");
            posEixoYComida = Integer.parseInt(scan.next());

            if(posEixoYComida <= 4 && posEixoYComida >= 0)
                break;
        }

        GraficoPosicao grafico = new GraficoPosicao(posEixoXComida, posEixoYComida);

        while(true){
            if(r1.mover(random.nextInt(4) + 1)) {
                grafico.RoboPosicao(r1, r2);
                passosR1++;
            }

            System.out.println();

            if(r1.RobotFoundFood(posEixoXComida, posEixoYComida)){
                System.out.println(r1.getCor() + " encontrou a comida!");
                break;
            }

            try {
                Thread.sleep(900);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
            
            if(r2.mover(random.nextInt(4) + 1)) {
                grafico.RoboPosicao(r1, r2);
                passosR2++;
            }

            System.out.println();

            if(r2.RobotFoundFood(posEixoXComida, posEixoYComida)){
               System.out.println(r2.getCor() + " encontrou a comida!");
               break; 
            }

            try {
                Thread.sleep(900);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Números de passos do " + r1.getCor() +": " + passosR1);
        System.out.println("Números de erros do " + r1.getCor() +": " + r1.getErros());
        System.out.println("Números de passos do " + r2.getCor() + ": " + passosR2);
        System.out.println("Números de erros do " + r2.getCor() +": " + r2.getErros());

        scan.close();
    }

    public static void questao3() {
        // Questão 3
        Robo r1 = null, r2 = null;
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int posEixoXComida, posEixoYComida;
        int passosR1=0, passosR2=0;
        int cor;

        System.out.println("Escolha uma cor para o Robô NÃO inteligente:");
        Cor.catalogarCores();

        cor = Integer.parseInt(scan.next());
        r1 = Cor.corRobo(r1, cor);

        System.out.println("Escolha uma cor para o Robô inteligente:");
        Cor.catalogarCores();

        cor = Integer.parseInt(scan.next());
        r2 = Cor.corRobo(r2, cor);

        while(true) {
            System.out.println("Informe a posição X da comida: ");
            posEixoXComida = Integer.parseInt(scan.next());

            if(posEixoXComida <= 4 && posEixoXComida >= 0)
                break;
        }

        while(true) {
            System.out.println("Informe a posição Y da comida: ");
            posEixoYComida = Integer.parseInt(scan.next());

            if(posEixoYComida <= 4 && posEixoYComida >= 0)
                break;
        }

        GraficoPosicao grafico = new GraficoPosicao(posEixoXComida, posEixoYComida);

        while(true){
            if(r1.mover(random.nextInt(4) + 1)) {
                grafico.RoboPosicao(r1, r2);
                passosR1++;
            }

            System.out.println();

            if(r1.RobotFoundFood(posEixoXComida, posEixoYComida)){
                System.out.println(r1.getCor() + " encontrou a comida!");
                break;
            }

            try {
                Thread.sleep(900);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
            
            if(r2.mover(random.nextInt(4) + 1)) {
                grafico.RoboPosicao(r1, r2);
                passosR2++;
            }

            System.out.println();

            if(r2.RobotFoundFood(posEixoXComida, posEixoYComida)){
               System.out.println(r2.getCor() + " encontrou a comida!");
               break; 
            }
        }
        System.out.println(r1.getCor() + " é o robô não inteligente, e o " + r2.getCor() + " é o robô inteligente.");
        System.out.println("Números de passos do " + r1.getCor() + ": " + passosR1);
        System.out.println("Números de erros do " + r1.getCor() + ": " + r1.getErros());
        System.out.println("Números de passos do " + r2.getCor() + ": " + passosR2);
        System.out.println("Números de erros do " + r2.getCor() + ": " + r2.getErros());

        scan.close();
    }
}