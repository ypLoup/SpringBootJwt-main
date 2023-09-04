package com.example.jwttest.basDict.service;

import com.example.jwttest.basDict.entity.BasDict;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lpf
 * @since 2023-03-31
 */
public interface IBasDictService extends IService<BasDict> {

    int insert(BasDict basDict);

    List<BasDict> select(String code);

    String uploadFile(MultipartFile multipartFile,int type) throws IOException;;
}
