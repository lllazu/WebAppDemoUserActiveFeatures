package info.laz.webappdemo.service;

import java.util.List;


public interface VersionService
{
	/**
	 * Get all active features for given user and application version
	 */
    public List<String> getActiveFeatures(String userName, String appVersion);
}