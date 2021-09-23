package project.com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.com.model.Category;
import project.com.model.Pading;
import project.com.model.ProductInfo;
import project.com.service.CategoryService;
import project.com.service.ProductInfoService;
import project.com.utils.Constant;
import project.com.validator.ProductInfoValidate;

@Controller
public class ProductInfoController {
	
	@Autowired
	private ProductInfoService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductInfoValidate productValidate;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		if(binder.getTarget() == null) {
			return;
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, dateEditor);
		if(binder.getTarget().getClass() == ProductInfo.class) {
			binder.setValidator(productValidate);
		}
	}
	
	
	@RequestMapping(value = { "/product-info/list", "/product/list/" })
	public String redirect(@ModelAttribute("searchForm") ProductInfo product, HttpSession session) {
		if(session.getAttribute("product") != null) {
			session.removeAttribute("product");
		}
		if (product.getName() != null && !product.getName().isEmpty()) {
			session.setAttribute("product", product);
		}
		return "redirect:/product-info/list/1";
	}
	
	@RequestMapping(value = "/product-info/list/{page}")
	public ModelAndView list(Model model, @ModelAttribute("searchForm") ProductInfo product, HttpSession session, @PathVariable("page") String page) {
		ModelAndView mv = new ModelAndView();
		Pading<ProductInfo> pa = new Pading<ProductInfo>(2, Integer.parseInt(page));
		if (session.getAttribute(Constant.SUCCESS) != null) {
			model.addAttribute(Constant.SUCCESS, session.getAttribute(Constant.SUCCESS));
			session.removeAttribute(Constant.SUCCESS);
		} else if (session.getAttribute(Constant.ERROR) != null) {
			model.addAttribute(Constant.ERROR, session.getAttribute(Constant.ERROR));
			session.removeAttribute(Constant.ERROR);
		}

		List<ProductInfo> list = productService.findAll();
		List<ProductInfo> lists = new ArrayList<ProductInfo>();
		if (session.getAttribute("product") != null) {
			ProductInfo productInfo = (ProductInfo) session.getAttribute("product");
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().toLowerCase().contains(productInfo.getName().toLowerCase())) {
					lists.add(list.get(i));
				}
			}
			product.setName(productInfo.getName());
			
		}else {
			lists = list;
		}
		pa.setTotal(lists);
		List<ProductInfo> pro = new ArrayList<ProductInfo>();
		for (int i = pa.getStartIndex(); i < (pa.getStartIndex() + pa.getLimit()); i++) {
			if((lists.size() - 1) <= i) {
				pro.add(lists.get(lists.size() - 1));
				break;
			}else {
				pro.add(lists.get(i));
			}
		}
//		/* List<ProductInfo> list = ProductInfoService.getAllCategories(pa, ProductInfo); */
		model.addAttribute("pa", pa);
		model.addAttribute("list", pro);
		model.addAttribute("titlePage", "List Product");
		model.addAttribute("searchForm", product);
		mv.setViewName("product-info/productInfo-list");
		return mv;
	}
	
	@RequestMapping(value = "/product-info/add")
	public ModelAndView add(Model model) {
		ModelAndView mv = new ModelAndView();
		
		List<Category> listCategory = categoryService.findAll();
		Map<String, String> map = new HashMap<String, String>();
		for(Category cate : listCategory) {
			map.put(String.valueOf(cate.getId()), cate.getName());
		}
		
		model.addAttribute("mapCategory", map);
		model.addAttribute("titlePage", "Add Product");
		model.addAttribute("modelForm", new ProductInfo());
		model.addAttribute("viewOnly", false);
		mv.setViewName("product-info/productInfo-action");
		return mv;
	}
	
	@RequestMapping(value = "/product-info/save", method = RequestMethod.POST)
	public ModelAndView save(Model model, @ModelAttribute("modelForm") @Validated ProductInfo productInfo,
			BindingResult result, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			if (productInfo.getId() != 0) {
				model.addAttribute("titlePage", "Edit Category");
			} else {
				model.addAttribute("titlePage", "Add Category");
			}
			List<Category> listCategory = categoryService.findAll();
			Map<String, String> map = new HashMap<String, String>();
			for(Category cate : listCategory) {
				map.put(String.valueOf(cate.getId()), cate.getName());
			}
			model.addAttribute("mapCategory", map);
			model.addAttribute("viewOnly", false);
//			model.addAttribute("modelForm", new ProductInfo());
			mv.setViewName("product-info/productInfo-action");
		} else {
			boolean b = productService.save(productInfo);
			if (productInfo.getId() != 0) {
				if (b) {
					session.setAttribute(Constant.SUCCESS, "Update success!!!");
				} else {
					session.setAttribute(Constant.ERROR, "Update has error!!!");
				}
			} else {
				if (b) {
					session.setAttribute(Constant.SUCCESS, "Insert success!!!");
				} else {
					session.setAttribute(Constant.ERROR, "Insert has error!!!");
				}
			}
			mv.setViewName("redirect:/product-info/list");
		}
		return mv;
	}
	
	@RequestMapping(value = "/product-info/delete/{id}")
	public ModelAndView delete(Model model, @PathVariable("id") int id, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		boolean b = productService.delete(id);
		if(b) {
			session.setAttribute(Constant.SUCCESS, "Delete success!!!");
		}else {
			session.setAttribute(Constant.ERROR, "Delete error!!!");
		}
		mv.setViewName("redirect:/product-info/list");
		return mv;
	}
	
	@RequestMapping(value = "/product-info/edit/{id}")
	public ModelAndView edit(Model model, @PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		ProductInfo pro = productService.findProductInfoById(id);
		List<Category> list = categoryService.findAll();
		Map<String, String> map = new HashMap<String, String>();
		for(Category cate : list) {
			map.put(String.valueOf(cate.getId()), cate.getName());
		}
		
		model.addAttribute("id", String.valueOf(pro.getCateId()));
		model.addAttribute("mapCategory", map);
		model.addAttribute("titlePage", "Edit Product");
		model.addAttribute("modelForm", pro);
		model.addAttribute("viewOnly", false);
		mv.setViewName("product-info/productInfo-action");
		return mv;
	}
	
	
	
	@RequestMapping(value = "/product-info/view/{id}")
	public ModelAndView view(Model model, @PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		ProductInfo pro = productService.findProductInfoById(id);
		List<Category> list = categoryService.findAll();
		Map<String, String> map = new HashMap<String, String>();
		for(Category cate : list) {
			map.put(String.valueOf(cate.getId()), cate.getName());
		}
		model.addAttribute("id", String.valueOf(pro.getCateId()));
		model.addAttribute("mapCategory", map);
		model.addAttribute("titlePage", "View Product");
		model.addAttribute("modelForm", pro);
		model.addAttribute("viewOnly", true);
		mv.setViewName("product-info/productInfo-action");
		return mv;
	}
	
	
	
	
	
	
	
}
