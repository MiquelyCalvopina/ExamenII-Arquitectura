package ec.edu.espe.examenarquitectura.dao;

import ec.edu.espe.examenarquitectura.model.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDate;
import java.util.List;

public interface CursoRepository extends MongoRepository<Curso, String> {

    Boolean existsByCodigo(String codigo);
    Curso findByCodigo(String codigo);
    List<Curso> findByAreaAndFechaInicioAfter(String area, LocalDate fecha);
    List<Curso> findByNombreLikeAndFechaInicioAfter(String nombre, LocalDate fecha);

}
