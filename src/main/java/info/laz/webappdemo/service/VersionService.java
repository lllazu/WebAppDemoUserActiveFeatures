package info.laz.webappdemo.service;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import info.laz.webappdemo.model.User;


@Component
public class VersionService
{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public List<String> getActiveFeatures(String user, String version) {
        Session session = sessionFactory.getCurrentSession();
        List<User> list = session.createCriteria(User.class).list();
    	
        return Arrays.asList("f1", "f2", "f3", "f5", "users=" + list.size());
    }
}