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
import com.energyman.bean.Area;
import com.energyman.bean.Building;
import com.energyman.bean.BuildingType;
import com.energyman.bean.BuildingUnion;
import com.energyman.bean.EnergyType;
import com.energyman.bean.Park;
import com.energyman.bean.Room;
import com.energyman.bean.RoomUnion;
import com.energyman.service.IAdminAuthorityJudgeService;
import com.energyman.service.IAreaService;
import com.energyman.service.IBuildingService;
import com.energyman.service.IBuildingTypeService;
import com.energyman.service.IBuildingUnionService;
import com.energyman.service.IEnergyTypeService;
import com.energyman.service.IParkService;
import com.energyman.service.IRoomService;
import com.energyman.service.IRoomUnionService;
import com.energyman.utils.Global;


@Controller
@RequestMapping("/superadmin")
public class InformationManageController {

	@Resource
	private IAreaService iAreaService;
	@Resource
	private IParkService iParkService;
	@Resource
	private IEnergyTypeService iEnergyTypeService;
	@Resource
	private IBuildingService iBuildingService;
	@Resource
	private IBuildingTypeService iBuildingTypeService;
	@Resource
	private IBuildingUnionService iBuildingUnionService;
	@Resource
	private IRoomService iRoomService;
	@Resource
	private IRoomUnionService iRoomUnionService;
	@Resource
	private IAdminAuthorityJudgeService iAdminAuthorityJudgeService;
	
