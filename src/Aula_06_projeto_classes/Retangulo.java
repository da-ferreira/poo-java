
package Aula_06_projeto_classes;

/**
 * @author david-ferreira
 */

public class Retangulo {
    private double x;
    private double y;
    private double largura;
    private double altura;
    
    public Retangulo() {
        this(0.0, 0.0, 0.0, 0.0);  // Sobrecarga de construtor (polimorfismo)
    }
    
    public Retangulo(double x, double y, double largura, double altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getLargura() {
        return largura;
    }

    public double getAltura() {
        return altura;
    }

    public Object area() {
        return this.largura * this.altura;
    }

    public void transladar(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}
