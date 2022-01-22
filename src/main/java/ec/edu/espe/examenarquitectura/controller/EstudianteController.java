package ec.edu.espe.examenarquitectura.controller;

import ec.edu.espe.examenarquitectura.dto.CrearEstudianteRQ;
import ec.edu.espe.examenarquitectura.dto.InscripcionRQ;
import ec.edu.espe.examenarquitectura.dto.MatriculaRS;
import ec.edu.espe.examenarquitectura.model.Curso;
import ec.edu.espe.examenarquitectura.model.Estudiante;
import ec.edu.espe.examenarquitectura.serice.CursoService;
import ec.edu.espe.examenarquitectura.serice.EstudianteService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/api/v1/estudiante")
@Slf4j
public class EstudianteController {

    private final EstudianteService estudianteService;
    private final CursoService cursoService;

    @PutMapping("/")
    public ResponseEntity crear(@RequestBody CrearEstudianteRQ estudiante){
        try{
            log.info("CREAR ESTUDIANTE {}", estudiante);
            Estudiante estudianteNuevo = this.estudianteService.crear(estudiante);
            log.info("ESTUDIANTE AGREGADO A LA BASE: {}", estudianteNuevo);
            return ResponseEntity.status(HttpStatus.CREATED).body(estudianteNuevo);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/inscripcion")
    public ResponseEntity inscribir(@RequestBody InscripcionRQ inscripcionRQ){
        try{
            Estudiante estudiante = this.estudianteService.buscarPorCorreo(inscripcionRQ.getEstudianteCorreo());
            Curso curso = this.cursoService.obtenerPorCodigo(inscripcionRQ.getCursoCodigo());
            MatriculaRS matricula = this.estudianteService.inscripcion(estudiante, curso);
            return ResponseEntity.status(HttpStatus.CREATED).body(matricula);
        }  catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
