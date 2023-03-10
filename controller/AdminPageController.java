package member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/adminpage.do")
public class AdminPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("adminpage doGet()");
		
		String mode = request.getParameter("mode");
		String id = request.getParameter("user_id");
		
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> members = new ArrayList<MemberDTO>();
		int totNum = dao.memberCount();
		int initNum = 0;
		
		//관리자가 관리자 페이지(AdminPage.jsp)의 목록 클릭했을 때
		if(mode.equals("memberlist")) {
			members = dao.selectAll();
			
			request.setAttribute("members", members);
			request.setAttribute("totNum", totNum);
			request.setAttribute("initNum", (int)initNum);
			request.getRequestDispatcher("/Member/MemberList.jsp").forward(request, response);
		}
		else if(mode.equals("board")) {
			System.out.println(mode);
		}
		else if(mode.equals("qna")) {
			System.out.println(mode);
		}
		
		//관리자 페이지의 회원 목록에서 회원 상세 보기
		if(mode.equals("adminview")) {
			MemberDTO dto = dao.getMemberById(id);
			
			request.setAttribute("dto", dto);
			request.getRequestDispatcher("/Member/MemberListView.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("adminpage doPost()");
	}

}
