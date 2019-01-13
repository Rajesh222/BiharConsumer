package com.db.controller;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.User;
import com.db.service.AuthenticationService;
import com.db.spring.model.RestResponse;
import com.db.spring.model.RestStatus;

@RestController
@RequestMapping(value = "/api/v0/auth")
public class AuthenticationController {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private AuthenticationService userServiceDetails;

	@PostMapping(value = "/registerUser")
	public ResponseEntity<RestResponse<Object>> registration(@RequestBody(required = true) User user) {
		log.info("call registration {}", user);
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "User Registered Successfully");
		if (userServiceDetails.getUserDetails(user.getEmail()) == null) {
			status = new RestStatus<>(HttpStatus.CONFLICT.toString(),
					"A user with this email address already exist into system!");
		} else if (userServiceDetails.getUserDetails(user.getPhoneNumber()) == null) {
			status = new RestStatus<>(HttpStatus.CONFLICT.toString(),
					"A user with this phone number already exist into system!");
		} else {
			 user = userServiceDetails.addUser(user);
			if (user != null)
				status = new RestStatus<>(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
						"User not Registered Successfully");	
		}
		return new ResponseEntity<>(new RestResponse(user, status), HttpStatus.OK);
	}

	@PostMapping(value = "/serviceLoginAuth")
	public ResponseEntity<RestResponse<Object>> authUser(@RequestBody(required = true) User user)
			throws UnsupportedEncodingException {
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "Login Successfully");
		if (user.getEmail() == null)
			status = new RestStatus<>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Please enter valid Email/Phone");
		else {
			user = userServiceDetails.authUser(user);
			if (user == null)
				status = new RestStatus<>(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
						"Unauthorized User. Please enter your valid credential!");
		}
		return new ResponseEntity<>(new RestResponse(user, status), HttpStatus.OK);
	}

	@PostMapping(value = "/forgotPassword")
	public ResponseEntity<RestResponse<Object>> getUserDetails(
			@RequestParam(name = "email", required = true) String email) {
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "Forgot password Successfully");
		User user = userServiceDetails.getUserDetails(email);
		if (user == null)
			status = new RestStatus<>(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
					"Invalid Email/password. Please enter valid email!");
		return new ResponseEntity<>(new RestResponse(user, status), HttpStatus.OK);
	}

	@PostMapping(value = "/changePassword/{uid}")
	public ResponseEntity<RestResponse<Object>> changePassword(@PathVariable(name = "uid", required = true) String uid,
			@RequestParam(name = "newPassword", required = true) String pass) throws UnsupportedEncodingException {
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "Forgot change Successfully");
		int i = userServiceDetails.changePassword(uid, pass);
		if (i == 0)
			status = new RestStatus<>(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
					"Currently this service is unavailable. We regret the inconvenience caused. Please try after some time.");
		return new ResponseEntity<>(new RestResponse(true, status), HttpStatus.OK);
	}

}
