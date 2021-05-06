package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Xiangcexinxi;
import com.server.XiangcexinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class XiangcexinxiController {
	@Resource
	private XiangcexinxiServer xiangcexinxiService;


   
	@RequestMapping("addXiangcexinxi.do")
	public String addXiangcexinxi(HttpServletRequest request,Xiangcexinxi xiangcexinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		xiangcexinxi.setAddtime(time.toString().substring(0, 19));
		xiangcexinxiService.add(xiangcexinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "xiangcexinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:xiangcexinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXiangcexinxi.do")
	public String doUpdateXiangcexinxi(int id,ModelMap map,Xiangcexinxi xiangcexinxi){
		xiangcexinxi=xiangcexinxiService.getById(id);
		map.put("xiangcexinxi", xiangcexinxi);
		return "xiangcexinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("xiangcexinxiDetail.do")
	public String xiangcexinxiDetail(int id,ModelMap map,Xiangcexinxi xiangcexinxi){
		xiangcexinxi=xiangcexinxiService.getById(id);
		map.put("xiangcexinxi", xiangcexinxi);
		return "xiangcexinxi_detail";
	}
//	前台详细
	@RequestMapping("xcxxDetail.do")
	public String xcxxDetail(int id,ModelMap map,Xiangcexinxi xiangcexinxi){
		xiangcexinxi=xiangcexinxiService.getById(id);
		map.put("xiangcexinxi", xiangcexinxi);
		return "xiangcexinxidetail";
	}
//	
	@RequestMapping("updateXiangcexinxi.do")
	public String updateXiangcexinxi(int id,ModelMap map,Xiangcexinxi xiangcexinxi,HttpServletRequest request,HttpSession session){
		xiangcexinxiService.update(xiangcexinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:xiangcexinxiList.do";
	}

//	分页查询
	@RequestMapping("xiangcexinxiList.do")
	public String xiangcexinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiangcexinxi xiangcexinxi, String bianhao, String xiangcebiaoti, String xiangceleixing, String xiangcefengmian, String wenjian, String tupianshuliang1,String tupianshuliang2, String jianshu, String gexingqianming, String faburiqi1,String faburiqi2, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(xiangcebiaoti==null||xiangcebiaoti.equals("")){pmap.put("xiangcebiaoti", null);}else{pmap.put("xiangcebiaoti", xiangcebiaoti);}		if(xiangceleixing==null||xiangceleixing.equals("")){pmap.put("xiangceleixing", null);}else{pmap.put("xiangceleixing", xiangceleixing);}		if(xiangcefengmian==null||xiangcefengmian.equals("")){pmap.put("xiangcefengmian", null);}else{pmap.put("xiangcefengmian", xiangcefengmian);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(tupianshuliang1==null||tupianshuliang1.equals("")){pmap.put("tupianshuliang1", null);}else{pmap.put("tupianshuliang1", tupianshuliang1);}		if(tupianshuliang2==null||tupianshuliang2.equals("")){pmap.put("tupianshuliang2", null);}else{pmap.put("tupianshuliang2", tupianshuliang2);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=xiangcexinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiangcexinxi> list=xiangcexinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiangcexinxi_list";
	}
	
	@RequestMapping("xiangcexinxi_yanben1.do")
	public String xiangcexinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiangcexinxi xiangcexinxi, String bianhao, String xiangcebiaoti, String xiangceleixing, String xiangcefengmian, String wenjian, String tupianshuliang1,String tupianshuliang2, String jianshu, String gexingqianming, String faburiqi1,String faburiqi2, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(xiangcebiaoti==null||xiangcebiaoti.equals("")){pmap.put("xiangcebiaoti", null);}else{pmap.put("xiangcebiaoti", xiangcebiaoti);}		if(xiangceleixing==null||xiangceleixing.equals("")){pmap.put("xiangceleixing", null);}else{pmap.put("xiangceleixing", xiangceleixing);}		if(xiangcefengmian==null||xiangcefengmian.equals("")){pmap.put("xiangcefengmian", null);}else{pmap.put("xiangcefengmian", xiangcefengmian);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(tupianshuliang1==null||tupianshuliang1.equals("")){pmap.put("tupianshuliang1", null);}else{pmap.put("tupianshuliang1", tupianshuliang1);}		if(tupianshuliang2==null||tupianshuliang2.equals("")){pmap.put("tupianshuliang2", null);}else{pmap.put("tupianshuliang2", tupianshuliang2);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=xiangcexinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiangcexinxi> list=xiangcexinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiangcexinxi_yanben1";
	}
	@RequestMapping("xiangcexinxi_yanben2.do")
	public String xiangcexinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiangcexinxi xiangcexinxi, String bianhao, String xiangcebiaoti, String xiangceleixing, String xiangcefengmian, String wenjian, String tupianshuliang1,String tupianshuliang2, String jianshu, String gexingqianming, String faburiqi1,String faburiqi2, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(xiangcebiaoti==null||xiangcebiaoti.equals("")){pmap.put("xiangcebiaoti", null);}else{pmap.put("xiangcebiaoti", xiangcebiaoti);}		if(xiangceleixing==null||xiangceleixing.equals("")){pmap.put("xiangceleixing", null);}else{pmap.put("xiangceleixing", xiangceleixing);}		if(xiangcefengmian==null||xiangcefengmian.equals("")){pmap.put("xiangcefengmian", null);}else{pmap.put("xiangcefengmian", xiangcefengmian);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(tupianshuliang1==null||tupianshuliang1.equals("")){pmap.put("tupianshuliang1", null);}else{pmap.put("tupianshuliang1", tupianshuliang1);}		if(tupianshuliang2==null||tupianshuliang2.equals("")){pmap.put("tupianshuliang2", null);}else{pmap.put("tupianshuliang2", tupianshuliang2);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=xiangcexinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiangcexinxi> list=xiangcexinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiangcexinxi_yanben2";
	}
	@RequestMapping("xiangcexinxi_yanben3.do")
	public String xiangcexinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiangcexinxi xiangcexinxi, String bianhao, String xiangcebiaoti, String xiangceleixing, String xiangcefengmian, String wenjian, String tupianshuliang1,String tupianshuliang2, String jianshu, String gexingqianming, String faburiqi1,String faburiqi2, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(xiangcebiaoti==null||xiangcebiaoti.equals("")){pmap.put("xiangcebiaoti", null);}else{pmap.put("xiangcebiaoti", xiangcebiaoti);}		if(xiangceleixing==null||xiangceleixing.equals("")){pmap.put("xiangceleixing", null);}else{pmap.put("xiangceleixing", xiangceleixing);}		if(xiangcefengmian==null||xiangcefengmian.equals("")){pmap.put("xiangcefengmian", null);}else{pmap.put("xiangcefengmian", xiangcefengmian);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(tupianshuliang1==null||tupianshuliang1.equals("")){pmap.put("tupianshuliang1", null);}else{pmap.put("tupianshuliang1", tupianshuliang1);}		if(tupianshuliang2==null||tupianshuliang2.equals("")){pmap.put("tupianshuliang2", null);}else{pmap.put("tupianshuliang2", tupianshuliang2);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=xiangcexinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiangcexinxi> list=xiangcexinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiangcexinxi_yanben3";
	}
	@RequestMapping("xiangcexinxi_yanben4.do")
	public String xiangcexinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiangcexinxi xiangcexinxi, String bianhao, String xiangcebiaoti, String xiangceleixing, String xiangcefengmian, String wenjian, String tupianshuliang1,String tupianshuliang2, String jianshu, String gexingqianming, String faburiqi1,String faburiqi2, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(xiangcebiaoti==null||xiangcebiaoti.equals("")){pmap.put("xiangcebiaoti", null);}else{pmap.put("xiangcebiaoti", xiangcebiaoti);}		if(xiangceleixing==null||xiangceleixing.equals("")){pmap.put("xiangceleixing", null);}else{pmap.put("xiangceleixing", xiangceleixing);}		if(xiangcefengmian==null||xiangcefengmian.equals("")){pmap.put("xiangcefengmian", null);}else{pmap.put("xiangcefengmian", xiangcefengmian);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(tupianshuliang1==null||tupianshuliang1.equals("")){pmap.put("tupianshuliang1", null);}else{pmap.put("tupianshuliang1", tupianshuliang1);}		if(tupianshuliang2==null||tupianshuliang2.equals("")){pmap.put("tupianshuliang2", null);}else{pmap.put("tupianshuliang2", tupianshuliang2);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=xiangcexinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiangcexinxi> list=xiangcexinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiangcexinxi_yanben4";
	}
	@RequestMapping("xiangcexinxi_yanben5.do")
	public String xiangcexinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiangcexinxi xiangcexinxi, String bianhao, String xiangcebiaoti, String xiangceleixing, String xiangcefengmian, String wenjian, String tupianshuliang1,String tupianshuliang2, String jianshu, String gexingqianming, String faburiqi1,String faburiqi2, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(xiangcebiaoti==null||xiangcebiaoti.equals("")){pmap.put("xiangcebiaoti", null);}else{pmap.put("xiangcebiaoti", xiangcebiaoti);}		if(xiangceleixing==null||xiangceleixing.equals("")){pmap.put("xiangceleixing", null);}else{pmap.put("xiangceleixing", xiangceleixing);}		if(xiangcefengmian==null||xiangcefengmian.equals("")){pmap.put("xiangcefengmian", null);}else{pmap.put("xiangcefengmian", xiangcefengmian);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(tupianshuliang1==null||tupianshuliang1.equals("")){pmap.put("tupianshuliang1", null);}else{pmap.put("tupianshuliang1", tupianshuliang1);}		if(tupianshuliang2==null||tupianshuliang2.equals("")){pmap.put("tupianshuliang2", null);}else{pmap.put("tupianshuliang2", tupianshuliang2);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=xiangcexinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiangcexinxi> list=xiangcexinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiangcexinxi_yanben5";
	}
	
	@RequestMapping("xiangcexinxiList2.do")
	public String xiangcexinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiangcexinxi xiangcexinxi, String bianhao, String xiangcebiaoti, String xiangceleixing, String xiangcefengmian, String wenjian, String tupianshuliang1,String tupianshuliang2, String jianshu, String gexingqianming, String faburiqi1,String faburiqi2, String faburen, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("faburen", (String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(xiangcebiaoti==null||xiangcebiaoti.equals("")){pmap.put("xiangcebiaoti", null);}else{pmap.put("xiangcebiaoti", xiangcebiaoti);}		if(xiangceleixing==null||xiangceleixing.equals("")){pmap.put("xiangceleixing", null);}else{pmap.put("xiangceleixing", xiangceleixing);}		if(xiangcefengmian==null||xiangcefengmian.equals("")){pmap.put("xiangcefengmian", null);}else{pmap.put("xiangcefengmian", xiangcefengmian);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(tupianshuliang1==null||tupianshuliang1.equals("")){pmap.put("tupianshuliang1", null);}else{pmap.put("tupianshuliang1", tupianshuliang1);}		if(tupianshuliang2==null||tupianshuliang2.equals("")){pmap.put("tupianshuliang2", null);}else{pmap.put("tupianshuliang2", tupianshuliang2);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		
		
		int total=xiangcexinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiangcexinxi> list=xiangcexinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiangcexinxi_list2";
	}	
	
	@RequestMapping("xcxxList.do")
	public String xcxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiangcexinxi xiangcexinxi, String bianhao, String xiangcebiaoti, String xiangceleixing, String xiangcefengmian, String wenjian, String tupianshuliang1,String tupianshuliang2, String jianshu, String gexingqianming, String faburiqi1,String faburiqi2, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(xiangcebiaoti==null||xiangcebiaoti.equals("")){pmap.put("xiangcebiaoti", null);}else{pmap.put("xiangcebiaoti", xiangcebiaoti);}		if(xiangceleixing==null||xiangceleixing.equals("")){pmap.put("xiangceleixing", null);}else{pmap.put("xiangceleixing", xiangceleixing);}		if(xiangcefengmian==null||xiangcefengmian.equals("")){pmap.put("xiangcefengmian", null);}else{pmap.put("xiangcefengmian", xiangcefengmian);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(tupianshuliang1==null||tupianshuliang1.equals("")){pmap.put("tupianshuliang1", null);}else{pmap.put("tupianshuliang1", tupianshuliang1);}		if(tupianshuliang2==null||tupianshuliang2.equals("")){pmap.put("tupianshuliang2", null);}else{pmap.put("tupianshuliang2", tupianshuliang2);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=xiangcexinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiangcexinxi> list=xiangcexinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiangcexinxilist";
	}
	@RequestMapping("xcxxListtp.do")
	public String xcxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xiangcexinxi xiangcexinxi, String bianhao, String xiangcebiaoti, String xiangceleixing, String xiangcefengmian, String wenjian, String tupianshuliang1,String tupianshuliang2, String jianshu, String gexingqianming, String faburiqi1,String faburiqi2, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(xiangcebiaoti==null||xiangcebiaoti.equals("")){pmap.put("xiangcebiaoti", null);}else{pmap.put("xiangcebiaoti", xiangcebiaoti);}		if(xiangceleixing==null||xiangceleixing.equals("")){pmap.put("xiangceleixing", null);}else{pmap.put("xiangceleixing", xiangceleixing);}		if(xiangcefengmian==null||xiangcefengmian.equals("")){pmap.put("xiangcefengmian", null);}else{pmap.put("xiangcefengmian", xiangcefengmian);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(tupianshuliang1==null||tupianshuliang1.equals("")){pmap.put("tupianshuliang1", null);}else{pmap.put("tupianshuliang1", tupianshuliang1);}		if(tupianshuliang2==null||tupianshuliang2.equals("")){pmap.put("tupianshuliang2", null);}else{pmap.put("tupianshuliang2", tupianshuliang2);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=xiangcexinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xiangcexinxi> list=xiangcexinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xiangcexinxilisttp";
	}
	
	@RequestMapping("deleteXiangcexinxi.do")
	public String deleteXiangcexinxi(int id,HttpServletRequest request){
		xiangcexinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:xiangcexinxiList.do";
	}
	
	
}
