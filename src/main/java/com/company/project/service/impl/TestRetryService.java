package com.company.project.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Slf4j
@Service
public class TestRetryService {
    @Retryable(value = IOException.class)
    public boolean testRrety() throws IOException {
        log.info("--开始---");
        throw new IOException("出现异常");
    }

    @Recover
    public boolean reciver(IOException e) {
        log.warn("出现异常，返回默认值");
        return false;
    }
}
