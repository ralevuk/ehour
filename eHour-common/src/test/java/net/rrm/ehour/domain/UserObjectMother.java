package net.rrm.ehour.domain;

import java.util.HashSet;
import java.util.List;

/**
 * Created on Feb 7, 2010 2:25:08 PM
 *
 * @author thies (www.te-con.nl)
 *
 */
public class UserObjectMother
{
	public static User createUser()
	{
		return createUser(new UserDepartment(1));
	}
	
	public static User createUser(UserDepartment department)
	{
		User user = new User();
		user.setUserId(1);
		user.setActive(true);
		user.setEmail("thies@te-con.nl");
		user.setUsername("testmetoo");
		user.setFirstName("Dummy");
		user.setLastName("TestUser");
		user.setPassword("abc");
		
		user.setUserDepartment(department);
        HashSet<UserRole> userRoles = new HashSet<UserRole>();
        userRoles.add(UserRole.ADMIN);
        user.setUserRoles(userRoles);
		
		return user;
	}

	public static List<User> createUsers()
	{
		return MotherUtil.createMultiple(createUser(new UserDepartment(1)));
	}

	
	public static List<User> createUsers(UserDepartment department)
	{
		return MotherUtil.createMultiple(createUser(department));
	}
}
