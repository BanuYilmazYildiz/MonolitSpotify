package com.banu.MonolitSpotify.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class MonolitSpotifyException extends RuntimeException{

    /*
        sifreler doğru değil
        uername yanlıs sekilde girildi gibi uygulmaya özel exceptionlar buraya yazılır
     */

    private final ErrorType errorType;
    public MonolitSpotifyException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }

    public MonolitSpotifyException(ErrorType errorType,String message){
        super(message);
        this.errorType=errorType;
    }

}
