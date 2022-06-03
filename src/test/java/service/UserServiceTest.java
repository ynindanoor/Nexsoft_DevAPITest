package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.User;

public class UserServiceTest {

	UserService userService;
	String firstName;
	String lastName;
	String email;
	String password;
	String repeatPassword;
	
	@BeforeEach
	public void persiapan() {
		//Arrange
		userService = new UserServiceImpl();
		firstName = "Antoni";
		lastName  = "Kurniawan";
		email     = "antoni@gmail.com";
		password  = "rahasia";
		repeatPassword = "rahasia";
	}
	
//	Green Test /Positive Test=========================================================================================
	@DisplayName("Positive Test")
	@Test
	//@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void testCreateUser_WhenDetailsProvide_returnUserObject() {
		//Arrange

		//Act
		User user = userService.createUser(firstName, lastName, email, password, repeatPassword);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		//Assert
		assertNotNull(user, "if creat user succes not return null");
		assertEquals(firstName, user.getFirstName(), "User first name is incorrect");
		assertEquals(lastName, user.getLastName(), "User last name is incorrect");
		assertEquals(email, user.getEmail(), "User email is incorrect");
		assertNotNull(user.getId(), "User id cannot null");
	}

//	Red Test/Negative Test=========================================================================================
	@DisplayName("Empty first name cause exception")
	@Test
	public void testCreateUser_WhenFirstNameIsEmpty_ThrowsIllegalException() {
		//Arrange
		String firstName = "";
		String exceptedExceptionMessage = "User first name is empty";
		//Act
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()->{
			userService.createUser(firstName, lastName, email, password, repeatPassword);
		}, "Empty first name cause Illegal Argument Exception");
		
		
		//Assert
		assertEquals(exceptedExceptionMessage, thrown.getMessage());
	}
	
//	Red Test/Negative Test=========================================================================================
	@DisplayName("Empty last name cause exception")
	@Test
	public void testCreateUser_WhenLastNameEmpty_ThrowsIllegalException() {
		//Arrange
		String lastName = "";
		String exceptedExceptionMessage = "User last name is empty";
						
		//Act
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()->{
			userService.createUser(firstName, lastName, email, password, repeatPassword);
		}, "Empty last name cause Illegal Argument Exception");
			
		//Assert
		assertEquals(exceptedExceptionMessage, thrown.getMessage());
	}
			
	
}
