package com.freeLearn.wall.service;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类管理服务
 * Create by oyoungy on 2019/10/26
 */
@Service
public interface CategoryService {
    /**
     * 通过id获取类别
     * @param cateId
     * @return
     */
    Category getById(Integer cateId);

    /**
     * 通过类别名获取类别
     * @param cateName
     * @return
     */
    List<Category> getByName(String cateName);

    /**
     * 添加新类别
     * @param cate
     * @return
     */
    CommonResult addNewCate(Category cate);

    /**
     * 修改类别信息
     * @param cateId
     * @param cate
     * @return
     */
    CommonResult updateCate(Integer cateId, Category cate);

    /**
     * 删除某一类
     * @param cateId
     * @return
     */
    CommonResult deleteCate(Integer cateId);

}
