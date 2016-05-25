package com.xg.mapper;

import com.xg.domain.Film;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 14:15.
 * @DESCRIPTION:
 */
@Mapper
public interface FilmMapper {
    Film findByFilmId(int id);
    List<Film> findAll(String name, RowBounds rowBounds);
}
