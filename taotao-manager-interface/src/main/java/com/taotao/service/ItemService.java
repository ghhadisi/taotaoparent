package com.taotao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;

/**
 * 商品相关的处理的service
 * @title ItemService.java
 * <p>description</p>
 * <p>company: www.itheima.com</p>
 * @author ljh 
 * @version 1.0
 */
public interface ItemService  extends IService<TbItem>{//
	
	/**
	 *  根据当前的页码和每页 的行数进行分页查询
	 * @param page
	 * @param rows
	 * @return
	 */
	public EasyUIDataGridResult getItemList(Integer page, Integer rows);

//	public TbItem  getById(Long itemId);

//	TbItem query();
}
