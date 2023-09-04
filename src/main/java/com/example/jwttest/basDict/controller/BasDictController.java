package com.example.jwttest.basDict.controller;



import com.example.jwttest.api.CommonResult;
import com.example.jwttest.basDict.entity.BasDict;
import com.example.jwttest.basDict.service.IBasDictService;
import com.example.jwttest.user.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lpf
 * @since 2023-03-31
 */
@RestController
@RequestMapping("/basDict")
public class BasDictController {

    @Resource
    IBasDictService basDictService;

    /**
     * 新增数据字典
     * @param basDict
     * @return
     */
    @PostMapping("/insert")
    public CommonResult insertBasDict(BasDict basDict) {
        int result = basDictService.insert(basDict);
        if (result == -1) {
            return CommonResult.failed("添加失败，信息已存在！");
        }
        return CommonResult.success("添加成功");
    }



    @PostMapping("/selectByCode")
    public CommonResult select(String code) {
        List<BasDict> basDictList = basDictService.select(code);
        return CommonResult.success(basDictList);
    }


    /**
     * 上传文件
     * @param file
     * @return
     */
    @PostMapping("/uploadFile")
    public CommonResult uploadFile(@RequestParam("file") MultipartFile[] file,int type ) throws IOException {
        List<String>urlList= new ArrayList<>();
        for(int i=0;i<file.length;i++){
            Boolean a=verificationPicFile(file[i]);
            String b=verificationPicFile2(file[i]);
            if(a==true&&b.equals("000000")==false){
                String imageUrl=basDictService.uploadFile(file[i],type);
                urlList.add(imageUrl);
                return CommonResult.success(urlList);
            }else{
                return CommonResult.failed("请上传正确图片类型文件！");
            }

        }

        return null;
    }

    private String verificationPicFile2(MultipartFile multipartFile) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        byte [] src=multipartFile.getBytes();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        String xxx= stringBuilder.toString().toUpperCase().substring(0,6);
        String type=checkImgType(xxx);
        return type;
    }

    private String checkImgType(String xxx) {
        switch (xxx) {
            case "FFD8FF": return "jpg";
            case "89504E": return "png";
            default: return "000000";
        }
    }

    private Boolean verificationPicFile(MultipartFile multipartFile) {
        Boolean A =false;
        String name= multipartFile.getOriginalFilename();
        String type =name.substring(name.indexOf(".")).toUpperCase();
        if(type.equals(".PNG")||type.equals(".JPG")||type.equals(".JPEG")){
            A=true;
        }
        //System.out.println(name);
        return A;
    }

}

