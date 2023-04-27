package one.digital.inovation.PadroesProjetoGOF.Service.impl;

import one.digital.inovation.PadroesProjetoGOF.Model.ClientRepository;
import one.digital.inovation.PadroesProjetoGOF.Model.Cliente;
import one.digital.inovation.PadroesProjetoGOF.Model.EnderecoRepository;
import one.digital.inovation.PadroesProjetoGOF.Service.ClientService;
import one.digital.inovation.PadroesProjetoGOF.Service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;


    @Override
    public Iterable<Cliente> buscarTodos(){
        return clientRepository.findAll();
    }
    @Override
    public Cliente buscarPorId(Long id){
      Optional<Cliente> cliente = clientRepository.findAllById(id);
        return cliente.get();
    }
    @Override
    public void inserir(Cliente cliente){

    }
    @Override
    public void atualizar(Long id, Cliente cliente){

    }
    @Override
    public void deletar(Long id){

    }
}
