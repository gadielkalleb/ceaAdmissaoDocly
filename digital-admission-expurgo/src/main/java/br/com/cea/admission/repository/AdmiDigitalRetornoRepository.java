package br.com.cea.admission.repository;

import br.com.cea.admission.entity.RhAdmissionRetornoDocly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdmiDigitalRetornoRepository extends JpaRepository<RhAdmissionRetornoDocly,String> {

    List<RhAdmissionRetornoDocly> findByCandidatoId(String candidatoId);

}
