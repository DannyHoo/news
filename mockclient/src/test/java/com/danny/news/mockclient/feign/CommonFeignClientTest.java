package com.danny.news.mockclient.feign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.danny.news.framework.util.RsaTool;
import com.danny.news.mockclient.MockClientApplicationTests;
import lombok.Data;
import lombok.experimental.Accessors;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author huyuyang
 * @email yuyang.hu@opay-inc.com
 * @date 2019/11/25下午2:04
 */
public class CommonFeignClientTest extends MockClientApplicationTests {

    @Autowired
    private CommonFeignClient commonFeignClient;

    @Test
    public void getRSATest() {
        System.out.println(getRSA().toJSONString());
    }

    private JSONObject getRSA() {
        JSONObject jsonObject = commonFeignClient.getRSA();
        return jsonObject;
    }

    @Test
    public void getKeyTest() throws Exception {
        //获得服务端公钥
        JSONObject rsa = getRSA();
        String serverPublicKey = ((Map) rsa.get("data")).get("serverPublicKey").toString();

        //客户端公私钥
        String clientPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCLNbmKl9/gLn7Bef/xtUkshC1WyrLZLRpXCcFYR1gQi0isWsZBTicC4efBOkkNG3r+1ue0gvtuU/tjREFGf4Y7HaKHGb5tNCOlMNeNjM5YLRwLFqrUSsQyD4rj4eua1ltearr24R0HilnTvnQm6Z/UY0s21vdOUFQBPY0GNAa+0wIDAQAB";
        String clientPrivateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIs1uYqX3+AufsF5//G1SSyELVbKstktGlcJwVhHWBCLSKxaxkFOJwLh58E6SQ0bev7W57SC+25T+2NEQUZ/hjsdoocZvm00I6Uw142MzlgtHAsWqtRKxDIPiuPh65rWW15quvbhHQeKWdO+dCbpn9RjSzbW905QVAE9jQY0Br7TAgMBAAECgYBcYhbzpr5no/Nyqmf0G/6nkEAWbQYrogbs5AhvcUk8EXL1DnirNhYlj42hafC4xhflrvCtlo8NNKaLxewbwN1uuzG8A2jd+ROEXlx5HDh2ZluhtHzL/SmNcJXo684xAl2pCNVBjDcW48PcIBijke/sTVHTDsDCukLKDPUOM/mKIQJBAL96k4+jBscazsJiuZ6C3RFDVtRRDpf1dMgLgxcx63bAXkA2Arau0J49IAYmSVJoDXqDoJKWdXJVh9vHSkhN/48CQQC6Hk1/G0Y0nOylf6NOp0oMgc0A+etnwxHKqwtctPKjEYcJx2fzALzTtCoySLYXX7gLnPIQXpQBTUysG5skBKp9AkEAiSQm6fqu0Q4fRlRlc+VwpnufhgPkOuw/z0OHiaZkajJPjxfgC63bl2paNG1ZmJ8UAEqkSDlhNxmRa9UqG+1ZewJASaQxz6gwCCNLM1SkfjuM/hPh1JAOh9jUUleJQF5MXx9RSho/VBQnorB3vbutaOQzw0yPLtDtSPKX8sVdhkveVQJAIDsJP5X8Tey6zXTUISor7PF0TSiKdE4k0IwKoy9y8HmQ+AU8+xyr/iOt5lvaGxKlBK8N/7yCw5H4qHnJaHT+Bg==";

        String encryptData = RsaTool.encryptByPublicKey(clientPublicKey,serverPublicKey);
        System.out.println("加密后：" + encryptData);

        JSONObject jsonObject = commonFeignClient.getKey(new KeyRequest().setClientEncryptPublicKey(encryptData));
        String encryptKey=((Map)jsonObject.get("data")).get("key").toString();
        System.out.println("key:"+encryptKey);
        String key= RsaTool.decryptByPrivateKey(encryptKey,clientPrivateKey);
        System.out.println("key:"+key);

    }


    @Data
    @Accessors(chain = true)
    static class KeyRequest {
        private String clientEncryptPublicKey;
    }
}
