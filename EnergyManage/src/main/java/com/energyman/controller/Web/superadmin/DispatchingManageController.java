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
import com.energyman.bean.Equipment;
import com.energyman.bean.EquipmentDispatch;
import com.energyman.bean.EquipmentDispatchUnion;
import com.energyman.bean.EquipmentUnion;
import com.energyman.bean.SuddenDispatch;
import com.energyman.bean.SuddenDispatchUnion;
import com.energyman.service.IAdminAuthorityJudgeService;
import com.energyman.service.IEquipmentDispatchService;
import com.energyman.service.IEquipmentDispatchUnionService;
import com.energyman.service.IEquipmentService;
import com.energyman.service.IEquipmentUnionService;
import com.energyman.service.ISudddenDispatchService;
import com.energyman.service.ISuddenDispatchUnionService;
import com.energyman.utils.Global;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@RequestMapping("/superadmin")
public class DispatchingManageController {
	
	@Resource
	private IEquipmentService iEquipmentService;
	@Resource
	private IEquipmentUnionService iEquipmentUnionService;
	@Resource
	private IEquipmentDispatchService iEquipmentDispatchService;
	@Resource
	private IEquipmentDispatchUnionService iEquipmentDispatchUnionService;
	@Resource
	private ISudddenDispatchService iSudddenDispatchService;
	@Resource
	private ISuddenDispatchUnionService iSuddenDispatchUnionService;
	@Resource
	private IAdminAuthorityJudgeService iAdminAuthorityJudgeService;
	
	
	/**
	 * 判断是否拥有显示现有的调度设备权限
	 * @param request
	 * @return
	 * @author 
	 
	@RequestMapping(value = "/judgeShowDispatch",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeShowAdmin(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentDispatch, Global.SHOW, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	*/
	
	/**判断权限，显示可正常优化调度设备
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="allNormalEquipment",method=RequestMethod.GET)
	public ModelAndView showAllNormalEquipment(HttpServletRequest request){		
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentDispatch, Global.SHOW, Global.AUTHORITY_NORMAL);		
		if(authorityJudgeResult !=null){
			EquipmentUnion equipmentUnion=new EquipmentUnion();
			equipmentUnion.setEquipmentType_ID(Global.DISPATCH_ALLOW);
			equipmentUnion.setEquipmentControlModel_ID(Global.STATUS_AUTO);
			List<EquipmentUnion> equipmentunions=iEquipmentUnionService.findAllDispatchEquipment(equipmentUnion);		
			modelAndView.addObject("equipmentunions", equipmentunions);
			modelAndView.setViewName("superadmin/addnormaldispatch");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}
	
	/**
	 * 判断是否拥有将设备加入优化调度的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeAddNormalDispatch",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeAddNormalDispatch(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentDispatch, Global.DISPATCH, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	
	/**将设备加入正常优化调度序列
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="addNormalDispatch",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addNormalDispatch(HttpServletRequest request)throws Exception{
		Map<String, Object> result=new HashMap<String, Object>();
		String[] selectEquipment_IDs=request.getParameterValues("selectlist");
		EquipmentDispatch equipmentDispatch=new EquipmentDispatch();
		boolean res=false;
		
		if(selectEquipment_IDs == null){
			result.put("success", "2");
			System.out.println("请添加需调度的设备！！");
		}else{
			for(String selectEquipment_ID :selectEquipment_IDs ){
				equipmentDispatch.setEquipment_ID(Integer.parseInt(selectEquipment_ID));
				String[] start_Times=request.getParameterValues("start_Time"); 
				System.out.println(start_Times.length);
			    String start_Time=start_Times[0];
				String[] end_Times=request.getParameterValues("end_Time");
				String end_Time=end_Times[0];
				
				equipmentDispatch.setStart_Time(Global.StringToData(start_Time));
				equipmentDispatch.setEnd_Time(Global.StringToData(end_Time));
				res=iEquipmentDispatchService.addEquipmentDispatch(equipmentDispatch);
			}			
		}
		if(res){
			result.put("success", 1);
		}else {
			result.put("success", 2);
		}
		
			return result;
	}
	
	/**
	 * 判断是否拥有显示正常调度列表的设备的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeshowNormalDispatch",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeshowNormalDispatch(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.DispatchList, Global.SHOW, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**
	 * 判断权限，显示设备正常调度列表
	 * @return
	 */
	@RequestMapping(value="showNormalDispatch",method=RequestMethod.GET)
	public ModelAndView showNormalDispatch(){		
		ModelAndView modelAndView=new ModelAndView();		
		List<EquipmentDispatchUnion> equipmentDispatchs=iEquipmentDispatchUnionService.findEquipmentDispatchUnionResult();
		modelAndView.addObject("equipmentDispatchs",equipmentDispatchs);
		modelAndView.setViewName("superadmin/shownormaldispatch");		
		return modelAndView;
	}
	
