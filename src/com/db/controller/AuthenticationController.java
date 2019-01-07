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

	@PostMapping(value = "/signUp")
	public String registration(@RequestBody User user) {
		log.info("call registration {}", user);
		userServiceDetails.addUser(user);
		return "redirect:/welcome";
	}

	@PostMapping(value = "/serviceLoginAuth")
	public ResponseEntity<RestResponse<Object>> authUser(
			@RequestParam(name = "userName", required = true) String userName,
			@RequestParam(name = "passowrd", required = true) String password) throws UnsupportedEncodingException {
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "Login Successfully");
		Object user = userServiceDetails.authUser(userName, password);
		if (user == null)
			status = new RestStatus<>(HttpStatus.OK.toString(), "Unauthorized User Credential!");
		return new ResponseEntity<>(new RestResponse(user, status), HttpStatus.OK);
	}

	@PostMapping(value = "/forgotPassword")
	public ResponseEntity<RestResponse<Object>> forgotPassword(
			@RequestParam(name = "username", required = true) String userName) {
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "Forgot password Successfully");
		return new ResponseEntity<>(new RestResponse(null, status), HttpStatus.OK);
	}

	@PostMapping(value = "/changePassword/{newPass}/{conformPass}")
	public ResponseEntity<RestResponse<Object>> changePassword(
			@PathVariable(name = "username", required=true) String newPass,
			@PathVariable(name = "username", required = true) String confirmPass,
			@RequestParam(name = "username", required = true) String userName) {
		RestStatus<String> status = new RestStatus<>(HttpStatus.OK.toString(), "Forgot change Successfully");
		return new ResponseEntity<>(new RestResponse(null, status), HttpStatus.OK);
	}

}
