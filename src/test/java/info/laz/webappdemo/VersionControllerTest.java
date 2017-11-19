package info.laz.webappdemo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import info.laz.webappdemo.data.FeaturesResponse;
import info.laz.webappdemo.service.impl.VersionServiceImpl;


public class VersionControllerTest
{
	@Test
    public void getActiveFeaturesForExistingUserAndAppVersion() {
        // Setup
        VersionServiceImpl versionService = mock(VersionServiceImpl.class);
        when(versionService.getActiveFeatures(any(), any())).thenReturn(Arrays.asList("f1", "f2", "f3"));
        
        VersionController versionController = new VersionController();
        versionController.setVersionService(versionService);
        
        // Test
        FeaturesResponse res = versionController.getActiveFeatures("user_x", "0.1");
        List<String> activeFeatures = res.getActive_features();
        
        // Verify
        assertEquals("user is wrong", "user_x", res.getUser());
        assertEquals("version is wrong", "0.1", res.getVersion());
        
        assertEquals("activeFeatures are wrong", 3, activeFeatures.size());
        assertTrue(activeFeatures.contains("f1"));
        assertTrue(activeFeatures.contains("f2"));
        assertTrue(activeFeatures.contains("f3"));
    }
    
    @Test
    public void getActiveFeaturesForNonExistingUserAndAppVersion() {
        // Setup
        VersionServiceImpl versionService = mock(VersionServiceImpl.class);
        when(versionService.getActiveFeatures(any(), any())).thenReturn(Collections.emptyList());
        
        VersionController versionController = new VersionController();
        versionController.setVersionService(versionService);
        
        // Test
        FeaturesResponse res = versionController.getActiveFeatures("user_unknown", "0.unknown");
        List<String> activeFeatures = res.getActive_features();
        
        // Verify
        assertEquals("user is wrong", "user_unknown", res.getUser());
        assertEquals("version is wrong", "0.unknown", res.getVersion());
        
        assertEquals("activeFeatures are wrong", 0, activeFeatures.size());
    }
    
}
