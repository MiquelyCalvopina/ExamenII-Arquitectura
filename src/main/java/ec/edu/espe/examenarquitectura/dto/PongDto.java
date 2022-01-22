package ec.edu.espe.examenarquitectura.dto;

import ec.edu.espe.examenarquitectura.model.Pong;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class PongDto {

    private String message;
    private String answer;
    private LocalDateTime creationDate;

    public static PongDto singlePong(Pong pong) {
        return PongDto.builder()
                .message(pong.getMessage())
                .answer(pong.getAnswer())
                .creationDate(pong.getCreationDate())
                .build();
    }

    public static List<PongDto> serializeMany(List<Pong> pongs) {
        List<PongDto> result = new ArrayList<PongDto>();
        for (Pong u : pongs) {
            result.add(singlePong(u));
        }
        return result;
    }

}
