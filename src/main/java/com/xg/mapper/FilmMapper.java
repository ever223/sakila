package com.xg.mapper;

import com.xg.domain.Film;
import org.apache.ibatis.annotations.Mapper;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 14:15.
 * @DESCRIPTION:
 */
@Mapper
public interface FilmMapper {
    Film findByFilmId(int id);
}
