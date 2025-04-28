package org.example.securitydemo.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder(setterPrefix = "with")
public class ExceptionResponse {

    private String message;
    private HttpStatus status;

    @JsonProperty("status")
    public Integer getStatusCode() {
        return status.value();
    }
}
