package com.danny.news.mock.feign.callback;

import com.alibaba.fastjson.JSONObject;
import com.danny.news.mock.feign.MockFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author huyuyang
 * @email yuyang.hu@opay-inc.com
 * @date 2019/11/23下午10:19
 */
@Component
public class MockFeignFactory implements MockFeignClient {

    @Override
    public JSONObject getOpayUserInfo(String token) {
        return null;
    }

    @Override
    public JSONObject queryBvnInfo(String json) {
        return null;
    }
}
