package com.xg.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 12:48.
 * @DESCRIPTION:
 */
@JsonSerialize
public class Rental implements Serializable {
    private int rentalId;
    private Date rentalDate;
    private Inventory inventory;
    private Customer customer;
    private Date returnDate;
    private Staff staff;
    private Date lastUpdate;
}
