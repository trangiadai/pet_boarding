package training.javaweb.exam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import training.javaweb.exam.dto.request.UserRequestDTO;
import training.javaweb.exam.dto.response.UserResponseDTO;
import training.javaweb.exam.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "A6. Tạo tài khoản Customer cho chủ nuôi")
    @ApiResponse(responseCode = "201", description = "Customer credentials created.")
    public UserResponseDTO createCustomerAccount(@Valid @RequestBody UserRequestDTO userRequest){
        return userService.createCustomerAccount(userRequest);
    }

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
}
