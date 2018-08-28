package com.energyman.controller.Web.superadmin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.energyman.bean.Admin;
import com.energyman.bean.AdminAuthority;
import com.energyman.bean.AdminAuthorityJudge;
import com.energyman.bean.AdminAuthorityUnion;
import com.energyman.bean.AdminFunctionAuthority;
import com.energyman.bean.Authority;
import com.energyman.bean.FunctionOfAdmin;
import com.energyman.service.IAdminAuthorityJudgeService;
import com.energyman.service.IAdminAuthorityService;
import com.energyman.service.IAdminAuthorityUnionService;
import com.energyman.service.IAdminFunctionAuthorityService;
import com.energyman.service.IAdminService;
import com.energyman.service.IAuthorityService;
import com.energyman.service.IFunctionOfAdminService;
import com.energyman.utils.Global;




@Controller
@RequestMapping("/superadmin")
public class AdminManageController {
	
	private String IMAGE_PATH = "D:/Tomcat 7.0/webapps/energysystem/upload/img/";
	
	@Resource
	private IAdminService iAdminService;
	@Resource
	private IAdminAuthorityService iAdminAuthorityService;
	@Resource
	private IAuthorityService iAuthorityService;
	@Resource
	private IAdminFunctionAuthorityService iAdminFunctionAuthorityService;
	@Resource
	private IAdminAuthorityUnionService iAdminAuthorityUnionService;
	@Resource
	private IAdminAuthorityJudgeService iAdminAuthorityJudgeService;
	@Resource
	private IFunctionOfAdminService iFunctionOfAdminService;
	
	
	
	/**
	 * �ж��Ƿ�ӵ����ʾ���е�ϵͳ����ԱȨ��
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeShowAdmin",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeShowAdmin(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.AdminList, Global.SHOW, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
		
	/** �ж�Ȩ�ޣ���ʾ����ϵͳ�����е�ϵͳ����Ա
	 * @param
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/allAdmin",method=RequestMethod.GET)
	public ModelAndView showAllAdmin(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.AdminList, Global.SHOW, Global.AUTHORITY_NORMAL);
		ModelAndView modelAndView=new ModelAndView();
		if(authorityJudgeResult !=null){
			List<Admin> admins=iAdminService.findAllAdmin();
			modelAndView.addObject("admins", admins);
			modelAndView.setViewName("superadmin/showalladmin");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}


	/**��ʾϵͳ����Ա��Ȩ����Ϣ
	 * @param request
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="/allAdminAuthority",method=RequestMethod.GET)
	public ModelAndView showAllAdminAuthority(HttpServletRequest request){
		int systemadminid=Integer.parseInt(request.getParameter("systemadminid"));
//		List<Integer> authorityids=iAdminAuthorityService.getauthorityids(systemadminid);
		List<Authority> authorities=new ArrayList<Authority>();
//		for(Integer authorityid:authorityids){
//			Authority authority=iAuthorityService.getAuthorityById(authorityid);
//			authorities.add(authority);
//		}
		ModelAndView modelAndView=new ModelAndView();
//		modelAndView.addObject("authorities",authorities);
//		modelAndView.setViewName("superadmin/addauthority");
		return modelAndView;
	}

	*/
	
	/**
	 * �ж��Ƿ���������ϵͳ����Ա
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeAddAdmin",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeAddAdmin(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.AddAdmin, Global.ADD, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	} 
	
	
	/** ������ӹ���Ա��Ϣ�հױ�
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/onClickAddAdmin",method=RequestMethod.GET)
	public ModelAndView onClickAddAdmin(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("superadmin/addadmin");
		return modelAndView;
	}
	
	
	/**������ӹ���ԱȨ�޿հױ�
	 * 
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="/onClickAddAuthority",method=RequestMethod.GET)
	public ModelAndView onClickAddAuthority(){
		ModelAndView modelAndView=new ModelAndView();
		List<AdminFunctionAuthority> AdminFunctionAuthorities=iAdminFunctionAuthorityService.findAdminFunctionAuthorityListResult();
		modelAndView .addObject("AdminFunctionAuthorities", AdminFunctionAuthorities);
		modelAndView.setViewName("superadmin/addauthority");
		return modelAndView;
	}
	*/
	
	
	
