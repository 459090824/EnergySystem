package com.energyman.controller.Web.admin;


import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.energyman.bean.Equipment;
import com.energyman.bean.EquipmentSubType;
import com.energyman.bean.EquipmentType;
import com.energyman.service.IEquipmentService;
import com.energyman.service.IEquipmentSubTypeService;
import com.energyman.service.IEquipmentTypeService;
import com.energyman.utils.Global;


@Controller
@RequestMapping("/admin")
public class AdminEquipmentManageController {

	@Resource
	private IEquipmentService iEquipmentService;
	@Resource
	private IEquipmentTypeService iEquipmentTypeService;
	@Resource
	private IEquipmentSubTypeService iEquipmentSubService;
	
	/**显示所有添加设备
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="allEquipment",method=RequestMethod.GET)
	public ModelAndView showAllEquipment(){
		List<Equipment> equipments=iEquipmentService.findAllEquipment();
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("equipments", equipments);
		modelAndView.setViewName("admin/showallequipment");
		return modelAndView;
	}
	
	/**显示所有设备类型
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="allEquipmentType",method=RequestMethod.GET)
	public ModelAndView showAllEquipmentType(){
		List<EquipmentType> equipmentTypes=iEquipmentTypeService.findAllEquipmentType(Global.Type_NORMAL);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("equipmentTypes", equipmentTypes);
		modelAndView.setViewName("admin/showallequipmenttype");
		return modelAndView;
	}
	
	/**显示所有设备子类型
	 * @return
	 * @author RenYang
	 */
	@RequestMapping(value="allEquipmentSubType",method=RequestMethod.GET)
	public ModelAndView showAllEquipmentSubType(){
		List<EquipmentSubType> equipmentSubTypes=iEquipmentSubService.findAllEquipmentSubType(Global.Type_NORMAL);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("equipmentSubTypes",equipmentSubTypes);
		modelAndView.setViewName("admin/showallequipmentsubtype");
		return modelAndView;
	}
}
