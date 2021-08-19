package com.example.demo.Controller;

import com.example.demo.Service.UserService;
import com.example.demo.domain.TbUser;
import com.example.demo.mapper.TbUserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;


import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class MyController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String index() {
        List<TbUser> list = new ArrayList<TbUser>();
        list = userService.findAll();
        for(TbUser i : list){
            System.out.println(i.getUserName());
        }
        return "fileUpload";
    }

    @RequestMapping("/todownload")
    public String todownload() {
        return "fileDownload";
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam("myfile") List<MultipartFile> multipartFiles) throws IOException {


        String filePath = "E:\\FileTestDown\\";
        for (int i = 0; i < multipartFiles.size(); i++) {

            File targetFile = new File(filePath, UUID.randomUUID() + multipartFiles.get(i).getOriginalFilename());
            multipartFiles.get(i).transferTo(targetFile);

        }

        return "redirect:/file/index";
    }

    @RequestMapping("/download")
    public String download(@RequestParam("fileName") String filename) throws IOException {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = requestAttributes.getResponse();
        // 设置信息给客户端不解析
        String type = new MimetypesFileTypeMap().getContentType(filename);
        // 设置contenttype，即告诉客户端所发送的数据属于什么类型
        response.setHeader("Content-type", type);
        // 设置编码
        String code = new String(filename.getBytes("utf-8"), "iso-8859-1");
        // 设置扩展头，当Content-Type 的类型为要下载的类型时 , 这个信息头会告诉浏览器这个文件的名字和类型。
        response.setHeader("Content-Disposition", "attachment;filename=" + code);
        // 发送给客户端的数据
        OutputStream outputStream = response.getOutputStream();
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        // 读取filename
        bis = new BufferedInputStream(new FileInputStream(new File("E:\\FileTestDown\\" + filename)));
        //将bis输入流传进buff中，buff一次接受1024bytes，128个字节
        int i = bis.read(buff);
        while (i != -1) {
            outputStream.write(buff, 0, buff.length);
            outputStream.flush();
            i = bis.read(buff);
        }
        return "redirect:/file/index";
    }


}
