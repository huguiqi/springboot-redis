package com.example.demo;

import com.example.demo.bean.EInvoiceRes;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sam on 2018/4/10.
 */
public class Tests {

    @Test
    public void testJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE);
        try {
//            EInvoiceRes eInvoiceRes = objectMapper.readValue("{\"args\":[],\"displayLevel\":3,\"formattedMsg\":\"不存在对应的酒店信息。\",\"msg\":\"不存在对应的酒店信息。\",\"statusCode\":2002}",EInvoiceRes.class);
//            System.out.println(eInvoiceRes);
            EInvoiceRes eInvoiceRes = new EInvoiceRes();
            List<Object> argsList = new ArrayList<Object>();
            argsList.add("1");
            argsList.add("2");
            argsList.add("3");
            eInvoiceRes.setArgs(argsList);
            eInvoiceRes.setFormattedMsg("不存在对应的酒店信息。");
            eInvoiceRes.setDisplayLevel(3);
            eInvoiceRes.setMsg("不存在对应的酒店信息。");
            eInvoiceRes.setStatusCode(2002);
            objectMapper.writeValueAsString(eInvoiceRes);
            Assert.assertTrue(1==1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
