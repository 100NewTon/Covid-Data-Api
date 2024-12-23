package com.covid.app.CovidApp.Controller;

import com.covid.app.CovidApp.Service.CovidDataGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid-data")
public class CovidDataController {

    @Autowired
    CovidDataGetter covidDataGetter;

    @GetMapping("/statewise/{state}")
    public String getCovidCases(@PathVariable String state){
        Integer confirmedCases = covidDataGetter.getCovidData(state);
        return "Total Confirmed cases in "+ state + " is " +confirmedCases;
    }

}
