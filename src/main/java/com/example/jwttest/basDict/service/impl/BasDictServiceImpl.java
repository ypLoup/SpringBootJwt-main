package com.example.jwttest.basDict.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectList;
import com.example.jwttest.basDict.entity.BasDict;
import com.example.jwttest.basDict.mapper.BasDictMapper;
import com.example.jwttest.basDict.service.IBasDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lpf
 * @since 2023-03-31
 */
@Service
public class BasDictServiceImpl extends ServiceImpl<BasDictMapper, BasDict> implements IBasDictService {

    @Override
    public int insert(BasDict basDict) {
        if (query().eq("name", basDict.getName()).eq("code",basDict.getCode()).eq("status",basDict.getStatus()).one() != null) {
            return -1;//已注册
        }
        save(basDict);
        return 0;

    }

    @Override
    public List<BasDict> select(String code) {
        QueryWrapper<BasDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code",code);
        queryWrapper.eq("status",1);
        return list(queryWrapper);

    }

    @Override
    public String uploadFile(MultipartFile multipartFile,int type) throws IOException {
        String PluploadFileName = multipartFile.getOriginalFilename();
        // 设置上传文件目录
        ResourceBundle res = ResourceBundle.getBundle("application");
        String UploadPath = "";
        if(type==1){
            UploadPath=res.getString("point_uploadFile_url");
        }else{
            UploadPath=res.getString("device_uploadFile_url");
        }

        //String UploadPath = "/home/jgkj/Projects/platform_6900/app/image/register_face_image/";
        String dataDir=endFileDir()+"/";
        File _UploadFile = new File(UploadPath+dataDir, PluploadFileName);
        if (!_UploadFile.isDirectory()) {
            _UploadFile.mkdirs();
        }
        multipartFile.transferTo(_UploadFile);
        return UploadPath+dataDir+PluploadFileName;
    }



    public static String endFileDir () {
        Date date = new Date(System. currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd" );
        String str = sdf.format(date).toString();
        return str;
    }
}
