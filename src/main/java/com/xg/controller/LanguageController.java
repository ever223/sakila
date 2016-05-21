package com.xg.controller;

import com.xg.domain.Language;
import com.xg.service.LanguageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 17:27.
 * @DESCRIPTION:
 */

@Controller
@RequestMapping("/rest/language")
public class LanguageController {
    private final Log logger = LogFactory.getLog(LanguageController.class);

    @Autowired
    private LanguageService languageService;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Language getLanguage(@PathVariable(value = "id") int id) {
        return languageService.get(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Language> getLanguageList() {
        return languageService.list();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public boolean getLanguageList(@RequestBody Language language) {
        return languageService.add(language);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateLanguageList(@RequestBody Language language) {
        return languageService.update(language);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteLanguageList(@RequestBody Language language) {
        return languageService.delete(language);
    }

}
