package project.com.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.com.dao.ProductInfoDao;
import project.com.model.ProductInfo;
import project.com.service.ProductInfoService;
import project.com.utils.ConfigLoader;

@Service
public class ProductInfoServiceImpl implements ProductInfoService{
	
	@Autowired
	private ProductInfoDao productDao;

	@Override
	public List<ProductInfo> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public ProductInfo findProductInfoByCode(Object... objects) {
		// TODO Auto-generated method stub
		List<ProductInfo> list = productDao.findProductInfoByCode(objects);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public boolean save(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		if (productInfo.getId() != 0) {
			productInfo.setUpdate_date(new Date());
			String filename = System.currentTimeMillis()+"_"+productInfo.getMultipartFile().getOriginalFilename();
			processUploadFile(productInfo.getMultipartFile(), filename);
			productInfo.setImgUrl("/upload/"+filename);
			return productDao.save(productInfo.getId(), productInfo.getName(), productInfo.getCode(),
					productInfo.getDescription(), productInfo.getActive_flag(), productInfo.getCreate_date(),
					productInfo.getUpdate_date(), productInfo.getCateId(), productInfo.getImgUrl() , productInfo.getId());
		} else {
			productInfo.setActive_flag(1);
			productInfo.setCreate_date(new Date());
			productInfo.setUpdate_date(new Date());
			String filename = System.currentTimeMillis()+"_"+productInfo.getMultipartFile().getOriginalFilename();
			processUploadFile(productInfo.getMultipartFile(), filename);
			productInfo.setImgUrl("/upload/"+filename);
			return productDao.save(productInfo.getId(), productInfo.getName(), productInfo.getCode(),
					productInfo.getDescription(), productInfo.getActive_flag(), productInfo.getCreate_date(),
					productInfo.getUpdate_date(), productInfo.getCateId(), productInfo.getImgUrl());
		}
		
	}
	
	public void processUploadFile(MultipartFile file, String filename) {
		if(!file.getOriginalFilename().isEmpty()) {
			File f = new File(ConfigLoader.getInstance().getValue("upload.location"));
			if(!f.exists()) {
				f.mkdirs();
			}
			File fl = new File(f, filename);
			try {
				file.transferTo(fl);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return productDao.delete(id);
	}

	@Override
	public ProductInfo findProductInfoById(Object... objects) {
		// TODO Auto-generated method stub
		List<ProductInfo> list = productDao.findProductInfoById(objects);
		return list.size() > 0 ? list.get(0) : null;
	}

}