	/**判断权限，显示全部区域
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/allArea",method=RequestMethod.GET)
	public ModelAndView showAllArea(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.AreaInformation, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
			List<Area> areas=iAreaService.findAllArea();		
			List<Park> parks=iParkService.getAllPark();
			modelAndView.addObject("parks", parks);
			modelAndView.addObject("areas", areas);
			modelAndView.setViewName("superadmin/showarea");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
		return modelAndView;
	} 
	
	/**
	 * 判断是否拥有删除区域的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgedeleteArea",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgedeleteArea(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.AreaInformation, Global.DELETE, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**删除区域
	 * @param region_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/deleteArea/{region_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> submitDeleteArea(@PathVariable("region_ID") Integer region_ID){
		boolean res=iAreaService.deleteArea(region_ID);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有增加区域的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeonClickAddArea",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeonClickAddArea(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.AreaInformation, Global.ADD, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**显示增加区域表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/onClickAddArea",method=RequestMethod.GET)
	public ModelAndView onClickAddArea(){
		ModelAndView modelAndView=new ModelAndView();
		List<Park> parks=iParkService.getAllPark();
		modelAndView.addObject("parks", parks);
		modelAndView.setViewName("superadmin/addarea");
		return modelAndView;
	}
	
	/**提交增加区域信息
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitAddArea",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddArea(HttpServletRequest request){
		Area area=new Area();
		area.setPark_ID(Integer.parseInt(request.getParameter("park_ID")));
		area.setRegion_Name(request.getParameter("region_Name"));
		area.setRegion_Addr(request.getParameter("region_Addr"));
		area.setRegion_Contact(request.getParameter("region_Contact"));
		area.setRegion_Tel(request.getParameter("region_Tel"));
		area.setRegion_Email(request.getParameter("region_Email"));
		boolean res=iAreaService.addArea(area);		
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else {
			result.put("failure", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有编辑区域的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeeditArea",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeeditArea(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.AreaInformation, Global.EDIT, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**显示编辑区域信息界面
	 * @param region_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/editArea/{region_ID}",method=RequestMethod.GET)
	public ModelAndView editArea(@PathVariable("region_ID") Integer region_ID){
		Area area=iAreaService.getAreaById(region_ID);
		ModelAndView modelAndView=new ModelAndView();
		List<Park> parks=iParkService.getAllPark();
		modelAndView.addObject("parks", parks);
		modelAndView.addObject("area", area);
		modelAndView.setViewName("superadmin/editarea");
		return modelAndView;		
	}
	
	/**提交编辑信息
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitEditArea",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditArea(HttpServletRequest request){
		int region_ID=Integer.parseInt(request.getParameter("region_ID"));
		Area area=iAreaService.getAreaById(region_ID);
		area.setPark_ID(Integer.parseInt(request.getParameter("park_ID")));
		area.setRegion_Name(request.getParameter("region_Name"));
		area.setRegion_Addr(request.getParameter("region_Addr"));
		area.setRegion_Contact(request.getParameter("region_Contact"));
		area.setRegion_Tel(request.getParameter("region_Tel"));
		area.setRegion_Email(request.getParameter("region_Email"));
		boolean res=iAreaService.updateArea(area);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
			return result;
	}
	
	/**判断权限，显示所有能源信息
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/allEnergy",method=RequestMethod.GET)
	public ModelAndView showAllEnergy(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EnergyInformation, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
			List<EnergyType> energyTypes=iEnergyTypeService.findAllEnergyType();		
			modelAndView.addObject("energyTypes", energyTypes);
			modelAndView.setViewName("superadmin/showenergy");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
		return modelAndView;
	}
	
	/**
	 * 判断是否拥有删除能源信息的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgedeleteEnergyType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgedeleteEnergyType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EnergyInformation, Global.DELETE, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**删除能源信息
	 * @param energyType_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/deleteEnergyType/{energyType_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> submitDeleteEnergyType(@PathVariable("energyType_ID") Integer energyType_ID){
		boolean res=iEnergyTypeService.deleteEnergyType(energyType_ID);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有增加能源信息的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeonClickAddEnergy",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeonClickAddEnergy(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EnergyInformation, Global.ADD, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**显示增加能源表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/onClickAddEnergy",method=RequestMethod.GET)
	public ModelAndView onClickAddEnergy(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("superadmin/addenergy");
		return modelAndView;
	}
	
	/**提交增加能源信息
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitAddEnergyType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddEnergyType(HttpServletRequest request){
		EnergyType energyType=new EnergyType();
		energyType.setEnergyType_Name(request.getParameter("energyType_Name"));
		energyType.setEnergyType_Desc(request.getParameter("energyType_Desc"));
		boolean res=iEnergyTypeService.addEnergyType(energyType);	
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else {
			result.put("failure", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有编辑能源信息的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeeditEnergyType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeeditEnergyType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EnergyInformation, Global.EDIT, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**显示编辑能源信息界面
	 * @param energyType_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/editEnergyType/{energyType_ID}",method=RequestMethod.GET)
	public ModelAndView editEnergyType(@PathVariable("energyType_ID") Integer energyType_ID){
		EnergyType energyType=iEnergyTypeService.getEnergyTypeById(energyType_ID);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("energyType", energyType);
		modelAndView.setViewName("superadmin/editenergy");
		return modelAndView;		
	}
	
	/**提交能源编辑信息
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitEditEnergyType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditEnergyType(HttpServletRequest request){
		int energyType_ID=Integer.parseInt(request.getParameter("energyType_ID"));
		EnergyType energyType=iEnergyTypeService.getEnergyTypeById(energyType_ID);
		energyType.setEnergyType_Name(request.getParameter("energyType_Name"));
		energyType.setEnergyType_Desc(request.getParameter("energyType_Desc"));
		boolean res=iEnergyTypeService.updateEnergyType(energyType);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
			return result;
	}
	
	/**判断权限，显示所有建筑类型信息
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/allBuildingType",method=RequestMethod.GET)
	public ModelAndView allBuildingType(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.BuildingTypeInformation, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
			List<BuildingType> buildingTypes=iBuildingTypeService.findAllBuildingType();		
			modelAndView.addObject("buildingTypes", buildingTypes);
			modelAndView.setViewName("superadmin/showallbuildingtype");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
		return modelAndView;
	}
	
	/**
	 * 判断是否拥有增加建筑类型信息的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeonClickAddBuildingType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeonClickAddBuildingType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.BuildingTypeInformation, Global.ADD, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**显示增加建筑类型表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/onClickAddBuildingType",method=RequestMethod.GET)
	public ModelAndView onClickAddBuildingType(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("superadmin/addbuildingtype");
		return modelAndView;
	}
	
	/**提交增加建筑类型信息
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitAddBuildingType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddBuildingType(HttpServletRequest request){
		BuildingType buildingType=new BuildingType();
		buildingType.setBuildType_Name(request.getParameter("buildType_Name"));
		buildingType.setBuildType_Desc(request.getParameter("buildType_Desc"));;
		boolean res=iBuildingTypeService.addBuildingType(buildingType);	
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else {
			result.put("failure", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有删除建筑类型信息的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgedeleteBuildingType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgedeleteBuildingType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.BuildingTypeInformation, Global.DELETE, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**删除建筑类型信息
	 * @param buildType_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/deleteBuildingType/{buildType_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> submitDeleteBuildingType(@PathVariable("buildType_ID") Integer buildType_ID){
		boolean res=iBuildingTypeService.deleteBuildingType(buildType_ID);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有编辑建筑类型的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeeditBuildingType",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeeditBuildingType(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.BuildingTypeInformation, Global.EDIT, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**显示编辑建筑类型信息界面
	 * @param buildType_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/editBuildingType/{buildType_ID}",method=RequestMethod.GET)
	public ModelAndView editBuildingType(@PathVariable("buildType_ID") Integer buildType_ID){
		BuildingType buildingType=iBuildingTypeService.getBuildingTypeById(buildType_ID);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("buildingType", buildingType);
		modelAndView.setViewName("superadmin/editbuildingtype");
		return modelAndView;		
	}
	
	/**提交编辑建筑类型信息
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitEditBuildingType",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditBuildingType(HttpServletRequest request){
		BuildingType buildingType=new BuildingType();
		buildingType.setBuildType_ID(Integer.parseInt(request.getParameter("buildType_ID")));
		buildingType.setBuildType_Name(request.getParameter("buildType_Name"));
		buildingType.setBuildType_Desc(request.getParameter("buildType_Desc"));;
		boolean res=iBuildingTypeService.updateBuildingType(buildingType);	
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else {
			result.put("failure", 0);
		}
		return result;
	}
	
	/**判断权限，显示所有建筑信息
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/allBuilding",method=RequestMethod.GET)
	public ModelAndView allBuilding(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.BuildingInformation, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
			List<BuildingUnion> buildingUnions=iBuildingUnionService.findAllBuildingUnion();		
			modelAndView.addObject("buildingUnions",buildingUnions);
			modelAndView.setViewName("superadmin/showallbuilding");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}
	
	
	/**
	 * 判断是否拥有增加建筑的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeonClickAddBuilding",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeonClickAddBuilding(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.BuildingInformation, Global.ADD, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**显示增加建筑表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/onClickAddBuilding",method=RequestMethod.GET)
	public ModelAndView onClickAddBuilding(){
		ModelAndView modelAndView=new ModelAndView();
		List<BuildingType> buildingTypes=iBuildingTypeService.findAllBuildingType();
		List<Area> areas=iAreaService.findAllArea();
		modelAndView.addObject("buildingTypes", buildingTypes);
		modelAndView.addObject("areas",areas);
		modelAndView.setViewName("superadmin/addbuilding");
		return modelAndView;
	}
	
	/**提交增加建筑信息
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitAddBuilding",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddBuilding(HttpServletRequest request){
		Building building=new Building();
		building.setBuild_Name(request.getParameter("build_Name"));
		building.setBuildType_ID(Integer.parseInt(request.getParameter("buildType_ID")));
		building.setRegion_ID(Integer.parseInt(request.getParameter("region_ID")));
		building.setBuildDown_Floor(Integer.parseInt(request.getParameter("buildDown_Floor")));
		building.setBuildUp_Floor(Integer.parseInt(request.getParameter("buildUp_Floor")));
		building.setBuild_State(Global.BUILD_STATE);
		
		boolean res=iBuildingService.addBuilding(building);	
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else {
			result.put("failure", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有删除建筑的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgedeleteBuilding",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgedeleteBuilding(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.BuildingInformation, Global.DELETE, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	

	/**删除建筑
	 * @param build_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/deleteBuilding/{build_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> submitDeleteBuilding(@PathVariable("build_ID") Integer build_ID){
		boolean res=iBuildingService.deleteBuilding(build_ID);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有编辑建筑的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeeditBuilding",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeeditBuilding(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.BuildingInformation, Global.EDIT, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**显示编辑建筑信息界面
	 * @param energyType_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/editBuilding/{build_ID}",method=RequestMethod.GET)
	public ModelAndView editBuilding(@PathVariable("build_ID") Integer build_ID){
		Building building=iBuildingService.getBuildingById(build_ID);
		ModelAndView modelAndView=new ModelAndView();
		List<BuildingType> buildingTypes=iBuildingTypeService.findAllBuildingType();
		List<Area> areas=iAreaService.findAllArea();
		modelAndView.addObject("buildingTypes", buildingTypes);
		modelAndView.addObject("areas",areas);
		modelAndView.addObject("building", building);
		modelAndView.setViewName("superadmin/editbuilding");
		return modelAndView;		
	}
	
	/**提交编辑建筑信息
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitEditBuilding",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditBuilding(HttpServletRequest request){
		Building building=new Building();
		building.setBuild_ID(Integer.parseInt(request.getParameter("build_ID")));
		building.setBuild_Name(request.getParameter("build_Name"));
		building.setBuildType_ID(Integer.parseInt(request.getParameter("buildType_ID")));
		building.setRegion_ID(Integer.parseInt(request.getParameter("region_ID")));
		building.setBuildDown_Floor(Integer.parseInt(request.getParameter("buildDown_Floor")));
		building.setBuildUp_Floor(Integer.parseInt(request.getParameter("buildUp_Floor")));
		building.setBuild_State(Global.BUILD_STATE);
		
		boolean res=iBuildingService.updateBuilding(building);	
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else {
			result.put("success", 2);
		}
		return result;
	}
	
	
	/**显示所有房间信息
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/allRoom",method=RequestMethod.GET)
	public ModelAndView allRoom(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.RoomInformation, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
			List<RoomUnion> roomUnions=iRoomUnionService.findAllRoomUnion();
			modelAndView.addObject("roomUnions",roomUnions);
			modelAndView.setViewName("superadmin/showallroom");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}
	
	/**
	 * 判断是否拥有增加房间的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeonClickAddRoom",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeonClickAddRoom(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.RoomInformation, Global.ADD, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**显示增加房间表单
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/onClickAddRoom",method=RequestMethod.GET)
	public ModelAndView onClickAddRoom(){
		ModelAndView modelAndView=new ModelAndView();
		List<Building> buildings=iBuildingService.findAllBuilding();
		modelAndView.addObject("buildings", buildings);
		modelAndView.setViewName("superadmin/addroom");
		return modelAndView;
	}
	
	
	/**提交增加房间信息
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitAddRoom",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitAddRoom(HttpServletRequest request){
		Room room=new Room();
		room.setRoom_Code(Integer.parseInt(request.getParameter("room_Code")));
		room.setRoom_Name(request.getParameter("room_Name"));
		room.setBuild_ID(Integer.parseInt(request.getParameter("build_ID")));
		room.setRoom_Floor(Integer.parseInt(request.getParameter("room_Floor")));
		room.setRoom_Area(Double.parseDouble(request.getParameter("room_Area")));
		room.setRoomEasementOfLight(Double.parseDouble(request.getParameter("roomEasementOfLight")));
		
		boolean res=iRoomService.addRoom(room);	
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else {
			result.put("failure", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有删除房间的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgedeleteRoom",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgedeleteRoom(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.RoomInformation, Global.DELETE, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	
	/**删除房间信息
	 * @param room_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/deleteRoom/{room_ID}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> submitDeleteRoom(@PathVariable("room_ID") Integer room_ID){
		boolean res=iRoomService.deleteRoom(room_ID);
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else{
			result.put("failure", 0);
		}
		return result;
	}
	
	/**
	 * 判断是否拥有编辑房间的权限
	 * @param request
	 * @return
	 * @author 
	 */
	@RequestMapping(value = "/judgeeditRoom",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> judgeeditRoom(HttpServletRequest request){
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.RoomInformation, Global.EDIT, Global.AUTHORITY_NORMAL);
		Map<String, Object> result = new HashMap<String, Object>();	
		if(authorityJudgeResult==null){
			result.put("success", '0');	
		}
		else{
			result.put("success", '1');
		}
		return result;
	}
	
