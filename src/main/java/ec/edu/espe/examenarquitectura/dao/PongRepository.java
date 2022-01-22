package ec.edu.espe.examenarquitectura.dao;

import ec.edu.espe.examenarquitectura.model.Pong;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface PongRepository extends MongoRepository<Pong, String> {
    List<Pong> findByCreationDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
