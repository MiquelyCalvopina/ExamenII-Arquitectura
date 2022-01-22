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
class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    private Curso curso;
    private List<String> estudiantes;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        estudiantes = new ArrayList<String>();
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
    void obtenerPorCodigo() {
        String codigo = curso.getCodigo();
        try{
            when(this.cursoRepository.existsByCodigo(codigo)).thenReturn(true);
            assertEquals(curso,this.cursoService.obtenerPorCodigo(codigo));
        }catch (Exception e){
            assertThrows(Exception.class, () -> this.cursoService.obtenerPorCodigo(codigo));
        }
    }

    @Test
    void listarCursosPorNombre() {
    }

    @Test
    void listarCursosPorArea() {
    }
}