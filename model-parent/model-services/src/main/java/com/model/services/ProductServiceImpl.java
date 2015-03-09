package com.model.services;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.model.representations.ProductResource;
import com.model.representations.ProductResourceAssembler;
import com.model.repositories.entities.Product;
import com.model.repositories.dao.ProductDao;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
public class ProductServiceImpl implements ProductService {
   /**
    * <!-- begin-user-doc -->
    * <!--  end-user-doc  -->
    * @generated
    */
   private static final Logger						log	= LogManager.getLogger();
	/**
    * <!-- begin-user-doc -->
    * <!--  end-user-doc  -->
    * @generated
    */
   private final ProductDao                       productDao;
	/**
    * <!-- begin-user-doc -->
    * <!--  end-user-doc  -->
    * @generated
    */
   private final ProductResourceAssembler                       productResourceAssembler;

	/**
    * <!-- begin-user-doc -->
    * <!--  end-user-doc  -->
    * @generated
    */
   @Inject
   public ProductServiceImpl(ProductDao productDao,
                               ProductResourceAssembler productResourceAssembler) {
      this.productDao = productDao;
      this.productResourceAssembler = productResourceAssembler;
   }

			/**
    * <!-- begin-user-doc -->
    * <!--  end-user-doc  -->
    * @generated
    */
   public ProductResource find(Integer id) {
       log.entry(id);
		
	   Product product = productDao.findOne(id);
		
	   /*if (generator == null) {
			throw new ResourceNotFoundException("Product " + id + " not found!");
	   }*/
		
	   return log.exit(productResourceAssembler.toResource( product));
   }
   
   /**
    * <!-- begin-user-doc -->
    * <!--  end-user-doc  -->
    * @generated
    */
   public void update(Integer id, ProductResource productResource) {
   }
   
   /**
    * <!-- begin-user-doc -->
    * <!--  end-user-doc  -->
    * @generated
    */
   public ProductResource create(ProductResource productResource) {
   }
}
