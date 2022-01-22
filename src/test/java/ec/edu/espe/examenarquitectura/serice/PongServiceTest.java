package ec.edu.espe.examenarquitectura.serice;

import ec.edu.espe.examenarquitectura.dao.PongRepository;
import ec.edu.espe.examenarquitectura.model.Pong;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class PongServiceTest {

    @Mock
    private PongRepository pongRepository;

    @InjectMocks
    private PongService pongService;

    private Pong pong;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
    }
}