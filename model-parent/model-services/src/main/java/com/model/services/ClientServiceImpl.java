package com.model.services;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.model.representations.ClientResource;
import com.model.representations.ClientResourceAssembler;
import com.model.repositories.entities.Client;
import com.model.repositories.dao.ClientDao;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
public class ClientServiceImpl implements ClientService {
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
   private final ClientDao                       clientDao;
	/**
    * <!-- begin-user-doc -->
    * <!--  end-user-doc  -->
    * @generated
    */
   private final ClientResourceAssembler                       clientResourceAssembler;

	/**
    * <!-- begin-user-doc -->
    * <!--  end-user-doc  -->
    * @generated
    */
   @Inject
   public ClientServiceImpl(ClientDao clientDao,
                               ClientResourceAssembler clientResourceAssembler) {
      this.clientDao = clientDao;
      this.clientResourceAssembler = clientResourceAssembler;
   }

			/**
    * <!-- begin-user-doc -->
    * <!--  end-user-doc  -->
    * @generated
    */
   public ClientResource find(Integer id) {
       log.entry(id);
		
	   Client client = clientDao.findOne(id);
		
	   /*if (generator == null) {
			throw new ResourceNotFoundException("Client " + id + " not found!");
	   }*/
		
	   return log.exit(clientResourceAssembler.toResource( client));
   }
   
   /**
    * <!-- begin-user-doc -->
    * <!--  end-user-doc  -->
    * @generated
    */
   public void update(Integer id, ClientResource clientResource) {
       log.entry(id);
		
	   Client client = clientDao.findOne(id);
		
	   /*if (generator == null) {
			throw new ResourceNotFoundException("Client " + id + " not found!");
	   }*/
	   
	   client.setName(clientResource.getName());
	   client.setColumn(clientResource.getColumn());
	   
   }
   
   /**
    * <!-- begin-user-doc -->
    * <!--  end-user-doc  -->
    * @generated
    */
   public ClientResource create(ClientResource clientResource) {
   }
}
