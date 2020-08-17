package com.zcy.spring.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

@Controller
public class FileController {
    @RequestMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(String fileName, List<MultipartFile> fileUploads, HttpServletRequest request) {
        //循环遍历上传的文件，保存到本地
        for (MultipartFile multipartFile : fileUploads) {
            if (multipartFile.isEmpty()) {
                continue;
            }

            String filePath = request.getServletContext().getRealPath("/fileLoad/");
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }


            //设置此处文件名 + UUID(随机数) ,为了让文件不重名
            String saveFileName = fileName + "-" + UUID.randomUUID() + multipartFile.getOriginalFilename();

            try {
                //将上传的文件保存
                multipartFile.transferTo(new File(filePath + saveFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "ok";
    }

    @RequestMapping("/downloadFile")
    public ResponseEntity<byte[]> downloadFile(String name, HttpServletRequest request) throws Exception {
        String filePath = "F://tmpTest/" + name;
        HttpHeaders httpHeaders = new HttpHeaders();

        //浏览器下载的名字  指定下载的名字  如果是中文文件名需要重新编码
        httpHeaders.setContentDispositionFormData("attachment", getFilename(request,name));

        //以流的形式进行传输
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<>(FileUtils.readFileToByteArray(new File(filePath)), httpHeaders, HttpStatus.OK);

    }


    /**
     * 根据浏览器的不同进行编码设置，返回编码后的文件名
     * */
    public String getFilename(HttpServletRequest request, String filename) throws Exception {
        // IE不同版本User-Agent中出现的关键词
        String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};
        // 获取请求头代理信息
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : IEBrowserKeyWords) {
            if (userAgent.contains(keyWord)) {
                //IE内核浏览器，统一为UTF-8编码显示
                return URLEncoder.encode(filename, "UTF-8");
            }
        }
        //火狐等其它浏览器统一为ISO-8859-1编码显示
        return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
    }

}
