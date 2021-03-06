package com.model.representations;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.security.MessageDigest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.hateoas.Link;

import com.model.repositories.entities.Client;
import com.model.representations.BasicResourceAssembler;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
public class ClientResourceAssembler extends BasicResourceAssembler<Client, ClientResource> {

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
	protected final Class<?>	clientController;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public ClientResourceAssembler(Class<?> clientController) {
		super(clientController, ClientResource.class);
		this.clientController = clientController;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	@Override
	public ClientResource toResource(Client entity) {
		ClientResource resource = super.toResource(entity);
		
        resource.getLinks().add(
        			linkTo(clientController).slash(entity).slash("products").withRel("products"));
		
		return resource;
	}
}
