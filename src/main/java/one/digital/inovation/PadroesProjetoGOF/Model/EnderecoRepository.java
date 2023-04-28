package one.digital.inovation.PadroesProjetoGOF.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
    Optional<Endereco> findAllById(String cep);
}
