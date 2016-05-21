package com.xg.domain;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 12:52.
 * @DESCRIPTION:
 */
public class Inventory implements Serializable {
    private int inventoryId;
    private Film film;
    private Store store;
    private Date lastUpdate;
}
