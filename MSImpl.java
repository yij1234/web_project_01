package membership;

import java.util.List;

public class MSImpl implements MemberService{
	
	 MemberDAO dao = new MemberDAO();

	@Override
	public MemberDTO selectMember(String id) {
		return null;
	}

	@Override
	public MemberDTO selectMember(String id, String pass) {
		return null;
	}

	@Override
	public boolean selectMember(String id, String ask, String answer) {
		return false;
	}

	@Override
	public int insertMember() {
		return 0;
	}

	@Override
	public int updateMember(String id, String pass) {
		return 0;
	}

	@Override
	public int updateMember(MemberDTO dto) {
		return 0;
	}

	@Override
	public int deleteMember() {
		return 0;
	}

	@Override
	public List<MemberDTO> selectMember() {
		return null;
	}

	@Override
	public int countMember() {
		return 0;
	}

	@Override
	public int countReview(String id) {
		return 0;
	}
	
}
