package ec.edu.espe.examenarquitectura.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MatriculaRS {

    private String estudianteId;
    private String estudianteNombre;
    private String cursoCodigo;
    private String cursoNombre;
    private Integer cursoDuracionHoras;

}
