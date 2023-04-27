package one.digital.inovation.PadroesProjetoGOF.Controller;

import one.digital.inovation.PadroesProjetoGOF.Model.Cliente;
import one.digital.inovation.PadroesProjetoGOF.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {
    @Autowired
    private ClientService clientService;
    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos(){
        return  ResponseEntity.ok(clientService.buscarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clientService.buscarPorId(id));
    }
    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
        clientService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Cliente> atuallizar(@PathVariable Long id, @RequestBody Cliente cliente){
        clientService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clientService.deletar(id);
        return ResponseEntity.ok().build();
    }


}
