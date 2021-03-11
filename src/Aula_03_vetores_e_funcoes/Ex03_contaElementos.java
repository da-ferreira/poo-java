
package Aula_03_vetores_e_funcoes;

import static Aula_03_vetores_e_funcoes.Ex01_InverterNumeroComFuncao.leInteiroPositivo;
import static Aula_03_vetores_e_funcoes.Ex02_MaiorDoVetor.exibeVetor;
import static Aula_03_vetores_e_funcoes.Ex02_MaiorDoVetor.leVetorAleatorio;
import java.util.Scanner;

public class Ex03_contaElementos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int dimensao = leInteiroPositivo();
        int vetor[] = leVetorAleatorio(dimensao);
         
        System.out.print("Elementos do vetor: ");
        exibeVetor(vetor);
        
        System.out.print("\nDigite o numero para buscar: ");
        int repetidos = in.nextInt();
        System.out.printf("\n%d aparece %d vezes no vetor\n.", repetidos, contaX(vetor, repetidos));
    }
    
    public static int contaX(int vetor[], int x) {
        int quantidade = 0;
        
        for (int i: vetor)
            if (i == x)
                quantidade++;
        
        return quantidade;
    }
}
