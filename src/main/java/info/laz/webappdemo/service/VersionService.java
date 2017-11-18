package info.laz.webappdemo.service;

import java.util.Arrays;
import java.util.List;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

//import info.laz.webappdemo.model.User;


@Component
public class VersionService
{
    //@PersistenceContext
    //private EntityManager em;
   
    public List<String> getActiveFeatures(String user, String version) {
        //CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
        //Root<User> root = criteriaQuery.from(User.class);
        //List<User> list = em.createQuery(criteriaQuery).getResultList();
      
    	return Arrays.asList("f1", "f2", "f3", "f5"); //, "users=" + list.size());
    }
}