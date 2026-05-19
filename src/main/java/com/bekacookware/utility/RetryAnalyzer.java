package com.bekacookware.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    ThreadLocal<Integer> count = ThreadLocal.withInitial(() ->0);
    private static final int MAX_RETRY_COUNT = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()){
            if (count.get() < MAX_RETRY_COUNT) {
                count.set(count.get()+1);
                return true;
            }
        }
        return false;
    }
}
