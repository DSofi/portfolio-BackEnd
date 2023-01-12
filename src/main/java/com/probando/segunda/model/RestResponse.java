
package com.probando.segunda.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RestResponse {
    
    private String status;
    private String message;

    public RestResponse() {
    }

    public RestResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }    
}
