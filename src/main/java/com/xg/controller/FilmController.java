package com.xg.controller;

import com.xg.domain.Film;
import com.xg.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 14:54.
 * @DESCRIPTION:
 */
@Controller
@RequestMapping(value = "/rest/film")
public class FilmController {

    @Autowired
    private FilmService filmService;
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Film getCountry(@PathVariable int id) {
        return filmService.findByFilmId(id);
    }
}
