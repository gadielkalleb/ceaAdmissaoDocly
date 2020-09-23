package br.com.cea.admission.repository;

import br.com.cea.admission.entity.RhAdmissionHistorico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmiDigitalHistoricoRepository extends JpaRepository<RhAdmissionHistorico,String> {


}
