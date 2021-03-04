package me.sup2is.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.sup2is.domain.Member;
import me.sup2is.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.zip.DataFormatException;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

//    @Transactional
    @Transactional(rollbackFor = DataFormatException.class)
    public void saveAll(List<Member> members) throws Exception {
        for (Member member : members) {
//            validUsernameThrowRuntimeException(member.getName());
//            validUsernameTryCatchRuntimeException(member.getName());
            validUsernameThrowDataFormatException(member.getName());
            memberRepository.save(member);
        }
    }

    private void validUsernameThrowRuntimeException(String name) {
        if(!name.startsWith("#")) {
            throw new RuntimeException(); //UnChecked Exception
        }
    }

    private void validUsernameTryCatchRuntimeException(String name) {
        if(!name.startsWith("#")) {
            try {
                throw new RuntimeException(); //UnChecked Exception
            }catch (RuntimeException e) {
                e.printStackTrace(); //예외를 복구할것으로 예측할 수 있음
            }
        }
    }

    private void validUsernameThrowDataFormatException(String name) throws DataFormatException {
        if(!name.startsWith("#")) {
            throw new DataFormatException(); //Checked Exception
        }
    }
}
