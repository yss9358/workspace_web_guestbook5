package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GbcService;
import com.javaex.vo.GbcVo;

@Controller
public class GuestbookController {
	@Autowired
	private GbcService gbcService;

	@RequestMapping(value="/gbc/addlist" ,method= {RequestMethod.GET, RequestMethod.POST})
	public String addlist(Model model){
		List<GbcVo> gbcList = gbcService.exeAddlist();
		model.addAttribute("gbcList",gbcList);
		return "addlist";
	}
	@RequestMapping(value="/gbc/insert", method= {RequestMethod.GET,RequestMethod.POST})
	public String insert(@ModelAttribute GbcVo gbcVo) {
		gbcService.exeInsert(gbcVo);
		return "redirect:/gbc/addlist";
	}
	@RequestMapping(value="/gbc/deleteform", method= {RequestMethod.GET,RequestMethod.POST})
	public String deleteform() {
		return "deleteForm";
	}
	@RequestMapping(value="/gbc/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GbcVo gbcVo) {
		gbcService.exeDelete(gbcVo);
		return "redirect:/gbc/addlist";
	}
}
