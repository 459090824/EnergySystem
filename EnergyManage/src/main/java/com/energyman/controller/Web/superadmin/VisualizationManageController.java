package com.energyman.controller.Web.superadmin;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import com.energyman.bean.DataCollectorData;
import com.energyman.bean.DataCollectorDataContent;
import com.energyman.bean.EquipmentSubType;
import com.energyman.bean.EquipmentType;
import com.energyman.bean.EquipmentUnion;
import com.energyman.bean.Park;
import com.energyman.bean.Room;
import com.energyman.service.IAddrService;
import com.energyman.service.IAdminAuthorityJudgeService;
import com.energyman.service.IAreaService;
import com.energyman.service.IBuildingService;
import com.energyman.service.IDataCollectorDataService;
import com.energyman.service.IEnergyTypeService;
import com.energyman.service.IEquipmentCountUnionService;
import com.energyman.service.IEquipmentService;
import com.energyman.service.IEquipmentSubTypeService;
import com.energyman.service.IEquipmentTypeService;
import com.energyman.service.IEquipmentUnionService;
import com.energyman.service.IParkService;
import com.energyman.service.IRoomService;
import com.energyman.service.IRoomUnionService;
import com.energyman.service.ISystemInfoService;
import com.energyman.utils.EchartData;
import com.energyman.utils.EchartDataEnergyConsumption;
import com.energyman.utils.EquipmentEnergyConsumption;
import com.energyman.utils.Global;
import com.energyman.utils.PieEchartsData;
import com.energyman.utils.PieEchartsDataEnergyConsumption;

@Controller
@RequestMapping("/superadmin")
public class VisualizationManageController {
	
	@Resource
	private IEquipmentUnionService iEquipmentUnionService;
	@Resource
	private IEquipmentTypeService iEquipmentTypeService;
	@Resource
	private IEquipmentSubTypeService iEquipmentSubTypeService;
	@Resource
	private IEquipmentService iEquipmentService;
	@Resource
	private IRoomService iRoomService;
	@Resource
	private IRoomUnionService iRoomUnionService;
	@Resource
	private IAreaService iAreaService;
	@Resource
	private IBuildingService iBuildingService;
	@Resource
	private IAddrService iAddrService;
	@Resource
	private IEquipmentCountUnionService iEquipmentCountUnionService;
	@Resource
	private ISystemInfoService iSystemInfoService;
	@Resource
	private IParkService iParkService;
	@Resource
	private IDataCollectorDataService iDataCollectorDataService;
	@Resource
	private IEnergyTypeService iEnergyTypeService;
	@Resource
	private IAdminAuthorityJudgeService iAdminAuthorityJudgeService;
	