	/**
	 * 判断是否拥有移除已加入正常调度列表的设备的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgedeleteEquipmentNormalDiapatch",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgedeleteEquipmentNormalDiapatch(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.DispatchList, Global.DELETE, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	
	/**
	 * 从正常调度设备列表移除
	 * @param dispatch_ID
	 * 
	 * @return
	 */
	@RequestMapping(value="/deleteEquipmentNormalDiapatch/{dispatch_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteEquipmentNormalDiapatch(@PathVariable("dispatch_ID") Integer dispatch_ID){
		boolean res=iEquipmentDispatchService.deleteEquipmentDispatch(dispatch_ID);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
		return result;
	}
	
			
	/**判断权限，显示可突发调度设备
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="allSuddenEquipment",method=RequestMethod.GET)
	public ModelAndView showAllSuddenEquipment(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentDispatch, Global.SHOW, Global.AUTHORITY_NORMAL);		
		if(authorityJudgeResult != null){
			List<EquipmentUnion> equipmentunions=iEquipmentUnionService.findAllEquipmentUnion(Global.STATUS_DELETE);		
			modelAndView.addObject("equipmentunions", equipmentunions);
			modelAndView.setViewName("superadmin/addsuddendispatch");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
		return modelAndView;
	}
	
	/**
	 * 判断是否拥有将设备加入突发调度的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeaddSuddenDispatch",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeaddSuddenDispatch(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentDispatch, Global.DISPATCH, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**将设备加入突发优化调度序列
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="addSuddenDispatch",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addSuddenDispatch(HttpServletRequest request)throws Exception{
		Map<String, Object> result=new HashMap<String, Object>();
		String[] selectEquipment_IDs=request.getParameterValues("selectlist");
		SuddenDispatch suddenDispatch=new SuddenDispatch();
		boolean res=false;
		
		if(selectEquipment_IDs == null){			
			System.out.println("请添加需调度的设备！！");
		}else{
			for(String selectEquipment_ID :selectEquipment_IDs ){
				suddenDispatch.setEquipment_ID(Integer.parseInt(selectEquipment_ID));
				String[] start_Times=request.getParameterValues("start_Time"); 
				System.out.println(start_Times.length);
			    String start_Time=start_Times[0];
				String[] end_Times=request.getParameterValues("end_Time");
				String end_Time=end_Times[0];
				
				suddenDispatch.setStart_Time(Global.StringToData(start_Time));
				suddenDispatch.setEnd_Time(Global.StringToData(end_Time));
				res=iSudddenDispatchService.addSuddenDispatch(suddenDispatch);
			}			
		}
		if(res){
			result.put("success", 1);
		}else {
			result.put("success", 2);
		}
		
			return result;
	}
	
	/**
	 * 判断是否拥有显示突发调度列表的设备的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeshowSuddenDispatch",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeshowSuddenDispatch(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.DispatchList, Global.SHOW, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**
	 * 显示设备突发调度列表
	 * @return
	 */
	@RequestMapping(value="showSuddenDispatch",method=RequestMethod.GET)
	public ModelAndView showSuddenDispatch(){
		ModelAndView modelAndView=new ModelAndView();
		List<SuddenDispatchUnion> equipmentDispatchs=iSuddenDispatchUnionService.findSuddenDispatchUnionResult();
		modelAndView.addObject("equipmentDispatchs",equipmentDispatchs);
		modelAndView.setViewName("superadmin/showsuddendispatch");
		return modelAndView;
	}
	
	/**
	 * 判断是否拥有移除已加入突发调度列表的设备的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgedeleteEquipmentSuddebnDiapatch",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgedeleteEquipmentSuddebnDiapatch(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.DispatchList, Global.DELETE, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**
	 * 从突发调度设备列表移除
	 * @param dispatch_ID
	 * 
	 * @return
	 */
	@RequestMapping(value="/deleteEquipmentSuddebnDiapatch/{dispatch_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteEquipmentSuddebnDiapatch(@PathVariable("dispatch_ID") Integer dispatch_ID){
		boolean res=iSudddenDispatchService.deleteSuddenDispatch(dispatch_ID);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
		return result;
	}
	
	
	/**
	 * 显示设备调度的编辑页面
	 * @param dispatch_ID
	 * @return
	 */
	@RequestMapping(value="/editDispatch/{dispatch_ID}",method=RequestMethod.GET)
	public ModelAndView showEditDispatch(@PathVariable("dispatch_ID") Integer dispatch_ID){
		ModelAndView modelAndView=new ModelAndView();
		return modelAndView;
	}
	
	
	/**
	 * 提交编辑设备调度
	 * @param dispatch_ID
	 * @return
	 */
	@RequestMapping(value="submitEditDispatch",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditDispatch(@PathVariable("dispatch_ID") Integer dispatch_ID){
		Map<String, Object> res=new HashMap<String,Object>();
		return res;
	}
	
	
	
	
}
