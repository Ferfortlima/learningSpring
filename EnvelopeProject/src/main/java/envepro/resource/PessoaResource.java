package envepro.resource;

import envepro.exception.ListaValidationErrorsException;
import envepro.exception.MessageModuleException;
import envepro.model.Pessoa;
import envepro.services.PessoaService;
import envepro.util.Envelope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("{id}")
    public Envelope getPessoaById(@PathVariable Long id) throws MessageModuleException {
        return new Envelope().setData(pessoaService.getPessoaById(id));
    }


    @PostMapping()
    public Envelope insertPessoa(@RequestBody Pessoa pessoa) throws ListaValidationErrorsException {
        return new Envelope().setData(pessoaService.insertPessoa(pessoa));
    }
}
