package kg.nurtelecom.swiftapp.util;
import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseMessage<T> {

    private T result;
    private ResultCode resultCode;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String details;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message;

    public ResponseMessage(T result, ResultCode resultCode) {
        this(result, resultCode, null);
    }

    public ResponseMessage(T result, ResultCode resultCode, String details) {
        this.result = result;
        this.resultCode = resultCode;
        this.details = details;
        this.message = null;
    }

    public ResponseMessage(T result, ResultCode resultCode, String details,String message) {
        this.result = result;
        this.resultCode = resultCode;
        this.details = details;
        this.message=message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean hasResult() {
        return result != null;
    }
}
