package com.xtivia.training.servicebuilder.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the book remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookServiceUtil
 * @see com.xtivia.training.servicebuilder.service.base.BookServiceBaseImpl
 * @see com.xtivia.training.servicebuilder.service.impl.BookServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface BookService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link BookServiceUtil} to access the book remote service. Add custom service methods to {@link com.xtivia.training.servicebuilder.service.impl.BookServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
}
