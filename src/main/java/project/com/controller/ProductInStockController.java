package project.com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.com.model.Pading;
import project.com.model.ProductInStock;
import project.com.service.ProductInStockService;

@Controller
public class ProductInStockController {
	
	@Autowired
	private ProductInStockService productInStockService;
	
	@RequestMapping(value = {"/product-in-stock/list", "/product-in-stock/list/"})
	public ModelAndView redirect(@ModelAttribute("searchForm") ProductInStock productInStock, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/product-in-stock/list/1");
		return mv;
	}
	
	@RequestMapping(value = "/product-in-stock/list/{page}")
	public ModelAndView list(Model model, @ModelAttribute("searchForm") ProductInStock productInStock, HttpSession session, @PathVariable("page") int page) {
		ModelAndView mv = new ModelAndView();
		Pading<ProductInStock> pa = new Pading<ProductInStock>(2, page);
		List<ProductInStock> list = productInStockService.findProductInStocks(pa, productInStock);
		if(list != null) {
			pa.setTotal(list);
			model.addAttribute("pa", pa);
		}
		model.addAttribute("list", list);
		model.addAttribute("titlePage", "List Product In Stock");
		model.addAttribute("searchForm", productInStock);
		mv.setViewName("product-in-stock/product-in-stock");
		return mv;
	}
}
