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

import com.entity.Shipinxinxi;
import com.server.ShipinxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShipinxinxiController {
	@Resource
	private ShipinxinxiServer shipinxinxiService;


   
	@RequestMapping("addShipinxinxi.do")
	public String addShipinxinxi(HttpServletRequest request,Shipinxinxi shipinxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shipinxinxi.setAddtime(time.toString().substring(0, 19));
		shipinxinxiService.add(shipinxinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shipinxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shipinxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShipinxinxi.do")
	public String doUpdateShipinxinxi(int id,ModelMap map,Shipinxinxi shipinxinxi){
		shipinxinxi=shipinxinxiService.getById(id);
		map.put("shipinxinxi", shipinxinxi);
		return "shipinxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shipinxinxiDetail.do")
	public String shipinxinxiDetail(int id,ModelMap map,Shipinxinxi shipinxinxi){
		shipinxinxi=shipinxinxiService.getById(id);
		map.put("shipinxinxi", shipinxinxi);
		return "shipinxinxi_detail";
	}
//	前台详细
	@RequestMapping("spxxDetail.do")
	public String spxxDetail(int id,ModelMap map,Shipinxinxi shipinxinxi){
		shipinxinxi=shipinxinxiService.getById(id);
		map.put("shipinxinxi", shipinxinxi);
		return "shipinxinxidetail";
	}
//	
	@RequestMapping("updateShipinxinxi.do")
	public String updateShipinxinxi(int id,ModelMap map,Shipinxinxi shipinxinxi,HttpServletRequest request,HttpSession session){
		shipinxinxiService.update(shipinxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shipinxinxiList.do";
	}

//	分页查询
	@RequestMapping("shipinxinxiList.do")
	public String shipinxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shipinxinxi shipinxinxi, String bianhao, String shipinbiaoti, String shipinleixing, String tupian, String shipin, String jianshu, String gerenqianming, String faburiqi1,String faburiqi2, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shipinbiaoti==null||shipinbiaoti.equals("")){pmap.put("shipinbiaoti", null);}else{pmap.put("shipinbiaoti", shipinbiaoti);}		if(shipinleixing==null||shipinleixing.equals("")){pmap.put("shipinleixing", null);}else{pmap.put("shipinleixing", shipinleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(shipin==null||shipin.equals("")){pmap.put("shipin", null);}else{pmap.put("shipin", shipin);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gerenqianming==null||gerenqianming.equals("")){pmap.put("gerenqianming", null);}else{pmap.put("gerenqianming", gerenqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=shipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shipinxinxi> list=shipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shipinxinxi_list";
	}
	
	@RequestMapping("shipinxinxi_yanben1.do")
	public String shipinxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shipinxinxi shipinxinxi, String bianhao, String shipinbiaoti, String shipinleixing, String tupian, String shipin, String jianshu, String gerenqianming, String faburiqi1,String faburiqi2, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shipinbiaoti==null||shipinbiaoti.equals("")){pmap.put("shipinbiaoti", null);}else{pmap.put("shipinbiaoti", shipinbiaoti);}		if(shipinleixing==null||shipinleixing.equals("")){pmap.put("shipinleixing", null);}else{pmap.put("shipinleixing", shipinleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(shipin==null||shipin.equals("")){pmap.put("shipin", null);}else{pmap.put("shipin", shipin);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gerenqianming==null||gerenqianming.equals("")){pmap.put("gerenqianming", null);}else{pmap.put("gerenqianming", gerenqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=shipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shipinxinxi> list=shipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shipinxinxi_yanben1";
	}
	@RequestMapping("shipinxinxi_yanben2.do")
	public String shipinxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shipinxinxi shipinxinxi, String bianhao, String shipinbiaoti, String shipinleixing, String tupian, String shipin, String jianshu, String gerenqianming, String faburiqi1,String faburiqi2, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shipinbiaoti==null||shipinbiaoti.equals("")){pmap.put("shipinbiaoti", null);}else{pmap.put("shipinbiaoti", shipinbiaoti);}		if(shipinleixing==null||shipinleixing.equals("")){pmap.put("shipinleixing", null);}else{pmap.put("shipinleixing", shipinleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(shipin==null||shipin.equals("")){pmap.put("shipin", null);}else{pmap.put("shipin", shipin);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gerenqianming==null||gerenqianming.equals("")){pmap.put("gerenqianming", null);}else{pmap.put("gerenqianming", gerenqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=shipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shipinxinxi> list=shipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shipinxinxi_yanben2";
	}
	@RequestMapping("shipinxinxi_yanben3.do")
	public String shipinxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shipinxinxi shipinxinxi, String bianhao, String shipinbiaoti, String shipinleixing, String tupian, String shipin, String jianshu, String gerenqianming, String faburiqi1,String faburiqi2, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shipinbiaoti==null||shipinbiaoti.equals("")){pmap.put("shipinbiaoti", null);}else{pmap.put("shipinbiaoti", shipinbiaoti);}		if(shipinleixing==null||shipinleixing.equals("")){pmap.put("shipinleixing", null);}else{pmap.put("shipinleixing", shipinleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(shipin==null||shipin.equals("")){pmap.put("shipin", null);}else{pmap.put("shipin", shipin);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gerenqianming==null||gerenqianming.equals("")){pmap.put("gerenqianming", null);}else{pmap.put("gerenqianming", gerenqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=shipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shipinxinxi> list=shipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shipinxinxi_yanben3";
	}
	@RequestMapping("shipinxinxi_yanben4.do")
	public String shipinxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shipinxinxi shipinxinxi, String bianhao, String shipinbiaoti, String shipinleixing, String tupian, String shipin, String jianshu, String gerenqianming, String faburiqi1,String faburiqi2, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shipinbiaoti==null||shipinbiaoti.equals("")){pmap.put("shipinbiaoti", null);}else{pmap.put("shipinbiaoti", shipinbiaoti);}		if(shipinleixing==null||shipinleixing.equals("")){pmap.put("shipinleixing", null);}else{pmap.put("shipinleixing", shipinleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(shipin==null||shipin.equals("")){pmap.put("shipin", null);}else{pmap.put("shipin", shipin);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gerenqianming==null||gerenqianming.equals("")){pmap.put("gerenqianming", null);}else{pmap.put("gerenqianming", gerenqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=shipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shipinxinxi> list=shipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shipinxinxi_yanben4";
	}
	@RequestMapping("shipinxinxi_yanben5.do")
	public String shipinxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shipinxinxi shipinxinxi, String bianhao, String shipinbiaoti, String shipinleixing, String tupian, String shipin, String jianshu, String gerenqianming, String faburiqi1,String faburiqi2, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shipinbiaoti==null||shipinbiaoti.equals("")){pmap.put("shipinbiaoti", null);}else{pmap.put("shipinbiaoti", shipinbiaoti);}		if(shipinleixing==null||shipinleixing.equals("")){pmap.put("shipinleixing", null);}else{pmap.put("shipinleixing", shipinleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(shipin==null||shipin.equals("")){pmap.put("shipin", null);}else{pmap.put("shipin", shipin);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gerenqianming==null||gerenqianming.equals("")){pmap.put("gerenqianming", null);}else{pmap.put("gerenqianming", gerenqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=shipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shipinxinxi> list=shipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shipinxinxi_yanben5";
	}
	
	@RequestMapping("shipinxinxiList2.do")
	public String shipinxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shipinxinxi shipinxinxi, String bianhao, String shipinbiaoti, String shipinleixing, String tupian, String shipin, String jianshu, String gerenqianming, String faburiqi1,String faburiqi2, String faburen, String issh,HttpServletRequest request){
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
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shipinbiaoti==null||shipinbiaoti.equals("")){pmap.put("shipinbiaoti", null);}else{pmap.put("shipinbiaoti", shipinbiaoti);}		if(shipinleixing==null||shipinleixing.equals("")){pmap.put("shipinleixing", null);}else{pmap.put("shipinleixing", shipinleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(shipin==null||shipin.equals("")){pmap.put("shipin", null);}else{pmap.put("shipin", shipin);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gerenqianming==null||gerenqianming.equals("")){pmap.put("gerenqianming", null);}else{pmap.put("gerenqianming", gerenqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		
		
		int total=shipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shipinxinxi> list=shipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shipinxinxi_list2";
	}	
	
	@RequestMapping("spxxList.do")
	public String spxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shipinxinxi shipinxinxi, String bianhao, String shipinbiaoti, String shipinleixing, String tupian, String shipin, String jianshu, String gerenqianming, String faburiqi1,String faburiqi2, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shipinbiaoti==null||shipinbiaoti.equals("")){pmap.put("shipinbiaoti", null);}else{pmap.put("shipinbiaoti", shipinbiaoti);}		if(shipinleixing==null||shipinleixing.equals("")){pmap.put("shipinleixing", null);}else{pmap.put("shipinleixing", shipinleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(shipin==null||shipin.equals("")){pmap.put("shipin", null);}else{pmap.put("shipin", shipin);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gerenqianming==null||gerenqianming.equals("")){pmap.put("gerenqianming", null);}else{pmap.put("gerenqianming", gerenqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=shipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shipinxinxi> list=shipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shipinxinxilist";
	}
	@RequestMapping("spxxListtp.do")
	public String spxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shipinxinxi shipinxinxi, String bianhao, String shipinbiaoti, String shipinleixing, String tupian, String shipin, String jianshu, String gerenqianming, String faburiqi1,String faburiqi2, String faburen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(shipinbiaoti==null||shipinbiaoti.equals("")){pmap.put("shipinbiaoti", null);}else{pmap.put("shipinbiaoti", shipinbiaoti);}		if(shipinleixing==null||shipinleixing.equals("")){pmap.put("shipinleixing", null);}else{pmap.put("shipinleixing", shipinleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(shipin==null||shipin.equals("")){pmap.put("shipin", null);}else{pmap.put("shipin", shipin);}		if(jianshu==null||jianshu.equals("")){pmap.put("jianshu", null);}else{pmap.put("jianshu", jianshu);}		if(gerenqianming==null||gerenqianming.equals("")){pmap.put("gerenqianming", null);}else{pmap.put("gerenqianming", gerenqianming);}		if(faburiqi1==null||faburiqi1.equals("")){pmap.put("faburiqi1", null);}else{pmap.put("faburiqi1", faburiqi1);}		if(faburiqi2==null||faburiqi2.equals("")){pmap.put("faburiqi2", null);}else{pmap.put("faburiqi2", faburiqi2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=shipinxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shipinxinxi> list=shipinxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shipinxinxilisttp";
	}
	
	@RequestMapping("deleteShipinxinxi.do")
	public String deleteShipinxinxi(int id,HttpServletRequest request){
		shipinxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shipinxinxiList.do";
	}
	
	
}
