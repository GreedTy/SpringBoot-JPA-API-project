package com.example.study.controller;

import com.example.study.model.SearchParam;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {
    @RequestMapping(method= RequestMethod.GET, path="/getMethod")
    public String getMethod() {
        return "hello springboot";
    }

    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String password) {
        System.out.println("id: " + id);
        System.out.println("password :" + password);

        return id+password;
    }
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader() {
        //
        return Header.builder().resultCode("OK").description("OK").build();
    }
}
