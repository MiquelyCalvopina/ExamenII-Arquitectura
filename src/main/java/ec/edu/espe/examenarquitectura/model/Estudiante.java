package ec.edu.espe.examenarquitectura.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "estudiante")
public class Estudiante {

    @Id
    private String id;
    private String nombre;
    private String email;
    private String pais;
    private List<String> cursosActivos;
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaCreacion;
    private String estado;

}
