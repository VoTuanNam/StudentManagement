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

import com.congnghejava.dto.GiaoVienDTO;
import com.congnghejava.service.IGiaoVienService;
import com.congnghejava.util.MessageUtil;

@Controller(value = "giaoVienControllerOfWeb")
public class GiaoVienController {
	
	@Autowired
	private IGiaoVienService giaoVienService;
	
	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/trang-chu/danh-sach-giao-vien", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, 
			 					 @RequestParam("limit") int limit,  HttpServletRequest request) {
		GiaoVienDTO model = new GiaoVienDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("web/giaovien/listgiaovien");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(giaoVienService.findAll(pageable));
		model.setTotalItem(giaoVienService.getTotalItem());
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
