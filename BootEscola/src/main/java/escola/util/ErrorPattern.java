package escola.util;

import java.io.Serializable;

public class ErrorPattern implements Serializable {

    private String code;
    private String message;

    public ErrorPattern() {
    }

    public ErrorPattern(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public ErrorPattern setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorPattern setMessage(String message) {
        this.message = message;
        return this;
    }
}

