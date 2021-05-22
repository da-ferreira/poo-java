
package Pacote_Fonte_v2;

import java.util.ArrayList;

/**
 * Classe para um estudante de pós-graduação
 * @author david-ferreira
 */

public class EstudantePos extends Estudante {
    protected String tema;
    protected String orientador;

    public EstudantePos(long id, String nome, String email, String tema, String orientador) {
        super(id, nome, email);
        this.tema = tema;
        this.orientador = orientador;
    }
    
    /** @return Total Créditos: Soma dos dos créditos (carga horária) das disciplinas. */
    @Override
    public int getTotalCreditos() {
        ArrayList<Disciplina> disciplinas = getDisciplinasMatriculadas();
        int total = 0;
        
        for (Disciplina discipline : disciplinas)
            total += discipline.getCreditos();
        
        return total;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }
}
 