package envepro.exception;


import envepro.util.ErrorPattern;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListaValidationErrorsException extends Exception {

    private List<ErrorPattern> listErrors = new ArrayList<>();

    public ListaValidationErrorsException(){
    }

    public ListaValidationErrorsException(Set<ConstraintViolation<Object>> errs){
        for (ConstraintViolation<Object> c : errs){
            listErrors.add(new ErrorPattern().setCode("").setMessage(c.getMessage()));
        }
    }

    public List<ErrorPattern> getListErrors() {
        return listErrors;
    }

}