package envepro.services;


import envepro.exception.ListaValidationErrorsException;
import envepro.exception.MessageModuleException;
import envepro.model.Pessoa;
import envepro.repository.PessoaRepository;
import envepro.util.FormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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

    @Cacheable(value = "findId", key = "'" + "findId" + "' + #id")
    public Pessoa getPessoaById(Long id) throws MessageModuleException {
        return pessoaRepository.findById(id).orElseThrow(() -> new MessageModuleException("ID não encontrado " + id));
    }

    @Caching(put = {
            @CachePut(value = "findId",
                    key = "'" + "findId" + "' +  #result.id")
            ,
            @CachePut(value = "findaAll",
                    key = "'" + "findaAll" + "' +  #result.id + #result.nome")
    })
    public Pessoa insertPessoa(Pessoa pessoa) throws ListaValidationErrorsException {

        formValidator.validate(pessoa);

        return pessoaRepository.save(pessoa);
    }
    @Cacheable(value = "findaAll", key = "'" + "findAll" + "' + #id")
    public List<Pessoa> getAllPessoas() {

        return pessoaRepository.findAll();

    }
}