package com.lunchbox.sample.sampleRest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.HibernateException;

import com.lunchbox.sample.sampleRest.model.User;
import com.lunchbox.sample.sampleRest.service.UserService;

/**
 * Root resource (exposed at "users" path)
 * @author Aditya Narain
 */
@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	UserService userController = new UserService();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "JSON" media type.
     * @return all active {@link User users} in the JSON format. <br/>
     * <Strong> Will return emptyList if there are no active users or {@link HibernateException} is caught
     */
    @GET
    public List<User> getAllUsers() {
        return userController.getAllUsers();
    }
    
    /**
     	Adds the user instance to the database.
    * @param user {@link User user} instance to be added
    * @return {@link User user} instance just added. Will be null if there is an exception
    */
   @POST 
    public User addUser(User user){
   	return userController.addUser(user);
    }
   
    
    /**
     * Returns specific user instance with given userId
    * @param userId id of user that wants to be retrieved
    * @return {@link User user} instance for the supplied userId
    */
   @GET
    @Path("/{id}")
    public User getUserWithId(@PathParam("id") String userId){
   	 return userController.getUserWithUserId(userId);
    }
   
   /**
    * Updates the {@link User user} instance for the provided userId.
    * @param userId id of the user that needs to be updated.
    * @param user {@link User user} instance for the specific userId to be updated
    * @return updated {@link User}
    */
   @PUT
   @Path("/{id}")
   public User updateUserWithId(@PathParam("id") String userId, User user){
   	user.setUserId(userId);
   	return userController.updateUser(user);
   }
   
   /**
    * Deletes the {@link User user} with provided userId.
    * Returns a 204 No Content Status when deleted.
    * @param userId Id of the user that needs to be deleted.
    * @param user {@link User user} instance for the specific userId to be deleted
    */
   @PUT
   @Path("/delete/{id}")
   public void deleteUserWithId(@PathParam("id") String userId, User user){
   	user.setUserId(userId);
   	userController.deleteUser(user);
   }
    
}
