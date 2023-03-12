package membership;

import java.util.List;

public interface MemberService {	
	// 1. member 하나 찾기 혹은 찾는 member 존재 여부 
	// => id로 찾기 / id + pass로 찾기 / id + 질문 + 답변
	public MemberDTO selectMember(String id);
	public MemberDTO selectMember(String id, String pass);
	public boolean selectMember(String id, String ask, String answer);
	
	//  2. member 추가
	public int insertMember();
	
	//  3. member 정보 수정 
	// => id, pass로 비밀번호만 변경 / 전체 정보 수정
	public int updateMember(String id, String pass);
	public int updateMember(MemberDTO dto);
	
	//  4. member 삭제
	public int deleteMember();
	
	//  5. 전체 member 조회
	public List<MemberDTO> selectMember();
	
	//  6. 전체 member 몇명인지
	public int countMember();
	
	//  7. member 별 리뷰 개수 확인 => id로 확인
	public int countReview(String id);
}