	EquipmentEnergyConsumption equipmentEnergyConsumption;     //设备能耗统计中的变量
	
	
	/** 判断权限，显示实时监测功能，获取6个框数据
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/energyconsumptionmonitor",method=RequestMethod.GET)
	public ModelAndView energyconsumptionmonitor(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();		
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();		
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EnergyConsumptionMonitor, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
		
			int equipmentTotal=iEquipmentService.countEquipmentTotal();
			int equipmentConnectNum=iEquipmentService.countByState(Global.STATUS_CONNECT);
			int equipmentNoWorkNum=iEquipmentService.countByState(Global.STATUS_NONWORK);
			int equipmentErroNum=iEquipmentService.countByState(Global.STATUS_ERROR);
			int systemInfo=iSystemInfoService.countAllSystemInfo();
				
			modelAndView.addObject("equipmentErroNum",equipmentErroNum);
			modelAndView.addObject("equipmentNoWorkNum",equipmentNoWorkNum);
			modelAndView.addObject("equipmentConnectNum",equipmentConnectNum);
			modelAndView.addObject("equipmentTotal",equipmentTotal);
			modelAndView.addObject("systemInfo",systemInfo);
				
			List<EquipmentUnion> equipmentUnions=iEquipmentUnionService.findAllEquipmentUnion(Global.STATUS_DELETE);
			modelAndView.addObject("equipmentUnions", equipmentUnions);		
			modelAndView.setViewName("superadmin/energyconsumptionmonitor");
		}else{
			modelAndView.setViewName("superadmin/noauthority");
		}
			return modelAndView;
	}
	
	/** 判断权限，显示能耗统计功能，获取6个框中数据
	 * @return
	 * @author 
	 */
	@RequestMapping(value="/energyconsumptiontotal",method=RequestMethod.GET)
	public ModelAndView energyconsumptiontotal(HttpServletRequest request) throws Exception{
		ModelAndView modelAndView=new ModelAndView();				
		Admin admin = (Admin)request.getSession().getAttribute("user");
		int systemadminid=admin.getSystemadminid();		
		AdminAuthorityJudge authorityJudgeResult=iAdminAuthorityJudgeService.findAdminFunctionAuthorityByAdmin(systemadminid, Global.EnergyConsumptionTotal, Global.SHOW, Global.AUTHORITY_NORMAL);
		if(authorityJudgeResult != null){
		
			List<Park> parks=iParkService.getAllPark();
			List<Area> areas=iAreaService.findAllArea();
			List<Building> buildings=iBuildingService.findAllBuilding();
			List<Room> rooms=iRoomService.findAllRoom();
		
			//6个统计框state
			int energyTypeCount=iEnergyTypeService.findCountEnergyType();  //能源类型统计
				
			List<DataCollectorDataContent> dataCollectorDataContents_today=new ArrayList<DataCollectorDataContent>();
			List<DataCollectorData> dataCollectorDatas_today=iDataCollectorDataService.findDataCollectorDataByDate(Global.StringTo(Global.getNowDate()));
			for(DataCollectorData data_today:dataCollectorDatas_today){
				dataCollectorDataContents_today.add(Global.JsonToBean(data_today.getContent()));
			}
			//当前能耗统计
			double equipmentEnergyConsumptionForDay=0;								
			for (DataCollectorDataContent dataCollectorDataContent_tody:dataCollectorDataContents_today) {
				equipmentEnergyConsumptionForDay=equipmentEnergyConsumptionForDay+(dataCollectorDataContent_tody.getCurrent_data_meter());									
			}
		
		
			//当月能耗统计
			double equipmentEnergyConsumptionForMonth=0;
			List<DataCollectorDataContent> dataCollectorDataContents_promonth=new ArrayList<DataCollectorDataContent>();
			List<DataCollectorData> dataCollectorDatas_promonth=iDataCollectorDataService.findDataCollectorDataByDate(Global.StringTo(Global.getProMonth()));
			for(DataCollectorData data_promonth:dataCollectorDatas_promonth){
				dataCollectorDataContents_promonth.add(Global.JsonToBean(data_promonth.getContent()));
			}
						
			for (DataCollectorDataContent dataCollectorDataContent_tody:dataCollectorDataContents_today) {
				for(DataCollectorDataContent dataCollectorDataContent_promonth:dataCollectorDataContents_promonth){				
					if((dataCollectorDataContent_tody.getEquipment_Code()).equals(dataCollectorDataContent_promonth.getEquipment_Code())){					
						equipmentEnergyConsumptionForMonth=equipmentEnergyConsumptionForMonth+((dataCollectorDataContent_tody.getCurrent_data_meter())-(dataCollectorDataContent_promonth.getCurrent_data_meter()));	
					}				
				}
			
			}	
		
			modelAndView.addObject("equipmentEnergyConsumptionForMonth",equipmentEnergyConsumptionForMonth);
			modelAndView.addObject("equipmentEnergyConsumptionForDay",equipmentEnergyConsumptionForDay);
			modelAndView.addObject("energyTypeCount",energyTypeCount);
			modelAndView.addObject("parks", parks);
			modelAndView.addObject("areas", areas);
			modelAndView.addObject("buildings", buildings);
			modelAndView.addObject("rooms", rooms);
			modelAndView.setViewName("superadmin/energyconsumptiontotal");
			}else{
				modelAndView.setViewName("superadmin/noauthority");
			}
			return modelAndView;
	} 
	
