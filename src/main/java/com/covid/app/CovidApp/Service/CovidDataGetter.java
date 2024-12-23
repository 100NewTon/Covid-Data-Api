package com.covid.app.CovidApp.Service;

import com.covid.app.CovidApp.Model.CovidResponse;
import com.covid.app.CovidApp.Model.Regional;
import com.covid.app.CovidApp.Util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CovidDataGetter {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CovidResponse response;

    public Integer getCovidData(String state) {

        response = restTemplate.getForObject(Utility.COVID_DATA_API, CovidResponse.class);
        if (response == null || response.getData() == null) {
            return null;
        }
        List<Regional> regional = response.getData().getRegional();
        for(Regional region: regional) {
            if(region.getLoc().equalsIgnoreCase(state)){
                return region.getConfirmedCases();
            }
        }
        return null;
    }
}
