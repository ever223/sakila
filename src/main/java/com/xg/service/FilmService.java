package com.xg.service;

import com.github.pagehelper.PageHelper;
import com.xg.domain.Film;
import com.xg.mapper.FilmMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<Film> findAll(String name, int pageNo, int pageSize) {
        return filmMapper.findAll(name, new RowBounds(pageNo, pageSize));
    }
}
