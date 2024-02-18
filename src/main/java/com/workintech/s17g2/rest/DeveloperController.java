package com.workintech.s17g2.rest;

import com.workintech.s17g2.dto.DeveloperResponse;
import com.workintech.s17g2.model.Developer;
import com.workintech.s17g2.model.DeveloperFactory;
import com.workintech.s17g2.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    //[POST]/workintech/developers => id, name, salary ve experience değerlerini alır, experience tipine bakarak uygun developer objesini oluşturup developers mapine ekler. JuniorDeveloper için salary bilgisinden salarygetSimpleTaxRate() değerini düşmelisiniz. Aynı şekilde MidDeveloper için salarygetMiddleTaxRate(), SeniorDeveloper için salary*getUpperTaxRate() değerlerini salary bilgisinden düşmelisiniz.
    @PostMapping
    public DeveloperResponse save(@RequestBody Developer developer){
        Developer createdDeveloper = DeveloperFactory.createDeveloper(developer,taxable);
        if(Objects.nonNull(createdDeveloper)){
            developers.put(developer.getId(), developer);
        }
        return new DeveloperResponse(developer.getId(), developer.getName(), developer.getSalary(), developer.getExperience());
    }
}
