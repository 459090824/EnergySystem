package com.energyman.controller.Web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.DelayQueue;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.energyman.bean.Addr;
import com.energyman.bean.AddrUnion;
import com.energyman.bean.Admin;
import com.energyman.bean.AdminAuthorityJudge;
import com.energyman.bean.Area;
import com.energyman.bean.Building;
import com.energyman.bean.DataCollector;
import com.energyman.bean.DataCollectorData;
import com.energyman.bean.DataCollectorType;
import com.energyman.bean.DataCollectorUnion;
import com.energyman.bean.Equipment;
import com.energyman.bean.EquipmentUnion;
import com.energyman.bean.Meter;
import com.energyman.bean.MeterType;
import com.energyman.bean.MeterUnion;
import com.energyman.bean.OtherSystemEquipment;
import com.energyman.bean.OtherSystemEquipmentUnion;
import com.energyman.bean.Park;
import com.energyman.bean.Room;
import com.energyman.bean.Sensor;
import com.energyman.bean.SensorType;
import com.energyman.bean.SensorUnion;
import com.energyman.bean.SystemEquipmentSubType;
import com.energyman.bean.SystemEquipmentSubTypeUnion;
import com.energyman.bean.SystemEquipmentType;
import com.energyman.dao.OtherSystemEquipmentUnionDao;
import com.energyman.service.IAddrService;
import com.energyman.service.IAddrUnionService;
import com.energyman.service.IAdminAuthorityJudgeService;
import com.energyman.service.IAreaService;
import com.energyman.service.IBuildingService;
import com.energyman.service.IDataCollectorDataService;
import com.energyman.service.IDataCollectorService;
import com.energyman.service.IDataCollectorTypeService;
import com.energyman.service.IDataCollectorUnionService;
import com.energyman.service.IMeterService;
import com.energyman.service.IMeterTypeService;
import com.energyman.service.IMeterUnionService;
import com.energyman.service.IOtherSystemEquipmentService;
import com.energyman.service.IOtherSystemEquipmentUnionService;
import com.energyman.service.IParkService;
import com.energyman.service.IRoomService;
import com.energyman.service.ISensorService;
import com.energyman.service.ISensorTypeService;
import com.energyman.service.ISensorUnionService;
import com.energyman.service.ISystemEquipmentSubTypeService;
import com.energyman.service.ISystemEquipmentSubTypeUnionService;
import com.energyman.service.ISystemEquipmentTypeService;
import com.energyman.service.impl.OtherSystemEquipmentService;
import com.energyman.utils.Global;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@RequestMapping("/superadmin")
public class SystemEquipmentManageController {
	
	@Resource
	private IMeterTypeService iMeterTypeService;
	@Resource
	private IDataCollectorTypeService iDataCollectorTypeService;
	@Resource
	private ISensorTypeService iSensorTypeService;
	
	@Resource
	private ISystemEquipmentTypeService iSystemEquipmentTypeService;
	@Resource
	private ISystemEquipmentSubTypeService iSystemEquipmentSubTypeService;
	@Resource
	private IOtherSystemEquipmentService iOtherSystemEquipmentService;
	@Resource
	private IOtherSystemEquipmentUnionService iOtherSystemEquipmentUnionService;
	@Resource
	private ISystemEquipmentSubTypeUnionService iSystemEquipmentSubTypeUnionService;
	
	@Resource
	private ISensorService iSensorService;
	@Resource
	private ISensorUnionService iSensorUnionService;
	@Resource
	private IDataCollectorUnionService iDataCollectorUnionService;
	@Resource
	private IDataCollectorService  iDataCollectorService;
	@Resource
	private IMeterService iMeterService;
	@Resource
	private IMeterUnionService iMeterUnionService;
	@Resource
	private IParkService iParkService;
	@Resource
	private IAreaService iAreaService;
	@Resource
	private IBuildingService iBuildingService;
	@Resource
	private IRoomService iRoomService;
	@Resource
	private IAddrService iAddrService;
	@Resource
	private IAddrUnionService iAddrUnionService;
	
	
	@Resource
	private IDataCollectorDataService iDataCollectorDataService;
	@Resource
	private IAdminAuthorityJudgeService iAdminAuthorityJudgeService;
	
	
	/**
	 * 判断是否拥有添加系统设备类型的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeonClickAddSystemEquipmentType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeonClickAddSystemEquipmentType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.SystemEquipmentTypeList, Global.ADD, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**增加仪表类型空白表单
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="onClickAddMeterType",method=RequestMethod.GET)
	public ModelAndView onClickAddMeterType(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("superadmin/addmetertype");
		return modelAndView;
	}
	*/
	
	/**增加系统设备类型空白表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="onClickAddSystemEquipmentType",method=RequestMethod.GET)
	public ModelAndView onClickAddSystemEquipmentType(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("superadmin/addsystemequipmenttype");
		return modelAndView;
	}
	
	/**增加系统设备子类型空白表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="onClickAddSystemEquipmentSubType",method=RequestMethod.GET)
	public ModelAndView onClickAddSystemEquipmentSubType(){
		ModelAndView modelAndView=new ModelAndView();
		List<SystemEquipmentType> systemEquipmentTypes=iSystemEquipmentTypeService.findAllSystemEquipmentType(Global.Type_NORMAL);
		modelAndView.addObject("systemEquipmentTypes", systemEquipmentTypes);
		modelAndView.setViewName("superadmin/addsystemequipmentsubtype");
		return modelAndView;
	}
	
	/**判断权限，显示所有仪表类型
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="AllMeterType",method=RequestMethod.GET)
	public ModelAndView showAllMeterType(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();		
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.SystemEquipmentTypeList, Global.SHOW, Global.AUTHORITY_NORMAL);		
		if(authorityJudgeResult != null){
			List<MeterType> meterTypes=iMeterTypeService.findAllMeterType();
			modelAndView.addObject("meterTypes", meterTypes);
			modelAndView.setViewName("superadmin/showmetertype");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}
	*/
	
