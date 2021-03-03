package me.sup2is.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import me.sup2is.domain.Member;
import me.sup2is.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.zip.DataFormatException;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final MemberRepository memberRepository;

    public void doSomething1(){
//        throw new DataFormatException();
    }

    public void doSomething2(){
        throw new NullPointerException();
    }

    public void doSomething3(){
        throw new AssertionError();
    }




}
