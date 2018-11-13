package com.web.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * 사용되는 캐시가 무엇인지 로그에 찍기 위한 용도
 *
 * CommandLineRunner 인터페이스를 구현하여 이스턴스가 만들어질 때 run 메소드가 무조건 실행이 되도록 설정함.
 * 테스트를 위한 용도이며 상용 서비스에는 테스트 후 아래 빈이 DI 되지 않도록 변경 필요
 */
@Component
public class CacheManagerCheck implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CacheManagerCheck.class);

    private final CacheManager cacheManager;

    public CacheManagerCheck(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("\n\n" + "=========================================================\n"
                + "Using cache manager: " + this.cacheManager.getClass().getName() + "\n"
                + "=========================================================\n\n");
    }
}