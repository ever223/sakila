package com.xg.controller;

import com.xg.domain.Actor;
import com.xg.service.ActorService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "/first_name/{first_name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Actor> findActorByFirstName(@PathVariable(value = "first_name") String first_name) {
        return actorService.findActorByFirstName(first_name);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public boolean add(@RequestBody Actor actor) {
        if (actor == null) {
            return false;
        }
        actor.setLastUpdate(new Date());
        actorService.insertActor(actor);
        return true;
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean delete(@RequestBody Actor actor) {
        if (actor == null) {
            return false;
        }
        actorService.deleteActor(actor);
        return true;
    }
}
