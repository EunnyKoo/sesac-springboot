package com.sesac.sesacspring.mybatis.service;


import com.sesac.sesacspring.mybatis.domain.User;
import com.sesac.sesacspring.mybatis.dto.UserDTO;
import com.sesac.sesacspring.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    // UserMapper 호출
    // 1. 생성자 사용
//    private final UserMapper userMapper;
//    public UserService(UserMapper userMapper){
//        this.userMapper = userMapper;
//    }

    // 2. @Autowired 사용
    @Autowired
    UserMapper userMapper;

    public List<UserDTO> retrieveAll(){
        // controller에서 호출하는 메소드
        // usermapper의 retrieveAll()을 실행한 후 받아온 List<User>
        // List<UserDTO>에 담아서 반환

        List<User> users = userMapper.retreiveAll();
        List<UserDTO> result = new ArrayList<>();

        // for문을 이용해 List<User> => List<UserDTO>
        for(User user : users){
            UserDTO userDTO = new UserDTO();
            userDTO.setName(user.getName());
            userDTO.setNickname(user.getNickname());

            result.add(userDTO);
        }

        return result;

        // 전체 동작 흐름
        // 1) userService.retrieveAll()에서 의존성을 주입받은 userMapper.retrieveAll() 호출
        // 2) userMapper interface 파일에서 xml파일 확인 필요 여부 체크
        // 3) 정의된 mapper 폴더(application.properties에서 정의)에서 namespace가 UserMapper인 xml 검색
        // 4) id가 retrieveAll인 태그를 찾고 그 안의 sql문을 실행
        // 5) 실행 결과를 resultType에 정의된 객체에 매핑해서 반환
    }

    public void createUser(String name, String nickname) {
        userMapper.createUser(name, nickname);
    }

    public void updateUser(int id, String nickname) {
        userMapper.updateUser(id, nickname);
    }

    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }
}
