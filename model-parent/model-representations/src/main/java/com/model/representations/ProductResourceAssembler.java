package com.model.representations;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.security.MessageDigest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.hateoas.Link;

import com.model.repositories.entities.Product;
import com.model.representations.BasicResourceAssembler;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
public class ProductResourceAssembler extends BasicResourceAssembler<Product, ProductResource> {

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     * @generated
     */
    private static final Logger	log	= LogManager.getLogger();
    
    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     * @generated
     */
	protected final Class<?>	productController;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public ProductResourceAssembler(Class<?> productController) {
		super(productController, ProductResource.class);
		this.productController = productController;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	@Override
	public ProductResource toResource(Product entity) {
		ProductResource resource = super.toResource(entity);
		
        
		
		return resource;
	}
}
