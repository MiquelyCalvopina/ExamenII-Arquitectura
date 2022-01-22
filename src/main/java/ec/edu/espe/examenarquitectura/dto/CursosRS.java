package ec.edu.espe.examenarquitectura.dto;

import ec.edu.espe.examenarquitectura.model.Curso;
import ec.edu.espe.examenarquitectura.model.Pong;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class CursosRS {

    private String codigo;
    private String area;
    private String nombre;
    private Integer duraciónHoras;
    private LocalDate fechaInicio;
    private BigDecimal costo;

    public static CursosRS singleCurso(Curso curso){
        return CursosRS.builder()
                .codigo(curso.getCodigo())
                .area(curso.getArea())
                .nombre(curso.getNombre())
                .duraciónHoras(curso.getDuraciónHoras())
                .fechaInicio(curso.getFechaInicio())
                .costo(curso.getCosto())
                .build();
    }

    public static List<CursosRS> serializeMany(List<Curso> cursos) {
        List<CursosRS> result = new ArrayList<CursosRS>();
        for (Curso elemento : cursos) {
            result.add(singleCurso(elemento));
        }
        return result;
    }
}