	/**提交系统设备类型信息
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="submitAddSystemEquipmentType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddSystemEquipmentType(HttpServletRequest request){		
		SystemEquipmentType systemEquipmentType=new SystemEquipmentType();
		systemEquipmentType.setSystemEquipmentState_ID(Global.Type_NORMAL);
		systemEquipmentType.setSystemEquipmentType_Desc(request.getParameter("systemEquipmentType_Desc"));
		systemEquipmentType.setSystemEquipmentType_Name(request.getParameter("systemEquipmentType_Name"));
		boolean res=iSystemEquipmentTypeService.addSystemEquipmentType(systemEquipmentType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
			return result;
	}
	
	/**提交系统设备子类型信息
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="submitAddSystemEquipmentSubType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddSystemEquipmentSubType(HttpServletRequest request){		
		SystemEquipmentSubType systemEquipmentSubType=new SystemEquipmentSubType();
		systemEquipmentSubType.setSystemEquipmentSubState_ID(Global.Type_NORMAL);
		systemEquipmentSubType.setSystemEquipmentSubType_Desc(request.getParameter("systemEquipmentSubType_Desc"));
		systemEquipmentSubType.setSystemEquipmentSubType_Name(request.getParameter("systemEquipmentSubType_Name"));
		systemEquipmentSubType.setSystemEquipmentType_ID(Integer.parseInt(request.getParameter("systemEquipmentType_ID")));
		boolean res=iSystemEquipmentSubTypeService.addSystemEquipmentSubType(systemEquipmentSubType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
			return result;
	}
	
	/**判断权限，显示所有系统设备类型
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="showSystemEquipmentType",method=RequestMethod.GET)
	public ModelAndView showSystemEquipmentType(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();		
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.SystemEquipmentTypeList, Global.SHOW, Global.AUTHORITY_NORMAL);		
		if(authorityJudgeResult != null){
			List<SystemEquipmentType> systemEquipmentTypes=iSystemEquipmentTypeService.findAllSystemEquipmentType(Global.Type_NORMAL);
			modelAndView.addObject("systemEquipmentTypes", systemEquipmentTypes);
			modelAndView.setViewName("superadmin/showsystemequipmenttype");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}
	
	/**判断权限，显示所有系统设备子类型
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="showSystemEquipmentSubType",method=RequestMethod.GET)
	public ModelAndView showSystemEquipmentSubType(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();		
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.SystemEquipmentTypeList, Global.SHOW, Global.AUTHORITY_NORMAL);		
		if(authorityJudgeResult != null){
			List<SystemEquipmentSubTypeUnion> systemEquipmentSubTypeUnions=iSystemEquipmentSubTypeUnionService.findSystemEquipmentSubTypeUnionResult(Global.Type_NORMAL);
			modelAndView.addObject("systemEquipmentSubTypeUnions", systemEquipmentSubTypeUnions);
			modelAndView.setViewName("superadmin/showsystemequipmentsubtype");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}
	
	/**提交要添加的仪表类型信息
	 * @param request
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="submitAddMeterType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddMeterType(HttpServletRequest request){

		MeterType meterType=new MeterType();
		meterType.setMeterType_Name(request.getParameter("meterType_Name"));
		meterType.setMeterType_Desc(request.getParameter("meterType_Desc"));
		boolean res=iMeterTypeService.addMeterType(meterType);
		
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
			return result;
	}
	*/
	
