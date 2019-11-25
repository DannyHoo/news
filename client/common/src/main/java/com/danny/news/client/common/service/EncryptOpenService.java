package com.danny.news.client.common.service;

import com.danny.news.client.common.model.KeyRequest;
import com.danny.news.client.common.model.KeyResponse;
import com.danny.news.client.common.model.RSAResponse;
import com.danny.news.client.common.model.Result;

/**
 * API传输加解密相关接口
 * @author huyuyang
 * @email yuyang.hu@opay-inc.com
 * @date 2019/11/21下午10:17
 */
public interface EncryptOpenService {
    /**
     * 生成RSA公私钥
     * @return
     */
    Result<RSAResponse> getRSA();    /**
     * 获得加解密用的密钥
     * @param request
     * @return
     */
    Result<KeyResponse> getKey(KeyRequest request) throws Exception;
}
