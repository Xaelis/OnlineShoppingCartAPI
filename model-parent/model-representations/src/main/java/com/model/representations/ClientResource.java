package com.model.representations;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import java.security.MessageDigest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Calendar;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.model.repositories.entities.Client;
import com.model.representations.BasicResourceAssembler;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
public class ClientAssembler extends BasicResourceAssembler<Client, ClientResource> {

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
        			linkTo(clientController).slash(entity).slash("client_id").withRel("client_id"));
		
		return resource;
	}
}
