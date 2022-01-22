package ec.edu.espe.examenarquitectura.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InscripcionRQ {

    private String estudianteCorreo;
    private String cursoCodigo;

}