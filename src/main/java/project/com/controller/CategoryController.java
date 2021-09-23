package project.com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import project.com.service.CategoryService;
import project.com.utils.Constant;
import project.com.validator.CategoryValidate;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryValidate categoryValidate;

	@InitBinder
	public void validate(WebDataBinder binder) {
		if (binder.getTarget() == null) {
			return;
		}
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
		if (binder.getTarget().getClass() == Category.class) {
			binder.setValidator(categoryValidate);
		}
	}

	@RequestMapping(value = { "/category/list", "/category/list/" })
	public String redirect(@ModelAttribute("searchForm") Category category, HttpSession session) {
		if(session.getAttribute("category") != null) {
			session.removeAttribute("category");
		}
		if (category.getName() != null && !category.getName().isEmpty()) {
			session.setAttribute("category", category);
		}
		return "redirect:/category/list/1";
	}

	@RequestMapping(value = "/category/list/{page}")
	public ModelAndView list(Model model, @ModelAttribute("searchForm") Category ca, HttpSession session, @PathVariable("page") int page) {
		ModelAndView mv = new ModelAndView();
		Pading<Category> pa = new Pading<Category>(2, page);
		if (session.getAttribute(Constant.SUCCESS) != null) {
			model.addAttribute(Constant.SUCCESS, session.getAttribute(Constant.SUCCESS));
			session.removeAttribute(Constant.SUCCESS);
		} else if (session.getAttribute(Constant.ERROR) != null) {
			model.addAttribute(Constant.ERROR, session.getAttribute(Constant.ERROR));
			session.removeAttribute(Constant.ERROR);
		}

		List<Category> list = categoryService.findAll();
		List<Category> lists = new ArrayList<Category>();
		if (session.getAttribute("category") != null) {
			Category category = (Category) session.getAttribute("category");
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().toLowerCase().contains(category.getName().toLowerCase())) {
					lists.add(list.get(i));
				}
			}
			ca.setName(category.getName());
			
		}else {
			lists = list;
		}
		pa.setTotal(lists);
		List<Category> cates = new ArrayList<Category>();
		for (int i = pa.getStartIndex(); i < (pa.getStartIndex() + pa.getLimit()); i++) {
			if((lists.size() - 1) <= i) {
				cates.add(lists.get(lists.size() - 1));
				break;
			}else {
				cates.add(lists.get(i));
			}
		}
//		/* List<Category> list = categoryService.getAllCategories(pa, category); */
		model.addAttribute("pa", pa);
		model.addAttribute("list", cates);
		model.addAttribute("titlePage", "List Category");
		model.addAttribute("searchForm", ca);
		mv.setViewName("category/category_list");
		return mv;
	}

	@RequestMapping(value = "/category/add")
	public ModelAndView add(Model model) {
		ModelAndView mv = new ModelAndView();
		model.addAttribute("titlePage", "Add Category");
		model.addAttribute("modelForm", new Category());
		model.addAttribute("viewOnly", false);
		mv.setViewName("category/category_action");
		return mv;
	}

	@RequestMapping(value = "/category/save", method = RequestMethod.POST)
	public ModelAndView save(Model model, @ModelAttribute("modelForm") @Validated Category category,
			BindingResult result, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			if (category.getId() != 0) {
				model.addAttribute("titlePage", "Edit Category");
			} else {
				model.addAttribute("titlePage", "Add Category");
			}
			model.addAttribute("viewOnly", false);
			mv.setViewName("category/category_action");
		} else {
			if (category.getId() != 0) {
				category.setUpdate_date(new Date());
				boolean b = categoryService.save(category.getId(), category.getName(), category.getCode(),
						category.getDescription(), category.getActive_flag(), category.getCreate_date(),
						category.getUpdate_date(), category.getId());
				if (b) {
					session.setAttribute(Constant.SUCCESS, "Update success!!!");
				} else {
					session.setAttribute(Constant.ERROR, "Update has error!!!");
				}
			} else {
				category.setActive_flag(1);
				category.setCreate_date(new Date());
				category.setUpdate_date(new Date());
				boolean b = categoryService.save(category.getId(), category.getName(), category.getCode(),
						category.getDescription(), category.getActive_flag(), category.getCreate_date(),
						category.getUpdate_date());
				if (b) {
					session.setAttribute(Constant.SUCCESS, "Insert success!!!");
				} else {
					session.setAttribute(Constant.ERROR, "Insert has error!!!");
				}
			}
			mv.setViewName("redirect:/category/list");
		}
		return mv;
	}

	@RequestMapping(value = "/category/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id, Model model, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Category cate = categoryService.findCategory("id", id);
		if (cate != null) {
			model.addAttribute("modelForm", cate);
			model.addAttribute("titlePage", "Edit Category");
			model.addAttribute("viewOnly", false);
			mv.setViewName("category/category_action");
		}
		return mv;
	}

	@RequestMapping(value = "/category/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (categoryService.deleteCategory(id)) {
			session.setAttribute(Constant.SUCCESS, "Delete success!!!");
		} else {
			session.setAttribute(Constant.ERROR, "Delete error!!!");
		}
		mv.setViewName("redirect:/category/list");
		return mv;
	}

	@RequestMapping(value = "/category/view/{id}")
	public ModelAndView view(Model model, @PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		Category cate = categoryService.findCategory("id", id);
		if (cate != null) {
			model.addAttribute("modelForm", cate);
			model.addAttribute("titlePage", "View Category");
			model.addAttribute("viewOnly", true);
			mv.setViewName("category/category_action");
		}
		return mv;
	}
}