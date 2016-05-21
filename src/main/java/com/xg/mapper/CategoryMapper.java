package com.xg.mapper;

import com.xg.domain.Category;
import com.xg.sql.CategorySqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 21:21.
 * @DESCRIPTION:
 */
@Mapper
public interface CategoryMapper {

    @SelectProvider(type = CategorySqlProvider.class, method = "getId")
    @Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE, timeout = 10000)
    @Results(id = "category", value = {
            @Result(id = true, property = "categoryId", column = "category_id", javaType = int.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "lastUpdate", column = "last_update", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP)
    })
    Category get(int id);

    @SelectProvider(type = CategorySqlProvider.class, method = "findByName")
    @Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE, timeout = 10000)
    @ResultMap("category")
    List<Category> findByName(@Param("name") String name);

    @InsertProvider(type = CategorySqlProvider.class, method = "addSql")
    @Options(flushCache = Options.FlushCachePolicy.TRUE, timeout = 20000, useGeneratedKeys = true)
    void add(Category category);

    @SelectProvider(type = CategorySqlProvider.class, method = "getAll")
    @Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE, timeout = 20000)
    List<Category> all();

    @UpdateProvider(type = CategorySqlProvider.class, method = "update")
    @Options(flushCache = Options.FlushCachePolicy.TRUE, timeout = 10000)
    void update(Category category);

    @DeleteProvider(type = CategorySqlProvider.class, method = "delete")
    @Options(flushCache = Options.FlushCachePolicy.TRUE, timeout = 10000)
    void delete(Category category);
}
