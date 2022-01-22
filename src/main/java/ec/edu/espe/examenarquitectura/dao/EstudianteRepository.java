package ec.edu.espe.examenarquitectura.dao;

import ec.edu.espe.examenarquitectura.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {

    Boolean existByEmail(String email);
    Estudiante findByEmail(String email);

}
