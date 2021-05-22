
package Pacote_Fonte_v2;

import java.util.ArrayList;

/**
 * Classe para um estudante de graduação
 * @author david-ferreira
 */

public class EstudanteGrad extends Estudante {
    protected int horasAtividades;  // Horas de atividades complementares do estudante

    public EstudanteGrad(long id, String nome, String email, int horasAtividades) {
        super(id, nome, email);
        this.horasAtividades = horasAtividades;
    }
    
    /** @return Total Créditos: Horas de atividades complementares + Soma dos dos créditos (carga horária) das disciplinas. */
    @Override
    public int getTotalCreditos() {
        ArrayList<Disciplina> disciplinas = getDisciplinasMatriculadas();
        int total = horasAtividades;
        
        for (Disciplina discipline : disciplinas)
            total += discipline.getCreditos();
        
        return total;
    }

    public int getHorasAtividades() {
        return horasAtividades;
    }

    public void setHorasAtividades(int horasAtividades) {
        this.horasAtividades = horasAtividades;
    }    
}
 