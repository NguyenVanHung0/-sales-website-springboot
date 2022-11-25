package com.hungnguyen.springboot.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hungnguyen.springboot.entity.Feedback;
import com.hungnguyen.springboot.entity.New;
import com.hungnguyen.springboot.entity.NewCategory;
import com.hungnguyen.springboot.entity.Order;
import com.hungnguyen.springboot.entity.Product;
import com.hungnguyen.springboot.entity.ProductCategory;
import com.hungnguyen.springboot.entity.User;
import com.hungnguyen.springboot.model.dto.FeedbackDTO;
import com.hungnguyen.springboot.model.dto.NewCategoryDTO;
import com.hungnguyen.springboot.model.dto.NewDTO;
import com.hungnguyen.springboot.model.dto.OrderDTO;
import com.hungnguyen.springboot.model.dto.ProductCategoryDTO;
import com.hungnguyen.springboot.model.dto.ProductDTO;
import com.hungnguyen.springboot.model.dto.UserDTO;

@Component
public class Mapper {
	
	// User Table
	public UserDTO toUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUserName(user.getUserName());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setAddress(user.getAddress());
		userDTO.setEmail(user.getEmail());
		userDTO.setPhone(user.getPhone());
		userDTO.setCreatedBy(user.getCreatedBy());
		userDTO.setCreatedDate(user.getCreatedDate());
		userDTO.setModifiedBy(user.getModifiedBy());
		userDTO.setModifiedDate(user.getModifiedDate());
		userDTO.setStatus(user.getStatus());
		
		List<Long> listOrderId = new ArrayList<>();
		List<Long> listFeedbackId = new ArrayList<>();
		
		for(Order order : user.getOrders()) {
			listOrderId.add(order.getId());
		}
		
