
package Aula_05_classes_objetos;

/**
 * @author david-ferreira
 */

public class Ponto {
    int x;  // Atributo da ordenada x.
    int y;

    public Ponto() {
        x = 0;
        y = 0;
    }

    public Ponto(int x, int y) {
        this.x = x;  // O this (isto) refere-se as variaveis dos atributos.
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public boolean igual(Ponto point) {
        return (this.x == point.x && this.y == point.y);
    }
    
    public void transladar(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    public double distancia(Ponto point) {
        double diferenca_x = Math.abs(point.x - this.x);
        double diferenca_y = Math.abs(point.y - this.y);
        
        double distancia = Math.pow(diferenca_x, 2) + Math.pow(diferenca_y, 2);
        distancia = Math.sqrt(distancia);
        
        return distancia;
    }
    
   /*
    * O Override é a sobrescrita (mais um conceito de polimorfismo).
    * O toString é um método da classe String, mas nesse caso, estou sobrescrevendo
    * esse método. O toString pode ser chamado explicitamente, ou apenas chamar o objeto com
    * o método toString nela.
    */
    
    @Override
    public String toString() {  
        return "Ponto = (" + x + ", " + y + ")";
    }       
}

