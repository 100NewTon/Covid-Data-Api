package com.covid.app.CovidApp.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Data {

    @Autowired
    @JsonProperty("regional")
    List<Regional> regional;

    public List<Regional> getRegional() {
        return regional;
    }

    public void setRegional(List<Regional> regional) {
        this.regional = regional;
    }
}
