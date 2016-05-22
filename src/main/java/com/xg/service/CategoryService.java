package com.xg.service;

import com.xg.domain.Category;
import com.xg.mapper.CategoryMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable("categoryById")
    public Category get(int id) {
        return categoryMapper.get(id);
    }

    @Cacheable("categoryByName")
    public List<Category> findByName(String name) {
        return categoryMapper.findByName(name);
    }

    @CacheEvict(value = {"categoryByName"}, allEntries = true)
    @Transactional(readOnly = false)
    public Category add(Category category) {
        if (category == null) {
            return null;
        }
        category.setLastUpdate(new Date());
        categoryMapper.add(category);
        return category;
    }

    @Cacheable("categoryAll")
    public List<Category> all() {
        return categoryMapper.all();
    }

    @CacheEvict(value = {"categoryAll", "categoryByName", "categoryById"}, allEntries = true)
    @Transactional(readOnly = false)
    public boolean update(Category category) {
        return category != null && categoryMapper.update(category) == 1;
    }

    @CacheEvict(value = {"categoryAll", "categoryByName", "categoryById"}, allEntries = true)
    @Transactional(readOnly = false)
    public boolean delete(Category category) {
        return category != null && categoryMapper.delete(category) == 1;
    }
}
