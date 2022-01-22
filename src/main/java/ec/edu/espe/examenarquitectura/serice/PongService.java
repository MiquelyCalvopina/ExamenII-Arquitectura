package ec.edu.espe.examenarquitectura.serice;

import ec.edu.espe.examenarquitectura.dao.PongRepository;
import ec.edu.espe.examenarquitectura.exception.PongException;
import ec.edu.espe.examenarquitectura.model.Pong;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PongService {

    @NonNull
    private final PongRepository pongRepository;

    public Pong create (String request){
        try{
            if ("PING".equals(request.toUpperCase())) {
                LocalDateTime dateTime = LocalDateTime.now();
                Pong pong = new Pong();
                pong.setMessage(request);
                pong.setAnswer("ping");
                pong.setCreationDate(dateTime);
                pongRepository.save(pong);
                return pong;
            }else{
                throw new PongException("La petición debe ser realizada con 'PING'");
            }
        } catch(Exception e) {
            throw new PongException(e.getMessage());
        }
    }

    public List<Pong> listTodaysPongs() {
        LocalDate date = LocalDate.now();
        return this.pongRepository.findByCreationDateBetween(date.atStartOfDay(),date.plusDays(1).atStartOfDay());
    }

}
