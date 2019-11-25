package com.danny.news.client.common.service.impl;

import com.danny.news.client.common.model.KeyRequest;
import com.danny.news.client.common.model.KeyResponse;
import com.danny.news.client.common.model.RSAResponse;
import com.danny.news.client.common.model.Result;
import com.danny.news.client.common.util.RSAUtils;
import com.danny.news.client.common.service.EncryptOpenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author huyuyang
 * @email yuyang.hu@opay-inc.com
 * @date 2019/11/21下午10:32
 */
@Service("encryptOpenService")
public class EncryptOpenServiceImpl implements EncryptOpenService {

    @Value("${rsa.publicKey}")
    private String publicKey;
    @Value("${rsa.privateKey}")
    private String privateKey;
    @Value("${api.encrypt.key}")
    private String key;

    @Override
    public Result<RSAResponse> getRSA() {
        RSAResponse response = RSAResponse.options()
                .setServerPublicKey(publicKey)
                .build();
        return Result.buildSuccess(response);
    }

    @Override
    public Result<KeyResponse> getKey(KeyRequest request) throws Exception {
        String clientPublicKey = RSAUtils.privateDecrypt(request.getClientEncryptPublicKey(), RSAUtils.getPrivateKey(privateKey));
        String encryptKey = RSAUtils.publicEncrypt(key, RSAUtils.getPublicKey(clientPublicKey));
        KeyResponse response = KeyResponse.options()
                .setKey(encryptKey)
                .build();
        return Result.buildSuccess(response);
    }
}
