package com.xg.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 12:58.
 * @DESCRIPTION:
 */
@JsonSerialize
public class Language implements Serializable {
    private int languageId;
    private String name;
    private Date lastUpdate;
}
