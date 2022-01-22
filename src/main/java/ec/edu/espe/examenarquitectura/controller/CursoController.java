package ec.edu.espe.examenarquitectura.controller;

import ec.edu.espe.examenarquitectura.dto.CursosRS;
import ec.edu.espe.examenarquitectura.serice.CursoService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static ec.edu.espe.examenarquitectura.dto.CursosRS.serializeMany;

@Data
@RestController
@RequestMapping("/api/v1/curso")
@Slf4j
public class CursoController {

    private final CursoService cursoService;

    @GetMapping("/nombre/{nombreCurso}")
    public ResponseEntity listarCursosPorNombre(@PathVariable("nombreCurso") String nombre){
        try{
            List<CursosRS> cursos = serializeMany(this.cursoService.listarCursosPorNombre(nombre));
            if(cursos.size() > 0){
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(cursos);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha encontrado pongs");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en la búsqueda");
        }
    }

    @GetMapping("/area/{areaCurso}")
    public ResponseEntity listarCursosPorArea(@PathVariable("areaCurso") String area){
        try{
            List<CursosRS> cursos = serializeMany(this.cursoService.listarCursosPorArea(area));
            if(cursos.size() > 0){
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(cursos);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha encontrado pongs");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en la búsqueda");
        }
    }

}
