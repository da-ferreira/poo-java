
package Aula_08_Relacionamento;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author david-ferreira
 */

public class Exemplo_Senha_Regex {
    public static void main(String[] args) {
        String password = "azk9963";  
        boolean bool = password.matches("[a-zA-Z]{3}[0-9]{4}+");  // Senha com 3 letras iniciais e 4 numeros finais.
        System.out.println(bool);
        
        /* Usando classes Pattern e Matcher e tem 3 formas: */
        
        // Forma 1
        Pattern p = Pattern.compile("[a-zA-Z]{3}[0-9]{4}+");
        Matcher m = p.matcher(password);
        System.out.println(m.matches());
        
        
    }
}
