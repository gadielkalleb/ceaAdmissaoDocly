package br.com.cea.admission.repository;

import br.com.cea.admission.entity.RhAdmissionArquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdmiDigitalArquivoRepository extends JpaRepository<RhAdmissionArquivo,Long> {

    List<RhAdmissionArquivo> findByCpfAndStatus(String cpf, String status);
}
