package br.com.cea.admission.repository;

import br.com.cea.admission.entity.RhAdmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdmiDigitalRepository extends JpaRepository<RhAdmission,Long> {

    List<RhAdmission> findByStatus(String status);

}
