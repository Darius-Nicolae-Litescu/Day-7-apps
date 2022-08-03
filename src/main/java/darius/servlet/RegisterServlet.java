package darius.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import darius.InitializeServices;
import darius.dto.UserInsertDTO;
import darius.service.UserService;
import darius.validator.UserValidator;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;
	
    public RegisterServlet() {
        super();
        this.userService = InitializeServices.createUserServiceInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		UserInsertDTO userInsertDto = new UserInsertDTO(username, password);
		String message = UserValidator.validateUserInsertDTO(userInsertDto);
		if(message != null) {
			request.setAttribute("errorMessage", message);
			request.getRequestDispatcher("Register").forward(request, response);
		} 
		userService.insert(userInsertDto);
		request.getRequestDispatcher("Login").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
