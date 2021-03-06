package com.atguigu.vodservice.controller;

import com.atguigu.util.R;
import com.atguigu.vodservice.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年04月18日
 */
@Api(description = "VOD服务API")
@RestController
@RequestMapping("/vodservice/video")
@CrossOrigin
public class VodController {

    @Autowired
    private VodService vodService;

    //上传视频到阿里云视频点播服务，即上传视频到云端
    @ApiOperation(value = "上传视频到云端")
    @PostMapping("uploadVideo")
    public R uploadVideo(@ApiParam(name = "file", value = "上传的文件") MultipartFile file) {
        String videoId = vodService.uploadVideo(file);//返回视频ID
        return R.ok().data("videoId",videoId);
    }

    //根据阿里云视频点播服务为每一个视频生成的视频ID来删除云端视频，支持删除至少为零个的视频
    @ApiOperation(value = "删除云端视频")
    @DeleteMapping("removeVideo/{videoSourceIds}")
    public R removeVideo(@ApiParam(name = "videoSourceIds", value = "云端视频IDS", required = true) @PathVariable String videoSourceIds){
        vodService.removeVideo(videoSourceIds);
        return R.ok();
    }


    @ApiOperation(value = "测试一个调用")
    @GetMapping("test/{Ids}")
    public R test(@ApiParam(name = "Ids", value = "云端视频IDS", required = true) @PathVariable String Ids){
        return R.ok().data("666","测试一个调用");
    }
}
