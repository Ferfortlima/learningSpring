package envepro.services;


import envepro.exception.ListaValidationErrorsException;
import envepro.exception.MessageModuleException;
import envepro.model.Endereco;
import envepro.repository.EnderecoRepository;
import envepro.util.FormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    FormValidator formValidator;

    @Cacheable("enderecoFindId")
    public Endereco getEnderecoById(Long id) throws MessageModuleException {
        return enderecoRepository.findById(id).orElseThrow(() -> new MessageModuleException("ID não encontrado " + id));
    }

    @Caching(put = {
            @CachePut(value = "enderecoFindAll",
                    key = "'" + "enderecoFindAll" + "' + #endereco.id")

    },
            evict = {@CacheEvict(value = "enderecoFindAll", key = "'" + "enderecoFindAll" + "' + #endereco.id",allEntries = true)})
    public Endereco insertEndereco(Endereco endereco) throws ListaValidationErrorsException {

        formValidator.validate(endereco);

        return enderecoRepository.save(endereco);
    }

    @Cacheable(value = "enderecoFindAll")
    public List<Endereco> getAllEndereco() {
        return enderecoRepository.findAll();
    }

}