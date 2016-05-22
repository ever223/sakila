package com.xg.controller;

import com.xg.domain.Category;
import com.xg.service.CategoryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 22:14.
 * @DESCRIPTION:
 */
@Controller
@RequestMapping("/rest/category")
public class CategoryController {
    private final Log logger = LogFactory.getLog(CategoryController.class);
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Category getCategory(@PathVariable(value = "id") int id) {
        return categoryService.get(id);
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getCategory(@RequestParam(value = "name", required = true) String name) {
        return categoryService.findByName(name);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Category getCategory(@RequestBody Category category) {
        return categoryService.add(category);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getAllCategory() {
        return categoryService.all();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateCategory(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteCategory(@RequestBody Category category) {
        return categoryService.delete(category);
    }
}
