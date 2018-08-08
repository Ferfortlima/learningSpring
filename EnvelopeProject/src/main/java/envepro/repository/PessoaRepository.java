package envepro.repository;

import envepro.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @SuppressWarnings("unused")
    @Repository
    public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

        //Pessoa findByNome(String nome);

    }
