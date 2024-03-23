package com.example.dataaccessobject.controller;

import com.example.dataaccessobject.repository.DBRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class FetchProductController {

    private DBRepository dbRepository;

    public FetchProductController(DBRepository dbRepository) {
        this.dbRepository = dbRepository;
    }

    @GetMapping("products/fetch-product")
    public Object fetch(@RequestParam String name) {
        return dbRepository.getProductName(name);
    }
}
