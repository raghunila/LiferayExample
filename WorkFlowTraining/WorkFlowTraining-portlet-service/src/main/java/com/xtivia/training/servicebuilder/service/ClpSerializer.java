package com.xtivia.training.servicebuilder.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.xtivia.training.servicebuilder.model.BookClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static ClassLoader _classLoader;
    private static String _servletContextName;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "WorkFlowTraining-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "WorkFlowTraining-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "WorkFlowTraining-portlet";
            }

            return _servletContextName;
        }
    }

    public static void setClassLoader(ClassLoader classLoader) {
        _classLoader = classLoader;
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(BookClp.class.getName())) {
            return translateInputBook(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputBook(BaseModel<?> oldModel) {
        BookClp oldCplModel = (BookClp) oldModel;

        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            currentThread.setContextClassLoader(_classLoader);

            try {
                Class<?> newModelClass = Class.forName("com.xtivia.training.servicebuilder.model.impl.BookImpl",
                        true, _classLoader);

                Object newModel = newModelClass.newInstance();

                Method method0 = newModelClass.getMethod("setUuid",
                        new Class[] { String.class });

                String value0 = oldCplModel.getUuid();

                method0.invoke(newModel, value0);

                Method method1 = newModelClass.getMethod("setId",
                        new Class[] { Long.TYPE });

                Long value1 = new Long(oldCplModel.getId());

                method1.invoke(newModel, value1);

                Method method2 = newModelClass.getMethod("setName",
                        new Class[] { String.class });

                String value2 = oldCplModel.getName();

                method2.invoke(newModel, value2);

                Method method3 = newModelClass.getMethod("setIsbn",
                        new Class[] { Long.TYPE });

                Long value3 = new Long(oldCplModel.getIsbn());

                method3.invoke(newModel, value3);

                Method method4 = newModelClass.getMethod("setAuthor",
                        new Class[] { String.class });

                String value4 = oldCplModel.getAuthor();

                method4.invoke(newModel, value4);

                Method method5 = newModelClass.getMethod("setSummary",
                        new Class[] { String.class });

                String value5 = oldCplModel.getSummary();

                method5.invoke(newModel, value5);

                Method method6 = newModelClass.getMethod("setStatus",
                        new Class[] { Integer.TYPE });

                Integer value6 = new Integer(oldCplModel.getStatus());

                method6.invoke(newModel, value6);

                Method method7 = newModelClass.getMethod("setStatusByUserId",
                        new Class[] { Long.TYPE });

                Long value7 = new Long(oldCplModel.getStatusByUserId());

                method7.invoke(newModel, value7);

                Method method8 = newModelClass.getMethod("setStatusByUserName",
                        new Class[] { String.class });

                String value8 = oldCplModel.getStatusByUserName();

                method8.invoke(newModel, value8);

                Method method9 = newModelClass.getMethod("setStatusDate",
                        new Class[] { Date.class });

                Date value9 = oldCplModel.getStatusDate();

                method9.invoke(newModel, value9);

                Method method10 = newModelClass.getMethod("setCompanyId",
                        new Class[] { Long.TYPE });

                Long value10 = new Long(oldCplModel.getCompanyId());

                method10.invoke(newModel, value10);

                Method method11 = newModelClass.getMethod("setGroupId",
                        new Class[] { Long.TYPE });

                Long value11 = new Long(oldCplModel.getGroupId());

                method11.invoke(newModel, value11);

                Method method12 = newModelClass.getMethod("setUserId",
                        new Class[] { Long.TYPE });

                Long value12 = new Long(oldCplModel.getUserId());

                method12.invoke(newModel, value12);

                return newModel;
            } catch (Exception e) {
                _log.error(e, e);
            }
        } finally {
            currentThread.setContextClassLoader(contextClassLoader);
        }

        return oldModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "com.xtivia.training.servicebuilder.model.impl.BookImpl")) {
            return translateOutputBook(oldModel);
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutputBook(BaseModel<?> oldModel) {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            currentThread.setContextClassLoader(_classLoader);

            try {
                BookClp newModel = new BookClp();

                Class<?> oldModelClass = oldModel.getClass();

                Method method0 = oldModelClass.getMethod("getUuid");

                String value0 = (String) method0.invoke(oldModel,
                        (Object[]) null);

                newModel.setUuid(value0);

                Method method1 = oldModelClass.getMethod("getId");

                Long value1 = (Long) method1.invoke(oldModel, (Object[]) null);

                newModel.setId(value1);

                Method method2 = oldModelClass.getMethod("getName");

                String value2 = (String) method2.invoke(oldModel,
                        (Object[]) null);

                newModel.setName(value2);

                Method method3 = oldModelClass.getMethod("getIsbn");

                Long value3 = (Long) method3.invoke(oldModel, (Object[]) null);

                newModel.setIsbn(value3);

                Method method4 = oldModelClass.getMethod("getAuthor");

                String value4 = (String) method4.invoke(oldModel,
                        (Object[]) null);

                newModel.setAuthor(value4);

                Method method5 = oldModelClass.getMethod("getSummary");

                String value5 = (String) method5.invoke(oldModel,
                        (Object[]) null);

                newModel.setSummary(value5);

                Method method6 = oldModelClass.getMethod("getStatus");

                Integer value6 = (Integer) method6.invoke(oldModel,
                        (Object[]) null);

                newModel.setStatus(value6);

                Method method7 = oldModelClass.getMethod("getStatusByUserId");

                Long value7 = (Long) method7.invoke(oldModel, (Object[]) null);

                newModel.setStatusByUserId(value7);

                Method method8 = oldModelClass.getMethod("getStatusByUserName");

                String value8 = (String) method8.invoke(oldModel,
                        (Object[]) null);

                newModel.setStatusByUserName(value8);

                Method method9 = oldModelClass.getMethod("getStatusDate");

                Date value9 = (Date) method9.invoke(oldModel, (Object[]) null);

                newModel.setStatusDate(value9);

                Method method10 = oldModelClass.getMethod("getCompanyId");

                Long value10 = (Long) method10.invoke(oldModel, (Object[]) null);

                newModel.setCompanyId(value10);

                Method method11 = oldModelClass.getMethod("getGroupId");

                Long value11 = (Long) method11.invoke(oldModel, (Object[]) null);

                newModel.setGroupId(value11);

                Method method12 = oldModelClass.getMethod("getUserId");

                Long value12 = (Long) method12.invoke(oldModel, (Object[]) null);

                newModel.setUserId(value12);

                return newModel;
            } catch (Exception e) {
                _log.error(e, e);
            }
        } finally {
            currentThread.setContextClassLoader(contextClassLoader);
        }

        return oldModel;
    }
}
