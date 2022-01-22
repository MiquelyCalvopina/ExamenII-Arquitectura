package ec.edu.espe.examenarquitectura.serice;

import ec.edu.espe.examenarquitectura.dao.CursoRepository;
import ec.edu.espe.examenarquitectura.exception.PongException;
import ec.edu.espe.examenarquitectura.model.Curso;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CursoService {

    @NonNull
    private final CursoRepository cursoRepository;

    public Curso obtenerPorCodigo(String codigo) {
        try{
            if(!cursoRepository.existsByCodigo(codigo)){
                return this.cursoRepository.findByCodigo(codigo);
            }else{
                throw new PongException("No existe un curso con este codigo.");
            }
        } catch (Exception e){
            throw new PongException(e.getMessage());
        }
    }
    public List<Curso> listarCursosPorNombre(String nombre){
        return this.cursoRepository.findByNombreLikeAndFechaInicioAfter(nombre, LocalDate.now());
    }

    public List<Curso> listarCursosPorArea(String area){
        return this.cursoRepository.findByAreaAndFechaInicioAfter(area, LocalDate.now());
    }
}
