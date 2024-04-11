package com.example.pius_project.feign;

import com.example.pius_project.dto.StoreRecordDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "storeRecord", url = "${history.service.url}")
public interface StoreRecordClient {
    @RequestMapping(method = RequestMethod.POST)
    void storeRecord(@RequestBody StoreRecordDto body, @RequestHeader(name = "user-id") long userId);
}


