package com.coldgeon.coldgeon1st.service;

import com.coldgeon.coldgeon1st.domain.User;
import com.coldgeon.coldgeon1st.dto.AddUserRequest;
import com.coldgeon.coldgeon1st.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest addUserRequest) {
        return userRepository.save(User.builder()
                .email(addUserRequest.getEmail())
                //패스워드 암호화
                .password(bCryptPasswordEncoder.encode(addUserRequest.getPassword()))
                .build()).getId();
    }
}
