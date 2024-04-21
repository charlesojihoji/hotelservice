package com.softel.hotel.feignclient;

import com.softel.hotel.response.UserServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE", url = "http://localhost:8081", path = "/USER-SERVICE")
public interface UserServiceClient {

    @GetMapping("/users/{id}")
    public ResponseEntity<UserServiceResponse> getUser(@PathVariable("id") String id);

}