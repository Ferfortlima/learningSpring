package envepro.services;


import envepro.exception.ListaValidationErrorsException;
import envepro.exception.MessageModuleException;
import envepro.model.Pessoa;
import envepro.repository.PessoaRepository;
import envepro.util.FormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    FormValidator formValidator;

    public Pessoa getPessoaById(Long id) throws MessageModuleException {
        return pessoaRepository.findById(id).orElseThrow(() -> new MessageModuleException("ID não encontrado " + id));
    }

    public Pessoa insertPessoa(Pessoa pessoa) throws ListaValidationErrorsException {

        formValidator.validate(pessoa);

        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> getAllPessoas() {

        return pessoaRepository.findAll();

    }
}