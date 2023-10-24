package com.global.advanced.java.advancedjava.spring.rest;

import com.global.advanced.java.advancedjava.models.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    private List<String> stringList = new Vector<>();

    @PostMapping("/add")
    public String add(@Valid @RequestBody Customer customerParam) {
        stringList.add(customerParam.getFirstName());
        return "" + customerParam;
    }

}
