package ec.edu.espe.examenarquitectura.controller;

import ec.edu.espe.examenarquitectura.dto.PongCreationDto;
import ec.edu.espe.examenarquitectura.dto.PongDto;
import ec.edu.espe.examenarquitectura.model.Pong;
import ec.edu.espe.examenarquitectura.serice.PongService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ec.edu.espe.examenarquitectura.dto.PongDto.serializeMany;

@CrossOrigin
@Data
@RestController
@RequestMapping("/api/v1/examen")
@Slf4j
public class PongController {

    private final PongService pongService;

    @PutMapping("/")
    public ResponseEntity create(@RequestBody PongCreationDto pong){
        try {
            log.info("Creando pong con la petición {}", pong);
            Pong pongCreated = this.pongService.create(pong.getRequest());
            log.info("Creado pong {}", pongCreated);
            return ResponseEntity.status(HttpStatus.CREATED).body(pongCreated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/today/")
    public  ResponseEntity getPongs(){
        try {
            List<PongDto> pongs = serializeMany(this.pongService.listTodaysPongs());
            log.info("Se obtuvo {} pongs de hoy", pongs.size());
            if(pongs.size() > 0){
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(pongs);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha encontrado pongs");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en la búsqueda");
        }
    }
}
