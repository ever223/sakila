package com.xg.controller;

import com.xg.domain.Country;
import com.xg.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-20 20:27.
 * @DESCRIPTION:
 */
@Controller
@RequestMapping(value = "/rest/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Country getCountry(@PathVariable int id) {
        return countryService.findCountryById(id);
    }
}
