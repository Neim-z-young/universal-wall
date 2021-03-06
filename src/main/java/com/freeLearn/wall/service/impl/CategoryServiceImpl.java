package com.freeLearn.wall.service.impl;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.mapper.CategoryMapper;
import com.freeLearn.wall.model.Category;
import com.freeLearn.wall.model.CategoryExample;
import com.freeLearn.wall.service.CategoryService;
import com.freeLearn.wall.util.DateUtil;
import com.github.pagehelper.PageHelper;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    protected static final Logger LOGGER = LogManager.getLogger();
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private DateUtil dateUtil;


    @Override
    public Category getById(Integer cateId) {
        return categoryMapper.selectByPrimaryKey(cateId);
    }

    @Override
    public List<Category> getByName(String cateName) {
        CategoryExample example = new CategoryExample();
        example.createCriteria().andCategoryLike("%"+cateName+"%");
        return categoryMapper.selectByExample(example);
    }

    @Override
    public List<Category> listAll() {
        CategoryExample example = new CategoryExample();
        return categoryMapper.selectByExample(example);
    }

    @Override
    public List<Category> listPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        CategoryExample example = new CategoryExample();
        return categoryMapper.selectByExample(example);
    }

    @Override
    public List<Category> listLimit(Integer offset, Integer pageSize) {
        PageHelper.offsetPage(offset, pageSize);
        CategoryExample example = new CategoryExample();
        return categoryMapper.selectByExample(example);
    }

    @Override
    public CommonResult addNewCate(String category, String intro) {
        Category newCate = new Category();
        newCate.setCategory(category);
        newCate.setIntroduction(intro);
        newCate.setCreateTime(dateUtil.getEpochFromDate(new Date()));
        categoryMapper.insert(newCate);
        LOGGER.info("New category: [" + category + "] added");
        return CommonResult.success(null, "新类别："+category+" 添加成功");
    }

    @Override
    public CommonResult updateCate(Integer cateId, String category, String intro) {
        Category cate = categoryMapper.selectByPrimaryKey(cateId);
        if(cate==null){
            return CommonResult.failed("无所选类别");
        }
        LOGGER.info("Update category: [" + cate.getCategory() + " : " + cate.getIntroduction()  + "] to: "
                + "[" + category + " : " + intro + "]");
        cate.setCategory(category);
        cate.setIntroduction(intro);
        categoryMapper.updateByPrimaryKeySelective(cate);
        return CommonResult.success(null, "类别信息更新成功");
    }

    @Override
    public CommonResult deleteCate(Integer cateId) {
        int res = categoryMapper.deleteByPrimaryKey(cateId);
        if(res>0){
            LOGGER.info("Delete category, whose id is: " + cateId.toString());
            return CommonResult.success(null, "删除类别成功");
        }
        return CommonResult.failed("删除失败");
    }
}
