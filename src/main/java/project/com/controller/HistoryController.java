package project.com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.com.model.History;
import project.com.model.Pading;
import project.com.model.ProductInStock;

@Controller
public class HistoryController {
	
	@RequestMapping(value = {"/history/list", "/history/list/"})
	public ModelAndView redirect(@ModelAttribute("searchForm") ProductInStock productInStock, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/history/list/1");
		return mv;
	}
	
	@RequestMapping(value = "/history/list/{page}")
	public ModelAndView list(Model model, @ModelAttribute("searchForm") History history, HttpSession session, @PathVariable("page") int page) {
		ModelAndView mv = new ModelAndView();
		Pading<ProductInStock> pa = new Pading<ProductInStock>(2, page);
		List<ProductInStock> list = productInStockService.findProductInStocks(pa, history);
		if(list != null) {
			pa.setTotal(list);
			model.addAttribute("pa", pa);
		}
		model.addAttribute("list", list);
		model.addAttribute("titlePage", "List Product In Stock");
		model.addAttribute("searchForm", history);
		mv.setViewName("product-in-stock/product-in-stock");
		return mv;
	}
}
