package ProjetoRobot_PEOO;

import java.util.Random;

public class RoboInteligente extends Robo{
    
    private boolean erro;
    private Random aleatorio;

    public RoboInteligente(String cor){
        super(cor);
        this.erro = false;
        this.aleatorio = new Random();
    }

    public boolean isErro() {
        return erro;
    }

    public void setMovimentoValido(boolean erro) {
        this.erro = erro;
    }

    public Random getAleatorio() {
        return aleatorio;
    }

    public void setAleatorio(Random aleatorio) {
        this.aleatorio = aleatorio;
    }

    @Override
    public int mover(int direcao)throws MovimentoInvalidoException{
        
        try{
            super.mover(direcao);
                             //Ele vai tentar uma vez executar o metodo "mover", caso ele falhe e entre na exceção, a booleana
        }                                           //de verificação de erro vai passar a ser verdadeira. Em seguida, enquanto o a verificadora for verdadeira
        catch(MovimentoInvalidoException m){        // ela vai tentar executar novamente o método de forma aleatória, até o movimento ser válido;
              
            if(!this.erro){
                this.erro = true;
                throw m;
            }

            while(this.erro){
                try{
                    super.mover(aleatorio.nextInt(4) + 1);
                    acuJogadas++;
                    this.erro = false;
                }
                catch(MovimentoInvalidoException e){        //apenas para o código não quebrar;

                }
            }
        }
        return acuJogadas;
    }


}
