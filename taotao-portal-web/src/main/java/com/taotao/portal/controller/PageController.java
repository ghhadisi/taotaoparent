package com.taotao.portal.controller;

import com.alibaba.dubbo.common.json.JSON;
import com.taotao.content.service.ContentService;
import com.taotao.pojo.TbContent;
import com.taotao.portal.controller.pojo.Ad1Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 展示首页
 * @title PageController.java
 * <p>description</p>
 * <p>company: www.itheima.com</p>
 * @author ljh 
 * @version 1.0
 */
@Controller
public class PageController {

	@Autowired
	private ContentService contentservice;

	@Value("${AD1_CATEGORY_ID}")
	private Long categoryId;

	@Value("${AD1_HEIGHT_B}")
	private String AD1_HEIGHT_B;

	@Value("${AD1_HEIGHT}")
	private String AD1_HEIGHT;

	@Value("${AD1_WIDTH}")
	private String AD1_WIDTH;

	@Value("${AD1_WIDTH_B}")
	private String AD1_WIDTH_B;
	
	/**
	 * 展示首页
	 * @return
	 */
	//接收URL的请求http://localhost:8082/index.html
//	@RequestMapping("/index")
//	public String showIndex(){
//		return "index";//响应jsp
//	}
	/**
	 * 展示首页
	 * @return
	 */
	//接收URL的请求http://localhost:8082/index.html
	@RequestMapping("/index")
	public String showIndex(Model model) throws IOException {
		//引入服务
		//注入服务
		//添加业务逻辑，根据内容分类的id 查询 内容列表
		List<TbContent> contentlist = contentservice.getContentListByCatId(categoryId);
		//转成自定义的POJO   AD1NOde的列表
		List<Ad1Node> nodes = new ArrayList<>();
		for (TbContent tbContent : contentlist) {
			Ad1Node node = new Ad1Node();
			node.setAlt(tbContent.getSubTitle());
			node.setHeight(AD1_HEIGHT);
			node.setHeightB(AD1_HEIGHT_B);
			node.setHref(tbContent.getUrl());
			node.setSrc(tbContent.getPic());
			node.setSrcB(tbContent.getPic2());
			node.setWidth(AD1_WIDTH);
			node.setWidthB(AD1_WIDTH_B);
			nodes.add(node);
		}

		//传递数据给JSP
		model.addAttribute("ad1", JSON.json(nodes));
		return "index";//响应jsp
	}

	@RequestMapping(value = "/test")
	public String test(Model  model){
		return "test";
	}
}
