package info.laz.webappdemo.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import info.laz.webappdemo.model.AppVersion;
import info.laz.webappdemo.model.User;
import info.laz.webappdemo.service.impl.VersionServiceImpl;


public class VersionServiceImplTest
{
    private VersionServiceImpl setUpVersionService(User user, AppVersion appVersion) {
        SessionFactory sessionFactory = mock(SessionFactory.class);
        Session session = mock(Session.class);
        Criteria appVersionCriteria = mock(Criteria.class);
        Criteria userCriteria = mock(Criteria.class);
        
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createCriteria(AppVersion.class)).thenReturn(appVersionCriteria);
        when(session.createCriteria(User.class)).thenReturn(userCriteria);
        
        when(appVersionCriteria.add(any())).thenReturn(appVersionCriteria);
        when(userCriteria.add(any())).thenReturn(userCriteria);
        
        when(appVersionCriteria.uniqueResult()).thenReturn(appVersion);
        when(userCriteria.uniqueResult()).thenReturn(user);
        
        VersionServiceImpl versionService = new VersionServiceImpl();
        versionService.setSessionFactory(sessionFactory);
        
        return versionService;
    }
    
    @Test
    public void getActiveFeaturesForExistingUserAndAppVersion() {
        // Setup
        User user = new User();
        user.setName("user_x");
        user.setActiveFeatures("f4");
        user.setInactiveFeatures("f1");
        
        AppVersion appVersion = new AppVersion();
        appVersion.setAppVersion("0.1");
        appVersion.setActiveFeatures("f1,f2,f3");
        
        VersionServiceImpl versionService = setUpVersionService(user, appVersion);
        
        // Test
        List<String> activeFeatures = versionService.getActiveFeatures("user_x", "0.1");
        
        // Verify
        assertEquals("activeFeatures are wrong", 3, activeFeatures.size());
        assertFalse(activeFeatures.contains("f1"));
        assertTrue(activeFeatures.contains("f2"));
        assertTrue(activeFeatures.contains("f3"));
        assertTrue(activeFeatures.contains("f4"));
    }
    
    @Test
    public void getActiveFeaturesForNonExistingUser() {
        // Setup
        AppVersion appVersion = new AppVersion();
        appVersion.setAppVersion("0.1");
        appVersion.setActiveFeatures("f1,f2,f3");
        
        VersionServiceImpl versionService = setUpVersionService(null, appVersion);
        
        // Test
        List<String> activeFeatures = versionService.getActiveFeatures("user_x", "0.1");
        
        // Verify
        assertEquals("activeFeatures are wrong", 0, activeFeatures.size());
    }
    
    @Test
    public void getActiveFeaturesForNonExistingAppVersion() {
        // Setup
        User user = new User();
        user.setName("user_x");
        user.setActiveFeatures("f4");
        user.setInactiveFeatures("f1");
        
        VersionServiceImpl versionService = setUpVersionService(user, null);
        
        // Test
        List<String> activeFeatures = versionService.getActiveFeatures("user_x", "0.1");
        
        // Verify
        assertEquals("activeFeatures are wrong", 0, activeFeatures.size());
    }
    
    @Test
    public void getActiveFeaturesForNonExistingUserAndNonExistingAppVersion() {
        // Setup
        VersionServiceImpl versionService = setUpVersionService(null, null);
        
        // Test
        List<String> activeFeatures = versionService.getActiveFeatures("user_x", "0.1");
        
        // Verify
        assertEquals("activeFeatures are wrong", 0, activeFeatures.size());
    }
    
}