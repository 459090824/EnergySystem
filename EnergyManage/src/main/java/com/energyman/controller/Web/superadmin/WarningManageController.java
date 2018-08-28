package com.energyman.controller.Web.superadmin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.energyman.bean.Admin;
import com.energyman.bean.AdminAuthorityJudge;
import com.energyman.bean.Warning;
import com.energyman.bean.WarningType;
import com.energyman.bean.WarningUnion;
import com.energyman.service.IAdminAuthorityJudgeService;
import com.energyman.service.IWarningService;
import com.energyman.service.IWarningTypeService;
import com.energyman.service.IWarningUnionService;
import com.energyman.utils.Global;

@Controller
@RequestMapping("/superadmin")
public class WarningManageController {
	
	@Resource
	private IWarningTypeService iWarningTypeService;
	@Resource
	private IWarningService iWarningService;
	@Resource
	private IWarningUnionService iWarningUnionService;
	@Resource
	private IAdminAuthorityJudgeService iAdminAuthorityJudgeService;
	
	/**判断权限，显示所有警告类型信息
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/allWarningType",method=RequestMethod.GET)
	public ModelAndView allWarningType(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();		
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.WarningTypeList, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
			List<WarningType> warningTypes=iWarningTypeService.findAllWarningType(Global.Type_NORMAL);		
			modelAndView.addObject("warningTypes", warningTypes);
			modelAndView.setViewName("superadmin/showallwarningtype");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
		return modelAndView;
	}
	
	/**
	 * 判断是否拥有添加警报类型的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeonClickAddWarningType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeonClickAddWarningType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.WarningTypeList, Global.ADD, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**显示增加警告类型表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/onClickAddWarningType",method=RequestMethod.GET)
	public ModelAndView onClickAddWarningType(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("superadmin/addwarningtype");
		return modelAndView;
	}
	
	/**提交增加警告类型信息
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitAddWarningType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddWarningType(HttpServletRequest request){
		WarningType warningType=new WarningType();
		warningType.setWarningtypename(request.getParameter("warningtypename"));
		warningType.setWarningtypedesc(request.getParameter("warningtypedesc"));
		boolean res=iWarningTypeService.addWarningType(warningType);	
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else {
			result.put("success", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有删除警报类型的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgedeletewarningType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgedeletewarningType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.WarningTypeList, Global.DELETE, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**删除警告类型信息
	 * @param warningtypeid
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/deletewarningType/{warningtypeid}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> submitDeleteWarningType(@PathVariable("warningtypeid") Integer warningtypeid){
		WarningType warningType= new WarningType();
		warningType.setWarningtypeid(warningtypeid);
		warningType.setTypestate(Global.Type_Delete);
		boolean res=iWarningTypeService.updateWarningType(warningType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有编辑警报类型的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeonClickEditWarningType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeonClickEditWarningType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.WarningTypeList, Global.EDIT, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**显示编辑警告类型表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/onClickEditWarningType/{warningtypeid}",method=RequestMethod.GET)
	public ModelAndView onClickEditWarningType(@PathVariable("warningtypeid") Integer warningtypeid){
		ModelAndView modelAndView=new ModelAndView();
		WarningType warningType=iWarningTypeService.getWarningTypeById(warningtypeid);
		modelAndView.addObject("warningType",warningType);
		modelAndView.setViewName("superadmin/editwarningtype");
		return modelAndView;
	}
	
	/**提交编辑警告类型信息
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitEditWarningType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditWarningType(HttpServletRequest request){
		WarningType warningType=new WarningType();
		warningType.setWarningtypeid(Integer.parseInt(request.getParameter("warningtypeid")));
		warningType.setWarningtypename(request.getParameter("warningtypename"));
		warningType.setWarningtypedesc(request.getParameter("warningtypedesc"));
		boolean res=iWarningTypeService.updateWarningType(warningType);	
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else {
			result.put("failure", 0);
		}
		return result;
	}
	
	
	/**判断权限，显示所有警告信息
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/allWarning",method=RequestMethod.GET)
	public ModelAndView allWarning(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();		
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.WarningList, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
			List<WarningUnion> warnings=iWarningUnionService.findAllWarningUnion();		
			modelAndView.addObject("warnings", warnings);
			modelAndView.setViewName("superadmin/showallwarning");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
		return modelAndView;
	}
	
	/**
	 * 判断是否拥有处理警报的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeHandlewarning",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeHandlewarning(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.WarningList, Global.HANDLE, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**点击处理警告
	 * @param warningtypeid
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/Handlewarning/{warningid}",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitHandleWarning(@PathVariable("warningid") Integer warningid){
		Warning warning=new Warning();
		warning.setWarningid(warningid);
		warning.setProcessstate(Global.WARNING_HANDLE);
		boolean res=iWarningService.updateWarning(warning);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有关闭警报的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeCanclewarning",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeCanclewarning(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.WarningList, Global.CANCLE, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**点击取消警告
	 * @param warningtypeid
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/Canclewarning/{warningid}",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitCanleWarning(@PathVariable("warningid") Integer warningid){
		Warning warning=new Warning();
		warning.setWarningid(warningid);
		warning.setProcessstate(Global.WARNIGN_CANCLE);
		boolean res=iWarningService.updateWarning(warning);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		return result;
	}
}
