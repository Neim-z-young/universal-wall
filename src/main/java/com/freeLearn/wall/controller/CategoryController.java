package com.freeLearn.wall.controller;

import com.freeLearn.wall.common.CommonPage;
import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.model.Category;
import com.freeLearn.wall.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "CategoryController", description = "类别管理")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation("按页码分页列出类别列表")
    @RequestMapping(value = "/pageNumListCategories", method = RequestMethod.GET)
    CommonResult getPageNumListCategories(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize){
        List<Category> categoryList = categoryService.listPage(pageNum, pageSize);
        if(CollectionUtils.isEmpty(categoryList)){
            return CommonResult.failed("暂无分类");
        }
        return CommonResult.success(CommonPage.restPage(categoryList));
    }

    @ApiOperation("按offset分页列出类别列表")
    @RequestMapping(value = "/offsetListCategories", method = RequestMethod.GET)
    CommonResult getOffsetListCategories(@RequestParam(defaultValue = "1") Integer offset,
                                @RequestParam(defaultValue = "10") Integer pageSize){
        List<Category> categoryList = categoryService.listLimit(offset, pageSize);
        if(CollectionUtils.isEmpty(categoryList)){
            return CommonResult.failed("暂无分类");
        }
        return CommonResult.success(CommonPage.restPage(categoryList));
    }
}
