package com.workintech.s17g2.rest;

import com.workintech.s17g2.model.Developer;
import com.workintech.s17g2.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/developers")
public class DeveloperController {
    private Map<Integer, Developer> developers;
    private Taxable taxable;

    @Autowired
    public DeveloperController(Taxable taxable) {
        this.taxable = taxable;
    }
    @PostConstruct
    public void init(){
        developers = new HashMap<>();
    }
}
