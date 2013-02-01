package com.xtivia.training.servicebuilder.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the book remote service. This utility wraps {@link com.xtivia.training.servicebuilder.service.impl.BookServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookService
 * @see com.xtivia.training.servicebuilder.service.base.BookServiceBaseImpl
 * @see com.xtivia.training.servicebuilder.service.impl.BookServiceImpl
 * @generated
 */
public class BookServiceUtil {
    private static BookService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.xtivia.training.servicebuilder.service.impl.BookServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */
    public static void clearService() {
        _service = null;
    }

    public static BookService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    BookService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    BookService.class.getName(), portletClassLoader);

            _service = new BookServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(BookServiceUtil.class,
                "_service");
            MethodCache.remove(BookService.class);
        }

        return _service;
    }

    public void setService(BookService service) {
        MethodCache.remove(BookService.class);

        _service = service;

        ReferenceRegistry.registerReference(BookServiceUtil.class, "_service");
        MethodCache.remove(BookService.class);
    }
}