	/**显示编辑房间信息界面
	 * @param room_ID
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/editRoom/{room_ID}",method=RequestMethod.GET)
	public ModelAndView editRoom(@PathVariable("room_ID") Integer room_ID){
		Room room=iRoomService.getRoomById(room_ID);
		ModelAndView modelAndView=new ModelAndView();
		List<Building> buildings=iBuildingService.findAllBuilding();
		modelAndView.addObject("buildings", buildings);
		modelAndView.addObject("room", room);
		modelAndView.setViewName("superadmin/editroom");
		return modelAndView;		
	}
	
	/**提交编辑房间信息
	 * @param request
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/submitEditRoom",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitEditRoom(HttpServletRequest request){
		Room room=new Room();
		room.setRoom_ID(Integer.parseInt(request.getParameter("room_ID")));
		room.setRoom_Code(Integer.parseInt(request.getParameter("room_Code")));
		room.setRoom_Name(request.getParameter("room_Name"));
		room.setBuild_ID(Integer.parseInt(request.getParameter("build_ID")));
		room.setRoom_Floor(Integer.parseInt(request.getParameter("room_Floor")));
		room.setRoom_Area(Double.parseDouble(request.getParameter("room_Area")));
		room.setRoomEasementOfLight(Double.parseDouble(request.getParameter("roomEasementOfLight")));
		
		boolean res=iRoomService.updateRoom(room);	
		Map<String, Object> result=new HashMap<String,Object>();
		if(res){
			result.put("success", 1);
		}else {
			result.put("failure", 0);
		}
		return result;
	}
}
