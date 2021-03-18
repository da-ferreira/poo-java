
package Aula_07_relacionamentos;

/**
 * @author david-ferreira
 */

public class Carro {
    private double combustivel;
    private double desempenho;  // Quantos km/litros o carro consegue andar.

    public Carro() {
        this(0, 14.0);
    }
    
    public Carro(double combustivel, double desempenho) {
        this.combustivel = combustivel;
        this.desempenho = desempenho;
    }
    
    public void encherTanque(Gasolina gasolina) {
        this.combustivel += gasolina.getLitros();
    }    
    
    public void encherTanque(Alcool alcool) {  // Sobrecarregando o método encherTanque
        this.combustivel += alcool.getLitros();
    }  
    
    /** @param distancia: Distancia andada pelo carro em Km */
    public void andar(double distancia) {
        this.combustivel -= distancia / desempenho;
    }

    public double getCombustivel() {
        return combustivel;
    }

    public double getDesempenho() {
        return desempenho;
    }

    
    
    
    
}
