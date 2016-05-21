package com.xg.service;

import com.xg.domain.Category;
import com.xg.mapper.CategoryMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 21:38.
 * @DESCRIPTION:
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class CategoryService {

    private final Log logger = LogFactory.getLog(CategoryService.class);

    @Autowired
    private CategoryMapper categoryMapper;

    public Category get(int id) {
        return categoryMapper.get(id);
    }

    public List<Category> findByName(String name) {
        return categoryMapper.findByName(name);
    }

    @Transactional(readOnly = false)
    public boolean add(Category category) {
        if (category == null) {
            return false;
        }
        category.setLastUpdate(new Date());
        categoryMapper.add(category);
        return true;
    }

    public List<Category> all() {
        return categoryMapper.all();
    }

    @Transactional(readOnly = false)
    public boolean update(Category category) {
        if (category == null) {
            return false;
        }
        categoryMapper.update(category);
        return true;
    }

    @Transactional(readOnly = false)
    public boolean delete(Category category) {
        if (category == null) {
            return false;
        }
        categoryMapper.delete(category);
        return true;
    }
}