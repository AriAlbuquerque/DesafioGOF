package one.digital.inovation.PadroesProjetoGOF.Service.impl;

import one.digital.inovation.PadroesProjetoGOF.Model.ClientRepository;
import one.digital.inovation.PadroesProjetoGOF.Model.Cliente;
import one.digital.inovation.PadroesProjetoGOF.Model.Endereco;
import one.digital.inovation.PadroesProjetoGOF.Model.EnderecoRepository;
import one.digital.inovation.PadroesProjetoGOF.Service.ClientService;
import one.digital.inovation.PadroesProjetoGOF.Service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClientService {
    @Autowired
    private final ClientRepository clientRepository;
    @Autowired
    private final EnderecoRepository enderecoRepository;
    @Autowired
    private final ViaCepService viaCepService;

    public ClienteServiceImpl(ClientRepository clientRepository, EnderecoRepository enderecoRepository, ViaCepService viaCepService) {
        this.clientRepository = clientRepository;
        this.enderecoRepository = enderecoRepository;
        this.viaCepService = viaCepService;
    }


    @Override
    public Iterable<Cliente> buscarTodos() {

        return clientRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clientRepository.findAllById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        SalvarNovoClienteComCep(cliente);
    }

    private void SalvarNovoClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findAllById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clientRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteDb = clientRepository.findAllById(id);
        if (clienteDb.isPresent()) {
            SalvarNovoClienteComCep(cliente);

        }
    }

    @Override
    public void deletar(Long id) {
        clientRepository.deleteById(id);

    }
}
