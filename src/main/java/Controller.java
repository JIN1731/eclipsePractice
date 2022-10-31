

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SignupDAO;
import dto.SignupDTO;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(uri.equals("/input.mem")) {

			SignupDAO dao = SignupDAO.getInstance();

			String id = request.getParameter("id");
			String pw = dao.getSHA256(request.getParameter("pw"));
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String zipcode = request.getParameter("zipcode");
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			String signup_date = request.getParameter("signup_date");

			SignupDTO dto = new SignupDTO(id, pw, name, phone, email, zipcode, address1, address2, null);
			int result = dao.insert(dto);
			response.sendRedirect("/index.jsp");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
