package com.taotao.sso.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.sso.service.UserRegisterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
    @Autowired
    private TbUserMapper usermapper;
    @Override
    public TaotaoResult checkData(String param, Integer type) {
        TbUser user;
        switch (type){
            case 1:
                user  = usermapper.selectOne(new QueryWrapper<TbUser>().lambda().eq(TbUser::getUsername, param));
                break;
            case 2:
                user  = usermapper.selectOne(new QueryWrapper<TbUser>().lambda().eq(TbUser::getPhone, param));

                break;
            case 3:
                user  = usermapper.selectOne(new QueryWrapper<TbUser>().lambda().eq(TbUser::getEmail, param));

                break;
                default:
                    return TaotaoResult.build(400, "非法的参数");

        }
        if (user ==null){
            return  TaotaoResult.ok(true);
        }else {
            return TaotaoResult.ok(false);

        }
    }

    @Override
    public TaotaoResult register(TbUser user) {
        //1.注入mapper
        //2.校验数据
        //2.1 校验用户名和密码不能为空
        if(StringUtils.isEmpty(user.getUsername())){
            return TaotaoResult.build(400, "注册失败. 请校验数据后请再提交数据");
        }
        if(StringUtils.isEmpty(user.getPassword())){
            return TaotaoResult.build(400, "注册失败. 请校验数据后请再提交数据");
        }
        //2.2 校验用户名是否被注册了
        TaotaoResult result = checkData(user.getUsername(),1);
        if(!(boolean)result.getData()){
            //数据不可用
            return TaotaoResult.build(400, "注册失败. 请校验数据后请再提交数据");
        }
        //2.3 校验电话号码是否被注册了
        if(StringUtils.isNotBlank(user.getPhone())){
            TaotaoResult result2 = checkData(user.getPhone(),2);
            if(!(boolean)result2.getData()){
                //数据不可用
                return TaotaoResult.build(400, "注册失败. 请校验数据后请再提交数据");
            }
        }
        //2.4 校验email是否被注册了
        if(StringUtils.isNotBlank(user.getEmail())){
            TaotaoResult result2 = checkData(user.getEmail(),3);
            if(!(boolean)result2.getData()){
                //数据不可用
                return TaotaoResult.build(400, "注册失败. 请校验数据后请再提交数据");
            }
        }
        //3.如果校验成功   补全其他的属性
        user.setCreated(new Date());
        user.setUpdated(user.getCreated());
        //4.对密码进行MD5加密
        String md5password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5password);
        //5.插入数据
        usermapper.insert(user);
        //6.返回taotaoresult
        return TaotaoResult.ok();
    }
}
