package com.freeLearn.wall.service;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.domain.PostingBrief;
import com.freeLearn.wall.domain.PostingDetails;
import com.freeLearn.wall.dto.PostingParam;
import com.freeLearn.wall.model.InsideFloor;
import com.freeLearn.wall.model.Posting;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 帖子服务
 * Create by oyoungy on 2019/10/26
 */
public interface PostingService {
    /**
     * 列出所有帖子的简略信息
     * @return
     */
    CommonResult listAll();

    /**
     * 按页码，页大小列出帖子的简略信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PostingBrief> listPage(Integer pageNum, Integer pageSize);

    /**
     * 按行位移，页大小列出帖子的简略信息
     * @param offset
     * @param pageSize
     * @return
     */
    List<PostingBrief> listLimit(Integer offset, Integer pageSize);

    /**
     * 根据类别列出帖子
     * @param cateId
     * @return
     */
    List<PostingBrief> listAllByCateId(Integer cateId);

    /**
     * 按类别，页码，页大小列出帖子的简略信息
     * @param cateId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PostingBrief> listPageByCateId(Integer cateId, Integer pageNum, Integer pageSize);

    /**
     * 按类别，行位移，页大小列出帖子的简略信息
     * @param cateId
     * @param offset
     * @param pageSize
     * @return
     */
    List<PostingBrief> listLimitByCateId(Integer cateId, Integer offset, Integer pageSize);

    /**
     * 通过发布者获取帖子
     * @param posterId
     * @return
     */
    List<PostingBrief> listAllByPosterId(Integer posterId);

    /**
     * 分页（by pageNum)获取发布者的帖子
     * @param posterId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PostingBrief> listPageByPosterId(Integer posterId, Integer pageNum, Integer pageSize);

    /**
     * 分页（by offset)获取发布者的帖子
     * @param posterId
     * @param offset
     * @param pageSize
     * @return
     */
    List<PostingBrief> listLimitByPosterId(Integer posterId, Integer offset, Integer pageSize);

    /**
     * 查找帖子
     * @param postingId
     * @return
     */
    Posting getById(Integer postingId);

    /**
     * 根据帖子Id获取帖子详细内容
     * @param postingId
     * @return
     */
    CommonResult getDetailedById(Integer postingId);

    /**
     * 发布新帖子
     * @param posterId
     * @param postingParam
     * @return
     */
    CommonResult addNewPosting(Integer posterId, PostingParam postingParam);

    /**
     * 修改帖子
     * @param postingId
     * @param detailedIntroduction
     * @param pictureIntroduction
     * @return
     */
    CommonResult updatePosting(Integer postingId, String detailedIntroduction, String pictureIntroduction);

    /**
     * 删除帖子
     * @param postingId
     * @return
     */
    CommonResult deletePosting(Integer postingId);

}
