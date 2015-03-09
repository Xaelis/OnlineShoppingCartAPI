package com.model.services;

import java.util.List;
import java.util.Set;

import com.model.representations.ClientResource;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
public interface ClientService {
    ClientResource find(Integer id);

				void update(Integer id, ClientResource clientResource);

				ClientResource create(ClientResource clientResource);
}
