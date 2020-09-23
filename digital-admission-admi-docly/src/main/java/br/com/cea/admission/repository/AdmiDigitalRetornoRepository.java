package br.com.cea.admission.repository;

import br.com.cea.admission.entity.RhAdmissionRetornoDocly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmiDigitalRetornoRepository extends JpaRepository<RhAdmissionRetornoDocly,String> {

    Boolean existsByCandidatoId(String id);
}
