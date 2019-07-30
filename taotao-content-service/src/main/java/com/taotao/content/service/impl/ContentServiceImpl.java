package com.taotao.content.service.impl;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.taotao.content.service.jdis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private JedisClient jedisClient;
	@Autowired
	private TbContentMapper mapper;

	@Value("${CONTENT_KEY}")
	private String CONTENT_KEY ;
	
	@Override
	public TaotaoResult saveContent(TbContent content) {
		//1.注入mapper
		
		//2.补全其他的属性
		content.setCreated(new Date());
		content.setUpdated(content.getCreated());
		//3.插入内容表中
		mapper.insert(content);
		return TaotaoResult.ok();
	}

	@Override
	public List<TbContent> getContentListByCatId(Long categoryId) {

		List<TbContent> list ;
		try{
			String str  =jedisClient.get(CONTENT_KEY);
			if (str !=null && str.length() > 0){
				list = JSON.parseArray(str, TbContent.class);
				System.err.println("---------jedisClient  cache--------------");
				return  list;
			}
		}catch (Exception e1){

		}
		list = mapper.selectList(new QueryWrapper<TbContent>().lambda().eq(TbContent::getCategoryId,categoryId));
		try{
			if (list != null){
				jedisClient.set(CONTENT_KEY, JSON.toJSONString(list));
			}
		}catch (Exception e1){

		}

		return list;
	}

}
