package com.taotao.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
@Autowired
private TbItemMapper mapper;
	@Override
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		//1.设置分页的信息 使用pagehelper
		if(page==null)page=1;
		if(rows==null)rows=30;
		//2.注入mapper
		//3.创建example 对象 不需要设置查询条件
		//4.根据mapper调用查询所有数据的方法
		Page<TbItem> page2 = new Page<>(page,rows);
		IPage<TbItem> presu =mapper.selectPage(page2, new QueryWrapper<TbItem>().lambda().eq(TbItem::getCid, x));
		//6.封装到EasyUIDataGridResult
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) presu.getTotal());
		result.setRows(presu.getRecords());
		//7.返回
		return result;
	}

}
