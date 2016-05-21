package com.xg.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 12:58.
 * @DESCRIPTION:
 */
@Alias("Language")
@JsonSerialize
public class Language implements Serializable {
    private int languageId;
    private String name;
    private Date lastUpdate;

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
