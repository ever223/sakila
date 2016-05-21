package com.xg.service;

import com.xg.domain.Film;
import com.xg.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 14:52.
 * @DESCRIPTION:
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class FilmService {
    @Autowired
    private FilmMapper filmMapper;
    public Film findByFilmId(int id) {
        return filmMapper.findByFilmId(id);
    }
}
