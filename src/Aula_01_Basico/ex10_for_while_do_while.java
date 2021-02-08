
package Aula_01_Basico;

/**
 * @author ferreira
 */

public class ex10_for_while_do_while {
    public static void main(String[] args) {
        
        System.out.println("--- For ---");       
        
        for (int i=0; i <= 10; i++) {
            System.out.println(i);
        }
        
        System.out.println("--- while ---");
        int x = 1;
        
        // Estrutura while verifica a condição antes de executa-la.
        while (x < 5) {
            System.out.println(x);
            x++;
        }
        
        System.out.println("--- Do while ---");
        
        // Estrutura do while executa uma vez o bloco, depois
        // verifica se deve continuar, ou seja, se a condição
        // continua verdadeira
        x = 1;
        
        do {
            System.out.println(x);
            x++;
                    
        } while (x < 1);
    }
}
