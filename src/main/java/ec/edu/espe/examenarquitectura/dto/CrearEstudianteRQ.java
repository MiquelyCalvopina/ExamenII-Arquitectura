package ec.edu.espe.examenarquitectura.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearEstudianteRQ {

    private String nombre;
    private String email;
    private String pais;
    private LocalDate fechaNacimiento;

}
