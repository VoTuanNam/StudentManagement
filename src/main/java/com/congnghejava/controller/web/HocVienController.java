package com.congnghejava.controller.web;

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

import com.congnghejava.dto.HocVienDTO;
import com.congnghejava.service.IHocVienService;
import com.congnghejava.util.MessageUtil;

@Controller(value = "hocVienControllerOfWeb")
public class HocVienController {
	
	@Autowired
	private IHocVienService hocVienService;
	
	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/trang-chu/danh-sach-hoc-vien", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, 
			 					 @RequestParam("limit") int limit,  HttpServletRequest request) {
		HocVienDTO model = new HocVienDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("web/hocvien/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(hocVienService.findAll(pageable));
		model.setTotalItem(hocVienService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	
}
