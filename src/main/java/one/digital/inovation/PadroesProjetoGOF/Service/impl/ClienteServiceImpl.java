package one.digital.inovation.PadroesProjetoGOF.Service.impl;

import one.digital.inovation.PadroesProjetoGOF.Model.Cliente;
import one.digital.inovation.PadroesProjetoGOF.Service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClientService {
    @Override
    public Iterable<Cliente> buscarTodos(){
        return null;
    }
    @Override
    public Cliente buscarPorId(Long id){
        return null;
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
