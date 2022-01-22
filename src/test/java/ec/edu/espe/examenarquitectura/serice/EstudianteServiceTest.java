package ec.edu.espe.examenarquitectura.serice;

import ec.edu.espe.examenarquitectura.dao.CursoRepository;
import ec.edu.espe.examenarquitectura.dao.EstudianteRepository;
import ec.edu.espe.examenarquitectura.model.Estudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstudianteServiceTest {

    @Mock
    private EstudianteRepository estudianteRepository;
    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private EstudianteService estudianteService;

    private Estudiante estudiante;

    @BeforeEach
    void setUp(){

        MockitoAnnotations.openMocks(this);
        List<String> cursos = new ArrayList<String>();
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
    }

    @Test
    void buscarPorCorreo() {
        try{

        }catch (Exception e){

        }
    }

    @Test
    void crear() {
    }

    @Test
    void inscripcion() {
    }
}