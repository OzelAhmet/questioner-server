package yte.intern.questioner.httpResponce;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HttpResponse<T> {

    private Integer responseCode;
    private T body;
    private String message;
    private List<String> errorList;

    public HttpResponse(Integer responseCode, T body) {
        this.responseCode = responseCode;
        this.body = body;
    }

    public HttpResponse(Integer responseCode, T body, String message) {
        this.responseCode = responseCode;
        this.body = body;
        this.message = message;
    }

    public HttpResponse(String message, List<String> errorList) {
        this.message = message;
        this.errorList = errorList;
    }

    public void addException(String error){
        if (this.errorList == null){
            this.errorList = new ArrayList<>();
        }
        this.errorList.add(error);
    }
}
