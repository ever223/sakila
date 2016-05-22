package com.xg.sql;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 21:25.
 * @DESCRIPTION:
 */
public class CategorySqlProvider {
    private final static String TABLE_NAME = "category";

    public String getId() {
        return new SQL() {{
            SELECT("*");
            FROM(TABLE_NAME);
            WHERE("category_id = #{id}");
        }}.toString();
    }

    public String findByName(final String name) {
        return new SQL() {{
            SELECT("*");
            FROM(TABLE_NAME);
            if (StringUtils.isNotEmpty(name)) {
                WHERE("binary name like concat('%', #{name}, '%')");
            }
        }}.toString();
    }

    public String addSql() {
        return new SQL() {{
            INSERT_INTO(TABLE_NAME);
            VALUES("name", "#{name, javaType=string, jdbcType=VARCHAR}");
            VALUES("last_update", "#{lastUpdate, javaType=date, jdbcType=TIMESTAMP}");}
        }.toString();
    }

    public String getAll() {
        return new SQL() {{
            SELECT("*");
            FROM(TABLE_NAME);
        }}.toString();
    }

    public String update() {
        return new SQL() {{
            UPDATE(TABLE_NAME);
            SET("name = #{name}");
            SET("last_update = #{lastUpdate}");
            WHERE("category_id = #{categoryId}");
        }}.toString();
    }

    public String delete() {
        return new SQL() {{
            DELETE_FROM(TABLE_NAME);
            WHERE("category_id = #{categoryId}");
        }}.toString();
    }
}
