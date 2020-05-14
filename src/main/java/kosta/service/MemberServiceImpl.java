package kosta.service;

import org.springframework.stereotype.Service;

@Service("service")
public class MemberServiceImpl implements MemberService {

	@Override
	public void register(int no, String name) throws Exception {
		System.out.println("MemberServiceImpl의 register(int no, String name) 호출됨");
		if(no==0) throw new Exception("예외가 발생했어요.");
	}

	@Override
	public boolean update(String id) {
		System.out.println("MemberServiceImpl의 update(String id) 호출됨");
		return false;
	}

}