	/**
	 * 判断是否拥有删除系统设备类型的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgedeleteSystemEquipmentType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgedeleteSystemEquipmentType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.SystemEquipmentTypeList, Global.DELETE, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	
	/** 提交删除设备类型
	 * @param
	 * @return
	 * @author RenYang
	 *
	 */
	@RequestMapping(value="/deleteSystemEquipmentType/{systemEquipmentType_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteSystemEquipmentType(@PathVariable("systemEquipmentType_ID") Integer systemEquipmentType_ID){
		SystemEquipmentType systemEquipmentType=new SystemEquipmentType();
		systemEquipmentType.setSystemEquipmentType_ID(systemEquipmentType_ID);
		systemEquipmentType.setSystemEquipmentState_ID(Global.Type_Delete);
		boolean res=iSystemEquipmentTypeService.updateSystemEquipmentType(systemEquipmentType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 0);
		}
		return result;
	}
	
	
	/** 提交删除设备子类型
	 * @param
	 * @return
	 * @author RenYang
	 *
	 */
	@RequestMapping(value="/deleteSystemEquipmentSubType/{systemEquipmentSubType_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteSystemEquipmentSubType(@PathVariable("systemEquipmentSubType_ID") Integer systemEquipmentSubType_ID){
		SystemEquipmentSubType systemEquipmentSubType=new SystemEquipmentSubType();
		systemEquipmentSubType.setSystemEquipmentSubType_ID(systemEquipmentSubType_ID);
		systemEquipmentSubType.setSystemEquipmentSubState_ID(Global.Type_Delete);
		boolean res=iSystemEquipmentSubTypeService.updateSystemEquipmentSubType(systemEquipmentSubType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 0);
		}
		return result;
	}
	
	
	/** 提交删除仪表类型
	 * @param
	 * @return
	 * @author RenYang
	 *
	 
	@RequestMapping(value="/deleteMeterType/{meterType_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> submitDeleteAdmin(@PathVariable("meterType_ID") Integer meterType_ID){
		boolean res=iMeterTypeService.deleteMeterType(meterType_ID);
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
	 * 判断是否拥有编辑系统设备类型的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeeditSystemEquipmentType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeeditSystemEquipmentType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.SystemEquipmentTypeList, Global.EDIT, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**显示编辑系统设备类型界面
	 * @param systemEquipmentType_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/editSystemEquipmentType/{systemEquipmentType_ID}",method=RequestMethod.GET)
	public ModelAndView editSystemEquipmentType(@PathVariable("systemEquipmentType_ID") Integer systemEquipmentType_ID){
		SystemEquipmentType systemEquipmentType=iSystemEquipmentTypeService.getSystemEquipmentTypeById(systemEquipmentType_ID);
		ModelAndView modelAndView=new ModelAndView();		
		modelAndView.addObject("systemEquipmentType", systemEquipmentType);
		modelAndView.setViewName("superadmin/editsystemequipmenttype");
		return modelAndView;		
	}
	
	/**提交编辑系统设备类型信息
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="submitEditSystemEquipmentType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditSystemEquipmentType(HttpServletRequest request){		
		SystemEquipmentType systemEquipmentType=new SystemEquipmentType();
		systemEquipmentType.setSystemEquipmentType_ID(Integer.parseInt(request.getParameter("systemEquipmentType_ID")));
		systemEquipmentType.setSystemEquipmentType_Desc(request.getParameter("systemEquipmentType_Desc"));
		systemEquipmentType.setSystemEquipmentType_Name(request.getParameter("systemEquipmentType_Name"));
		boolean res=iSystemEquipmentTypeService.updateSystemEquipmentType(systemEquipmentType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
			return result;
	}
	
	/**显示编辑系统设备子类型界面
	 * @param systemEquipmentSubType_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/editSystemEquipmentSubType/{systemEquipmentSubType_ID}",method=RequestMethod.GET)
	public ModelAndView editSystemEquipmentSubType(@PathVariable("systemEquipmentSubType_ID") Integer systemEquipmentSubType_ID){
		SystemEquipmentSubType systemEquipmentSubType=iSystemEquipmentSubTypeService.getSystemEquipmentSubTypeById(systemEquipmentSubType_ID);
		ModelAndView modelAndView=new ModelAndView();
		List<SystemEquipmentType> systemEquipmentTypes=iSystemEquipmentTypeService.findAllSystemEquipmentType(Global.Type_NORMAL);
		modelAndView.addObject("systemEquipmentTypes", systemEquipmentTypes);
		modelAndView.addObject("systemEquipmentSubType", systemEquipmentSubType);
		modelAndView.setViewName("superadmin/editsystemequipmentsubtype");
		return modelAndView;		
	}
	
	/**提交编辑系统设备子类型信息
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="submitEditSystemEquipmentSubType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditSystemEquipmentSubType(HttpServletRequest request){		
		SystemEquipmentSubType systemEquipmentSubType=new SystemEquipmentSubType();
//		systemEquipmentSubType.setSystemEquipmentSubState_ID(Global.Type_NORMAL);
		systemEquipmentSubType.setSystemEquipmentSubType_ID(Integer.parseInt(request.getParameter("systemEquipmentSubType_ID")));
		systemEquipmentSubType.setSystemEquipmentSubType_Desc(request.getParameter("systemEquipmentSubType_Desc"));
		systemEquipmentSubType.setSystemEquipmentSubType_Name(request.getParameter("systemEquipmentSubType_Name"));
		systemEquipmentSubType.setSystemEquipmentType_ID(Integer.parseInt(request.getParameter("systemEquipmentType_ID")));
		boolean res=iSystemEquipmentSubTypeService.updateSystemEquipmentSubType(systemEquipmentSubType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
			return result;
	}
	
	/**显示编辑仪表类型界面
	 * @param meterType_ID
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="/editMeterType/{meterType_ID}",method=RequestMethod.GET)
	public ModelAndView editMeterType(@PathVariable("meterType_ID") Integer meterType_ID){
		MeterType meterType=iMeterTypeService.getMeterTypeById(meterType_ID);
		ModelAndView modelAndView=new ModelAndView();		
		modelAndView.addObject("meterType", meterType);
		modelAndView.setViewName("superadmin/editmetertype");
		return modelAndView;		
	}
	*/
	
	/**提交编辑仪表类型信息
	 * @param request
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="submitEditMeterType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditMeterType(HttpServletRequest request){
		MeterType meterType=new MeterType();
		meterType.setMeterType_ID(Integer.parseInt(request.getParameter("meterType_ID")));
		meterType.setMeterType_Name(request.getParameter("meterType_Name"));
		meterType.setMeterType_Desc(request.getParameter("meterType_Desc"));
		boolean res=iMeterTypeService.updateMeterType(meterType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
			return result;
	}
	*/
		
	/**增加数据采集器类型空白表单
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="onClickAddDataCollectorType",method=RequestMethod.GET)
	public ModelAndView onClickAddDataCollectorType(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("superadmin/adddatacollectortype");
		return modelAndView;
	}
	*/
	
	/**判断权限，显示所有采集器类型
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="AllDataCollectorType",method=RequestMethod.GET)
	public ModelAndView showAllDataCollectorType(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();		
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.SystemEquipmentTypeList, Global.SHOW, Global.AUTHORITY_NORMAL);				
		if(authorityJudgeResult != null){
			List<DataCollectorType> dataCollectorTypes=iDataCollectorTypeService.findAllDataCollectorType();
			modelAndView.addObject("dataCollectorTypes", dataCollectorTypes);
			modelAndView.setViewName("superadmin/showdatacollectortype");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}
	*/
	
	/**提交要添加的数据采集器类型信息
	 * @param request
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="submitAddDataCollectorType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddDataCollectorType(HttpServletRequest request){
		DataCollectorType dataCollectorType=new DataCollectorType();
		dataCollectorType.setCollectionType_Name(request.getParameter("collectionType_Name"));
		dataCollectorType.setCollectionType_Desc(request.getParameter("collectionType_Desc"));
		boolean res=iDataCollectorTypeService.addDataCollectorType(dataCollectorType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
			return result;
	}
	*/
		
	/** 提交删除采集器类型
	 * @param
	 * @return
	 * @author RenYang
	 *
	 
	@RequestMapping(value="/deleteDataCollectorType/{collectionType_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteDataCollectorType(@PathVariable("collectionType_ID") Integer collectionType_ID){
		boolean res=iMeterTypeService.deleteMeterType(collectionType_ID);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
		return result;
	}
	*/
	
	/**显示编辑采集器类型界面
	 * @param collectionType_ID
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="/editDataCollectorType/{collectionType_ID}",method=RequestMethod.GET)
	public ModelAndView editDataCollectorType(@PathVariable("collectionType_ID") Integer collectionType_ID){
		DataCollectorType dataCollectorType=iDataCollectorTypeService.getDataCollectorTypeById(collectionType_ID);
		ModelAndView modelAndView=new ModelAndView();		
		modelAndView.addObject("dataCollectorType", dataCollectorType);
		modelAndView.setViewName("superadmin/editdatacollectortype");
		return modelAndView;		
	}
	*/
	
	/**提交编辑数据采集器类型信息
	 * @param request
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="submitEditDataCollectorType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditDataCollectorType(HttpServletRequest request){
		DataCollectorType dataCollectorType=new DataCollectorType();
		dataCollectorType.setCollectionType_ID(Integer.parseInt("collectionType_ID"));
		dataCollectorType.setCollectionType_Name(request.getParameter("collectionType_Name"));
		dataCollectorType.setCollectionType_Desc(request.getParameter("collectionType_Desc"));
		boolean res=iDataCollectorTypeService.updateDataCollectorType(dataCollectorType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
			return result;
	}
	*/
	
	/**增加传感器类型空白表单
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="onClickAddSensorType",method=RequestMethod.GET)
	public ModelAndView onClickAddSensorType(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("superadmin/addsensortype");
		return modelAndView;
	}
	*/
	
	/**判断权限，显示所有传感器类型
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="AllSensorType",method=RequestMethod.GET)
	public ModelAndView showAllSensorType(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();		
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.SystemEquipmentTypeList, Global.SHOW, Global.AUTHORITY_NORMAL);						
		if(authorityJudgeResult != null){
			List<SensorType> sensorTypes=iSensorTypeService.findAllSensorType();
			modelAndView.addObject("sensorTypes", sensorTypes);
			modelAndView.setViewName("superadmin/showsensortype");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}
	*/
	
	/**提交要添加的传感器类型信息
	 * @param request
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="submitAddSensorType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddSensorType(HttpServletRequest request){
		SensorType sensorType=new SensorType();
		sensorType.setSensorType_Name(request.getParameter("sensorType_Name"));
		sensorType.setSensorType_Desc(request.getParameter("sensorType_Desc"));
		boolean res=iSensorTypeService.addSensorType(sensorType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
			return result;
	}
	*/
	
	/** 提交删除传感器类型
	 * @param
	 * @return
	 * @author RenYang
	 *
	 
	@RequestMapping(value="/deleteSensorType/{sensorType_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteSensorType(@PathVariable("sensorType_ID") Integer sensorType_ID){
		boolean res=iSensorTypeService.deleteSensorType(sensorType_ID);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
		return result;
	}
	*/
	
	/**显示编辑传感器类型界面
	 * @param sensorType_ID
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="/editSensorType/{sensorType_ID}",method=RequestMethod.GET)
	public ModelAndView editSensorType(@PathVariable("sensorType_ID") Integer sensorType_ID){
		SensorType sensorType=iSensorTypeService.getSensorTypeById(sensorType_ID);
		ModelAndView modelAndView=new ModelAndView();		
		modelAndView.addObject("sensorType", sensorType);
		modelAndView.setViewName("superadmin/editsensortype");
		return modelAndView;		
	}
	*/
	
	/**提交编辑的传感器类型信息
	 * @param request
	 * @return
	 * @author RenYang
	 
	@RequestMapping(value="submitEditSensorType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditSensorType(HttpServletRequest request){
		SensorType sensorType=new SensorType();
		sensorType.setSensorType_ID(Integer.parseInt(request.getParameter("sensorType_ID")));
		sensorType.setSensorType_Name(request.getParameter("sensorType_Name"));
		sensorType.setSensorType_Desc(request.getParameter("sensorType_Desc"));
		boolean res=iSensorTypeService.updateSensorType(sensorType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
			return result;
	}
	*/
	
	/**判断权限，显示所有仪器
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="allMeter",method=RequestMethod.GET)
	public ModelAndView showallMeter(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();		
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.SystemEquipmentList, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
			//删除的设备除外
			List<MeterUnion> meterUnions=iMeterUnionService.findAllMeterUnion(Global.STATUS_DELETE);	
			modelAndView.addObject("meterUnions", meterUnions);
			modelAndView.setViewName("superadmin/showallmeter");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}
	
	/**判断权限，显示所有数据采集器
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="allDataCollector",method=RequestMethod.GET)
	public ModelAndView showAllDataCollector(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();		
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.SystemEquipmentList, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
			//删除的除外
			List<DataCollectorUnion> dataCollectorUnions=iDataCollectorUnionService.findAllDataCollectorUnion(Global.STATUS_DELETE);		
			modelAndView.addObject("dataCollectorUnions", dataCollectorUnions);
			modelAndView.setViewName("superadmin/showalldatacollector");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}
	
	/**判断权限，显示所有传感器
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="allSensor",method=RequestMethod.GET)
	public ModelAndView showAllSensor(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();		
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.SystemEquipmentList, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
			//将删除的设备除外
			List<SensorUnion> sensorUnions=iSensorUnionService.findAllSensorUnion(Global.STATUS_DELETE);		
			modelAndView.addObject("sensorUnions", sensorUnions);
			modelAndView.setViewName("superadmin/showallsensor");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}
	
	/**判断权限，显示所有其他系统设备
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="allOtherSystemEquipment",method=RequestMethod.GET)
	public ModelAndView allOtherSystemEquipment(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();		
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.SystemEquipmentList, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
			//删除设备除外
			List<OtherSystemEquipmentUnion> otherSystemEquipmentUnions=iOtherSystemEquipmentUnionService.findOtherSystemEquipmentUnionResult(Global.STATUS_DELETE);		
			modelAndView.addObject("otherSystemEquipmentUnions", otherSystemEquipmentUnions);
			modelAndView.setViewName("superadmin/showallothersystemequipment");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}
	
	/**
	 * 判断是否拥有添加系统设备的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeonClickAddSystemEquipment",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeonClickAddEquipment(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.SystemEquipmentList, Global.ADD, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**增加其它系统设备空白表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="onClickAddOtherSystemEquipment",method=RequestMethod.GET)
	public ModelAndView onClickAddOtherEquipment(){
		ModelAndView modelAndView=new ModelAndView();
//		List<SensorType> sensorTypes=iSensorTypeService.findAllSensorType();
		List<Park> parks=iParkService.getAllPark();
		List<Area> areas=iAreaService.findAllArea();
		List<Building> buildings=iBuildingService.findAllBuilding();
		List<Room> rooms=iRoomService.findAllRoom();
		
		List<SystemEquipmentType> systemEquipmentTypes=iSystemEquipmentTypeService.findAllSystemEquipmentType(Global.Type_NORMAL);
		List<SystemEquipmentSubType> systemEquipmentSubTypes=iSystemEquipmentSubTypeService.findAllSystemEquipmentSubType(Global.Type_NORMAL);
		
		modelAndView.addObject("systemEquipmentTypes", systemEquipmentTypes);
		modelAndView.addObject("systemEquipmentSubTypes", systemEquipmentSubTypes);
		
//		modelAndView.addObject("sensorTypes", sensorTypes);
		modelAndView.addObject("parks", parks);
		modelAndView.addObject("areas", areas);
		modelAndView.addObject("buildings", buildings);
		modelAndView.addObject("rooms", rooms);
		modelAndView.setViewName("superadmin/addothersystemequipment");
		return modelAndView;
	}
	
	/**提交其它系统设备
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="submitAddOtherSystemEquipment",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddOtherSystemEquipment(HttpServletRequest request){
//		Room room=iRoomService.getRoomById(Integer.parseInt(request.getParameter("room_ID")));
		Addr addr=new Addr();		 
		addr.setAddr_Code(Integer.parseInt(request.getParameter("room_ID")));
		boolean  addr_result=iAddrService.addAddr(addr);
				
		int addr_id=addr.getAddr_ID();
		
		OtherSystemEquipment otherSystemEquipment=new OtherSystemEquipment();
		otherSystemEquipment.setSystemEquipmentName(request.getParameter("systemEquipmentName"));
		otherSystemEquipment.setSystemEquipmentCode(Integer.parseInt(request.getParameter("systemEquipmentCode")));
		otherSystemEquipment.setSystemEquipmentTypeID(Integer.parseInt(request.getParameter("systemEquipmentSubType_ID")));
		otherSystemEquipment.setSystemEquipmentType_ID(Integer.parseInt(request.getParameter("systemEquipmentType_ID")));
		otherSystemEquipment.setStateID(Global.STATUS_CONNECT);
		otherSystemEquipment.setAddrID(addr_id);
							
		boolean res=iOtherSystemEquipmentService.addOtherSystemEquipment(otherSystemEquipment);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		
			return result;
	}
	
	
	
	/**增加传感器空白表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="onClickAddSensor",method=RequestMethod.GET)
	public ModelAndView onClickAddSensor(){
		ModelAndView modelAndView=new ModelAndView();
//		List<SensorType> sensorTypes=iSensorTypeService.findAllSensorType();
		List<Park> parks=iParkService.getAllPark();
		List<Area> areas=iAreaService.findAllArea();
		List<Building> buildings=iBuildingService.findAllBuilding();
		List<Room> rooms=iRoomService.findAllRoom();
		
		List<SystemEquipmentType> systemEquipmentTypes=iSystemEquipmentTypeService.findAllSystemEquipmentType(Global.Type_NORMAL);
		List<SystemEquipmentSubType> systemEquipmentSubTypes=iSystemEquipmentSubTypeService.findAllSystemEquipmentSubType(Global.Type_NORMAL);
		
		modelAndView.addObject("systemEquipmentTypes", systemEquipmentTypes);
		modelAndView.addObject("systemEquipmentSubTypes", systemEquipmentSubTypes);
		
//		modelAndView.addObject("sensorTypes", sensorTypes);
		modelAndView.addObject("parks", parks);
		modelAndView.addObject("areas", areas);
		modelAndView.addObject("buildings", buildings);
		modelAndView.addObject("rooms", rooms);
		modelAndView.setViewName("superadmin/addsensor");
		return modelAndView;
	}
	
		
	/**提交增加传感器
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="submitAddSensor",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddSensor(HttpServletRequest request){
//		Room room=iRoomService.getRoomById(Integer.parseInt(request.getParameter("room_ID")));
		Addr addr=new Addr();		 
		addr.setAddr_Code(Integer.parseInt(request.getParameter("room_ID")));
		boolean  addr_result=iAddrService.addAddr(addr);
				
		int addr_id=addr.getAddr_ID();
		
		Sensor sensor=new Sensor();
		sensor.setSensor_Name(request.getParameter("sensor_Name"));
		sensor.setSensor_Code(Integer.parseInt(request.getParameter("sensor_Code")));
		sensor.setSensorType_ID(Integer.parseInt(request.getParameter("systemEquipmentSubType_ID")));
		sensor.setSystemEquipmentType_ID(Integer.parseInt(request.getParameter("systemEquipmentType_ID")));
		sensor.setSensor_Interval(request.getParameter("sensor_Interval"));
		sensor.setState_ID(Global.STATUS_CONNECT);
		sensor.setAddr_ID(addr_id);
							
		boolean res=iSensorService.addSensor(sensor);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		
			return result;
	}
	
	/**增加数据采集器空白表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="onClickAddDataCollector",method=RequestMethod.GET)
	public ModelAndView onClickAddDataCollector(){
		ModelAndView modelAndView=new ModelAndView();
//		List<DataCollectorType> dataCollectorTypes=iDataCollectorTypeService.findAllDataCollectorType();
		List<Park> parks=iParkService.getAllPark();
		List<Area> areas=iAreaService.findAllArea();
		List<Building> buildings=iBuildingService.findAllBuilding();
		List<Room> rooms=iRoomService.findAllRoom();
		
		List<SystemEquipmentType> systemEquipmentTypes=iSystemEquipmentTypeService.findAllSystemEquipmentType(Global.Type_NORMAL);
		List<SystemEquipmentSubType> systemEquipmentSubTypes=iSystemEquipmentSubTypeService.findAllSystemEquipmentSubType(Global.Type_NORMAL);
		
		modelAndView.addObject("systemEquipmentTypes", systemEquipmentTypes);
		modelAndView.addObject("systemEquipmentSubTypes", systemEquipmentSubTypes);
		
		
//		modelAndView.addObject("dataCollectorTypes", systemEquipmentTypes);
		modelAndView.addObject("parks", parks);
		modelAndView.addObject("areas", areas);
		modelAndView.addObject("buildings", buildings);
		modelAndView.addObject("rooms", rooms);
		modelAndView.setViewName("superadmin/adddatacollector");
		return modelAndView;
	}
	
	
	/**提交增加采集器
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="submitAddDataCollector",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddDataCollector(HttpServletRequest request){
//		Room room=iRoomService.getRoomById(Integer.parseInt(request.getParameter("room_ID")));
		Addr addr=new Addr();		 
		addr.setAddr_Code(Integer.parseInt(request.getParameter("room_ID")));
		boolean  addr_result=iAddrService.addAddr(addr);
				
		int addr_id=addr.getAddr_ID();
		
		DataCollector dataCollector=new DataCollector();
		dataCollector.setCollection_Name(request.getParameter("collection_Name"));
		dataCollector.setCollection_Code(Integer.parseInt(request.getParameter("collection_Code")));
		dataCollector.setCollectionType_ID(Integer.parseInt(request.getParameter("systemEquipmentSubType_ID")));
		dataCollector.setSystemEquipmentType_ID(Integer.parseInt(request.getParameter("systemEquipmentType_ID")));
		dataCollector.setCollect_Interval(request.getParameter("collect_Interval"));
		dataCollector.setState_ID(Global.STATUS_CONNECT);
		dataCollector.setAddr_ID(addr_id);
							
		boolean res=iDataCollectorService.addDataCollector(dataCollector);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		
			return result;
	}
	
	/**增加仪器空白表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="onClickAddMeter",method=RequestMethod.GET)
	public ModelAndView onClickAddMeter(){
		ModelAndView modelAndView=new ModelAndView();
//		List<MeterType> meterTypes=iMeterTypeService.findAllMeterType();
		List<DataCollector> dataCollectors=iDataCollectorService.findAllDataCollector();
		List<Park> parks=iParkService.getAllPark();
		List<Area> areas=iAreaService.findAllArea();
		List<Building> buildings=iBuildingService.findAllBuilding();
		List<Room> rooms=iRoomService.findAllRoom();
		
		List<SystemEquipmentType> systemEquipmentTypes=iSystemEquipmentTypeService.findAllSystemEquipmentType(Global.Type_NORMAL);
		List<SystemEquipmentSubType> systemEquipmentSubTypes=iSystemEquipmentSubTypeService.findAllSystemEquipmentSubType(Global.Type_NORMAL);
		
		modelAndView.addObject("systemEquipmentTypes", systemEquipmentTypes);
		modelAndView.addObject("systemEquipmentSubTypes", systemEquipmentSubTypes);
		
//		modelAndView.addObject("meterTypes", meterTypes);
		modelAndView.addObject("dataCollectors", dataCollectors);
		modelAndView.addObject("parks", parks);
		modelAndView.addObject("areas", areas);
		modelAndView.addObject("buildings", buildings);
		modelAndView.addObject("rooms", rooms);
		modelAndView.setViewName("superadmin/addmeter");
		return modelAndView;
	}
	
	/**提交增加仪器
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="submitAddMeter",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddMeter(HttpServletRequest request){
//		Room room=iRoomService.getRoomById(Integer.parseInt(request.getParameter("room_ID")));
		Addr addr=new Addr();		 
		addr.setAddr_Code(Integer.parseInt(request.getParameter("room_ID")));
		boolean  addr_result=iAddrService.addAddr(addr);
				
		int addr_id=addr.getAddr_ID();
		
		Meter meter=new Meter();
		meter.setMeter_Name(request.getParameter("meter_Name"));
		meter.setMeter_Code(Integer.parseInt(request.getParameter("meter_Code")));
		meter.setMeterType_ID(Integer.parseInt(request.getParameter("systemEquipmentSubType_ID")));
		meter.setSystemEquipmentType_ID(Integer.parseInt(request.getParameter("systemEquipmentType_ID")));
		meter.setCollection_ID(Integer.parseInt(request.getParameter("collection_ID")));;
		meter.setState_ID(Global.STATUS_CONNECT);
		meter.setAddr_ID(addr_id);
							
		boolean res=iMeterService.addMeter(meter);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		
			return result;
	}
	
	/**
	 * 判断是否拥有编辑系统设备的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeEditSystemEquipment",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeEditSystemEquipment(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.SystemEquipmentList, Global.EDIT, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**编辑其它系统设备表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/onClickEditOtherSystemEquipment/{systemEquipmentID}",method=RequestMethod.GET)
	public ModelAndView onClickEditOtherSystemEquipment(@PathVariable("systemEquipmentID") Integer systemEquipmentID){
		ModelAndView modelAndView=new ModelAndView();
		OtherSystemEquipment otherSystemEquipment=iOtherSystemEquipmentService.getOtherSystemEquipmentById(systemEquipmentID);
		AddrUnion addrUnion=iAddrUnionService.findAddrUnionByAddrId(otherSystemEquipment.getAddrID());
		modelAndView.addObject("otherSystemEquipment", otherSystemEquipment);
		modelAndView.addObject("addrUnion", addrUnion);
		
		
		List<Park> parks=iParkService.getAllPark();
		List<Area> areas=iAreaService.findAllArea();
		List<Building> buildings=iBuildingService.findAllBuilding();
		List<Room> rooms=iRoomService.findAllRoom();
		
		List<SystemEquipmentType> systemEquipmentTypes=iSystemEquipmentTypeService.findAllSystemEquipmentType(Global.Type_NORMAL);
		List<SystemEquipmentSubType> systemEquipmentSubTypes=iSystemEquipmentSubTypeService.findAllSystemEquipmentSubType(Global.Type_NORMAL);
		
		modelAndView.addObject("systemEquipmentTypes", systemEquipmentTypes);
		modelAndView.addObject("systemEquipmentSubTypes", systemEquipmentSubTypes);
		
		modelAndView.addObject("parks", parks);
		modelAndView.addObject("areas", areas);
		modelAndView.addObject("buildings", buildings);
		modelAndView.addObject("rooms", rooms);
		modelAndView.setViewName("superadmin/editothersystemequipment");
		return modelAndView;
	}
	
	/**编辑提交其它系统设备
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="submitEditOtherSystemEquipment",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditOtherSystemEquipment(HttpServletRequest request){
//		Room room=iRoomService.getRoomById(Integer.parseInt(request.getParameter("room_ID")));
		Addr addr=new Addr();		 
		addr.setAddr_Code(Integer.parseInt(request.getParameter("room_ID")));
		boolean  addr_result=iAddrService.addAddr(addr);
				
		int addr_id=addr.getAddr_ID();
		
		OtherSystemEquipment otherSystemEquipment=new OtherSystemEquipment();
		otherSystemEquipment.setSystemEquipmentID(Integer.parseInt(request.getParameter("systemEquipmentID")));
		otherSystemEquipment.setSystemEquipmentName(request.getParameter("systemEquipmentName"));
		otherSystemEquipment.setSystemEquipmentCode(Integer.parseInt(request.getParameter("systemEquipmentCode")));
		otherSystemEquipment.setSystemEquipmentTypeID(Integer.parseInt(request.getParameter("systemEquipmentSubType_ID")));
		otherSystemEquipment.setSystemEquipmentType_ID(Integer.parseInt(request.getParameter("systemEquipmentType_ID")));
		otherSystemEquipment.setStateID(Global.STATUS_CONNECT);
		otherSystemEquipment.setAddrID(addr_id);
							
		boolean res=iOtherSystemEquipmentService.updateOtherSystemEquipment(otherSystemEquipment);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 0);
		}
		
			return result;
	}
	
	
	/**显示编辑传感器界面
	 * @param sensor_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/editSensor/{sensor_ID}",method=RequestMethod.GET)
	public ModelAndView editSensor(@PathVariable("sensor_ID") Integer sensor_ID){
		Sensor sensor=iSensorService.getSensorById(sensor_ID);
		AddrUnion addrUnion=iAddrUnionService.findAddrUnionByAddrId(sensor.getAddr_ID());
		ModelAndView modelAndView=new ModelAndView();		
		modelAndView.addObject("sensor", sensor);
		modelAndView.addObject("addrUnion", addrUnion);
//		List<SensorType> sensorTypes=iSensorTypeService.findAllSensorType();
		List<Park> parks=iParkService.getAllPark();
		List<Area> areas=iAreaService.findAllArea();
		List<Building> buildings=iBuildingService.findAllBuilding();
		List<Room> rooms=iRoomService.findAllRoom();
		
		List<SystemEquipmentType> systemEquipmentTypes=iSystemEquipmentTypeService.findAllSystemEquipmentType(Global.Type_NORMAL);
		List<SystemEquipmentSubType> systemEquipmentSubTypes=iSystemEquipmentSubTypeService.findAllSystemEquipmentSubType(Global.Type_NORMAL);
		
		modelAndView.addObject("systemEquipmentTypes", systemEquipmentTypes);
		modelAndView.addObject("systemEquipmentSubTypes", systemEquipmentSubTypes);
		
//		modelAndView.addObject("sensorTypes", sensorTypes);
		modelAndView.addObject("parks", parks);
		modelAndView.addObject("areas", areas);
		modelAndView.addObject("buildings", buildings);
		modelAndView.addObject("rooms", rooms);
		modelAndView.setViewName("superadmin/editsensor");
		return modelAndView;		
	}
	
	/**提交编辑传感器
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="submitEditSensor",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditSensor(HttpServletRequest request){
//		Room room=iRoomService.getRoomById(Integer.parseInt(request.getParameter("room_ID")));
		Addr addr=new Addr();		 
		addr.setAddr_Code(Integer.parseInt(request.getParameter("room_ID")));
		boolean  addr_result=iAddrService.addAddr(addr);
				
		int addr_id=addr.getAddr_ID();
		
		Sensor sensor=new Sensor();
		sensor.setSensor_ID(Integer.parseInt(request.getParameter("sensor_ID")));
		sensor.setSensor_Name(request.getParameter("sensor_Name"));
		sensor.setSensor_Code(Integer.parseInt(request.getParameter("sensor_Code")));
		sensor.setSensorType_ID(Integer.parseInt(request.getParameter("systemEquipmentSubType_ID")));
		sensor.setSystemEquipmentType_ID(Integer.parseInt(request.getParameter("systemEquipmentType_ID")));
		sensor.setSensor_Interval(request.getParameter("sensor_Interval"));
		sensor.setState_ID(Global.STATUS_CONNECT);
		sensor.setAddr_ID(addr_id);
							
		boolean res=iSensorService.updateSensor(sensor);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		
			return result;
	}
	
	/**显示编辑采集器界面
	 * @param collection_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/editDataCollector/{collection_ID}",method=RequestMethod.GET)
	public ModelAndView editDataCollector(@PathVariable("collection_ID") Integer collection_ID){
		DataCollector dataCollector=iDataCollectorService.getDataCollectorById(collection_ID);
		AddrUnion addrUnion=iAddrUnionService.findAddrUnionByAddrId(dataCollector.getAddr_ID());
		ModelAndView modelAndView=new ModelAndView();		
		modelAndView.addObject("dataCollector", dataCollector);
		modelAndView.addObject("addrUnion", addrUnion);
//		List<DataCollectorType> dataCollectorTypes=iDataCollectorTypeService.findAllDataCollectorType();
		List<Park> parks=iParkService.getAllPark();
		List<Area> areas=iAreaService.findAllArea();
		List<Building> buildings=iBuildingService.findAllBuilding();
		List<Room> rooms=iRoomService.findAllRoom();
		
		List<SystemEquipmentType> systemEquipmentTypes=iSystemEquipmentTypeService.findAllSystemEquipmentType(Global.Type_NORMAL);
		List<SystemEquipmentSubType> systemEquipmentSubTypes=iSystemEquipmentSubTypeService.findAllSystemEquipmentSubType(Global.Type_NORMAL);
		
		modelAndView.addObject("systemEquipmentTypes", systemEquipmentTypes);
		modelAndView.addObject("systemEquipmentSubTypes", systemEquipmentSubTypes);
		
//		modelAndView.addObject("dataCollectorTypes", dataCollectorTypes);
		modelAndView.addObject("parks", parks);
		modelAndView.addObject("areas", areas);
		modelAndView.addObject("buildings", buildings);
		modelAndView.addObject("rooms", rooms);
		modelAndView.setViewName("superadmin/editdatacollector");
		return modelAndView;		
	}
	
	/**提交编辑采集器
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="submitEditDataCollector",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditDataCollector(HttpServletRequest request){
//		Room room=iRoomService.getRoomById(Integer.parseInt(request.getParameter("room_ID")));
		Addr addr=new Addr();		 
		addr.setAddr_Code(Integer.parseInt(request.getParameter("room_ID")));
		boolean  addr_result=iAddrService.addAddr(addr);
				
		int addr_id=addr.getAddr_ID();
		
		DataCollector dataCollector=new DataCollector();
		dataCollector.setCollection_ID(Integer.parseInt(request.getParameter("collection_ID")));
		dataCollector.setCollection_Name(request.getParameter("collection_Name"));
		dataCollector.setCollection_Code(Integer.parseInt(request.getParameter("collection_Code")));
		dataCollector.setCollectionType_ID(Integer.parseInt(request.getParameter("systemEquipmentSubType_ID")));
		dataCollector.setSystemEquipmentType_ID(Integer.parseInt(request.getParameter("systemEquipmentType_ID")));
		dataCollector.setCollect_Interval(request.getParameter("collect_Interval"));
		dataCollector.setState_ID(Global.STATUS_CONNECT);
		dataCollector.setAddr_ID(addr_id);
							
		boolean res=iDataCollectorService.updateDataCollector(dataCollector);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		
			return result;
	}
	
	/**显示编辑仪器界面
	 * @param meter_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/editMeter/{meter_ID}",method=RequestMethod.GET)
	public ModelAndView editMeter(@PathVariable("meter_ID") Integer meter_ID){
		Meter meter=iMeterService.getMeterById(meter_ID);
		AddrUnion addrUnion=iAddrUnionService.findAddrUnionByAddrId(meter.getAddr_ID());
		ModelAndView modelAndView=new ModelAndView();		
		modelAndView.addObject("meter", meter);
		modelAndView.addObject("addrUnion", addrUnion);
//		List<MeterType> meterTypes=iMeterTypeService.findAllMeterType();
		List<DataCollector> dataCollectors=iDataCollectorService.findAllDataCollector();
		List<Park> parks=iParkService.getAllPark();
		List<Area> areas=iAreaService.findAllArea();
		List<Building> buildings=iBuildingService.findAllBuilding();
		List<Room> rooms=iRoomService.findAllRoom();
		
		List<SystemEquipmentType> systemEquipmentTypes=iSystemEquipmentTypeService.findAllSystemEquipmentType(Global.Type_NORMAL);
		List<SystemEquipmentSubType> systemEquipmentSubTypes=iSystemEquipmentSubTypeService.findAllSystemEquipmentSubType(Global.Type_NORMAL);
		
		modelAndView.addObject("systemEquipmentTypes", systemEquipmentTypes);
		modelAndView.addObject("systemEquipmentSubTypes", systemEquipmentSubTypes);
		
//		modelAndView.addObject("meterTypes", meterTypes);
		modelAndView.addObject("dataCollectors", dataCollectors);
		modelAndView.addObject("parks", parks);
		modelAndView.addObject("areas", areas);
		modelAndView.addObject("buildings", buildings);
		modelAndView.addObject("rooms", rooms);
		modelAndView.setViewName("superadmin/editmeter");
		return modelAndView;		
	}
	
	/**提交编辑仪器
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="submitEditMeter",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditMeter(HttpServletRequest request){
//		Room room=iRoomService.getRoomById(Integer.parseInt(request.getParameter("room_ID")));
		Addr addr=new Addr();		 
		addr.setAddr_Code(Integer.parseInt(request.getParameter("room_ID")));
		boolean  addr_result=iAddrService.addAddr(addr);
				
		int addr_id=addr.getAddr_ID();
		
		
		Meter meter=new Meter();
		meter.setMeter_ID(Integer.parseInt(request.getParameter("meter_ID")));
		meter.setMeter_Name(request.getParameter("meter_Name"));
		meter.setMeter_Code(Integer.parseInt(request.getParameter("meter_Code")));
		meter.setMeterType_ID(Integer.parseInt(request.getParameter("systemEquipmentSubType_ID")));
		meter.setSystemEquipmentType_ID(Integer.parseInt(request.getParameter("systemEquipmentType_ID")));
		meter.setCollection_ID(Integer.parseInt(request.getParameter("collection_ID")));;
		meter.setState_ID(Global.STATUS_CONNECT);
		meter.setAddr_ID(addr_id);
							
		boolean res=iMeterService.updateMeter(meter);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		
			return result;
	}
	
	/**
	 * 判断是否拥有删除系统设备的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeDeleteSystemEquipment",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeDeleteSystemEquipment(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.SystemEquipmentList, Global.DELETE, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/** 提交删除其他系统设备
	 * @param
	 * @return
	 * @author RenYang
	 *
	 */
	@RequestMapping(value="/deleteOtherSyetemEquipment/{systemEquipmentID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteOtherSyetemEquipment(@PathVariable("systemEquipmentID") Integer systemEquipmentID){
		OtherSystemEquipment otherSystemEquipment=new OtherSystemEquipment();
		otherSystemEquipment.setSystemEquipmentID(systemEquipmentID);
		otherSystemEquipment.setStateID(Global.STATUS_DELETE);
		boolean res=iOtherSystemEquipmentService.updateOtherSystemEquipment(otherSystemEquipment);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
		return result;
	}
	
	/** 提交删除传感器
	 * @param
	 * @return
	 * @author RenYang
	 *
	 */
	@RequestMapping(value="/deleteSensor/{sensor_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteSensor(@PathVariable("sensor_ID") Integer sensor_ID){
		Sensor sensor=new Sensor();
		sensor.setSensor_ID(sensor_ID);
		sensor.setState_ID(Global.STATUS_DELETE);
		boolean res=iSensorService.updateSensor(sensor);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
		return result;
	}
	
	/** 提交删除采集器
	 * @param
	 * @return
	 * @author RenYang
	 *
	 */
	@RequestMapping(value="/deleteDataCollector/{collection_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteDataCollector(@PathVariable("collection_ID") Integer collection_ID){
		DataCollector dataCollector=new DataCollector();
		dataCollector.setCollection_ID(collection_ID);
		dataCollector.setState_ID(Global.STATUS_DELETE);
		boolean res=iDataCollectorService.updateDataCollector(dataCollector);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
		return result;
	}
	
	/** 提交删除仪器
	 * @param
	 * @return
	 * @author RenYang
	 *
	 */
	@RequestMapping(value="/deleteMeter/{meter_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteMeter(@PathVariable("meter_ID") Integer meter_ID){
		Meter meter=new Meter();
		meter.setMeter_ID(meter_ID);
		meter.setState_ID(Global.STATUS_DELETE);
		boolean res=iMeterService.updateMeter(meter);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
		return result;
	}
		
	/**查询系统设备类型所拥有的系统设备子类型
	 * @param systemEquipmentType_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="branchforSubType/{systemEquipmentType_ID}",method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> branchforSubType(@PathVariable("systemEquipmentType_ID") Integer systemEquipmentType_ID){
		List<SystemEquipmentSubType> subTypes=iSystemEquipmentSubTypeService.selectSystemEquipmentSubTypeBySystemEquipmentType(systemEquipmentType_ID,Global.Type_NORMAL);
		List<Map<String, Object>> msgList=new ArrayList<Map<String,Object>>();
		if(subTypes.size()>0){
			for(int i=0;i<subTypes.size();i++){
				SystemEquipmentSubType systemEquipmentSubType=subTypes.get(i);
				Map<String, Object> msgmap=new HashMap<String,Object>();
				msgmap.put("systemEquipmentSubType_ID", systemEquipmentSubType.getSystemEquipmentSubType_ID());
				msgmap.put("systemEquipmentSubType_Name", systemEquipmentSubType.getSystemEquipmentSubType_Name());
				msgList.add(msgmap);
			}
		}
		return msgList;
	}
}
