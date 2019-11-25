package com.danny.news.client.common.controller;

import com.danny.news.client.common.model.KeyRequest;
import com.danny.news.client.common.model.KeyResponse;
import com.danny.news.client.common.model.RSAResponse;
import com.danny.news.client.common.model.Result;
import com.danny.news.client.common.service.EncryptOpenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author huyuyang
 * @email yuyang.hu@opay-inc.com
 * @date 2019/11/21下午10:35
 */
@RestController
@RequestMapping("open/encrypt")
public class EncryptController {

    @Autowired
    private EncryptOpenService encryptOpenService;

    @RequestMapping(value = "getRSA", method = RequestMethod.POST)    //@DisabledEncrypt
    public Result<RSAResponse> getRSA() {
        return encryptOpenService.getRSA();
    }

    @RequestMapping(value = "getKey", method = RequestMethod.POST)    //@DisabledEncrypt
    public Result<KeyResponse> getKey(@Valid @RequestBody KeyRequest request) throws Exception {
        return encryptOpenService.getKey(request);
    }


}
