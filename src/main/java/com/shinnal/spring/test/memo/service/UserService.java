package com.shinnal.spring.test.memo.service;

import org.springframework.stereotype.Service;

import com.shinnal.spring.test.memo.common.MDSHashingEncoder;
import com.shinnal.spring.test.memo.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	// 다른 생산자가 없이 autowired를 위한 생산자가 있는 경우는 @Autowired 생략가능
//	@Autowired
	public UserService(UserRepository userRepository) { // 사용성의 폭이 넓어짐. 생산자를 전달받아 사용
		this.userRepository = userRepository;
	}
	
	public boolean addUser(
			String loginId
			, String password
			, String name
			, String email) {
		
		// 비밀 번호 암호화는 Service에서
		
		// MDSHashingEncoder encoder = new MDSHashingEncoder();
		
		String encyptPassword = MDSHashingEncoder.encode(password);
		
		int count = userRepository.insertUser(loginId, password, name, email);
		
		if(count == 1) {
			return true;
		} else {
			return false;
		}
		
	}

}