		for(Feedback feedback : user.getFeedBacks()) {
			listFeedbackId.add(feedback.getId());
		}
		userDTO.setListOrderId(listOrderId);
		userDTO.setListFeedbackId(listFeedbackId);
		return userDTO;
	}
	
	public User toUser(UserDTO userDTO) {
		User user = new User();
		user.setUserName(userDTO.getUserName());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setAddress(userDTO.getAddress());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());
		user.setCreatedBy(userDTO.getCreatedBy());
		user.setCreatedDate(userDTO.getCreatedDate());
		user.setModifiedBy(userDTO.getModifiedBy());
		user.setModifiedDate(userDTO.getModifiedDate());
		user.setStatus(userDTO.getStatus());
		return user;
	}
	
	public User toUser(UserDTO userDTO, User user) {
		user.setUserName(userDTO.getUserName());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setAddress(userDTO.getAddress());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());
		user.setCreatedBy(userDTO.getCreatedBy());
		user.setCreatedDate(userDTO.getCreatedDate());
		user.setModifiedBy(userDTO.getModifiedBy());
		user.setModifiedDate(userDTO.getModifiedDate());
		user.setStatus(userDTO.getStatus());
		return user;
	}
	
	
	// Product Table
	
	public Product toProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setCode(productDTO.getCode());
		product.setName(productDTO.getName());
		product.setTitle(productDTO.getTitle());
		product.setDescription(productDTO.getDescription());
		product.setImage(productDTO.getImage());
		product.setMoreImage(productDTO.getMoreImage());
		product.setPrice(productDTO.getPrice());
		product.setPromotionPrice(productDTO.getPromotionPrice());
		product.setQuantity(productDTO.getQuantity());
		product.setDetail(productDTO.getDetail());
		product.setStatus(productDTO.getStatus());
		return product;
	}
	
	public ProductDTO toProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setCode(product.getCode());
		productDTO.setName(product.getName());
		productDTO.setTitle(product.getTitle());
		productDTO.setDescription(product.getDescription());
		productDTO.setImage(product.getImage());
		productDTO.setPrice(product.getPrice());
		productDTO.setPromotionPrice(product.getPromotionPrice());
		productDTO.setQuantity(product.getQuantity());
		productDTO.setDetail(product.getDetail());
		productDTO.setStatus(product.getStatus());
		
		List<Order> orders = product.getListOrder();
		List<Long> listOrderId = new ArrayList<>();
		for(Order order : orders) {
			listOrderId.add(order.getId());
		}
		productDTO.setListOrderId(listOrderId);
		
		productDTO.setProductCategoryId(product.getProductCategory().getId());
		return productDTO;
	}
	
	public Product toProduct(ProductDTO productDTO, Product product) {
		product.setCode(productDTO.getCode());
		product.setName(productDTO.getName());
		product.setTitle(productDTO.getTitle());
		product.setDescription(productDTO.getDescription());
		product.setImage(productDTO.getImage());
		product.setMoreImage(productDTO.getMoreImage());
		product.setPrice(productDTO.getPrice());
		product.setPromotionPrice(productDTO.getPromotionPrice());
		product.setQuantity(productDTO.getQuantity());
		product.setDetail(productDTO.getDetail());
		product.setStatus(productDTO.getStatus());
		return product;
	}
	
	
	// Product Category Table
	
	public ProductCategoryDTO toProductCategoryDTO(ProductCategory productCategory) {
		ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
		productCategoryDTO.setId(productCategory.getId());
		productCategoryDTO.setName(productCategory.getName());
		productCategoryDTO.setTitle(productCategory.getTitle());
		productCategoryDTO.setDescription(productCategory.getDescription());
		productCategoryDTO.setStatus(productCategory.getStatus());
		List<Product> products = productCategory.getProducts();
		List<Long> listProductId = new ArrayList<>();
		for(Product product : products) {
			listProductId.add(product.getId());
		}
		productCategoryDTO.setListProductId(listProductId);
		productCategoryDTO.setCreatedDate(productCategory.getCreatedDate());
		productCategoryDTO.setCreatedBy(productCategory.getCreatedBy());
		productCategoryDTO.setModifiedBy(productCategory.getModifiedBy());
		productCategoryDTO.setModifiedDate(productCategory.getModifiedDate());
		return productCategoryDTO;
	}
	
	public ProductCategory toProductCategory(ProductCategoryDTO productCategoryDTO) {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setName(productCategoryDTO.getName());
		productCategory.setTitle(productCategoryDTO.getTitle());
		productCategory.setDescription(productCategoryDTO.getDescription());
		productCategory.setStatus(productCategoryDTO.getStatus());
		productCategory.setCreatedDate(productCategoryDTO.getCreatedDate());
		productCategory.setCreatedBy(productCategoryDTO.getCreatedBy());
		productCategory.setModifiedBy(productCategoryDTO.getModifiedBy());
		productCategory.setModifiedDate(productCategoryDTO.getModifiedDate());
		return productCategory;
	}
	
	public ProductCategory toProductCategory(ProductCategoryDTO productCategoryDTO, ProductCategory productCategory) {
		productCategory.setName(productCategoryDTO.getName());
		productCategory.setTitle(productCategoryDTO.getTitle());
		productCategory.setDescription(productCategoryDTO.getDescription());
		productCategory.setStatus(productCategoryDTO.getStatus());
		productCategory.setCreatedDate(productCategoryDTO.getCreatedDate());
		productCategory.setCreatedBy(productCategoryDTO.getCreatedBy());
		productCategory.setModifiedBy(productCategoryDTO.getModifiedBy());
		productCategory.setModifiedDate(productCategoryDTO.getModifiedDate());
		return productCategory;
	}
	
	
	// New Table
	
	public New toNew(NewDTO newDTO) {
		New news = new New();
		news.setTitle(newDTO.getTitle());
		news.setDescription(newDTO.getDescription());
		news.setImage(newDTO.getImage());
		news.setDetail(newDTO.getDetail());
		news.setStatus(newDTO.getStatus());
		news.setTopHot(newDTO.getTopHot());
		news.setTagName(newDTO.getTagName());
		news.setCreatedBy(newDTO.getCreatedBy());
		news.setCreatedDate(newDTO.getCreatedDate());
		news.setModifiedBy(newDTO.getModifiedBy());
		news.setModifiedDate(newDTO.getModifiedDate());
		return news;
	}
	
	public NewDTO toNewDTO(New news) {
		NewDTO newDTO = new NewDTO();
		newDTO.setId(news.getId());
		newDTO.setTitle(news.getTitle());
		newDTO.setDescription(news.getDescription());
		newDTO.setImage(news.getImage());
		newDTO.setDetail(news.getDetail());
		newDTO.setStatus(news.getStatus());
		newDTO.setTopHot(news.getTopHot());
		newDTO.setTagName(news.getTagName());
		newDTO.setCategoryId(news.getNewCategory().getId());
		newDTO.setCreatedBy(news.getCreatedBy());
		newDTO.setCreatedDate(news.getCreatedDate());
		newDTO.setModifiedBy(news.getModifiedBy());
		newDTO.setModifiedDate(news.getModifiedDate());
		return newDTO;
	}
	
	public New toNew(NewDTO newDTO, New news) {
		news.setTitle(newDTO.getTitle());
		news.setDescription(newDTO.getDescription());
		news.setImage(newDTO.getImage());
		news.setDetail(newDTO.getDetail());
		news.setStatus(newDTO.getStatus());
		news.setTopHot(newDTO.getTopHot());
		news.setTagName(newDTO.getTagName());
		news.setCreatedBy(newDTO.getCreatedBy());
		news.setCreatedDate(newDTO.getCreatedDate());
		news.setModifiedBy(newDTO.getModifiedBy());
		news.setModifiedDate(newDTO.getModifiedDate());
		return news;
	}
	
	
	// NewCategory table
	
	public NewCategory toNewCategory(NewCategoryDTO newCategoryDTO) {
		NewCategory newCategory = new NewCategory();
		newCategory.setName(newCategoryDTO.getName());
		newCategory.setTitle(newCategoryDTO.getTitle());
		newCategory.setStatus(newCategoryDTO.getStatus());
		newCategory.setDescription(newCategoryDTO.getDescription());
		newCategory.setCreatedBy(newCategoryDTO.getCreatedBy());
		newCategory.setCreatedDate(newCategoryDTO.getCreatedDate());
		newCategory.setModifiedBy(newCategoryDTO.getModifiedBy());
		newCategory.setModifiedDate(newCategoryDTO.getModifiedDate());
		return newCategory;
	}
	
	public NewCategory toNewCategory(NewCategoryDTO newCategoryDTO, NewCategory newCategory) {
		newCategory.setName(newCategoryDTO.getName());
		newCategory.setTitle(newCategoryDTO.getTitle());
		newCategory.setStatus(newCategoryDTO.getStatus());
		newCategory.setDescription(newCategoryDTO.getDescription());
		newCategory.setCreatedBy(newCategoryDTO.getCreatedBy());
		newCategory.setCreatedDate(newCategoryDTO.getCreatedDate());
		newCategory.setModifiedBy(newCategoryDTO.getModifiedBy());
		newCategory.setModifiedDate(newCategoryDTO.getModifiedDate());
		return newCategory;
	}
	
	public NewCategoryDTO toNewCategoryDTO(NewCategory newCategory) {
		NewCategoryDTO newCategoryDTO = new NewCategoryDTO();
		newCategoryDTO.setId(newCategory.getId());
		newCategoryDTO.setName(newCategory.getName());
		newCategoryDTO.setTitle(newCategory.getTitle());
		newCategoryDTO.setStatus(newCategory.getStatus());
		newCategoryDTO.setDescription(newCategory.getDescription());
		List<New> listNew = newCategory.getNews();
		List<Long> listIdNew = new ArrayList<>();
		for(New news : listNew) {
			listIdNew.add(news.getId());
		}
		newCategoryDTO.setNews(listIdNew);
		newCategoryDTO.setCreatedBy(newCategory.getCreatedBy());
		newCategoryDTO.setCreatedDate(newCategory.getCreatedDate());
		newCategoryDTO.setModifiedBy(newCategory.getModifiedBy());
		newCategoryDTO.setModifiedDate(newCategory.getModifiedDate());
		return newCategoryDTO;
	}
	
	// Order Table
	
	public Order toOrder(OrderDTO orderDTO) {
		Order order = new Order();
		order.setStatus(orderDTO.getStatus());
		order.setTotalMoney(orderDTO.getTotalMoney());
		order.setCreatedBy(orderDTO.getCreatedBy());
		order.setCreatedDate(orderDTO.getCreatedDate());
		order.setModifiedBy(orderDTO.getModifiedBy());
		order.setModifiedDate(orderDTO.getModifiedDate());
		return order;
	}
	
	public Order toOrder(OrderDTO orderDTO, Order order) {
		order.setStatus(orderDTO.getStatus());
		order.setTotalMoney(orderDTO.getTotalMoney());
		order.setCreatedBy(orderDTO.getCreatedBy());
		order.setCreatedDate(orderDTO.getCreatedDate());
		order.setModifiedBy(orderDTO.getModifiedBy());
		order.setModifiedDate(orderDTO.getModifiedDate());
		return order;
	}
	
	public OrderDTO toOrderDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(order.getId());
		orderDTO.setStatus(order.getStatus());
		orderDTO.setTotalMoney(order.getTotalMoney());
		orderDTO.setUserId(order.getUser().getId());
		orderDTO.setCreatedBy(order.getCreatedBy());
		orderDTO.setCreatedDate(order.getCreatedDate());
		orderDTO.setModifiedBy(order.getModifiedBy());
		orderDTO.setModifiedDate(order.getModifiedDate());
		return orderDTO;
	}
	
	// Feedback Table
	
	public Feedback toFeedback(FeedbackDTO feedbackDTO) {
		Feedback feedback = new Feedback();
		feedback.setContent(feedbackDTO.getContent());
		feedback.setStatus(feedbackDTO.getStatus());
		feedback.setCreateDate(feedbackDTO.getCreateDate());
		return feedback;
	}
	
	public Feedback toFeedback(FeedbackDTO feedbackDTO, Feedback feedback) {
		feedback.setContent(feedbackDTO.getContent());
		feedback.setStatus(feedbackDTO.getStatus());
		feedback.setCreateDate(feedbackDTO.getCreateDate());
		return feedback;
	}
	
	public FeedbackDTO toFeedbackDTO(Feedback feedback) {
		FeedbackDTO feedbackDTO = new FeedbackDTO();
		feedbackDTO.setId(feedback.getId());
		feedbackDTO.setContent(feedback.getContent());
		feedbackDTO.setStatus(feedback.getStatus());
		feedbackDTO.setCreateDate(feedback.getCreateDate());
		feedbackDTO.setUserId(feedback.getUser().getId());
		return feedbackDTO;
	}
	
	
}
