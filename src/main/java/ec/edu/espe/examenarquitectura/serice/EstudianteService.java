package ec.edu.espe.examenarquitectura.serice;

import ec.edu.espe.examenarquitectura.dao.CursoRepository;
import ec.edu.espe.examenarquitectura.dao.EstudianteRepository;
import ec.edu.espe.examenarquitectura.dto.CrearEstudianteRQ;
import ec.edu.espe.examenarquitectura.dto.InscripcionRQ;
import ec.edu.espe.examenarquitectura.dto.MatriculaRS;
import ec.edu.espe.examenarquitectura.exception.PongException;
import ec.edu.espe.examenarquitectura.model.Curso;
import ec.edu.espe.examenarquitectura.model.Estudiante;
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
public class EstudianteService {

    @NonNull
    private final EstudianteRepository estudianteRepository;
    private final CursoRepository cursoRepository;

    public Estudiante buscarPorCorreo(String correo){
        try{
            if(!estudianteRepository.existByEmail(correo)){
                return this.estudianteRepository.findByEmail(correo);
            }else{
                throw new PongException("No existe un usuario con este correo.");
            }
        } catch (Exception e){
            throw new PongException(e.getMessage());
        }
    }

    public Estudiante crear (CrearEstudianteRQ crearEstudianteRQ){
        try{
            if(estudianteRepository.existByEmail(crearEstudianteRQ.getEmail())){
                Estudiante estudiante = new Estudiante();
                estudiante.setNombre(crearEstudianteRQ.getNombre());
                estudiante.setEmail(crearEstudianteRQ.getEmail());
                estudiante.setPais(crearEstudianteRQ.getPais());
                estudiante.setFechaNacimiento(crearEstudianteRQ.getFechaNacimiento());
                estudiante.setFechaCreacion(LocalDateTime.now());
                estudiante.setEstado("ACT");
                return estudiante;
            }else{
                throw new PongException("Ya existe un usuario con este correo.");
            }
        } catch (Exception e){
            throw new PongException(e.getMessage());
        }
    }

    public MatriculaRS inscripcion(Estudiante estudiante, Curso curso){
        try{
            int counter = 0, counterAux = 0;
            List<String> cursosInscritos = estudiante.getCursosActivos();
            for(String e: cursosInscritos){
                if(e.equals(curso.getId()))
                    counter++;
            }
            if(counter < 3) {
                List<String> estudiantes = curso.getEstudiantes();
                for(String e: estudiantes){
                    if(e.equals(estudiante.getId())){
                        throw new PongException("El estudiante ya esta inscrito en este curso");
                    }
                }
                estudiantes.add(estudiante.getId());
                curso.setEstudiantes(estudiantes);
                this.cursoRepository.save(curso);
                cursosInscritos.add(curso.getId());
                estudiante.setCursosActivos(cursosInscritos);
                this.estudianteRepository.save(estudiante);
                return MatriculaRS.builder()
                        .estudianteId(estudiante.getId())
                        .estudianteNombre(estudiante.getNombre())
                        .cursoCodigo(curso.getCodigo())
                        .cursoNombre(curso.getNombre())
                        .cursoDuracionHoras(curso.getDuraciónHoras())
                        .build();
            }else{
                throw new PongException("El estudiante ya esta inscrito en más de 1 curso");
            }
        } catch (Exception e) {
            throw new PongException(e.getMessage());
        }
    }

}
