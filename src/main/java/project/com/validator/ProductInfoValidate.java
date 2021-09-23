package project.com.validator;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.com.model.ProductInfo;
import project.com.service.ProductInfoService;

@Component
public class ProductInfoValidate implements Validator{
	
	@Autowired
	private ProductInfoService productService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == ProductInfo.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ProductInfo pro = (ProductInfo) target;
		ValidationUtils.rejectIfEmpty(errors, "code", "ProductInfo.Code");
		ValidationUtils.rejectIfEmpty(errors, "name", "ProductInfo.Name");
		ValidationUtils.rejectIfEmpty(errors, "description", "ProductInfo.Description");
		ValidationUtils.rejectIfEmpty(errors, "multipartFile", "ProductInfo.Image");
		if(pro != null && !pro.getCode().isEmpty()) {
			ProductInfo product = productService.findProductInfoByCode(pro.getCode());
			if(product != null) {
				if(product.getId() != pro.getId()) {
					errors.rejectValue("code", "ProductInfo.Exist");
				}
			}
		}
		
		if(pro.getMultipartFile() != null) {
			String extension = FilenameUtils.getExtension(pro.getMultipartFile().getOriginalFilename());
			if(!extension.equals("jpg") && !extension.equals("png")) {
				errors.rejectValue("multipartFile", "ProductInfo.Image");
			}
		}
	}

}
