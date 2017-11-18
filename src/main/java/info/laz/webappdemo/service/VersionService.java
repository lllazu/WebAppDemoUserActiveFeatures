package info.laz.webappdemo.service;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Restrictions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import info.laz.webappdemo.model.AppVersion;
import info.laz.webappdemo.model.User;


@Component
public class VersionService
{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public List<String> getActiveFeatures(String userName, String appVersion) {
        Session session = sessionFactory.getCurrentSession();
        
        AppVersion version = (AppVersion) session.createCriteria(AppVersion.class)
            .add(Restrictions.eq("appVersion", appVersion)).uniqueResult();
        if (version != null) {
            User user = (User) session.createCriteria(User.class)
                .add(Restrictions.eq("name", userName)).uniqueResult();
            if (user != null) {
            	Set<String> activeFeatures = new LinkedHashSet<String>();
                activeFeatures.addAll(Arrays.asList(version.getActiveFeatures().split(",")));
                activeFeatures.addAll(Arrays.asList(user.getActiveFeatures().split(",")));
                activeFeatures.removeAll(Arrays.asList(user.getInactiveFeatures().split(",")));
                
                List<String> sortedActiveFeatures = new ArrayList<String>(activeFeatures);
                Collections.sort(sortedActiveFeatures);
                return sortedActiveFeatures;
            }
        }
        
        return Collections.emptyList();
    }
}