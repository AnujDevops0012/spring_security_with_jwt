package com.springJwt.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api")
public class OtpController {

    @PostMapping("/send-otp")
    public int sendOtp(@RequestParam String number )
    {
        System.out.println("This is the number  "+number);
        String myUrl="https://www.fast2sms.com/dev/bulkV2?authorization=x62HVEfq9GoSK3bRpATCPUNjYudgyztseIOZFh50LrkmQ8nW4vLxadX583sofEvGV6rjFYW9SJzZTnDB&variables_values=1233&route=otp&numbers="+number;
        System.out.println("MyURL is ---> "+myUrl);
        try {
            URL url=new URL(myUrl);
            HttpURLConnection con=(HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent","Mozilla/5.0");
            con.setRequestProperty("cache-control", "no-cache");
            int code=con.getResponseCode();
            System.out.println("response Code is  ="+code);


            return  code;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
//        URL url=new URL(myUrl);
//        HttpResponse response = .get(myUrl)
//            .header("cache-control", "no-cache")
//            .asString();
//        return  null;
        return 0;
    }
}
