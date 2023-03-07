package model2.mvcmember;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import membership.MemberDAO;
import membership.MemberDTO;

@WebServlet("/mvcmember/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login doGet()");
		
		//로그아웃 처리
		HttpSession session = request.getSession();
		//System.out.println(session.getAttribute("UserId"));
		session.invalidate();
		response.sendRedirect("/WebProject01/LoginForm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login doPost()");
		
		String id = request.getParameter("userid");
		String pass = request.getParameter("userpass");
		String chkBoxVal = request.getParameter("isChk");
		
		//세션 객체 생성
		HttpSession session = request.getSession();
		
		//(임시)membership 패키지의 MemberDAO, MemberDTO 이용
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMemberDTO(id, pass);
		
		//System.out.println(id);
		//System.out.println(pass);
		System.out.println(chkBoxVal);
		System.out.println(dto.getId());
		
		if(dto.getId() != null) {
			session.setAttribute("UserId", dto.getId());
			session.setAttribute("UserName", dto.getName());
			//request.setAttribute("checked", chkBoxVal);
			request.getRequestDispatcher("/WebProject01/LoginForm.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("/WebProject01/LoginForm.jsp");
		}
	}
}
