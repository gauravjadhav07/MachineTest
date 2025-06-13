package com.Gaurav.ServiceGaurav;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.Gaurav.DTOGaurav.RequestCategory;
import com.Gaurav.DTOGaurav.ResponseCategory;

public interface CategoryService {

	ResponseCategory registerCategoryINService(RequestCategory requestCategory);

	List<ResponseCategory> getAllCategory(int page, int size);

	ResponseCategory getSingleCateogry(long id);

	ResponseCategory updateCategoryInService(long id, RequestCategory requestCategory);

	String deleteCategory(long id);

}
