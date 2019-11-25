package com.danny.news.mock.feign;

import com.alibaba.fastjson.JSONObject;
import com.danny.news.mock.feign.callback.MockFeignFactory;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author huyuyang
 * @email yuyang.hu@opay-inc.com
 * @date 2019/11/23下午10:15
 */
@FeignClient(name = "mock", url = "${config.opay.host.common}", fallbackFactory = MockFeignFactory.class)
public interface MockFeignClient {

    @PostMapping("/api/users/lookupCurrentUser")
    @Headers({"ContentType:application/json"})
    JSONObject getOpayUserInfo(@RequestHeader("Authorization") String token);

    @PostMapping("/api/users/queryBvnInfo")
    @Headers({"ContentType:application/json"})
    JSONObject queryBvnInfo(String json);
}
