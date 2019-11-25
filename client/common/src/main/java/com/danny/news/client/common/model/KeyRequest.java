package com.danny.news.client.common.model;

import javax.validation.constraints.NotNull;

/**
 * 私钥输入参数（其实就是客户端通过服务端返回的公钥加密后的客户端自己生成的公钥）
 *
 * @author huyuyang
 * @email yuyang.hu@opay-inc.com
 * @date 2019/11/21下午10:14
 */
public class KeyRequest {
    /**
     * 客户端自己生成的加密后公钥
     */
    @NotNull
    private String clientEncryptPublicKey;

    public String getClientEncryptPublicKey() {
        return clientEncryptPublicKey;
    }

    public void setClientEncryptPublicKey(String clientEncryptPublicKey) {
        this.clientEncryptPublicKey = clientEncryptPublicKey;
    }
}
