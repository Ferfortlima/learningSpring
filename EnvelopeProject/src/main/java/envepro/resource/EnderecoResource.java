package envepro.resource;

import envepro.exception.ListaValidationErrorsException;
import envepro.exception.MessageModuleException;
import envepro.model.Endereco;
import envepro.model.Pessoa;
import envepro.services.EnderecoService;
import envepro.util.Envelope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("{id}")
    public Envelope getEnderecoById(@PathVariable Long id) throws MessageModuleException {
        return new Envelope().setData(enderecoService.getEnderecoById(id));
    }

    @PostMapping()
    public Envelope insertPessoa(@RequestBody Endereco endereco) throws ListaValidationErrorsException {
        return new Envelope().setData(enderecoService.insertEndereco(endereco));
    }
}
