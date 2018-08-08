package envepro.services;


import envepro.exception.ListaValidationErrorsException;
import envepro.exception.MessageModuleException;
import envepro.model.Endereco;
import envepro.repository.EnderecoRepository;
import envepro.util.FormValidator;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Endereco getEnderecoById(Long id) throws MessageModuleException {
        return enderecoRepository.findById(id).orElseThrow(() -> new MessageModuleException("ID não encontrado " + id));
    }

    public Endereco insertEndereco(Endereco endereco) throws ListaValidationErrorsException {

        formValidator.validate(endereco);

        return enderecoRepository.save(endereco);
    }

    public List<Endereco> getAllEndereco() {
        return enderecoRepository.findAll();
    }

}