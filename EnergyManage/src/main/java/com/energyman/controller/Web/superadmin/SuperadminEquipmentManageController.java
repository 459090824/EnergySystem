package com.energyman.controller.Web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.alibaba.fastjson.parser.deserializer.StringFieldDeserializer;
import com.energyman.bean.Addr;
import com.energyman.bean.AddrUnion;
import com.energyman.bean.Admin;
import com.energyman.bean.AdminAuthorityJudge;
import com.energyman.bean.Area;
import com.energyman.bean.Building;
import com.energyman.bean.Equipment;
import com.energyman.bean.EquipmentSubType;
import com.energyman.bean.EquipmentSubTypeUnion;
import com.energyman.bean.EquipmentType;
import com.energyman.bean.EquipmentUnion;
import com.energyman.bean.Park;
import com.energyman.bean.Room;
import com.energyman.bean.SystemEquipmentSubType;
import com.energyman.service.IAddrService;
import com.energyman.service.IAddrUnionService;
import com.energyman.service.IAdminAuthorityJudgeService;
import com.energyman.service.IAreaService;
import com.energyman.service.IBuildingService;
import com.energyman.service.IEquipmentService;
import com.energyman.service.IEquipmentSubTypeService;
import com.energyman.service.IEquipmentSubTypeUnionService;
import com.energyman.service.IEquipmentTypeService;
import com.energyman.service.IEquipmentUnionService;
import com.energyman.service.IParkService;
import com.energyman.service.IRoomService;
import com.energyman.utils.Global;
import com.energyman.utils.RequestToEquipment;


@Controller
@RequestMapping("/superadmin")
public class SuperadminEquipmentManageController {

