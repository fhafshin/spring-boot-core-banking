package ir.setad.banking.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface ResponseUtil {

    static <x>ResponseEntity<x> wrapOrNotFound(Optional<x> mayBeResource){

     return wrapOrNotFound(mayBeResource,(HttpHeaders) null);
    }

    static <x>ResponseEntity<x> wrapOrNotFound(Optional<x> mayBeResource, HttpHeaders header){

        return (ResponseEntity)mayBeResource.map((response)->{
            return  ResponseEntity.ok().headers(header).body(response);
        }).orElseThrow(()->{
            return new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }
}
