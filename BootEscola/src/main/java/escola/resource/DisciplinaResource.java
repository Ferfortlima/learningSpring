package escola.resource.exception;

import escola.exception.MessageModuleException;
import escola.model.Disciplina;
import escola.service.DisciplinaService;
import escola.util.Envelope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("disciplina")
public class DisciplinaResource {

    @Autowired
    DisciplinaService disciplinaService;

    @GetMapping("{id}")
    public Envelope getById(@PathVariable Long id) throws MessageModuleException {
        return new Envelope().setData(disciplinaService.getbyId(id));
    }

    @PostMapping
    public Envelope insert(@RequestBody Disciplina disciplina){
        return new Envelope().setData(disciplinaService.insert(disciplina));
    }

    @GetMapping("listDisciplinas")
    public Envelope getAll(){
        return new Envelope().setData(disciplinaService.getAll());
    }
}
