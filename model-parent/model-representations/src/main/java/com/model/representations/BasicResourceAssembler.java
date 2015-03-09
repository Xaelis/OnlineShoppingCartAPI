package com.model.representations;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.hateoas.Identifiable;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.IdentifiableResourceAssemblerSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
public abstract class BasicResourceAssembler<T extends Identifiable<?>, D extends ResourceSupport>
	extends IdentifiableResourceAssemblerSupport<T, D>
{
    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     * @generated
     */
	private static final Logger log = LogManager.getLogger();

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     * @generated
     */
	@Inject private ApplicationContext context;

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     * @generated
     */
	protected final Class<?> controllerClass;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	protected final Class<?> resourceType;

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     * @generated
     */
	public BasicResourceAssembler(Class<?> controllerClass, Class<D> resourceType)
	{
		super(controllerClass, resourceType);
		this.controllerClass = controllerClass;
		this.resourceType = resourceType;
	}

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     * @generated
     */
	protected D createResourceWithoutId(Object id, T entity, Object... parameters)
	{
		D instance = instantiateResource(entity);
		instance.add(linkTo(controllerClass, unwrapIdentifyables(parameters)).withSelfRel());
		return instance;
	}

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     * @generated
     */
	protected Object[] unwrapIdentifyables(Object[] values)
	{

		List<Object> result = new ArrayList<Object>(values.length);

		for (Object element : Arrays.asList(values)) {
			result.add(
				element instanceof Identifiable ? ((Identifiable<?>) element).getId() : element
			);
		}

		return result.toArray();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	@Override
	public D toResource(T entity)
	{
		return toResource(entity, new Object[0]);
	}

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     * @generated
     */
	public D toResource(T entity, Object... parameters)
	{
		D resource = this.createResource(entity, parameters);
		BeanUtils.copyProperties(entity, resource);
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public void setApplicationContext(ApplicationContext context)
	{
		this.context = context;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	protected Class<?> getController(String controllerName)
	{
		return context.getType(controllerName);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	protected Class<?> getClientController() {
		return this.getController("clientController");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	protected Class<?> getProductController() {
		return this.getController("productController");
	}
}
