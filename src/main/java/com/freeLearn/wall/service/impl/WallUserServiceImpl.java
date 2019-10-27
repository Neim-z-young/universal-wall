package com.freeLearn.wall.service.impl;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.domain.WallUserDetails;
import com.freeLearn.wall.mapper.WallUserMapper;
import com.freeLearn.wall.model.WallUser;
import com.freeLearn.wall.model.WallUserExample;
import com.freeLearn.wall.service.WallUserService;
import com.freeLearn.wall.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * 用户服务实现类
 * Create by oyoungy on 2019/10/26
 */
public class WallUserServiceImpl implements WallUserService {
    @Autowired
    private WallUserMapper wallUserMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DateUtil dateUtil;

    @Override
    public WallUser getByUsername(String username) {
        WallUserExample example = new WallUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<WallUser> userList = wallUserMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(userList)){  //判断null和size为0
            return userList.get(0);
        }
        return null;
    }

    @Override
    public WallUser getByUserId(Integer userId) {
        return wallUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public WallUser getByOpenId(String openId) {
        WallUserExample example = new WallUserExample();
        example.createCriteria().andOpenIdEqualTo(openId);
        List<WallUser> userList = wallUserMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(userList)){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public CommonResult register(String username, String password) {
        //查询用户是否存在
        WallUser user = getByUsername(username);
        if(user!=null){
            return CommonResult.failed("用户名已存在");
        }
        WallUser newUser = new WallUser();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setSignupTime(dateUtil.getEpochFromDate(new Date()));
        newUser.setStatus(true);
        newUser.setGender(0);
        newUser.setPoints(0);
        newUser.setGrowth(0);

        wallUserMapper.insert(newUser);
        newUser.setPassword(null);
        return CommonResult.success(null, "注册成功");
    }

    @Override
    public CommonResult updatePassword(String username, String oldPassword, String newPassword) {
        WallUser user = getByUsername(username);
        if(user==null){
            return CommonResult.failed("用户不存在");
        }
        if (!user.getPassword().equals(passwordEncoder.encode(oldPassword))) {
            return CommonResult.failed("原密码错误");
        }
        user.setPassword(newPassword);
        wallUserMapper.updateByPrimaryKeySelective(user);
        return CommonResult.success(null, "密码修改成功");
    }

    @Override
    public WallUser getCurrentUser() {
        WallUserDetails userDetails = (WallUserDetails) SecurityContextHolder
                                        .getContext()
                                        .getAuthentication()
                                        .getPrincipal();
        return userDetails.getUser();
    }

    @Override
    public CommonResult updateNickName(Integer userId, String newNickName) {
        WallUser user = new WallUser();
        user.setId(userId);
        user.setNickName(newNickName);
        wallUserMapper.updateByPrimaryKeySelective(user);
        return CommonResult.success(null, "昵称修改成功");
    }


    @Override
    public void updateGrowth(Integer userId, Integer growth) {
        WallUser user = new WallUser();
        user.setId(userId);
        user.setGrowth(growth);
        wallUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void updatePoints(Integer userId, Integer newPoints) {
        WallUser user = new WallUser();
        user.setId(userId);
        user.setPoints(newPoints);
        wallUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public String login(String username, String password) {

        return null;
    }
}
