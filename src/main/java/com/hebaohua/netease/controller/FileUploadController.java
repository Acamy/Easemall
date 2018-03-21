package com.hebaohua.netease.controller;

import com.hebaohua.netease.util.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Hebh
 * @date 2018/3/21
 * @description:
 */
@Controller
public class FileUploadController {
    @RequestMapping(value = "/uploadFile", headers = "content-type=multipart/*", method = RequestMethod.POST)
    public void uploadFile(@RequestParam(value = "fileinfo", required = false) MultipartFile file, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        //上传文件的路径
        String path = FileUploadUtil.getFileInfo(request, response, file);
        System.out.println(path);
        map.addAttribute("result", true);
        map.addAttribute("code", 200);
    }
}