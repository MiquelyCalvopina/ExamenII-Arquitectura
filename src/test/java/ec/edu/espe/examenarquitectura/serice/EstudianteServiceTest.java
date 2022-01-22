package ec.edu.espe.examenarquitectura.serice;

import ec.edu.espe.examenarquitectura.dao.CursoRepository;
import ec.edu.espe.examenarquitectura.dao.EstudianteRepository;
import ec.edu.espe.examenarquitectura.dto.CrearEstudianteRQ;
import ec.edu.espe.examenarquitectura.dto.MatriculaRS;
import ec.edu.espe.examenarquitectura.model.Curso;
import ec.edu.espe.examenarquitectura.model.Estudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EstudianteServiceTest {

    @Mock
    private EstudianteRepository estudianteRepository;
    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private EstudianteService estudianteService;

    private Estudiante estudiante;
    private CrearEstudianteRQ crearEstudianteRQ;
    private Curso curso;
    private MatriculaRS matriculaRS;
    private List<String> cursos;
    private List<String> estudiantes;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        cursos = new ArrayList<String>();
        estudiantes = new ArrayList<String>();
        estudiante = new Estudiante();
        estudiante.setNombre("MIQUELY CALVOPIÑA");
        estudiante.setEstado("ACT");
        estudiante.setPais("EC");
        estudiante.setFechaNacimiento(LocalDate.of(1998,5,28));
        estudiante.setId("15646451s65d1w64fw4f6wd");
        estudiante.setFechaCreacion(LocalDateTime.now());
        cursos.add("sdf465sd4f6s54f6");
        estudiante.setCursosActivos(cursos);
        estudiante.setEmail("mecalvopina1@espe.edu.ec");

        CrearEstudianteRQ crearEstudianteRQ = new CrearEstudianteRQ();
        crearEstudianteRQ.setNombre(estudiante.getNombre());
        crearEstudianteRQ.setEmail(estudiante.getEmail());
        crearEstudianteRQ.setPais(estudiante.getPais());
        crearEstudianteRQ.setFechaNacimiento(estudiante.getFechaNacimiento());

        curso = new Curso();
        curso.setId("fg46sdf85g46f5");
        curso.setCodigo("COMPA22");
        curso.setArea("COMPUTACION");
        curso.setNombre("ARQUITECTURA DE SOFTWARE");
        curso.setDuraciónHoras(9);
        curso.setFechaInicio(LocalDate.now());
        curso.setCosto(BigDecimal.valueOf(130.50));
        curso.setEstudiantes(estudiantes);

    }

    @Test
    void buscarPorCorreo() {
        String email = estudiante.getEmail();
        try{
            when(this.estudianteRepository.existByEmail(email)).thenReturn(true);
            assertEquals(estudiante,this.estudianteService.buscarPorCorreo(email));
        }catch (Exception e){
            assertThrows(Exception.class, () -> this.estudianteService.buscarPorCorreo(email));
        }
    }

    @Test
    void crear() {
        String email = this.estudiante.getEmail();
        try {
            when(this.estudianteRepository.existByEmail(email)).thenReturn(true);
            assertEquals(estudiante,this.estudianteService.crear(crearEstudianteRQ));
        } catch (Exception e) {
            assertThrows(Exception.class, () -> this.estudianteService.buscarPorCorreo(email));
        }
    }

    @Test
    void inscripcion() {
        String email = this.estudiante.getEmail();
        try {
            estudiantes.add(estudiante.getId());
            cursos.add(curso.getId());
            estudiante.setCursosActivos(cursos);
            curso.setEstudiantes(estudiantes);
            when(this.cursoRepository.save(curso)).thenReturn(curso);
            when(this.estudianteRepository.save(estudiante)).thenReturn(estudiante);
            matriculaRS = MatriculaRS.builder()
                    .estudianteId(estudiante.getId())
                    .estudianteNombre(estudiante.getNombre())
                    .cursoCodigo(curso.getCodigo())
                    .cursoNombre(curso.getNombre())
                    .cursoDuracionHoras(curso.getDuraciónHoras())
                    .build();
            assertEquals(matriculaRS,this.estudianteService.inscripcion(estudiante,curso));
        } catch (Exception e) {
            assertThrows(Exception.class, () -> this.estudianteService.buscarPorCorreo(email));
        }
    }
}