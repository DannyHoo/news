package com.danny.news.client.common.model;

/**
 * RSA生成的公私钥输出参数
 *
 * @author huyuyang
 * @email yuyang.hu@opay-inc.com
 * @date 2019/11/21下午10:15
 */
public class RSAResponse {

    private String serverPublicKey;
    private String serverPrivateKey;

    public static class Builder {
        private String serverPublicKey;
        private String serverPrivateKey;

        public Builder setServerPublicKey(String serverPublicKey) {
            this.serverPublicKey = serverPublicKey;
            return this;
        }

        public Builder setServerPrivateKey(String serverPrivateKey) {
            this.serverPrivateKey = serverPrivateKey;
            return this;
        }

        public RSAResponse build() {
            return new RSAResponse(this);
        }

    }

    public static Builder options() {
        return new Builder();
    }

    public RSAResponse(Builder builder) {
        this.serverPrivateKey = builder.serverPrivateKey;
        this.serverPublicKey = builder.serverPublicKey;
    }

    public String getServerPrivateKey() {
        return serverPrivateKey;
    }

    public String getServerPublicKey() {
        return serverPublicKey;
    }
}
