package com.congnghejava.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.congnghejava.dto.LopDTO;
import com.congnghejava.service.ILopService;
import com.congnghejava.util.MessageUtil;

@Controller(value = "lopControllerOfAdmin")
public class LopController {
	
	@Autowired
	private ILopService lopService;
	
	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/quan-tri/bai-viet/danh-sach-lop", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, 
			 					 @RequestParam("limit") int limit,  HttpServletRequest request) {
		LopDTO model = new LopDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/lop/listlop");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(lopService.findAll(pageable));
		model.setTotalItem(lopService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua-lop", method = RequestMethod.GET)
	public ModelAndView editLop(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/lop/editlop");
		LopDTO model = new LopDTO();
		if (id!= null) {
			model = lopService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
}
