package org.listners;

import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    private static String getMethodName(ITestResult result) {
        return result.getMethod().getMethodName();
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("This will be getting called on before suit level");
    }
}
