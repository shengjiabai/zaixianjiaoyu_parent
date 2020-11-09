package com.atguigu.ossservice.clienttest;

import com.atguigu.util.R;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "service-vod")
public interface DueContrroer {
    

    @GetMapping("/vodservice/video/test/{Ids}")
    public R test(@ApiParam(name = "Ids", value = "云端视频IDS", required = true) @PathVariable String Ids);
    
}
