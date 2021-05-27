
package Aula_15_Interface;

/**
 * @author david-ferreira
 */

public class Circulo implements FormaGeometrica {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }
    
    @Override
    public double areaCalculavel() {
        return Math.PI * raio * raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
}
 