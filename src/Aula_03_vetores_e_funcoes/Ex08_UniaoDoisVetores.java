
package Aula_03_vetores_e_funcoes;

import static Aula_03_vetores_e_funcoes.Ex01_InverterNumeroComFuncao.leInteiroPositivo;
import static Aula_03_vetores_e_funcoes.Ex02_MaiorDoVetor.exibeVetor;
import static Aula_03_vetores_e_funcoes.Ex02_MaiorDoVetor.leVetorAleatorio;
import static Aula_03_vetores_e_funcoes.Ex04_BuscaLinear.buscaLinear;

public class Ex08_UniaoDoisVetores {
    public static void main(String[] args) {
        int dimensao1 = leInteiroPositivo();
        int vetor1[] = leVetorAleatorio(dimensao1);
        System.out.print("Elementos do vetor1: ");
        exibeVetor(vetor1);
        
        System.out.println("");
        
        int dimensao2 = leInteiroPositivo();
        int vetor2[] = leVetorAleatorio(dimensao2);
        System.out.print("Elementos do vetor2: ");
        exibeVetor(vetor2);
        
        int uniao[] = new int[dimensao1 + dimensao2];
        int tamanho = uniaoVetores(uniao, vetor1, vetor2);
        
        System.out.print("\n\nElementos do vetor unido: ");
        exibeVetorTamanho(uniao, tamanho);
        System.out.println("");
    }

    public static int uniaoVetores(int uniao[], int vetor1[], int vetor2[]) {
        int k = 0;  // quantidade
        
        for (int i=0; i < vetor1.length; i++) {
            if (buscaLinear(uniao, vetor1[i]) == -1) {
                uniao[k] = vetor1[i];
                k++;
            }
        }
        
        for (int i=0; i < vetor2.length; i++) {
            if (buscaLinear(uniao, vetor2[i]) == -1) {
                uniao[k] = vetor2[i];
                k++;
            }
        }
        return k;
    }
    
    public static void exibeVetorTamanho(int vetor[], int k) {  // retorna um vetor de inteiros, com k posicoes.
        for (int i=0; i < k; i++) 
            System.out.print(vetor[i] + " ");
    }
}
