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

import com.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Zhuceyonghu;
import com.server.ZhuceyonghuServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ZhuceyonghuController {
	@Resource
	private ZhuceyonghuServer zhuceyonghuService;


   
	@RequestMapping("addZhuceyonghu.do")
	public String addZhuceyonghu(HttpServletRequest request,Zhuceyonghu zhuceyonghu,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		zhuceyonghu.setAddtime(time.toString().substring(0, 19));
		MD5Util md5 = new MD5Util();
		zhuceyonghu.setMima(md5.md5(zhuceyonghu.getMima()));
		zhuceyonghuService.add(zhuceyonghu);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "zhuceyonghuList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:zhuceyonghuList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateZhuceyonghu.do")
	public String doUpdateZhuceyonghu(int id,ModelMap map,Zhuceyonghu zhuceyonghu){
		zhuceyonghu=zhuceyonghuService.getById(id);
		map.put("zhuceyonghu", zhuceyonghu);
		return "zhuceyonghu_updt";
	}
	
	@RequestMapping("doUpdateZhuceyonghu2.do")
	public String doUpdateZhuceyonghu2(ModelMap map,Zhuceyonghu zhuceyonghu,HttpServletRequest request){
		zhuceyonghu=zhuceyonghuService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("zhuceyonghu", zhuceyonghu);
		return "zhuceyonghu_updt2";
	}
	
@RequestMapping("updateZhuceyonghu2.do")
	public String updateZhuceyonghu2(int id,ModelMap map,Zhuceyonghu zhuceyonghu){
		zhuceyonghuService.update(zhuceyonghu);
		return "redirect:doUpdateZhuceyonghu2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("zhuceyonghuDetail.do")
	public String zhuceyonghuDetail(int id,ModelMap map,Zhuceyonghu zhuceyonghu){
		zhuceyonghu=zhuceyonghuService.getById(id);
		map.put("zhuceyonghu", zhuceyonghu);
		return "zhuceyonghu_detail";
	}
//	前台详细
	@RequestMapping("zcyhDetail.do")
	public String zcyhDetail(int id,ModelMap map,Zhuceyonghu zhuceyonghu){
		zhuceyonghu=zhuceyonghuService.getById(id);
		map.put("zhuceyonghu", zhuceyonghu);
		return "zhuceyonghudetail";
	}
//	
	@RequestMapping("updateZhuceyonghu.do")
	public String updateZhuceyonghu(int id,ModelMap map,Zhuceyonghu zhuceyonghu,HttpServletRequest request,HttpSession session){
		zhuceyonghuService.update(zhuceyonghu);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:zhuceyonghuList.do";
	}

//	分页查询
	@RequestMapping("zhuceyonghuList.do")
	public String zhuceyonghuList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuceyonghu zhuceyonghu, String yonghuming, String mima, String cheng, String xingming, String xingbie, String touxiang, String shengri1,String shengri2, String xingzuo, String shenfenzheng, String shouji, String gexingqianming, String aihao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);


		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima",mima);}
		if(cheng==null||cheng.equals("")){pmap.put("cheng", null);}else{pmap.put("cheng", cheng);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(touxiang==null||touxiang.equals("")){pmap.put("touxiang", null);}else{pmap.put("touxiang", touxiang);}
		if(shengri1==null||shengri1.equals("")){pmap.put("shengri1", null);}else{pmap.put("shengri1", shengri1);}
		if(shengri2==null||shengri2.equals("")){pmap.put("shengri2", null);}else{pmap.put("shengri2", shengri2);}
		if(xingzuo==null||xingzuo.equals("")){pmap.put("xingzuo", null);}else{pmap.put("xingzuo", xingzuo);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}
		if(aihao==null||aihao.equals("")){pmap.put("aihao", null);}else{pmap.put("aihao", aihao);}
		
		int total=zhuceyonghuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuceyonghu> list=zhuceyonghuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuceyonghu_list";
	}
	
	@RequestMapping("zhuceyonghu_yanben1.do")
	public String zhuceyonghu_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuceyonghu zhuceyonghu, String yonghuming, String mima, String cheng, String xingming, String xingbie, String touxiang, String shengri1,String shengri2, String xingzuo, String shenfenzheng, String shouji, String gexingqianming, String aihao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(cheng==null||cheng.equals("")){pmap.put("cheng", null);}else{pmap.put("cheng", cheng);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(touxiang==null||touxiang.equals("")){pmap.put("touxiang", null);}else{pmap.put("touxiang", touxiang);}
		if(shengri1==null||shengri1.equals("")){pmap.put("shengri1", null);}else{pmap.put("shengri1", shengri1);}
		if(shengri2==null||shengri2.equals("")){pmap.put("shengri2", null);}else{pmap.put("shengri2", shengri2);}
		if(xingzuo==null||xingzuo.equals("")){pmap.put("xingzuo", null);}else{pmap.put("xingzuo", xingzuo);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}
		if(aihao==null||aihao.equals("")){pmap.put("aihao", null);}else{pmap.put("aihao", aihao);}
		
		int total=zhuceyonghuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuceyonghu> list=zhuceyonghuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuceyonghu_yanben1";
	}
	@RequestMapping("zhuceyonghu_yanben2.do")
	public String zhuceyonghu_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuceyonghu zhuceyonghu, String yonghuming, String mima, String cheng, String xingming, String xingbie, String touxiang, String shengri1,String shengri2, String xingzuo, String shenfenzheng, String shouji, String gexingqianming, String aihao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(cheng==null||cheng.equals("")){pmap.put("cheng", null);}else{pmap.put("cheng", cheng);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(touxiang==null||touxiang.equals("")){pmap.put("touxiang", null);}else{pmap.put("touxiang", touxiang);}
		if(shengri1==null||shengri1.equals("")){pmap.put("shengri1", null);}else{pmap.put("shengri1", shengri1);}
		if(shengri2==null||shengri2.equals("")){pmap.put("shengri2", null);}else{pmap.put("shengri2", shengri2);}
		if(xingzuo==null||xingzuo.equals("")){pmap.put("xingzuo", null);}else{pmap.put("xingzuo", xingzuo);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}
		if(aihao==null||aihao.equals("")){pmap.put("aihao", null);}else{pmap.put("aihao", aihao);}
		
		int total=zhuceyonghuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuceyonghu> list=zhuceyonghuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuceyonghu_yanben2";
	}
	@RequestMapping("zhuceyonghu_yanben3.do")
	public String zhuceyonghu_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuceyonghu zhuceyonghu, String yonghuming, String mima, String cheng, String xingming, String xingbie, String touxiang, String shengri1,String shengri2, String xingzuo, String shenfenzheng, String shouji, String gexingqianming, String aihao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(cheng==null||cheng.equals("")){pmap.put("cheng", null);}else{pmap.put("cheng", cheng);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(touxiang==null||touxiang.equals("")){pmap.put("touxiang", null);}else{pmap.put("touxiang", touxiang);}
		if(shengri1==null||shengri1.equals("")){pmap.put("shengri1", null);}else{pmap.put("shengri1", shengri1);}
		if(shengri2==null||shengri2.equals("")){pmap.put("shengri2", null);}else{pmap.put("shengri2", shengri2);}
		if(xingzuo==null||xingzuo.equals("")){pmap.put("xingzuo", null);}else{pmap.put("xingzuo", xingzuo);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}
		if(aihao==null||aihao.equals("")){pmap.put("aihao", null);}else{pmap.put("aihao", aihao);}
		
		int total=zhuceyonghuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuceyonghu> list=zhuceyonghuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuceyonghu_yanben3";
	}
	@RequestMapping("zhuceyonghu_yanben4.do")
	public String zhuceyonghu_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuceyonghu zhuceyonghu, String yonghuming, String mima, String cheng, String xingming, String xingbie, String touxiang, String shengri1,String shengri2, String xingzuo, String shenfenzheng, String shouji, String gexingqianming, String aihao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(cheng==null||cheng.equals("")){pmap.put("cheng", null);}else{pmap.put("cheng", cheng);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(touxiang==null||touxiang.equals("")){pmap.put("touxiang", null);}else{pmap.put("touxiang", touxiang);}
		if(shengri1==null||shengri1.equals("")){pmap.put("shengri1", null);}else{pmap.put("shengri1", shengri1);}
		if(shengri2==null||shengri2.equals("")){pmap.put("shengri2", null);}else{pmap.put("shengri2", shengri2);}
		if(xingzuo==null||xingzuo.equals("")){pmap.put("xingzuo", null);}else{pmap.put("xingzuo", xingzuo);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}
		if(aihao==null||aihao.equals("")){pmap.put("aihao", null);}else{pmap.put("aihao", aihao);}
		
		int total=zhuceyonghuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuceyonghu> list=zhuceyonghuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuceyonghu_yanben4";
	}
	@RequestMapping("zhuceyonghu_yanben5.do")
	public String zhuceyonghu_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuceyonghu zhuceyonghu, String yonghuming, String mima, String cheng, String xingming, String xingbie, String touxiang, String shengri1,String shengri2, String xingzuo, String shenfenzheng, String shouji, String gexingqianming, String aihao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(cheng==null||cheng.equals("")){pmap.put("cheng", null);}else{pmap.put("cheng", cheng);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(touxiang==null||touxiang.equals("")){pmap.put("touxiang", null);}else{pmap.put("touxiang", touxiang);}
		if(shengri1==null||shengri1.equals("")){pmap.put("shengri1", null);}else{pmap.put("shengri1", shengri1);}
		if(shengri2==null||shengri2.equals("")){pmap.put("shengri2", null);}else{pmap.put("shengri2", shengri2);}
		if(xingzuo==null||xingzuo.equals("")){pmap.put("xingzuo", null);}else{pmap.put("xingzuo", xingzuo);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}
		if(aihao==null||aihao.equals("")){pmap.put("aihao", null);}else{pmap.put("aihao", aihao);}
		
		int total=zhuceyonghuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuceyonghu> list=zhuceyonghuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuceyonghu_yanben5";
	}
	
	@RequestMapping("zhuceyonghuList2.do")
	public String zhuceyonghuList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuceyonghu zhuceyonghu, String yonghuming, String mima, String cheng, String xingming, String xingbie, String touxiang, String shengri1,String shengri2, String xingzuo, String shenfenzheng, String shouji, String gexingqianming, String aihao, String issh,HttpServletRequest request){
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
		
		pmap.put("yonghuming", (String)request.getSession().getAttribute("username"));
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(cheng==null||cheng.equals("")){pmap.put("cheng", null);}else{pmap.put("cheng", cheng);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(touxiang==null||touxiang.equals("")){pmap.put("touxiang", null);}else{pmap.put("touxiang", touxiang);}
		if(shengri1==null||shengri1.equals("")){pmap.put("shengri1", null);}else{pmap.put("shengri1", shengri1);}
		if(shengri2==null||shengri2.equals("")){pmap.put("shengri2", null);}else{pmap.put("shengri2", shengri2);}
		if(xingzuo==null||xingzuo.equals("")){pmap.put("xingzuo", null);}else{pmap.put("xingzuo", xingzuo);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}
		if(aihao==null||aihao.equals("")){pmap.put("aihao", null);}else{pmap.put("aihao", aihao);}
		
		
		int total=zhuceyonghuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuceyonghu> list=zhuceyonghuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuceyonghu_list2";
	}
	
	
	@RequestMapping("zcyhList.do")
	public String zcyhList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuceyonghu zhuceyonghu, String yonghuming, String mima, String cheng, String xingming, String xingbie, String touxiang, String shengri1,String shengri2, String xingzuo, String shenfenzheng, String shouji, String gexingqianming, String aihao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(cheng==null||cheng.equals("")){pmap.put("cheng", null);}else{pmap.put("cheng", cheng);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(touxiang==null||touxiang.equals("")){pmap.put("touxiang", null);}else{pmap.put("touxiang", touxiang);}
		if(shengri1==null||shengri1.equals("")){pmap.put("shengri1", null);}else{pmap.put("shengri1", shengri1);}
		if(shengri2==null||shengri2.equals("")){pmap.put("shengri2", null);}else{pmap.put("shengri2", shengri2);}
		if(xingzuo==null||xingzuo.equals("")){pmap.put("xingzuo", null);}else{pmap.put("xingzuo", xingzuo);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}
		if(aihao==null||aihao.equals("")){pmap.put("aihao", null);}else{pmap.put("aihao", aihao);}
		
		int total=zhuceyonghuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuceyonghu> list=zhuceyonghuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuceyonghulist";
	}
	@RequestMapping("zcyhListtp.do")
	public String zcyhListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Zhuceyonghu zhuceyonghu, String yonghuming, String mima, String cheng, String xingming, String xingbie, String touxiang, String shengri1,String shengri2, String xingzuo, String shenfenzheng, String shouji, String gexingqianming, String aihao, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(cheng==null||cheng.equals("")){pmap.put("cheng", null);}else{pmap.put("cheng", cheng);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(touxiang==null||touxiang.equals("")){pmap.put("touxiang", null);}else{pmap.put("touxiang", touxiang);}
		if(shengri1==null||shengri1.equals("")){pmap.put("shengri1", null);}else{pmap.put("shengri1", shengri1);}
		if(shengri2==null||shengri2.equals("")){pmap.put("shengri2", null);}else{pmap.put("shengri2", shengri2);}
		if(xingzuo==null||xingzuo.equals("")){pmap.put("xingzuo", null);}else{pmap.put("xingzuo", xingzuo);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
		if(gexingqianming==null||gexingqianming.equals("")){pmap.put("gexingqianming", null);}else{pmap.put("gexingqianming", gexingqianming);}
		if(aihao==null||aihao.equals("")){pmap.put("aihao", null);}else{pmap.put("aihao", aihao);}
		
		int total=zhuceyonghuService.getCount(pmap);
		pageBean.setTotal(total);
		List<Zhuceyonghu> list=zhuceyonghuService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "zhuceyonghulisttp";
	}
	
	@RequestMapping("deleteZhuceyonghu.do")
	public String deleteZhuceyonghu(int id,HttpServletRequest request){
		zhuceyonghuService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:zhuceyonghuList.do";
	}
	
	@RequestMapping("quchongZhuceyonghu.do")
	public void quchongZhuceyonghu(Zhuceyonghu zhuceyonghu,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("yonghuming", zhuceyonghu.getYonghuming());
		   System.out.println("yonghuming==="+zhuceyonghu.getYonghuming());
		   System.out.println("yonghuming222==="+zhuceyonghuService.quchongZhuceyonghu(map));
		   JSONObject obj=new JSONObject();
		   if(zhuceyonghuService.quchongZhuceyonghu(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "用户名可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
