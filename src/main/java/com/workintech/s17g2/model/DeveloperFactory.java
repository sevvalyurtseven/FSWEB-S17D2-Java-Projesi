package com.workintech.s17g2.model;

import com.workintech.s17g2.tax.Taxable;

public class DeveloperFactory {

    //TODO create developer by experience

    //TODO calculate tax and substract from existing salary = salary-salary*taxrate
    public static Developer createDeveloper(Developer developer, Taxable taxable){
        Developer createdDeveloper = null;
        if(developer.getExperience().equals(Experience.JUNIOR)){
            createdDeveloper = new JuniorDeveloper(developer.getId(), developer.getName(),(developer.getSalary()-(developer.getSalary()*taxable.getSimpleTaxRate())/100));
        }
        else if(developer.getExperience().equals(Experience.MID)){
            createdDeveloper = new MidDeveloper(developer.getId(), developer.getName(),(developer.getSalary()-(developer.getSalary()*taxable.getMiddleTaxRate())/100));
        }
        else if(developer.getExperience().equals(Experience.SENIOR)){
            createdDeveloper = new SeniorDeveloper(developer.getId(), developer.getName(),(developer.getSalary()-(developer.getSalary()*taxable.getUpperTaxRate())/100));
        }
        return createdDeveloper;
    }
}
