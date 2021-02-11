
package Aula_01_Basico;

import java.util.Scanner;

/**
 * @author ferreira
 */

public class Ex05_consumoMedioCombustivel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite a distancia percorrida em km: ");
        double distancia = in.nextDouble();
        
        System.out.print("Digite a quantidade de combustivel consumida em litros: ");
        double combustivel = in.nextDouble();
        
        System.out.printf("Seu consumo medio foi %.2f.\n", (distancia / combustivel));
    }
}
