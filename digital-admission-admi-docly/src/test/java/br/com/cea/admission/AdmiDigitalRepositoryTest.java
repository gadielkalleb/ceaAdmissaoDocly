package br.com.cea.admission;

import br.com.cea.admission.entity.RhAdmissionDigital;
import br.com.cea.admission.repository.AdmiDigitalRepository;
import org.junit.Assert;
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
public class AdmiDigitalRepositoryTest {

    @Mock
    private AdmiDigitalRepository admiDigitalRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testgetByPreAdmissaoId_Found() {
        RhAdmissionDigital rhAdmission = createRhAdmissionDigital();
        when(admiDigitalRepository.getByPreAdmissaoId("1234567890")).thenReturn(rhAdmission);
        Assert.assertEquals(rhAdmission,admiDigitalRepository.getByPreAdmissaoId("1234567890"));
    }

    @Test
    public void testgetByPreAdmissaoId_NotFound() {
        when(admiDigitalRepository.getByPreAdmissaoId("1234567890x")).thenReturn(null);
        Assert.assertEquals(null,admiDigitalRepository.getByPreAdmissaoId("1234567890x"));
    }

    private RhAdmissionDigital createRhAdmissionDigital() {
        RhAdmissionDigital rhAdmission = new RhAdmissionDigital();
        rhAdmission.setPreAdmissaoId("1234567890");
        admiDigitalRepository.save(rhAdmission);
        return rhAdmission;
    }

}