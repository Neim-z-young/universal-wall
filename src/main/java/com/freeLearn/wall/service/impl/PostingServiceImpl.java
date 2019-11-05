package com.freeLearn.wall.service.impl;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.dao.PostingBriefDao;
import com.freeLearn.wall.domain.PostingBrief;
import com.freeLearn.wall.domain.PostingDetails;
import com.freeLearn.wall.dto.PostingParam;
import com.freeLearn.wall.mapper.PostingMapper;
import com.freeLearn.wall.model.Posting;
import com.freeLearn.wall.service.PostingService;
import com.freeLearn.wall.util.DateUtil;
import com.freeLearn.wall.util.StringUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class PostingServiceImpl implements PostingService {
    @Autowired
    private PostingMapper postingMapper;

    @Autowired
    private PostingBriefDao postingBriefDao;

    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private StringUtil stringUtil;

    @Override
    public CommonResult listAll() {
        List<PostingBrief> postingBriefList = postingBriefDao.listAll();
        if(CollectionUtils.isEmpty(postingBriefList)){
            return CommonResult.failed("无可查看的帖子");
        }
        return CommonResult.success(postingBriefList, "帖子查询成功");
    }

    @Override
    public List<PostingBrief> listPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return postingBriefDao.listAll();

    }

    @Override
    public List<PostingBrief> listLimit(Integer offset, Integer pageSize) {
        PageHelper.offsetPage(offset, pageSize);
        return postingBriefDao.listAll();
    }

    @Override
    public List<PostingBrief> listAllByCateId(Integer cateId) {
        return postingBriefDao.listAllByCateId(cateId);

    }

    @Override
    public List<PostingBrief> listPageByCateId(Integer cateId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return postingBriefDao.listAllByCateId(cateId);
    }

    @Override
    public List<PostingBrief> listLimitByCateId(Integer cateId, Integer offset, Integer pageSize) {
        PageHelper.offsetPage(offset, pageSize);
        return postingBriefDao.listAllByCateId(cateId);
    }

    @Override
    public List<PostingBrief> listAllByPosterId(Integer posterId) {
        return postingBriefDao.listAllByPosterId(posterId);
    }

    @Override
    public List<PostingBrief> listPageByPosterId(Integer posterId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return postingBriefDao.listAllByPosterId(posterId);
    }

    @Override
    public List<PostingBrief> listLimitByPosterId(Integer posterId, Integer offset, Integer pageSize) {
        PageHelper.offsetPage(offset, pageSize);
        return postingBriefDao.listAllByPosterId(posterId);
    }

    @Override
    public Posting getById(Integer postingId) {
        return postingMapper.selectByPrimaryKey(postingId);
    }

    //TODO 二期任务
    @Override
    public CommonResult getDetailedById(Integer postingId) {
        return null;
    }

    @Override
    public CommonResult addNewPosting(Integer posterId, PostingParam postingParam) {
        Posting posting = new Posting();
        BeanUtils.copyProperties(postingParam, posting);
        posting.setPosterId(posterId);
        posting.setBriefIntroduction(stringUtil.cutStringHead(posting.getDetailedIntroduction(), 20));
        posting.setReleaseTime(dateUtil.getEpochFromDate(new Date()));
        int res = postingMapper.insert(posting);
        if(res>0){
            return CommonResult.success(null, "发帖成功");
        }
        return CommonResult.failed("发帖失败");
    }

    @Override
    public CommonResult updatePosting(Integer postingId, String detailedIntroduction, String pictureIntroduction) {
        Posting posting = postingMapper.selectByPrimaryKey(postingId);
        if(posting==null){
            return CommonResult.failed("帖子不存在");
        }
        if(detailedIntroduction!=null){
            posting.setBriefIntroduction(stringUtil.cutStringHead(detailedIntroduction, 20));
            posting.setDetailedIntroduction(detailedIntroduction);
        }
        posting.setPictureIntroduction(pictureIntroduction);
        int res = postingMapper.updateByPrimaryKeySelective(posting);
        if(res>0){
            return CommonResult.success(null, "修改成功");
        }
        return CommonResult.failed("修改失败");
    }

    @Override
    public CommonResult deletePosting(Integer postingId) {
        int res = postingMapper.deleteByPrimaryKey(postingId);
        if(res>0){
            return CommonResult.success(null, "删除成功");
        }
        return CommonResult.failed("删除失败");
    }
}
