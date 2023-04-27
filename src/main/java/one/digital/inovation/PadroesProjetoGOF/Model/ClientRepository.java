package one.digital.inovation.PadroesProjetoGOF.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Cliente, Long> {

    Optional<Cliente> findAllById(Long id);
}
