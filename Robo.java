package ProjetoRobot_PEOO;

import java.util.Arrays;

public class Robo{

    protected int robo;
    protected int comida;
    protected String cor;
    protected int posicao [][] = new int [5][5];
    protected int line;
    protected int column;
    protected int acuJogadas;

    public Robo(String cor){
        this.acuJogadas = 0;
        this.line = 0;
        this.column = 0;
        this.robo = 1;
        this.comida = 2;
        this.cor = cor;
        this.posicao[line][column] = this.robo;
    }

    public int[][] getPosicao() {
        return posicao;
    }

    public void setPosicao(int[][] posicao) {
        this.posicao = posicao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getComida() {
        return comida;
    }

    public void setComida(int comida) {
        this.comida = comida;
    }

    public int getAcuJogadas() {
        return acuJogadas;
    }

    public void setAcuJogadas(int acuJogadas) {
        this.acuJogadas = acuJogadas;
    }

    public void posicionarComida(int linha, int coluna) throws PosicaoComidaInvalidaException{
        if(linha < this.posicao.length && coluna < this.posicao.length && linha >= 0 && coluna >= 0){
            if(this.posicao[linha][coluna] == 0){                   //limita o index as coordenadas do tabuleiro;
                this.posicao[linha][coluna] = comida;
                return;  //return serve para que o metodo execute sem entrar na exeção, 
                        //pois se a exceção fosse dentro de um else, 
                        //caso entrasse em um if e falhasse no outro, ele não entraria no else;
        }
    }
        throw new PosicaoComidaInvalidaException();
         
    }

    public int mover(String direcao) throws MovimentoInvalidoException{

        acuJogadas = 0;
        
        if(direcao.equals("up")){
            if(this.line > 0){
                this.line -= 1;
                this.posicao[line + 1][column] = 0;
                this.posicao[line][column] += 1;
                acuJogadas++;
            }
            else{
                throw new MovimentoInvalidoException();
            }
        }
        else if(direcao.equals("down")){
            if(this.line < this.posicao.length - 1){
                this.line += 1;
                this.posicao[line - 1][column] = 0;
                this.posicao[line][column] += 1;
                this.acuJogadas++;
            }
            else{
                throw new MovimentoInvalidoException();
            }
        }
        else if(direcao.equals("left")){
            if(this.column > 0){
                this.column -= 1;
                this.posicao[line][column + 1] = 0;
                this.posicao[line][column] += 1;
                this.acuJogadas++;
            }
            else{
                throw new MovimentoInvalidoException();
            }
        }
        else if(direcao.equals("right")){
            if(this.column < this.posicao.length - 1){
                this.column += 1;
                this.posicao[line][column - 1] = 0;
                this.posicao[line][column] += 1;
                this.acuJogadas++;
            }
            else{
                throw new MovimentoInvalidoException();
            }
        }
        return this.acuJogadas;

    }

    public void showBoard(){

        System.out.println("Robo " + getCor() + ":");
        
        System.out.println(" ");
        
        for(int i = 0; i < posicao.length; i++){
            for(int j = 0; j < posicao.length; j++){
                System.out.print(getPosicao()[i][j] + " ");
            }
            System.out.println();
        }
    }

    
    public int mover(int direcao) throws MovimentoInvalidoException{

        if(direcao == 1){  //cima;
            if(this.line > 0){
                this.line -= 1;
                this.posicao[line + 1][column] = 0;
                this.posicao[line][column] += 1;
                this.acuJogadas++;
            }
            else{
                throw new MovimentoInvalidoException();
            }
        }
        else if(direcao == 2){  //baixo;
            if(this.line < this.posicao.length - 1){
                this.line += 1;
                this.posicao[line - 1][column] = 0;
                this.posicao[line][column] += 1;
                this.acuJogadas++;
            }
            else{
                throw new MovimentoInvalidoException();
            }
        }
        else if(direcao == 3){  //esquerda;
            if(this.column > 0){
                this.column -= 1;
                this.posicao[line][column + 1] = 0;
                this.posicao[line][column] += 1;
                this.acuJogadas++;
            }
            else{
                throw new MovimentoInvalidoException();
            }
        }
        else if(direcao == 4){  //direita;
            if(this.column < this.posicao.length - 1){
                this.column += 1;
                this.posicao[line][column - 1] = 0;
                this.posicao[line][column] += 1;
                this.acuJogadas++;
            }
            else{
                throw new MovimentoInvalidoException();
            }
        }
        return this.acuJogadas;

    }

    public boolean verifyComida(){
        for(int i = 0; i < posicao.length; i++){
            for(int j = 0; j < posicao.length; j++){
                if(this.posicao[i][j] == 3){
                    return true;
                }
            }
        }
        return false;
    }


    public void showAcuJogadas(){
        System.out.println("O robo " + getCor() + " fez " + this.acuJogadas + " Jogadas");
    }

    @Override
    public String toString() {
        return "Robo [cor=" + cor + ", posicao=" + Arrays.toString(posicao) + "]";
    }

}