	/**能耗统计功能设备能耗列表 
	 * @author 
	 * @return 
	 */
	@RequestMapping(value="/findEquipmentEnergyConsumptionList/{rangeId}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findEquipmentEnergyConsumptionList (@PathVariable("rangeId") String rangeId) throws Exception{
		
		List<EquipmentEnergyConsumption> equipmentEnergyConsumptions = new ArrayList<EquipmentEnergyConsumption>();     //设备能耗统计list
		
		if(rangeId.equals("date")){
			//根据日消耗，设备能耗列表(求今天的设备仪表值与昨天设备仪表值的差值)
						
			List<DataCollectorDataContent> dataCollectorDataContents_yestoday=new ArrayList<DataCollectorDataContent>();
			List<DataCollectorDataContent> dataCollectorDataContents_today=new ArrayList<DataCollectorDataContent>();
			List<DataCollectorData> dataCollectorDatas_yestoday=iDataCollectorDataService.findDataCollectorDataByDate(Global.StringTo(Global.getProDay()));
			List<DataCollectorData> dataCollectorDatas_today=iDataCollectorDataService.findDataCollectorDataByDate(Global.StringTo(Global.getNowDate()));
			for(DataCollectorData data_yestody:dataCollectorDatas_yestoday){
				dataCollectorDataContents_yestoday.add(Global.JsonToBean(data_yestody.getContent()));
			}
			for(DataCollectorData data_today:dataCollectorDatas_today){
				dataCollectorDataContents_today.add(Global.JsonToBean(data_today.getContent()));
			}
						
			for (DataCollectorDataContent dataCollectorDataContent_tody:dataCollectorDataContents_today) {
				for(DataCollectorDataContent dataCollectorDataContent_yestody:dataCollectorDataContents_yestoday){
					
					if((dataCollectorDataContent_tody.getEquipment_Code()).equals(dataCollectorDataContent_yestody.getEquipment_Code())){
						equipmentEnergyConsumption = new EquipmentEnergyConsumption();
						equipmentEnergyConsumption.setEquipment_Name((iEquipmentService.getEquipmentByEquipmentCode(dataCollectorDataContent_tody.getEquipment_Code())).getEquipment_Name());
						equipmentEnergyConsumption.setEnerg_Consumption((dataCollectorDataContent_tody.getCurrent_data_meter())-(dataCollectorDataContent_yestody.getCurrent_data_meter()));
						equipmentEnergyConsumption.setEquipment_Auto((iEquipmentService.getEquipmentByEquipmentCode(dataCollectorDataContent_tody.getEquipment_Code())).getIsAuto_Equipment());					
//						System.out.println(equipmentEnergyConsumption.getEquipment_Name());
						equipmentEnergyConsumptions.add(equipmentEnergyConsumption);
					}
					
				}
				
			}	
				
				Map<String, Object> result = new HashMap<String, Object>();	
				result.put("aaData", equipmentEnergyConsumptions);
				return result;
		}
		
		
		
		if(rangeId.equals("month")){
			//根据月消耗，设备能耗列表(求今天的设备仪表值与上个月同一天设备的仪表值的差值)
			
			List<DataCollectorDataContent> dataCollectorDataContents_promonth=new ArrayList<DataCollectorDataContent>();
			List<DataCollectorDataContent> dataCollectorDataContents_today=new ArrayList<DataCollectorDataContent>();
			List<DataCollectorData> dataCollectorDatas_promonth=iDataCollectorDataService.findDataCollectorDataByDate(Global.StringTo(Global.getProMonth()));
			List<DataCollectorData> dataCollectorDatas_today=iDataCollectorDataService.findDataCollectorDataByDate(Global.StringTo(Global.getNowDate()));
			for(DataCollectorData data_promonth:dataCollectorDatas_promonth){
				dataCollectorDataContents_promonth.add(Global.JsonToBean(data_promonth.getContent()));
			}
			for(DataCollectorData data_today:dataCollectorDatas_today){
				dataCollectorDataContents_today.add(Global.JsonToBean(data_today.getContent()));
			}
						
			for (DataCollectorDataContent dataCollectorDataContent_tody:dataCollectorDataContents_today) {
				for(DataCollectorDataContent dataCollectorDataContent_promonth:dataCollectorDataContents_promonth){
					
					if((dataCollectorDataContent_tody.getEquipment_Code()).equals(dataCollectorDataContent_promonth.getEquipment_Code())){
						equipmentEnergyConsumption = new EquipmentEnergyConsumption();
						equipmentEnergyConsumption.setEquipment_Name((iEquipmentService.getEquipmentByEquipmentCode(dataCollectorDataContent_tody.getEquipment_Code())).getEquipment_Name());
						equipmentEnergyConsumption.setEnerg_Consumption((dataCollectorDataContent_tody.getCurrent_data_meter())-(dataCollectorDataContent_promonth.getCurrent_data_meter()));
						equipmentEnergyConsumption.setEquipment_Auto((iEquipmentService.getEquipmentByEquipmentCode(dataCollectorDataContent_tody.getEquipment_Code())).getIsAuto_Equipment());					
//						System.out.println(equipmentEnergyConsumption.getEquipment_Name());
						equipmentEnergyConsumptions.add(equipmentEnergyConsumption);
					}
					
				}
				
			}	
			Map<String, Object> result = new HashMap<String, Object>();	
			result.put("aaData", equipmentEnergyConsumptions);
			return result;
		}
		
		else{
			//根据年消耗，设备能耗列表(求设备今天的设备仪表值与前一年同一天的设备仪表值的差值)
			
			List<DataCollectorDataContent> dataCollectorDataContents_proyear=new ArrayList<DataCollectorDataContent>();
			List<DataCollectorDataContent> dataCollectorDataContents_today=new ArrayList<DataCollectorDataContent>();
			List<DataCollectorData> dataCollectorDatas_proyear=iDataCollectorDataService.findDataCollectorDataByDate(Global.StringTo(Global.getProYear()));
			List<DataCollectorData> dataCollectorDatas_today=iDataCollectorDataService.findDataCollectorDataByDate(Global.StringTo(Global.getNowDate()));
			for(DataCollectorData data_proyear:dataCollectorDatas_proyear){
				dataCollectorDataContents_proyear.add(Global.JsonToBean(data_proyear.getContent()));
			}
			for(DataCollectorData data_today:dataCollectorDatas_today){
				dataCollectorDataContents_today.add(Global.JsonToBean(data_today.getContent()));
			}
						
			for (DataCollectorDataContent dataCollectorDataContent_tody:dataCollectorDataContents_today) {
				for(DataCollectorDataContent dataCollectorDataContent_proyear:dataCollectorDataContents_proyear){
					
					if((dataCollectorDataContent_tody.getEquipment_Code()).equals(dataCollectorDataContent_proyear.getEquipment_Code())){
						equipmentEnergyConsumption = new EquipmentEnergyConsumption();
						equipmentEnergyConsumption.setEquipment_Name((iEquipmentService.getEquipmentByEquipmentCode(dataCollectorDataContent_tody.getEquipment_Code())).getEquipment_Name());
						equipmentEnergyConsumption.setEnerg_Consumption((dataCollectorDataContent_tody.getCurrent_data_meter())-(dataCollectorDataContent_proyear.getCurrent_data_meter()));
						equipmentEnergyConsumption.setEquipment_Auto((iEquipmentService.getEquipmentByEquipmentCode(dataCollectorDataContent_tody.getEquipment_Code())).getIsAuto_Equipment());					
//						System.out.println(equipmentEnergyConsumption.getEquipment_Name());
						equipmentEnergyConsumptions.add(equipmentEnergyConsumption);
					}
					
				}
				
			}	
			Map<String, Object> result = new HashMap<String, Object>();	
			result.put("aaData", equipmentEnergyConsumptions);
			return result;
		}
	}
	
