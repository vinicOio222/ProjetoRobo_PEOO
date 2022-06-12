package ProjetoRobot_PEOO;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class ThirdPrincipal {
    public static void main(String[] args){
        Scanner key = new Scanner(System.in);
        ArrayList <Robo> listaRobos = new ArrayList<Robo>();

        Random moves = new Random();
        System.out.println("\t\tBem-vindo(a) a Bot Race(Modo: Normal vs Inteligente)\n");
        
        System.out.println("Insira a cor do Robô Inteligente: ");
        listaRobos.add(new RoboInteligente(key.next()));

        System.out.println("Insira a cor do Robô Comum: ");
        listaRobos.add(new Robo(key.next()));

        while(true){  //setar a comida;
            try{
                System.out.println("Digite a posição da comida do Robô " + listaRobos.get(0).getCor() + ":");
                listaRobos.get(0).posicionarComida(key.nextInt(), key.nextInt()); //caso o try não funcione, ele vai direto para catch, sem passar no break;
                break;
            }
            catch(PosicaoComidaInvalidaException movimento){
                System.out.println("\n" + movimento + "\n");
            }
        }

        while(true){  //setar a comida
            try{
                System.out.println("Digite a posição da comida do Robô " + listaRobos.get(1).getCor() + ":");
                listaRobos.get(1).posicionarComida(key.nextInt(), key.nextInt()); //caso o try não funcione, ele vai direto para catch, sem passar no break;
                break;
            }
            catch(PosicaoComidaInvalidaException movimento){
                System.out.println("\n" + movimento + "\n");
            }
        }
        
        System.out.println(" ");

        listaRobos.get(0).showBoard();

        System.out.println(" ");

        listaRobos.get(1).showBoard();

        System.out.println(" ");

        while(!listaRobos.get(0).verifyComida() && !listaRobos.get(1).verifyComida()){ 
                                             //enquanto nenhum dos dois chega na comida, eles se movem;"

            try{
                listaRobos.get(0).mover(moves.nextInt(4) + 1);
                listaRobos.get(1).mover(moves.nextInt(4) + 1);
            }
            catch(MovimentoInvalidoException index){
                System.out.println("\n" + index + "\n");
            }
            try{
                Thread.sleep(2500);
            }catch (InterruptedException e){

            }

            listaRobos.get(0).showBoard();
            
            System.out.println(" ");
            
            listaRobos.get(1).showBoard();
            
            System.out.println(" ");

            if(listaRobos.get(0).verifyComida() != true){
                System.out.println(listaRobos.get(0).getCor() + " não conseguiu chegar na comida! \n");
            }
            else{
                System.out.println(listaRobos.get(0).getCor() + "  chegou à comida! \n");
            }

            if(listaRobos.get(1).verifyComida() != true){
                System.out.println(listaRobos.get(1).getCor() + " não conseguiu chegar na comida! \n");
            }
            else{
                System.out.println(listaRobos.get(1).getCor() + " chegou na comida! \n");
            }

        }
        
        listaRobos.get(0).showAcuJogadas();
        
        System.out.println(" ");
        
        listaRobos.get(1).showAcuJogadas();
        key.close();
    }
}

