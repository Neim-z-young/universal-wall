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
     * 列出所有类别
     * @return
     */
    List<Category> listAll();

    /**
     * 分页列出类别
     * @return
     */
    List<Category> listPage(Integer pageNum, Integer pageSize);

    /**
     * 分页列出类别
     * @return
     */
    List<Category> listLimit(Integer offset, Integer pageSize);

    /**
     * 添加新类别
     * @param category
     * @param intro
     * @return
     */
    CommonResult addNewCate(String category, String intro);

    /**
     * 修改类别信息
     * @param cateId
     * @param category
     * @param intro
     * @return
     */
    CommonResult updateCate(Integer cateId, String category, String intro);

    /**
     * 删除某一类
     * @param cateId
     * @return
     */
    CommonResult deleteCate(Integer cateId);

}