	/** 实时监测功能柱状图数据加载
	 * @author 
	 * @return 
	 */
	@RequestMapping(value="/findData/{rangeId}", method=RequestMethod.GET)
	@ResponseBody
	public List<EchartData> findData(@PathVariable("rangeId") String rangeId){
		
		List<EchartData> echartDataList = new ArrayList<EchartData>();
        EchartData echart = new EchartData();
        List<Integer> equipmentNum=new ArrayList<Integer>();
		
		if(rangeId.equals("area")){
			//按区域统计区域中的设备
			List<String> areaName=new ArrayList<String>();
			List<Area> areas=iAreaService.findAllArea();
						
			for(int i=0;i<areas.size();i++){
				areaName.add(areas.get(i).getRegion_Name());
				equipmentNum.add(iEquipmentCountUnionService.findcountEquipmentByArea(areas.get(i).getRegion_ID()));
			}
			
			echart.setData(equipmentNum);
			echart.setXdata(areaName);
	        echartDataList.add(echart);
	        return echartDataList;
		}
		if(rangeId.equals("building")){
			//按建筑统计建筑中的设备
			List<String> buildingName=new ArrayList<String>();
	        List<Building> buildings=iBuildingService.findAllBuilding();
	        	        
			for(int i=0;i<buildings.size();i++){
				buildingName.add(buildings.get(i).getBuild_Name());
				equipmentNum.add(iEquipmentCountUnionService.findcountEquipmentByBuilding(buildings.get(i).getBuild_ID()));				
			}
							
			echart.setData(equipmentNum);
			echart.setXdata(buildingName);
	        echartDataList.add(echart);
	        return echartDataList;
		}
		else{
			//按房间统计房间中的设备
			List<String> roomName=new ArrayList<String>();
	        List<Room> rooms=iRoomService.findAllRoom();
	        
	        for(int i=0;i<rooms.size();i++){
	        	roomName.add(rooms.get(i).getRoom_Name());
	        	equipmentNum.add(iEquipmentCountUnionService.findcountEquipmentByRoom(rooms.get(i).getRoom_ID()));
	        }	        
	        echart.setXdata(roomName);
	        echart.setData(equipmentNum);
	        echartDataList.add(echart);
	        return echartDataList;
		}
	}
	
