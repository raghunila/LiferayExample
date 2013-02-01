package com.xtivia.training.servicebuilder.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class BookFinderUtil {
    private static BookFinder _finder;

    public static com.xtivia.training.servicebuilder.model.Book findBook(
        long isbn) throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().findBook(isbn);
    }

    public static BookFinder getFinder() {
        if (_finder == null) {
            _finder = (BookFinder) PortletBeanLocatorUtil.locate(com.xtivia.training.servicebuilder.service.ClpSerializer.getServletContextName(),
                    BookFinder.class.getName());

            ReferenceRegistry.registerReference(BookFinderUtil.class, "_finder");
        }

        return _finder;
    }

    public void setFinder(BookFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(BookFinderUtil.class, "_finder");
    }
}
