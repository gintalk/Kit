package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 14/10/2022
 */

import com.vng.zing.media.commonlib.helper.JsoniterHelper;
import com.vng.zing.media.mp3.commonlib.util.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class SeleniumTest extends Test {

    private static final String BASE_URL = "https://beta.nhaccuatui.com";

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Nang kieu", "/bai-hat/nang-kieu-nal-ft-ryot.DsSPWrHdPOoR.html");
//        map.put("Chap va", "/bai-hat/chap-va-huong-ly.uWdOEfNVkqsC.html");
//        map.put("Dieu dang do ngot ngao", "/bai-hat/dieu-dang-do-ngot-ngao-huong-duong-nguoc-nang-p2-ost-huong-ly.jYCAhECuMjbK.html");

        WebDriver driver = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (driver == null) {
                driver = BrowserUtils.openBrowser(BASE_URL + entry.getValue(), BrowserUtils.Browser.CHROME, false, true, true);
            } else {
                driver = BrowserUtils.openBrowser(driver, BASE_URL + entry.getValue(), BrowserUtils.Browser.CHROME, false, true, true);
            }

            driver.manage().window().maximize();
            System.out.println(driver.getCurrentUrl());
        }

//        driver.close();
//        driver.quit();

        System.exit(0);
    }

    private static JsoniterHelper getAttributes(WebDriver driver, WebElement element) {
        Object elementAttributes = ((JavascriptExecutor) driver).executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return JSON.stringify(items);", element);

        return JsoniterHelper.build(elementAttributes.toString());
    }
}
