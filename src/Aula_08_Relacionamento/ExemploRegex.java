
package Aula_08_Relacionamento;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author david-ferreira
 */

public class ExemploRegex {
    public static void main(String[] args) {
        // Usando a função matches() da classe String
        String str = "asa";
        boolean bool = str.matches("[a-z]+"); 
        System.out.println(bool);
        
        /* Usando classes Pattern e Matcher e tem 3 formas: */
        
        // Forma 1
        Pattern p = Pattern.compile("[a-z]+");
        Matcher m = p.matcher(str);
        boolean bool1 = m.matches();
        System.out.println(bool1);
        
        // Forma 2 (fazendo de forma direta)
        boolean bool2 = Pattern.compile("[a-z]+").matcher(str).matches();
        System.out.println(bool2);
        
        // Forma 3
        boolean bool3 = Pattern.matches("[a-z]+", str);
        System.out.println(bool3);
    }
}
