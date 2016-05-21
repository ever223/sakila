package com.xg.service;

import com.xg.domain.Country;
import com.xg.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-20 20:13.
 * @DESCRIPTION:
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception.class", readOnly = true)
public class CountryService {
    @Autowired
    private CountryMapper countryMapper;

    public Country findCountryById(int id) {
        return countryMapper.get(id);
    }
}
