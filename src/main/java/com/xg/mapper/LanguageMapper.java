package com.xg.mapper;

import com.xg.domain.Language;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 17:18.
 * @DESCRIPTION:
 */
@Mapper
public interface LanguageMapper {

    @Select("select * from language l where l.language_id = #{id}")
    Language get(int id);

    @Select("select * from language")
    List<Language> list();

    @Insert("insert into language(name, last_update) values(#{name}, #{lastUpdate})")
    void add(Language language);


}