	@Resource
	private IEquipmentService iEquipmentService;
	@Resource
	private IEquipmentTypeService iEquipmentTypeService;
	@Resource
	private IEquipmentSubTypeService iEquipmentSubTypeService;
	@Resource
	private IEquipmentSubTypeUnionService iEquipmentSubTypeUnionService;
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
	private IEquipmentUnionService iEquipmentUnionService;
	@Resource
	private IAddrUnionService iAddrUnionService;
	@Resource
	private IAdminAuthorityJudgeService iAdminAuthorityJudgeService;
	
	
	/**判断权限，显示以所有添加的设备
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="allEquipment",method=RequestMethod.GET)
	public ModelAndView showAllEquipment(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentList, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
			//删除的设备除外
			List<EquipmentUnion> equipmentunions=iEquipmentUnionService.findAllEquipmentUnion(Global.STATUS_DELETE);		
			modelAndView.addObject("equipmentunions", equipmentunions);		
			modelAndView.setViewName("superadmin/showallequipment");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
		return modelAndView;
	}
	
	/**判断权限，显示所有设备类型
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="allEquipmentType",method=RequestMethod.GET)
	public ModelAndView showAllEquipmentType(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentTypeList, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
			List<EquipmentType> equipmentTypes=iEquipmentTypeService.findAllEquipmentType(Global.Type_NORMAL);	
			modelAndView.addObject("equipmentTypes", equipmentTypes);
			modelAndView.setViewName("superadmin/showallequipmenttype");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
		return modelAndView;
	}
	
	/**显示所有设备子类型
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="allEquipmentSubType",method=RequestMethod.GET)
	public ModelAndView showAllEquipmentSubType(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentSubTypeList, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
			List<EquipmentSubTypeUnion> equipmentSubTypeUnions=iEquipmentSubTypeUnionService.findEquipmentSubTypeUnionResult(Global.Type_NORMAL);		
			modelAndView.addObject("equipmentSubTypeUnions",equipmentSubTypeUnions);
			modelAndView.setViewName("superadmin/showallequipmentsubtype");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
		return modelAndView;
	}
	
	/**
	 * 判断是否拥有添加设备类型的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeonClickAddEquipmentType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeonClickAddEquipmentType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentTypeList, Global.ADD, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**添加设备类型空白表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/onClickAddEquipmentType",method=RequestMethod.GET)
	public ModelAndView onClickAddEquipmentType(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("superadmin/addequipmenttype");
		return modelAndView;
	}
	
	/**点击提交设备类型添加
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitAddEquipmentType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddEquipmentType(HttpServletRequest request){
		EquipmentType equipmentType=new EquipmentType();
		equipmentType.setEquipmentType_Name(request.getParameter("equipmentType_Name"));
		equipmentType.setEquipmentType_Desc(request.getParameter("equipmentType_Desc"));
		equipmentType.setEquipmentType_state(Global.Type_NORMAL);
		boolean res=iEquipmentTypeService.addEquipmentType(equipmentType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有添加设备子类型的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeonClickAddEquipmentSubType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeonClickAddEquipmentSubType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentSubTypeList, Global.ADD, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**添加设备子类型空白表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/onClickAddEquipmentSubType",method=RequestMethod.GET)
	public ModelAndView onClickAddEquipmentSubType(){
		ModelAndView modelAndView=new ModelAndView();
		List<EquipmentType> equipmentTypes=iEquipmentTypeService.findAllEquipmentType(Global.Type_NORMAL);
		modelAndView.addObject("equipmentTypes",equipmentTypes);
		modelAndView.setViewName("superadmin/addequipmentsubtype");
		return modelAndView;
	}
	
	
	/**点击提交设备子类型添加
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitAddEquipmentSubType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddEquipmentSubType(HttpServletRequest request){
		EquipmentSubType equipmentSubType=new EquipmentSubType();
		equipmentSubType.setEquipmentSubType_Name(request.getParameter("equipmentSubType_Name"));
		equipmentSubType.setEquipmentSubType_Desc(request.getParameter("equipmentSubType_Desc"));
		equipmentSubType.setEquipmentType_ID(Integer.parseInt(request.getParameter("equipmentType_ID")));
		equipmentSubType.setEquipmentSubType_state(Global.Type_NORMAL);
		boolean res=iEquipmentSubTypeService.addEquipmentSubType(equipmentSubType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有删除设备类型的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgedeleteEquipmentType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgedeleteEquipmentType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentTypeList, Global.DELETE, Global.AUTHORITY_NORMAL);
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
	 * 删除设备类型
	 * @param equipmentType_ID
	 * @return
	 */
	@RequestMapping(value="/deleteEquipmentType/{equipmentType_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteEnergyType(@PathVariable("equipmentType_ID") Integer equipmentType_ID){
		EquipmentType equipmentType=new EquipmentType();
		equipmentType.setEquipmentType_ID(equipmentType_ID);
		equipmentType.setEquipmentType_state(Global.Type_Delete);
		boolean res=iEquipmentTypeService.updateEquipmentType(equipmentType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有编辑设备类型的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeeditEquipmentType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeeditEquipmentType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentTypeList, Global.EDIT, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**显示编辑设备类型界面
	 * @param equipmentType_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/editEquipmentType/{equipmentType_ID}",method=RequestMethod.GET)
	public ModelAndView editEquipmentType(@PathVariable("equipmentType_ID") Integer equipmentType_ID){
		ModelAndView modelAndView=new ModelAndView();
		EquipmentType equipmentType=iEquipmentTypeService.getEquipmentTypeById(equipmentType_ID);
		modelAndView.addObject("equipmentType",equipmentType);
		modelAndView.setViewName("superadmin/editequipmenttype");
		return modelAndView;		
	}
	
	/** 提交设备类型编辑页面
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitEditEquipmentType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> submitEditEquipmentType(HttpServletRequest request){
		Map<String,Object> result=new HashMap<String,Object>();
		EquipmentType equipmentType=new EquipmentType();
		Integer equipmentType_ID=Integer.parseInt(request.getParameter("equipmentType_ID"));
		equipmentType.setEquipmentType_ID(equipmentType_ID);		
		equipmentType.setEquipmentType_Name(request.getParameter("equipmentType_Name"));	
		equipmentType.setEquipmentType_Desc(request.getParameter("equipmentType_Desc"));
		boolean res=iEquipmentTypeService.updateEquipmentType(equipmentType);		
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有删除设备子类型的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgedeleteEquipmentSubType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgedeleteEquipmentSubType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentSubTypeList, Global.DELETE, Global.AUTHORITY_NORMAL);
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
	 * 删除设备子类型
	 * @param equipmentSubType_ID
	 * 
	 * @return
	 */
	@RequestMapping(value="/deleteEquipmentSubType/{equipmentSubType_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteEnergySubType(@PathVariable("equipmentSubType_ID") Integer equipmentSubType_ID){
		EquipmentSubType equipmentSubType=new EquipmentSubType();
		equipmentSubType.setEquipmentSubType_ID(equipmentSubType_ID);
		equipmentSubType.setEquipmentSubType_state(Global.Type_Delete);
		boolean res=iEquipmentSubTypeService.updateEquipmentSubType(equipmentSubType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有编辑设备子类型的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeeditEquipmentSubType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeeditEquipmentSubType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentSubTypeList, Global.EDIT, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**显示编辑设备子类型界面
	 * @param equipmentSubType_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/editEquipmentSubType/{equipmentSubType_ID}",method=RequestMethod.GET)
	public ModelAndView editEquipmentSubType(@PathVariable("equipmentSubType_ID") Integer equipmentSubType_ID){
		ModelAndView modelAndView=new ModelAndView();
		EquipmentSubType equipmentSubType=iEquipmentSubTypeService.getEquipmentSubTypeById(equipmentSubType_ID);
		List<EquipmentType> equipmentTypes=iEquipmentTypeService.findAllEquipmentType(Global.Type_NORMAL);
		modelAndView.addObject("equipmentTypes",equipmentTypes);
		modelAndView.addObject("equipmentSubType",equipmentSubType);
		modelAndView.setViewName("superadmin/editequipmentsubtype");
		return modelAndView;		
	}
	
	/** 提交设备子类型编辑页面
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitEditEquipmentSubType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> submitEditEquipmentSubType(HttpServletRequest request){
		Map<String,Object> result=new HashMap<String,Object>();
		EquipmentSubType equipmentSubType=new EquipmentSubType();
		Integer equipmentSubType_ID=Integer.parseInt(request.getParameter("equipmentSubType_ID"));
		equipmentSubType.setEquipmentSubType_ID(equipmentSubType_ID);	
		equipmentSubType.setEquipmentSubType_Name(request.getParameter("equipmentSubType_Name"));			
		equipmentSubType.setEquipmentSubType_Desc(request.getParameter("equipmentSubType_Desc"));
		equipmentSubType.setEquipmentType_ID(Integer.parseInt(request.getParameter("equipmentType_ID")));
		boolean res=iEquipmentSubTypeService.updateEquipmentSubType(equipmentSubType);
		
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有添加设备的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeonClickAddEquipment",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeonClickAddEquipment(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentList, Global.ADD, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**添加设备空白表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/onClickAddEquipment",method=RequestMethod.GET)
	public ModelAndView onClickAddEquipment(){
		ModelAndView modelAndView=new ModelAndView();
		List<EquipmentType> equipmentTypes=iEquipmentTypeService.findAllEquipmentType(Global.Type_NORMAL);
		List<EquipmentSubType> equipmentSubTypes=iEquipmentSubTypeService.findAllEquipmentSubType(Global.Type_NORMAL);
		List<Park> parks=iParkService.getAllPark();
		List<Area> areas=iAreaService.findAllArea();
		List<Building> buildings=iBuildingService.findAllBuilding();
		List<Room> rooms=iRoomService.findAllRoom();
		modelAndView.addObject("equipmentTypes", equipmentTypes);
		modelAndView.addObject("equipmentSubTypes", equipmentSubTypes);
		modelAndView.addObject("parks", parks);
		modelAndView.addObject("areas", areas);
		modelAndView.addObject("buildings", buildings);
		modelAndView.addObject("rooms", rooms);
		modelAndView.setViewName("superadmin/addequipment");
		return modelAndView;
	}
	
	/**提交增加设备
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="submitAddEquipment",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddEquipment(HttpServletRequest request){
//		Room room=iRoomService.getRoomById(Integer.parseInt(request.getParameter("room_ID")));
		Addr addr=new Addr();		 
		addr.setAddr_Code(Integer.parseInt(request.getParameter("room_ID")));
		boolean  addr_result=iAddrService.addAddr(addr);
				
		int addr_id=addr.getAddr_ID();
		
		Equipment equipment=new Equipment();
		equipment.setEquipment_Name(request.getParameter("equipment_Name"));
		equipment.setEquipment_Code(Integer.parseInt(request.getParameter("equipment_Code")));
		equipment.setEquipmentType_ID(Integer.parseInt(request.getParameter("equipmentType_ID")));
		equipment.setEquipmentSubType_ID(Integer.parseInt(request.getParameter("equipmentSubType_ID")));
		equipment.setIsAuto_Equipment(request.getParameter("isAuto_Equipment"));
		equipment.setAddr_ID(addr_id);
		equipment.setState_ID(Global.STATUS_CONNECT);
		equipment.setEquipmentControlModel_ID(Global.STATUS_START);
			
//		equipment.setState_ID(Global.STATUS_CONNECT);
		
				
		boolean res=iEquipmentService.addEquipment(equipment);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		
			return result;
	}
	
	/**
	 * 判断是否拥有编辑设备的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeeditEquipment",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeeditEquipment(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentList, Global.EDIT, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**显示设备编辑界面
	 * @param equipment_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/editEquipment/{equipment_ID}",method=RequestMethod.GET)
	public ModelAndView editEquipment(@PathVariable("equipment_ID") Integer equipment_ID){
		ModelAndView modelAndView=new ModelAndView();
		Equipment equipment=iEquipmentService.getEquipmentById(equipment_ID);
		AddrUnion addrUnion=iAddrUnionService.findAddrUnionByAddrId(equipment.getAddr_ID());
		List<EquipmentType> equipmentTypes=iEquipmentTypeService.findAllEquipmentType(Global.Type_NORMAL);
		List<EquipmentSubType> equipmentSubTypes=iEquipmentSubTypeService.findAllEquipmentSubType(Global.Type_NORMAL);
		List<Park> parks=iParkService.getAllPark();
		List<Area> areas=iAreaService.findAllArea();
		List<Building> buildings=iBuildingService.findAllBuilding();
		List<Room> rooms=iRoomService.findAllRoom();
		modelAndView.addObject("equipmentTypes", equipmentTypes);
		modelAndView.addObject("equipmentSubTypes", equipmentSubTypes);
		modelAndView.addObject("parks", parks);
		modelAndView.addObject("areas", areas);
		modelAndView.addObject("buildings", buildings);
		modelAndView.addObject("rooms", rooms);
		modelAndView.addObject("equipment",equipment);
		modelAndView.addObject("addrUnion",addrUnion);
		modelAndView.setViewName("superadmin/editequipment");
		return modelAndView;		
	}
	
	/**
	 * 判断是否拥有删除设备的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgedeleteEquipment",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgedeleteEquipment(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentList, Global.DELETE, Global.AUTHORITY_NORMAL);
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
	 * 删除设备
	 * @param equipment_ID
	 * 
	 * @return
	 */
	@RequestMapping(value="/deleteEquipment/{equipment_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteEquipment(@PathVariable("equipment_ID") Integer equipment_ID){
		Equipment equipment=new Equipment();
		equipment.setEquipment_ID(equipment_ID);
		equipment.setState_ID(Global.STATUS_DELETE);
		boolean res=iEquipmentService.updateEquipment(equipment);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
		return result;
	}
	
	/**提交编辑设备
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="submitEditEquipment",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditEquipment(HttpServletRequest request){
//		Room room=iRoomService.getRoomById(Integer.parseInt(request.getParameter("room_ID")));
		Addr addr=new Addr();		 
		addr.setAddr_Code(Integer.parseInt(request.getParameter("room_ID")));
		boolean  addr_result=iAddrService.addAddr(addr);
				
		int addr_id=addr.getAddr_ID();
		
		Equipment equipment=new Equipment();
		equipment.setEquipment_ID(Integer.parseInt(request.getParameter("equipment_ID")));
		equipment.setEquipment_Name(request.getParameter("equipment_Name"));
		equipment.setEquipment_Code(Integer.parseInt(request.getParameter("equipment_Code")));
		equipment.setEquipmentType_ID(Integer.parseInt(request.getParameter("equipmentType_ID")));
		equipment.setEquipmentSubType_ID(Integer.parseInt(request.getParameter("equipmentSubType_ID")));
		equipment.setIsAuto_Equipment(request.getParameter("isAuto_Equipment"));
		equipment.setAddr_ID(addr_id);
//		equipment.setState_ID(Global.STATUS_CONNECT);
//		equipment.setEquipmentControlModel_ID(Global.STATUS_START);
			
//		equipment.setState_ID(Global.STATUS_CONNECT);
		
				
		boolean res=iEquipmentService.updateEquipment(equipment);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		
			return result;
	}
	
	
	/**查询对应园区所拥有的区域
	 * @param park_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="branchOne/{park_ID}",method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> branchOne(@PathVariable("park_ID") Integer park_ID){
		List<Area> areas=iAreaService.getAreaByPark(park_ID);
		List<Map<String, Object>> msgList=new ArrayList<Map<String, Object>>();  
		if(areas.size()>0){
			for(int i=0;i<areas.size();i++){
				Area area=areas.get(i);
				Map<String, Object> msgmap=new HashMap<String,Object>();
				msgmap.put("region_ID",area.getRegion_ID());
				msgmap.put("region_Name",area.getRegion_Name());
				msgList.add(msgmap);
			}
			
		}		
		return msgList;
	}
	
	/**查询对应区域所拥有的建筑
	 * @param region_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="branchTwo/{region_ID}",method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> branchTwo(@PathVariable("region_ID") Integer region_ID){
		List<Building> buildings=iBuildingService.getBuildingByArea(region_ID);
		List<Map<String, Object>> msgList=new ArrayList<Map<String,Object>>();
		if(buildings.size()>0){
			for(int i=0;i<buildings.size();i++){
				Building building=buildings.get(i);
				Map<String, Object> msgmap=new HashMap<String,Object>();
				msgmap.put("build_ID", building.getBuild_ID());
				msgmap.put("build_Name", building.getBuild_Name());
				msgList.add(msgmap);
			}
		}
		return msgList;
	}
	
	/**查询对应建筑所拥有的房间
	 * @param build_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="branchThree/{build_ID}",method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> branchThree(@PathVariable("build_ID") Integer build_ID){
		List<Room> rooms=iRoomService.getRoomByBuilding(build_ID); 
		List<Map<String, Object>> msgList=new ArrayList<Map<String,Object>>();
		if(rooms.size()>0){
			for(int i=0;i<rooms.size();i++){
				Room room=rooms.get(i);
				Map<String, Object> msgmap=new HashMap<String,Object>();
				msgmap.put("room_ID", room.getRoom_ID());
				msgmap.put("room_Name", room.getRoom_Name());
				msgList.add(msgmap);
			}
		}
		return msgList;
	}
	
	/**连接设备并返回连接结果
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="equipmentConnect",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> equipmentConeect(HttpServletRequest request) throws Exception{
		Map<String, Object> reslut=new HashMap<String,Object>();
		System.out.println("..........."+request.getParameter("equipment_Code"));
		Integer equipment_Code=Integer.parseInt(request.getParameter("equipment_Code"));
		RequestToEquipment requestToEquipment=new RequestToEquipment();
		boolean res=requestToEquipment.handler(equipment_Code);
		if(res){
			reslut.put("success", 1);
		}else{
			reslut.put("failure", 0);
		}
			return reslut;
	}
	
	
	/**查询用户设备类型所拥有的用户设备子类型
	 * @param equipmentType_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="userEquipmentTypeBranchforSubType/{equipmentType_ID}",method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> branchforSubType(@PathVariable("equipmentType_ID") Integer equipmentType_ID){
		List<EquipmentSubType> equipmentSubTypes=iEquipmentSubTypeService.findEquipmentSubTypeByEquipmentType(equipmentType_ID, Global.Type_NORMAL);
		List<Map<String, Object>> msgList=new ArrayList<Map<String,Object>>();
		if(equipmentSubTypes.size()>0){
			for(int i=0;i<equipmentSubTypes.size();i++){
				EquipmentSubType equipmentSubType=equipmentSubTypes.get(i);
				Map<String, Object> msgmap=new HashMap<String,Object>();
				msgmap.put("equipmentSubType_ID", equipmentSubType.getEquipmentSubType_ID());
				msgmap.put("equipmentSubType_Name", equipmentSubType.getEquipmentSubType_Name());
				msgList.add(msgmap);
			}
		}
		return msgList;
	}
	
	/*-------------进行设备控制的方法Controller--------------------*/
	
	/**判断权限，设备控制模式设置页面
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="showSetEquipmentModel",method=RequestMethod.GET)
	public ModelAndView showSetEquipmentModel(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentControl, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
			List<EquipmentUnion> equipmentunions=iEquipmentUnionService.findAllEquipmentUnion(Global.STATUS_DELETE);		
//		for(int i=0;i<equipmentunions.size();i++){
//			Integer addrCode=equipmentunions.get(i).getAddr().getAddr_Code();
//			String roomName=iRoomService.getRoomById(addrCode).getRoom_Name();
//			String buildName=iBuildingService.getBuildingById(iRoomService.getRoomById(addrCode).getBuild_ID()).getBuild_Name();
//			String areaName=iAreaService.getAreaById(iBuildingService.getBuildingById(iRoomService.getRoomById(addrCode).getBuild_ID()).getRegion_ID()).getRegion_Name();
//		}
//		modelAndView.addObject("roomName",roomName);
			modelAndView.addObject("equipmentunions", equipmentunions);
			modelAndView.setViewName("superadmin/equipmentcontrol");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}
	
	/**
	 * 判断是否拥有设置设备控制模式的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgesetControlModel",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgesetControlModel(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentControl, Global.CONTROL, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**设备控制模式设置为手动模式
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="setHMModel",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> setHMModel(HttpServletRequest request){
		Map<String, Object> result=new HashMap<String, Object>();
		String[] selectEquipment_IDs=request.getParameterValues("selectlist");
		Equipment equipment=new Equipment();
		boolean res=false;
		
		if(selectEquipment_IDs == null){
			result.put("success", "2");
			System.out.println("请添加需设置的设备！！");
		}else{
			for(String selectEquipment_ID :selectEquipment_IDs ){
				equipment.setEquipment_ID(Integer.parseInt(selectEquipment_ID));
				equipment.setEquipmentControlModel_ID(Global.STATUS_HM);
				res=iEquipmentService.updateEquipment(equipment);
			}			
		}
		if(res){
			result.put("success", 1);
		}else {
			result.put("success", 2);
		}
		
			return result;
	}
	
	/**设备控制模式设置为智能模式
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="setAUTOModel",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> setAUTOModel(HttpServletRequest request){
		Map<String, Object> result=new HashMap<String, Object>();
		String[] selectEquipment_IDs=request.getParameterValues("selectlist");
		Equipment equipment=new Equipment();
		boolean res=false;
		
		if(selectEquipment_IDs == null){
			result.put("success", "2");
			System.out.println("请添加需设置的设备！！");
		}else{
			for(String selectEquipment_ID :selectEquipment_IDs ){
				equipment.setEquipment_ID(Integer.parseInt(selectEquipment_ID));
				equipment.setEquipmentControlModel_ID(Global.STATUS_AUTO);
				res=iEquipmentService.updateEquipment(equipment);
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
	 * 判断是否拥有显示设备控制模式列表的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeshowModelEquipment",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeshowModelEquipment(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentControlList, Global.SHOW, Global.AUTHORITY_NORMAL);
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
	 * 判断权限，显示自动控制模式设备列表
	 * @return
	 */
	@RequestMapping(value="showAUTOModelEquipment",method=RequestMethod.GET)
	public ModelAndView showAUTOModelEquipment(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentControlList, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult !=null){
			List<EquipmentUnion> equipmentUnions=iEquipmentUnionService.findEquipmentByModel(Global.STATUS_AUTO);
			modelAndView.addObject("equipmentUnions",equipmentUnions);
			modelAndView.setViewName("superadmin/showautoequipment");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}
	
	/**
	 * 判断是否拥有移除设备控制模式列表中设备的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgedeleteEquipmentControlModel",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgedeleteEquipmentControlModel(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentControlList, Global.DELETE, Global.AUTHORITY_NORMAL);
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
	 * 从自动控制模式设备列表移除设备
	 * @param equipment_ID
	 * 
	 * @return
	 */
	@RequestMapping(value="/deleteEquipmentAutoModel/{equipment_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteEquipmentAutoModel(@PathVariable("equipment_ID") Integer equipment_ID){
		Equipment equipment=new Equipment();
		equipment.setEquipment_ID(equipment_ID);
		equipment.setEquipmentControlModel_ID(Global.STATUS_START);
		boolean res=iEquipmentService.updateEquipment(equipment);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
		return result;
	}
	
	/**
	 * 判断权限，显示手动控制模式设备列表
	 * @return
	 */
	@RequestMapping(value="showHMModelEquipment",method=RequestMethod.GET)
	public ModelAndView showHMModelEquipment(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EquipmentControlList, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
			List<EquipmentUnion> equipmentUnions=iEquipmentUnionService.findEquipmentByModel(Global.STATUS_HM);
			modelAndView.addObject("equipmentUnions",equipmentUnions);
			modelAndView.setViewName("superadmin/showhmequipment");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}
	
	/**
	 * 从手动控制模式设备列表移除设备
	 * @param equipment_ID
	 * 
	 * @return
	 */
	@RequestMapping(value="/deleteEquipmentHmModel/{equipment_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteEquipmentHmModel(@PathVariable("equipment_ID") Integer equipment_ID){
		Equipment equipment=new Equipment();
		equipment.setEquipment_ID(equipment_ID);
		equipment.setEquipmentControlModel_ID(Global.STATUS_START);
		boolean res=iEquipmentService.updateEquipment(equipment);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("success", 2);
		}
		return result;
	}
	/*-------------进行设备控制的方法Controller--------------------*/
}
