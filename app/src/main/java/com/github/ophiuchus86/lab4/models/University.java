package com.github.ophiuchus86.lab4.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties({"alpha_two_code", "state-province"})
public class University {
    private String name;
    private String country;
    private List<String> domains;
    @JsonProperty("web_pages")
    private List<String> pages;

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getDomains() {
        return domains;
    }

    public List<String> getPages() {
        return pages;
    }
}
