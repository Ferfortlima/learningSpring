package envepro;

import envepro.model.Endereco;
import envepro.model.Pessoa;
import envepro.repository.EnderecoRepository;
import envepro.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Application.class, args);


    }

    @Override
    public void run(String... args) throws Exception {

        Endereco enderecoa = new Endereco("a","a","a","a");
        Endereco enderecob = new Endereco("b","b","b","b");


        Pessoa pessoa = new Pessoa("nome", "11/11/1992","123123123");

        enderecoa.setPessoa(pessoa);
        enderecob.setPessoa(pessoa);

        pessoa.setEnderecos(Arrays.asList(enderecoa,enderecob));
        pessoaRepository.saveAll(Arrays.asList(pessoa));
        enderecoRepository.saveAll(Arrays.asList(enderecoa,enderecob));

    }
}