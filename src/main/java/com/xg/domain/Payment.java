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
public class Payment implements Serializable {
    private int paymentId;
    private Staff manageStaff;
    private Address address;
    private Date lastUpdate;
}
