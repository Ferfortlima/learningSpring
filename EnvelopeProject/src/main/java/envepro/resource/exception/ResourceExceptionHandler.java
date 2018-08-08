package envepro.resource.exception;

import envepro.exception.MessageModuleException;
import envepro.util.Envelope;
import envepro.util.ErrorPattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(MessageModuleException.class)
    public final ResponseEntity<Envelope> handleUserNotFoundException(MessageModuleException ex, WebRequest request) {
        return new ResponseEntity<>(new Envelope(null, Arrays.asList(ex.getMessage())), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseBody
    public ResponseEntity<Envelope> exceptionHandler(ConstraintViolationException e) {

        List<ErrorPattern> errs = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().stream().forEach((er) -> {
            errs.add(new ErrorPattern(null, er.getMessage()));
        });

        Envelope<Void> ret = new Envelope(errs);

        return new ResponseEntity<>(ret, HttpStatus.BAD_REQUEST);
    }
}