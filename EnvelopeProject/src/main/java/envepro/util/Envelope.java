package envepro.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Envelope<T> implements Serializable {
    private T data;
    private List<Error> listErrors;

    public Envelope() {
    }

    public Envelope(List<Error> listErrors) {
        this.listErrors = listErrors;
    }

    public Envelope(T data, List<Error> listErrs) {
        this.data = data;
        this.listErrors = listErrs;
    }

    public T getData() {
        return data;
    }

    public Envelope setData(T data) {
        this.data = data;
        return this;
    }

    public List<Error> getListErrors() {
        if (listErrors == null) {
            listErrors = new ArrayList<>();
        }
        return listErrors;
    }

    public Envelope setListErrors(List<Error> listErrs) {
        this.listErrors = listErrs;
        return this;
    }
}