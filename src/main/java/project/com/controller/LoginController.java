package project.com.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.com.model.Menu;
import project.com.model.Role;
import project.com.model.Users;
import project.com.service.MenuService;
import project.com.service.RoleService;
import project.com.service.UserService;
import project.com.validator.UserValidate;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private UserValidate userValidate = new UserValidate();

	@InitBinder
	private void initialiseBinder(WebDataBinder binder) {
		if (binder.getTarget() == null) {
			return;
		}
		if (binder.getTarget().getClass() == Users.class) {
			binder.setValidator(userValidate);
		}
	}

	@RequestMapping("/login")
	public ModelAndView login(Model model) {
		ModelAndView mv = new ModelAndView();
		model.addAttribute("userAttribute", new Users());
		mv.setViewName("login/login");
		return mv;
	}

	@RequestMapping(value = "/login_process", method = RequestMethod.POST)
	public ModelAndView processLogin(Model model, @ModelAttribute("userAttribute") @Validated Users users,
			BindingResult result, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("login/login");
		}
		Users user = userService.findUser(users.getEmail());
		List<Role> roles = roleService.findRoles(user.getId());
		List<Menu> listMenu = new ArrayList<Menu>();
		for (Role role : roles) {
			List<Menu> menuParents = new ArrayList<Menu>();
			List<Menu> menuChilds = new ArrayList<Menu>();
			List<Menu> menus = menuService.findMenus(role.getId());
			for (Menu menu : menus) {
				if (menu.getParent_id() == 0 && menu.getOrder_index() != -1 && menu.getActive_flag() == 1) {
					menu.setId_menu(menu.getUrl().replace("/", "") + "Id");
					menuParents.add(menu);
				} else if (menu.getParent_id() != 0 && menu.getOrder_index() != -1 && menu.getActive_flag() == 1) {
					menu.setId_menu(menu.getUrl().replace("/", "") + "Id");
					menuChilds.add(menu);
				}
				listMenu.add(menu);
			}

			for (Menu menu : menuParents) {
				List<Menu> list = new ArrayList<Menu>();
				for (Menu m : menuChilds) {
					if (menu.getOrder_index() == m.getParent_id()) {
						list.add(m);
					}
				}
				menu.setListMenuChild(list);
			}

			sort(menuParents);
			for (Menu menu : menuParents) {
				sort(menu.getListMenuChild());
			}
			user.getListMenu().put(role.getId(), menuParents);
		}
		user.setMenus(listMenu);
		session.setAttribute("user", user);
		if (user.getListMenu().size() > 1) {
			session.setAttribute("menu", user.getListMenu().get(1));
			mv.setViewName("redirect:/index");
		}else if(user.getListMenu().size() == 1) {
			Set<Integer> key = user.getListMenu().keySet();
			Iterator<Integer> iterator = key.iterator();
			Integer k = null;
			while(iterator.hasNext()) {
				k = iterator.next();
				session.setAttribute("menu", user.getListMenu().get(k));
			}
			if(k == 1) {
				mv.setViewName("redirect:/index");
			}else if(k == 2) {
				mv.setViewName("redirect:/login");
			}
		}
		return mv;
	}

	@RequestMapping("/access-denied")
	public ModelAndView access() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/page_403");
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.removeAttribute("user");
		session.removeAttribute("menu");
		mv.setViewName("redirect:/login");
		return mv;
	}

	public void sort(List<Menu> list) {
		Collections.sort(list, new Comparator<Menu>() {

			@Override
			public int compare(Menu o1, Menu o2) {
				// TODO Auto-generated method stub
				return o1.getOrder_index() - o2.getOrder_index();
			}
		});
	}
}
