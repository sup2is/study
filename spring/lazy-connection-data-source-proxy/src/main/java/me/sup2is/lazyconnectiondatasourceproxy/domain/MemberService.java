package me.sup2is.lazyconnectiondatasourceproxy.domain;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    @Transactional
    public void create(Member member) {
//        repository.save(member);
        printConnectionStatus();
    }

//    private final DataSource dataSource;
//
//    private void printConnectionStatus() {
//        final HikariPoolMXBean hikariPoolMXBean = ((HikariDataSource)dataSource).getHikariPoolMXBean();
//        System.out.println("################################");
//        System.out.println("현재 active인 connection의 수 : " + hikariPoolMXBean.getActiveConnections());
//        System.out.println("현재 idle인 connection의 수 : " + hikariPoolMXBean.getIdleConnections());
//        System.out.println("################################");
//    }

    private final LazyConnectionDataSourceProxy lazyConnectionDataSourceProxy;

    private void printConnectionStatus() {
        final HikariPoolMXBean hikariPoolMXBean = ((HikariDataSource)lazyConnectionDataSourceProxy.getTargetDataSource()).getHikariPoolMXBean();
        System.out.println("################################");
        System.out.println("현재 active인 connection의 수 : " + hikariPoolMXBean.getActiveConnections());
        System.out.println("현재 idle인 connection의 수 : " + hikariPoolMXBean.getIdleConnections());
        System.out.println("################################");
    }

}
