package boardTest;

import java.util.ArrayList;
import java.util.List;

import Common.JDBConnect;

public class BoardDAO extends JDBConnect{

	// 1. 답글 작성
	// => 최신 답글이 제일 위로 올라옴
	public int insertAns(BoardDTO dto) {
		int res = 0;
		String user_id = "admin";

		try {
			// 1) 답글의 b_id 설정
			int ans_b_id = 0;
			String query = "select max(b_id) as b_id from board";
			pstmt= conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				ans_b_id = rs.getInt("b_id") + 1;
			}

			// 2)
			int ans_re_ref = dto.getRe_ref();	
			int re_level = dto.getRe_level();
			int re_seq = dto.getRe_seq();

			// 3) 답글의 re_seq 설정
			// 부모글의 re_level, re_seq 상속 받은 상태에서 
			// 같은 re_ref 가운데에서 부모글의 re_seq보다 큰 re_seq를 가진 행들의 re_seq 값들을
			// +1 증가시키면 새로 작성된 답글의 re_seq는 부모글 다음으로 re_seq가 작은 값을 가지게 된다

			query = "update board set re_seq = re_seq + 1"
					+ " where re_ref = ? and re_seq > ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ans_re_ref);
			pstmt.setInt(2, re_seq);
			pstmt.setInt(3, dto.getB_id());
			pstmt.executeUpdate();

			// 4) 답글 추가!
			query = "insert into board(b_id, user_id, title, content, type,"
					+ " re_ref, re_level, re_seq)"
					+ " values(?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ans_b_id);
			pstmt.setString(2, user_id);
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getType());
			pstmt.setInt(6, ans_re_ref);
			pstmt.setInt(7, re_level + 1);
			pstmt.setInt(8, re_seq + 1);
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	// 2. 답글 작성
	// => 입력한 순서대로 보이도록 
	public int insertAns2(BoardDTO dto) {
		int res = 0;
		String user_id = "admin";

		try {
			// 1) 답글의 b_id 설정
			int ans_b_id = 0;
			String query = "select max(b_id) as b_id from board";
			pstmt= conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				ans_b_id = rs.getInt("b_id") + 1;
			}

			// 2)
			int ans_re_ref = dto.getRe_ref();	
			int re_level = dto.getRe_level();
			int re_seq = dto.getRe_seq();

			// 3) 답글의 re_seq 설정
			// 부모글의 re_level, re_seq 상속 받은 상태에서 
			// 같은 re_ref 가운데에서 부모글의 re_seq보다 큰 re_seq를 가진 행들의 re_seq 값들을
			// +1 증가시키면 새로 작성된 답글의 re_seq는 부모글 다음으로 re_seq가 작은 값을 가지게 된다

			query = "update board set re_seq = re_seq + 1"
					+ " where re_ref = ? and re_seq > ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ans_re_ref);
			pstmt.setInt(2, re_seq);
			pstmt.setInt(3, dto.getB_id());
			pstmt.executeUpdate();

			// 4) 답글 추가!
			query = "insert into board(b_id, user_id, title, content, type,"
					+ " re_ref, re_level, re_seq)"
					+ " values(?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ans_b_id);
			pstmt.setString(2, user_id);
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getType());
			pstmt.setInt(6, ans_re_ref);
			pstmt.setInt(7, re_level + 1);
			pstmt.setInt(8, re_seq + 1);
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}


	public List<BoardDTO> selectList(){
		List<BoardDTO> boards = new ArrayList<BoardDTO>();
		int min = 0;
		int max = 0;

		try {

			String query = "select * from board ";
			query += " order by re_ref desc, re_seq asc";

			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while(rs.next()){
				BoardDTO dto = new BoardDTO();
				dto.setB_id(rs.getInt("b_id"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setVisitcount(rs.getInt("visitcount"));
				dto.setType(rs.getString("type"));
				dto.setRe_ref(rs.getInt("re_ref"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setRe_seq(rs.getInt("re_seq"));

				boards.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boards;
	}

	public BoardDTO viewtList(String n){
		int b_id = Integer.parseInt(n);
		BoardDTO dto = new BoardDTO();

		try {
			String query = "select * from board where b_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b_id);
			rs = pstmt.executeQuery();

			if(rs.next()){
				dto.setB_id(rs.getInt("b_id"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setVisitcount(rs.getInt("visitcount"));
				dto.setType(rs.getString("type"));
				dto.setRe_ref(rs.getInt("re_ref"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setRe_seq(rs.getInt("re_seq"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

}