	/** 能耗统计功能柱状图数据加载
	 * @author 
	 * @return 
	 */
	@RequestMapping(value="/findDataTotalData/{rangeId}", method=RequestMethod.GET)
	@ResponseBody
	public List<EchartDataEnergyConsumption> findDataTotalData(@PathVariable("rangeId") String rangeId) throws Exception{
		
		List<EchartDataEnergyConsumption> echartDataList = new ArrayList<EchartDataEnergyConsumption>();
		EchartDataEnergyConsumption echart = new EchartDataEnergyConsumption();
        List<Double> energyConsumption=new ArrayList<Double>();
        
        
       
       
      //获得现在系统中的最新采集数据,并转化成对象
      	List<DataCollectorData> dataCollectorDatas_today=iDataCollectorDataService.findDataCollectorDataByDate(Global.StringTo(Global.getNowDate()));
      	List<DataCollectorDataContent> dataCollectorDataContents_today=new ArrayList<DataCollectorDataContent>();
      	for(DataCollectorData data_today:dataCollectorDatas_today){
      		dataCollectorDataContents_today.add(Global.JsonToBean(data_today.getContent()));
      	}
		
		if(rangeId.equals("area")){
			//按区域统计区域中的设备耗能值
			List<String> areaName=new ArrayList<String>();
			List<Area> areas=iAreaService.findAllArea();
			
//			for(DataCollectorDataContent dataCollectorDataContent:dataCollectorDataContents_today){
//				areas.add(iEquipmentCountUnionService.findEquipmentByCode(dataCollectorDataContent.getEquipment_Code()).getArea().getRegion_Name());
//			}
//			areas=new ArrayList(new HashSet(areas));   //除去重复的区域名
						
			for(int i=0;i<areas.size();i++){
				double totalForArea=0;
				areaName.add(areas.get(i).getRegion_Name());
				for(DataCollectorDataContent dataCollectorDataContent:dataCollectorDataContents_today){
					if(((iEquipmentCountUnionService.findEquipmentByCode(dataCollectorDataContent.getEquipment_Code())).getArea().getRegion_Name()).equals(areas.get(i).getRegion_Name())){
						totalForArea=totalForArea+dataCollectorDataContent.getCurrent_data_meter();
					}
				}
				energyConsumption.add(totalForArea);
			}
			
			echart.setData(energyConsumption);
			echart.setXdata(areaName);
	        echartDataList.add(echart);
	        return echartDataList;
		}
		
		if(rangeId.equals("building")){
			//按建筑统计建筑中的设备耗能值
			List<String> buildingName=new ArrayList<String>();
	        List<Building> buildings=iBuildingService.findAllBuilding();
	        	        
			for(int i=0;i<buildings.size();i++){
				double totalForBuilding=0;
				buildingName.add(buildings.get(i).getBuild_Name());
				for(DataCollectorDataContent dataCollectorDataContent:dataCollectorDataContents_today){
					if(((iEquipmentCountUnionService.findEquipmentByCode(dataCollectorDataContent.getEquipment_Code())).getBuilding().getBuild_Name()).equals(buildings.get(i).getBuild_Name())){
						totalForBuilding=totalForBuilding+dataCollectorDataContent.getCurrent_data_meter();
					}
				}
				energyConsumption.add(totalForBuilding);
			}
							
			echart.setData(energyConsumption);
			echart.setXdata(buildingName);
	        echartDataList.add(echart);
	        return echartDataList;
		}
		else{
			//按房间统计房间中的设备耗能
			List<String> roomName=new ArrayList<String>();
	        List<Room> rooms=iRoomService.findAllRoom();
	        
	        for(int i=0;i<rooms.size();i++){
	        	double totalForRoom=0;
	        	roomName.add(rooms.get(i).getRoom_Name());
				for(DataCollectorDataContent dataCollectorDataContent:dataCollectorDataContents_today){
					if(((iEquipmentCountUnionService.findEquipmentByCode(dataCollectorDataContent.getEquipment_Code())).getRoom().getRoom_Name()).equals(rooms.get(i).getRoom_Name())){
						totalForRoom=totalForRoom+dataCollectorDataContent.getCurrent_data_meter();
					}
				}
				energyConsumption.add(totalForRoom);
			}
	        
	        echart.setXdata(roomName);
	        echart.setData(energyConsumption);
	        echartDataList.add(echart);
	        return echartDataList;
		}
	}
 	
