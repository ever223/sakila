package com.xg.controller;

import com.xg.domain.Actor;
import com.xg.service.ActorService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-20 16:49.
 * @DESCRIPTION:
 */
@Controller
@RequestMapping("/rest/actor")
public class ActorController {
    private final Log logger = LogFactory.getLog(ActorController.class);
    @Autowired
    private ActorService actorService;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Actor findActor(@PathVariable(value = "id") int id) {
        return actorService.findActor(id);
    }
}
