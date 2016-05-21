package com.xg.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 13:02.
 * @DESCRIPTION:
 */
@JsonSerialize
public class Film implements Serializable {
    private int filmId;
    private String title;
    private String description;
    private java.sql.Date releaseYear;
    private Language language;
    private Language originalLanguage;
    private int rentalDuration;
    private BigDecimal rentalRate;
    private int length;
    private BigDecimal replacementCost;
    private RatingType rating;
    private String specialFeatures;
    private Date lastUpdate;
}
