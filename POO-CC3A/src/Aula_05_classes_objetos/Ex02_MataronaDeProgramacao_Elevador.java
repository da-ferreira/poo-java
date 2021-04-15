
package Aula_05_classes_objetos;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author david-ferreira
 */

// TODO: TA ERRADO A LOGICA MATEMATICA

public class Ex02_MataronaDeProgramacao_Elevador {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        while (true) {
            String entrada[] = in.nextLine().split(" ");

            int largura_elevador = Integer.parseInt(entrada[0]);
            int comprimento_elevador = Integer.parseInt(entrada[1]); 
            int raio1 = Integer.parseInt(entrada[2]);
            int raio2 = Integer.parseInt(entrada[3]);
            
            if (largura_elevador == 0 && comprimento_elevador == 0 && raio1 == 0 && raio2 == 0) {
                break;  // Saindo o loop.
            }

            int maior = (largura_elevador >= comprimento_elevador) ? largura_elevador : comprimento_elevador;
            double diagonal = Math.sqrt(Math.pow(largura_elevador, 2) + Math.pow(comprimento_elevador, 2));

            System.out.println(diagonal);

            char resposta;

            if (((raio1 * 2) + (raio2 * 2)) <= maior) {
                resposta = 'S';
            }
            else if (((raio1 * 2) + (raio2 * 2)) <= diagonal) {
                resposta = 'S';
            }
            else {
                resposta = 'N';
            }

            System.out.println(resposta);
        }
    }
}

