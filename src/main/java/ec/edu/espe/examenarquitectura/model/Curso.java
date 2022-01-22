package ec.edu.espe.examenarquitectura.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "curso")
public class Curso {

    @Id
    private String id;
    private String codigo;
    private String area;
    private String nombre;
    private Integer duraciónHoras;
    private LocalDate fechaInicio;
    private BigDecimal costo;
    private List<String> estudiantes;
}
