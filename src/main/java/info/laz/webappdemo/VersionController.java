package info.laz.webappdemo;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import info.laz.webappdemo.data.FeaturesResponse;
import info.laz.webappdemo.service.VersionService;

import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class VersionController
{
    @Autowired
    private VersionService versionService;
	
    @RequestMapping(value = "/rest/version/features", method = RequestMethod.GET)
    public @ResponseBody FeaturesResponse getActiveFeatures(
        @RequestParam("user") String user, 
        @RequestParam("version") String version) {
 
        FeaturesResponse res = new FeaturesResponse();
        res.setUser(user);
        res.setVersion(version);
        res.setActive_features(versionService.getActiveFeatures(user, version));
        return res;
    }
    
    public void setVersionService(VersionService versionService) {
        this.versionService = versionService;
    }
}
