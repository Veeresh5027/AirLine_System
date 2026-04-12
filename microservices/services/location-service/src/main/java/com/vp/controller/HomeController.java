package com.vp.controller;

import com.vp.payload.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ApiResponse homeController() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Welcome to Location Service");
        return apiResponse;
    }
}
