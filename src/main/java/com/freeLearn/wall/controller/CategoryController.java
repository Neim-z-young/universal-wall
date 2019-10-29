package com.freeLearn.wall.controller;

import com.freeLearn.wall.common.CommonPage;
import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.model.Category;
import com.freeLearn.wall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/pageNumListCategories")
    CommonResult getPageNumListCategories(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize){
        List<Category> categoryList = categoryService.listPage(pageNum, pageSize);
        if(CollectionUtils.isEmpty(categoryList)){
            return CommonResult.failed("暂无分类");
        }
        return CommonResult.success(CommonPage.restPage(categoryList));
    }

    @RequestMapping("/offsetListCategories")
    CommonResult getOffsetListCategories(@RequestParam(defaultValue = "1") Integer offset,
                                @RequestParam(defaultValue = "10") Integer pageSize){
        List<Category> categoryList = categoryService.listLimit(offset, pageSize);
        if(CollectionUtils.isEmpty(categoryList)){
            return CommonResult.failed("暂无分类");
        }
        return CommonResult.success(CommonPage.restPage(categoryList));
    }
}