	/** �ύ����ϵͳ����Ա��Ϣ
	 * @param
	 * @return
	 * @author RenYang
	 * @throws ParseException 
	 */
	@RequestMapping(value="/addAdmin",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> submitAddAdmin(HttpServletRequest request) throws ParseException{
		Admin admin=new Admin();		
		admin.setUsername(request.getParameter("username"));		
		admin.setPassword(request.getParameter("password"));		
		admin.setGender(Short.parseShort(request.getParameter("gender")));		
		admin.setEmail(request.getParameter("email"));
		admin.setAddress(request.getParameter("address"));
		admin.setTelephone(request.getParameter("telephone"));
		admin.setBirthday(Global.StringTo(request.getParameter("birthday")));
		admin.setUserstatus(Global.STATUS_OFFLINE);
		admin.setLittleheadportrait(request.getParameter("fileName"));
		admin.setBigheadportrait(request.getParameter("fileName"));
		
		boolean res=iAdminService.addAdmin(admin);
		Map<String,Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		return result;
	}
	
	/**�ύ���ӹ���ԱȨ��
	 * 
	 * @param request
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="/addAdminAuthority",method=RequestMethod.POST)
	public Map<String, Object> submitAddAdminAuthority(HttpServletRequest request){
		AdminAuthority adminAuthority=new AdminAuthority();
		adminAuthority.setSystemadminid(Integer.parseInt(request.getParameter("systemadminid")));
		adminAuthority.setAuthorityid(Integer.parseInt(request.getParameter("authorityid")));
		
		boolean res=iAdminAuthorityService.addAdminAuthority(adminAuthority);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
			return result;
	}
	*/
	
	/**
	 * �ж��Ƿ�ӵ��ɾ��ϵͳ����ԱȨ��
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeDeleteAdmin",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeDeleteAdmin(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.AdminList, Global.DELETE, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	} 
	
	
	/** �ύɾ��ϵͳ����Ա
	 * @param
	 * @return
	 * @author RenYang
	 *
	 */
	@RequestMapping(value="/deleteAdmin/{systemadminid}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> submitDeleteAdmin(@PathVariable("systemadminid") Integer systemadminid){
		Admin admin=iAdminService.getAdminById(systemadminid);
		boolean res=iAdminService.deleteAdmin(admin.getSystemadminid());
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 0);
		}
		return result;
	}
	
	/**
	 * �ж��Ƿ�ӵ�б༭ϵͳ����ԱȨ��
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeEditAdmin",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeEditAdmin(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.AdminList, Global.EDIT, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	} 
	
	
	/**��ʾ�༭����Ա��Ϣ����
	 * @param username
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/editAdmin/{systemadminid}",method=RequestMethod.GET)
	public ModelAndView editAdmin(@PathVariable("systemadminid") Integer systemadminid){
		Admin admin=iAdminService.getAdminById(systemadminid);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("admin", admin);
		modelAndView.setViewName("superadmin/editadmin");
		return modelAndView;
	}
	
	/**��ʾ�༭����ԱȨ�޽���
	 * @param systemadminid
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/editAdminAuthority/{systemadminid}",method=RequestMethod.GET)
	public  ModelAndView editAdminAuthority(@PathVariable("systemadminid") Integer systemadminid){
		ModelAndView modelAndView=new ModelAndView();
		//��ʾ���к�̨Ȩ��
		List<AdminFunctionAuthority> AdminFunctionAuthorities=iAdminFunctionAuthorityService.findAdminFunctionAuthorityListResult();
		//��ѯ�ù���Ա��ӵ�еĺ�̨����Ȩ��
		List<AdminAuthorityUnion> adminAuthorityUnions=iAdminAuthorityUnionService.findAdminAuthorityByAdmin(systemadminid);
		for(AdminFunctionAuthority adminFunctionAuthority:AdminFunctionAuthorities){
			for(Authority authority : adminFunctionAuthority.getAdminFunctionAuthorityList()){
				for(AdminAuthorityUnion adminAuthorityUnion:adminAuthorityUnions){
					if((authority.getAuthorityid()) == (adminAuthorityUnion.getAuthorityid())){
						authority.setAdminAuthority(true);
					}
				}
			}
		}
		
		modelAndView.addObject("AdminFunctionAuthorities",AdminFunctionAuthorities);
		modelAndView.addObject("systemadminid",systemadminid);
		modelAndView.setViewName("superadmin/editauthority");
		return modelAndView;		
	}
	
	
	/** �ύ����Ա��Ϣ�༭ҳ��
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitEditAdmin",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> submitEditAdmin(HttpServletRequest request) throws Exception{
		int systemadminid=Integer.parseInt(request.getParameter("systemadminid"));
		Admin admin=iAdminService.getAdminById(systemadminid);
		admin.setUsername(request.getParameter("username"));			
		admin.setGender(Short.parseShort(request.getParameter("gender")));
		admin.setPassword(request.getParameter("password"));								
		admin.setAddress(request.getParameter("address"));
		admin.setEmail(request.getParameter("email"));
		admin.setTelephone(request.getParameter("telephone"));
		admin.setBirthday(Global.StringTo(request.getParameter("birthday")));
		admin.setLittleheadportrait(request.getParameter("fileName"));
		admin.setBigheadportrait(request.getParameter("fileName"));
		
		boolean res=iAdminService.updateAdmin(admin);
		Map<String,Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 0);
		}
		return result;
	}
	
	/** �ύ����ԱȨ�ޱ༭ҳ��
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitEditAdminAuthority",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> submitEditAdminAuthority(HttpServletRequest request){
		Map<String, Object> map=new HashMap<String,Object>();
		String[] preSelectedAuthorities = request.getParameterValues("preSelectlist");
		String[] selectedAuthorities = request.getParameterValues("selectlist");
		Integer systemadminid = Integer.parseInt(request.getParameter("systemadminid"));
		
		boolean result = false, res = false;
		if(preSelectedAuthorities == null){
			result = true;
		}else{
			List<Integer> authorities = new ArrayList<Integer>();
			for (String preSelectedAuthority : preSelectedAuthorities) {
				authorities.addAll(iAdminAuthorityService.findAuthorityIdByAdminIdAndAuthorityId(Integer.parseInt(preSelectedAuthority), systemadminid));
			}
			result = iAdminAuthorityService.batchDelete(authorities);//ɾ���ý�ɫ�༭�󲻴��ڵ�Ȩ��
		}
		
		//������Ա����µ�Ȩ��
		List<AdminAuthority> adminAuthorities=new ArrayList<AdminAuthority>();
		if(selectedAuthorities == null){
			//��ʱ��Ҫ����ý�ɫ��Ȩ��Ϊ0��
			if(result){
				map.put("success", '1');
			}else{
				map.put("success", '2');
			}
		}else{
			//��ʱҪ����ý�ɫ����һ��Ȩ�ޣ�����Ҫ����
			//�õ�����ѡ�е�Ȩ��
			for (String selectedAuthority : selectedAuthorities) {
				AdminAuthority adminAuthority = new AdminAuthority();
				adminAuthority.setAuthorityid(Integer.parseInt(selectedAuthority));
				adminAuthority.setSystemadminid(systemadminid);
				adminAuthorities.add(adminAuthority);
			}
			if(result){
				res = iAdminAuthorityService.saveRoleOwnAuthorityList(adminAuthorities);
			}
			
			if(res&&result){
				map.put("success", '1');
			}else{
				map.put("success", '2');
			}
		}
		
		return map;
	}
	
	
	
	/**�ж��Ƿ�Ҫ�༭����Ա��Ϣ
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="/judgeEdit",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> judgeEdit(){
		Map<String,Object> res=new HashMap<String,Object>();
		res.put("success", '1');
		return res;
	}
	
	*/
	
	/**
	 * �첽�ϴ�ͼƬ
	 * @param request
	 * @param response
	 */
	@RequestMapping("/upLoadImage")
	public void upLoadImage(HttpServletRequest request, HttpServletResponse response){
		System.out.println(request.getContextPath());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("default", "board_default.jpg");
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			//����������request��������
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); 
			//���ж�request���Ƿ����multipart���͵����ݣ�
			if(multipartResolver.isMultipart(request)){
				jsonObject.put("success", "1");
				//�ٽ�request�е�����ת����multipart���͵�����
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				Iterator iter = multiRequest.getFileNames();
				while(iter.hasNext()){
					MultipartFile file = multiRequest.getFile((String)iter.next());
					if(file != null){
						String fileName = (System.currentTimeMillis()) + file.getOriginalFilename();
						jsonObject.put("fileName", fileName);
						String path = IMAGE_PATH + fileName;
						File localFile = new File(path);
						System.out.println(path);
						//д�ļ�������
						try {
							file.transferTo(localFile);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}else{
				jsonObject.put("success", "2");
			}
			out.write(jsonObject.toString());
			System.out.println(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ͨ������Ա�����ҹ���Ա��̨����Ȩ��
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="showFunctionOfAdmin",method = RequestMethod.GET)
	public void showFunctionOfAdmin(HttpServletRequest request,HttpServletResponse response){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("text/html;charset=UTF-8");
	    
	    int adminID=admin.getSystemadminid();
	    List<FunctionOfAdmin> FunctionOfAdmins=iFunctionOfAdminService.selectFunctionOfAdminByAdmin(adminID, Global.AdminFunctionLevel_1, 
	    		Global.AdminFunctionParent, Global.Function_Status, Global.isAdminFunctionMeun, Global.SHOW);
	   
	    try {
			PrintWriter out = response.getWriter();
			JSONArray jsonArray =new JSONArray();
			
			for(FunctionOfAdmin functionOfAdmin : FunctionOfAdmins){
				List<FunctionOfAdmin> subFunctionOfAdmins=iFunctionOfAdminService.selectFunctionOfAdminByAdmin(adminID, Global.AdminFunctionLevel_2, 
						functionOfAdmin.getParent_Function(), Global.Function_Status, Global.noAdminFunctionMeun, Global.SHOW);
				Map<String, Object> map = new HashMap<String, Object>();
				if(subFunctionOfAdmins.isEmpty()){
					map.put("status", 0);
					map.put("father", functionOfAdmin);
					map.put("children", subFunctionOfAdmins);
				}else{
					map.put("status", 1);
					String FunctionPathl = "";
					for(FunctionOfAdmin functionOfAdmin2 : subFunctionOfAdmins){
						FunctionPathl += functionOfAdmin2.getFunction_Path();
						FunctionPathl += ";";
					}
					functionOfAdmin.setFunction_Path(FunctionPathl.substring(0, FunctionPathl.length()-1));
					map.put("father", functionOfAdmin);
					map.put("children", subFunctionOfAdmins);
				}
				jsonArray.add(map);
			}
			out.print(jsonArray.toString());  
	        out.flush();  
	        out.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
	}
}

