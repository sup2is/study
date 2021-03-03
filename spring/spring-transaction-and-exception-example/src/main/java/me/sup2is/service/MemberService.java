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

    @Transactional(rollbackFor = DataFormatException.class)
    public void saveAll(List<Member> members) {
        for (Member member : members) {

            if(!member.getName().startsWith("#")) {
                validUsername(member.getName());
            }
            memberRepository.save(member);
        }
    }

    private void validUsername(String name) {
        try {
            if(name.startsWith("#")) {
                throw new DataFormatException();
            }
        } catch (DataFormatException e) {
            e.printStackTrace();
            log.error("사용자 이름 앞에는 #이 반드시 있어야합니다.");
        }
    }


}
