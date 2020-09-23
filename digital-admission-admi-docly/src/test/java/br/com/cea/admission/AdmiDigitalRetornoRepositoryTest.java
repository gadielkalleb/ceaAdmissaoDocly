package br.com.cea.admission;

import br.com.cea.admission.entity.RhAdmissionRetornoDocly;
import br.com.cea.admission.repository.AdmiDigitalRetornoRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.when;

@DataJpaTest
@ActiveProfiles("dev")
public class AdmiDigitalRetornoRepositoryTest {

    @Mock
    private AdmiDigitalRetornoRepository mockRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExistsByCandidatoId_True() {
        RhAdmissionRetornoDocly rhAdmission = new RhAdmissionRetornoDocly();
        rhAdmission.setCandidatoId("1234567890");
        when(mockRepository.save(Mockito.any(RhAdmissionRetornoDocly.class))).thenReturn(rhAdmission);
        when(mockRepository.existsByCandidatoId(rhAdmission.getCandidatoId())).thenReturn(true);
    }

    @Test
    public void testExistsByCandidatoId_False() {
        RhAdmissionRetornoDocly rhAdmission = new RhAdmissionRetornoDocly();
        rhAdmission.setCandidatoId("809fkdjfnmk3");
        when(mockRepository.save(Mockito.any(RhAdmissionRetornoDocly.class))).thenReturn(rhAdmission);
        when(mockRepository.existsByCandidatoId("809fkdjfnmk3x")).thenReturn(false);
    }

}
