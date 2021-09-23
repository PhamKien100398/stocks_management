package project.com.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.com.model.Category;
import project.com.service.CategoryService;

@Component
public class CategoryValidate implements Validator {

	@Autowired
	private CategoryService categoryService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == Category.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Category category = (Category) target;
		ValidationUtils.rejectIfEmpty(errors, "code", "Min.Category.Code");
		ValidationUtils.rejectIfEmpty(errors, "name", "Min.Category.Name");
		ValidationUtils.rejectIfEmpty(errors, "description", "Min.Category.Description");
		if (!category.getCode().isEmpty()) {
			Category cate = categoryService.findCategory("code",category.getCode());
			if (cate != null) {
				if (cate.getId() != category.getId()) {
					errors.rejectValue("code", "Min.Category.Exist");
				}
			}
		}

	}

}
