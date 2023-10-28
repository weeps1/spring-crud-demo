package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.dao.MilkDAO;
import com.luv2code.cruddemo.entity.Milk;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MilkRestController {

    private final MilkDAO milkDAO;

    public MilkRestController(MilkDAO milkDAO) {
        this.milkDAO = milkDAO;
    }

    @GetMapping("/milks")
    public List<Milk> getAllMilk() {
        return milkDAO.findAll();
    }
}
