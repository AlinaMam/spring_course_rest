package com.zaurtregulov.spring.rest.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//создаем DispatcherServlet, который был прописал в web.xml - frontController
//этот класс есть у Spring
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; //не будет RootConfig классов
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyConfig.class}; //даем ссылку на applicationContext, теперь это класс MyConfig, отвечает за конфигурацию Spring приложения
    }

    @Override
    protected String[] getServletMappings() { //прописываем URL адрес для Dispatcher Servlet, набирая какой адрес HTTP запрос будет поступать на DispatcherServlet
        return new String[]{"/"}; //слэш означает, что какой бы адрес мы ни прописали, что бы в адресе не содержалось, request должен приходить на DispatcherServlet,
        //пусть на DispatcherServlet поступает любой запрос
    }
}
