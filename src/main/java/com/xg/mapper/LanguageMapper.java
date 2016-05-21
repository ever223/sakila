package com.xg.mapper;

import com.xg.domain.Language;
import org.apache.ibatis.annotations.*;

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

    @Update("update language set name = #{name}, last_update = #{lastUpdate} where language_id = #{languageId}")
    void update(Language language);

    @Delete("delete from language where language_id = #{languageId}")
    void delete(Language language);
}
