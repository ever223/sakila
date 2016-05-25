package com.xg.controller;

import com.github.pagehelper.PageInfo;
import com.xg.domain.Category;
import com.xg.domain.Film;
import com.xg.mapper.FilmMapper;
import com.xg.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.spi.ObjectFactory;
import java.util.List;

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
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Film> page(@RequestParam(required = false) String name,
                            @RequestParam(required = false) Integer pageNo,
                           @RequestParam(required = false) Integer pageSize) {
        if (pageNo == null) {
            pageNo = 1;
        }
        if (pageSize == null) {
            pageSize= 10;
        }
        return new PageInfo<>(filmService.findAll(name, pageNo, pageSize));
    }
}
