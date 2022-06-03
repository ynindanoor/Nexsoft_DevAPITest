package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.User;

public class UserServiceTest1 {
	UserService userService;
	String firstname;
	String lastname;
	String email;
	String password;
	String repeatpassword;
	
	
	
	@BeforeEach
	public void init() {
		userService = new UserServiceImpl();
		String firstname = "Antoni";
		String lastname = "Kurniawan";
		String email = "antoni@gmail.com";
		String password = "rahasia";
		String repeatpassword = "rahasia";
	}
	
	//green test/positive test
	@DisplayName("User object is created")
	@Test
	public void testCreateUser_WhenDetailIsProvide_ReturnUserObject() {
		
		//Arrange
		

		//Act
		
		User user = userService.createUser(firstname, lastname, email, password, repeatpassword);
		
		//Assert
		assertNotNull(user,"if createuser success should not return null");
		assertEquals(firstname, user.getFirstName(),"User first name is incorrect");
		assertEquals(lastname, user.getLastName(),"User last name is incorrect");
		assertEquals(email, user.getEmail(),"User email is incorrect");
		assertNotNull(user.getId(),"User id cannot null");


	}
	
	//red test/negative test
	@DisplayName("Empty first name cause exception")
	@Test
	public void testCreateUser_WhenFirstNameIsEmpty_ThrowsIllegalException(Object exceptedExceptionMessage) {
		
		//Arrange
		String firstname = "";
		String exceptedExceptionMessage1 = "User first name is empty";		

		//Act
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()->{
			userService.createUser(firstname, lastname, email, password, repeatpassword);
		},"Empty first name cause Illegal Argument Exception");
		//Assert
		assertEquals(exceptedExceptionMessage1, thrown.getMessage());
	}
	//red test/negative test
	@DisplayName("Empty last name cause exception")
	@Test
	public void testCreateUser_WhenLastNameIsEmpty_ThrowsIllegalException(Object exceptedExceptionMessage) {
			
		//Arrange
		
		String lastName = "";
		String exceptedExceptionMessage1 = "User last name is empty";		
			
		//Act
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()->{
				userService.createUser(firstname, lastname, email, password, repeatpassword);
		},"Empty last name cause Illegal Argument Exception");
		//Assert
		assertEquals(exceptedExceptionMessage1, thrown.getMessage());

	}

}