	/**实时监测功能中饼状图中数据加载
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/findPieData",method=RequestMethod.GET)
	@ResponseBody
	public List<PieEchartsData> findPieData(){
		List<PieEchartsData> pieEchartDataList = new ArrayList<PieEchartsData>();
		PieEchartsData pieEchart = new PieEchartsData();
		List<String> equipmentType=new ArrayList<String>();
		List<Integer> equipmentNum=new ArrayList<Integer>();
		
		List<EquipmentType> equipmentTypes=iEquipmentTypeService.findAllEquipmentType(Global.Type_NORMAL);
		List<EquipmentSubType> equipmentSubTypes=iEquipmentSubTypeService.findAllEquipmentSubType(Global.Type_NORMAL);
				
		for(int i=0;i<equipmentTypes.size();i++){			
			equipmentType.add(equipmentTypes.get(i).getEquipmentType_Name());//设备类型					
			equipmentNum.add(iEquipmentService.selectCountByType(equipmentTypes.get(i).getEquipmentType_ID()));//设备类型对应的数据
		}
		
		for(int j=0;j<equipmentSubTypes.size();j++){
			equipmentType.add(equipmentSubTypes.get(j).getEquipmentSubType_Name());
			equipmentNum.add(iEquipmentService.selectCountBySubType(equipmentSubTypes.get(j).getEquipmentSubType_ID()));
		}
		
			pieEchart.setCategory(equipmentType);
			pieEchart.setData(equipmentNum);
		
			pieEchartDataList.add(pieEchart);
		
			return pieEchartDataList;
	
	}
	
	/**能耗统计功能中饼状图中数据加载
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="/findPieTotalData",method=RequestMethod.GET)
	@ResponseBody
	public List<PieEchartsDataEnergyConsumption> findPieTotalData() throws Exception{
		
		
		PieEchartsDataEnergyConsumption pieEchart = new PieEchartsDataEnergyConsumption();
		List<PieEchartsDataEnergyConsumption> pieEchartDataList = new ArrayList<PieEchartsDataEnergyConsumption>();
		List<String> equipmentType=new ArrayList<String>();
		List<Double> energyConsumption=new ArrayList<Double>();
		List<String> equipmentTypes=new ArrayList<String>();
		List<String> equipmentSubTypes=new ArrayList<String>();
		
		
		
		
		//获得现在系统中的最新采集数据
		List<DataCollectorData> dataCollectorDatas_today=iDataCollectorDataService.findDataCollectorDataByDate(Global.StringTo(Global.getNowDate()));
		List<DataCollectorDataContent> dataCollectorDataContents_today=new ArrayList<DataCollectorDataContent>();
		for(DataCollectorData data_today:dataCollectorDatas_today){
			dataCollectorDataContents_today.add(Global.JsonToBean(data_today.getContent()));
		}
		
		for(DataCollectorDataContent dataCollectorDataContent:dataCollectorDataContents_today){
			equipmentTypes.add((iEquipmentUnionService.findEquipmentByCode(dataCollectorDataContent.getEquipment_Code())).getEquipmentType().getEquipmentType_Name());
			equipmentSubTypes.add((iEquipmentUnionService.findEquipmentByCode(dataCollectorDataContent.getEquipment_Code())).getEquipmentSubType().getEquipmentSubType_Name());
		}
		equipmentTypes=new ArrayList(new HashSet(equipmentTypes));        //将list中重复的类型去掉
		equipmentSubTypes=new ArrayList(new HashSet(equipmentSubTypes));	
		
//		System.out.println(equipmentTypes);
//		System.out.println(equipmentSubTypes);
		
		
		for(int i=0;i<equipmentTypes.size();i++){
			double energyForType=0;
			equipmentType.add(equipmentTypes.get(i));//设备类型
//			System.out.println(equipmentTypes.get(i));
			for(DataCollectorDataContent dataCollectorDataContent:dataCollectorDataContents_today){
				if((iEquipmentUnionService.findEquipmentByCode(dataCollectorDataContent.getEquipment_Code()).getEquipmentType().getEquipmentType_Name()).equals(equipmentTypes.get(i))){
					energyForType=energyForType+dataCollectorDataContent.getCurrent_data_meter();//设备类型对应的数据		
				}
			}			
			energyConsumption.add(energyForType);
		}
		
		for(int j=0;j<equipmentSubTypes.size();j++){
			double energyForSubType=0;
			equipmentType.add(equipmentSubTypes.get(j));    //设备子类型
			for(DataCollectorDataContent dataCollectorDataContent:dataCollectorDataContents_today){
				if((iEquipmentUnionService.findEquipmentByCode(dataCollectorDataContent.getEquipment_Code()).getEquipmentSubType().getEquipmentSubType_Name()).equals(equipmentSubTypes.get(j))){
					energyForSubType=energyForSubType+dataCollectorDataContent.getCurrent_data_meter();//设备子类型对应的数据
				}				
			}
			energyConsumption.add(energyForSubType);			
		}
		
			pieEchart.setCategory(equipmentType);
			pieEchart.setData(energyConsumption);
		
			pieEchartDataList.add(pieEchart);
		
			return pieEchartDataList;
	
	}
	
	
	
	/**能耗统计功能中能耗查询功能
	 * @return
	 * @author 
	 */
	@RequestMapping(value="/queryEnergyConsumption",method=RequestMethod.GET)
	@ResponseBody
	public double queryEnergyConsumption(HttpServletRequest request) throws ParseException{
		
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
//		Integer region_ID=Integer.parseInt(request.getParameter("region_ID"));
//		Integer build_ID=Integer.parseInt(request.getParameter("build_ID"));
		Integer room_ID=Integer.parseInt(request.getParameter("room_ID"));
		
		//获取时间段开始时间的数据，并转换成对象
		List<DataCollectorDataContent> dataCollectorDataContents_startTime=new ArrayList<DataCollectorDataContent>();
		List<DataCollectorData> dataCollectorDatas_startTime=iDataCollectorDataService.findDataCollectorDataByDate(Global.StringTo(startTime));			
		for(DataCollectorData dataCollectorData :dataCollectorDatas_startTime){
			DataCollectorDataContent code = Global.JsonToBean(dataCollectorData.getContent());
			dataCollectorDataContents_startTime.add(code);					
		}
		
		//获取时间段截至时间的数据，并转换成对象
		List<DataCollectorDataContent> dataCollectorDataContents_endTime=new ArrayList<DataCollectorDataContent>();
		List<DataCollectorData> dataCollectorDatas_endTime=iDataCollectorDataService.findDataCollectorDataByDate(Global.StringTo(endTime));			
		for(DataCollectorData dataCollectorData :dataCollectorDatas_endTime){
			DataCollectorDataContent code = Global.JsonToBean(dataCollectorData.getContent());
			dataCollectorDataContents_endTime.add(code);					
		}
		
		//获取房间对应的数据
		List<DataCollectorDataContent> dataCollectorDataContents_startTime_room=new ArrayList<DataCollectorDataContent>();
		for(DataCollectorDataContent dataCollectorDataContent_startTime:dataCollectorDataContents_startTime){
			if(((iEquipmentCountUnionService.findEquipmentByCode(dataCollectorDataContent_startTime.getEquipment_Code())).getRoom().getRoom_ID()).equals(room_ID)){
				dataCollectorDataContents_startTime_room.add(dataCollectorDataContent_startTime);
			}
		}
		
		List<DataCollectorDataContent> dataCollectorDataContents_endTime_room=new ArrayList<DataCollectorDataContent>();
		for(DataCollectorDataContent dataCollectorDataContent_endTime:dataCollectorDataContents_endTime){
			if(((iEquipmentCountUnionService.findEquipmentByCode(dataCollectorDataContent_endTime.getEquipment_Code())).getRoom().getRoom_ID()).equals(room_ID)){
				dataCollectorDataContents_endTime_room.add(dataCollectorDataContent_endTime);
			}
		}
			
		
		//判断有无对应数据出现，然后进行计算
		double energyCon=0;
		for(DataCollectorDataContent dataCollectorDataContent1:dataCollectorDataContents_endTime_room){
			for(DataCollectorDataContent dataCollectorDataContent2:dataCollectorDataContents_startTime_room){
				if((dataCollectorDataContent1.getEquipment_Code()).equals(dataCollectorDataContent2.getEquipment_Code()) && dataCollectorDataContent1!=null && dataCollectorDataContent2!=null){
					energyCon=energyCon+((dataCollectorDataContent1.getCurrent_data_meter())-(dataCollectorDataContent2.getCurrent_data_meter()));
				}
			}
		}		
			return energyCon;
	}

}
