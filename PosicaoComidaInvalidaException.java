package ProjetoRobot_PEOO;

public class PosicaoComidaInvalidaException extends Exception{
    
    public String toString(){
        return "A comida não pode ser colocada aqui, tente novamente! ";
    }
}
