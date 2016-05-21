package com.xg.mapper;

import com.xg.domain.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-20 20:05.
 * @DESCRIPTION:
 */
@Mapper
public interface CountryMapper {
    @Select("select * from country where country_id = #{id}")
    Country get(int id);
}
