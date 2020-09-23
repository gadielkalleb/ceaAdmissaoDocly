package br.com.cea.admission.repository;

import br.com.cea.admission.entity.RhAdmissionDigital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmiDigitalRepository extends JpaRepository<RhAdmissionDigital,String> {

    RhAdmissionDigital getByPreAdmissaoId(String preAdmissaoId);

}
