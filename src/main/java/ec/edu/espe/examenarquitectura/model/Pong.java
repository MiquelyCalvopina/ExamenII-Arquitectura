package ec.edu.espe.examenarquitectura.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "plantilla")
public class Pong {

    @Id
    private String id;
    private String message;
    private String answer;
    private LocalDateTime creationDate;
}
