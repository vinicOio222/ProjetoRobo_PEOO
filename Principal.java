package ProjetoRobot_PEOO;

import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args){
        
        String cor;
        Scanner key = new Scanner(System.in);

        System.out.println("\t\tBem-vindo(a) a Bot Maze\n\n*Ajude o robô a encontrar seu alimento.\n");
        System.out.println("Insira a cor do robô:");
        cor = key.nextLine();
        Robo b1 = new Robo(cor);
        
        while(true){
            try{
                System.out.println("Digite a posição da comida: ");
                b1.posicionarComida(key.nextInt(), key.nextInt()); //caso o try não funcione, ele vai direto para catch, sem passar no break;
                break;
            }
            catch(PosicaoComidaInvalidaException movimento){
                System.out.println("\n" + movimento + "\n");
            }
        }
        System.out.println();
        
        b1.showBoard();
        System.out.println(" ");

        System.out.println("Bot Controller:\n"
                              +"1 or 'up';\n"
                              +"2 or 'down';\n" 
                              +"3 or 'left';\n"
                              +"4 or 'right'\n");


        while(!b1.verifyComida()){
            boolean isInt = false;
            String operation = key.next();
            try{                                //primeiro try foi feito para verificar se a entrada é um inteiro ou uma string
                Integer.parseInt(operation);   //ou um inteiro, para então, no try catch seguinte, executar a ação de mover;
                isInt = true;
            }
            catch(Exception e){
                //apenas para impedir que quebre;
            }

            try{
                if(isInt){
                    b1.mover(Integer.parseInt(operation));
                }
                else {
                    b1.mover(operation);
                }
            }
            catch(MovimentoInvalidoException index){
                System.out.println("\n" + index + "\n");
            }

            b1.showBoard();
            System.out.println(" ");
            System.out.println("Bot Controller:\n"
                              +"1 or 'up';\n"
                              +"2 or 'down';\n"
                              +"3 or 'left';\n"
                              +"4 or 'right'\n");

            if(b1.verifyComida() != true){
                System.out.println("Não conseguiu chegar à comida!");
            }
            else{
                System.out.println("Parabéns! O Robô "+ b1.getCor()+" chegou à comida!");
            }

        }
        key.close();
    }
}
