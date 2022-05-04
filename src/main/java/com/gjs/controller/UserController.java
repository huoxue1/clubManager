package com.gjs.controller;

import com.gjs.entity.User;
import com.gjs.exception.H;
import com.gjs.exception.exceptionImpl.CustomException;
import com.gjs.service.UserService;
import com.gjs.utils.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import com.gjs.utils.*;
import java.util.UUID;

/**
 * 用户信息(User)表控制层
 *
 * @author makejava
 * @since 2021-11-01 14:49:33
 */
@RestController
@Slf4j
@RequestMapping("user")
public class UserController {

    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @Value(value = "${file.upload}")
    String uploadPath;


    @PostMapping(value = "/get_login_info")
    public ResponseEntity<User> GetLoginInfo(HttpServletRequest request){
        String token = request.getHeader("Authorization").split(" ")[1];
        Integer userId = Token.decode(token);
        User user = userService.queryById(userId);
        user.setPassword("");
        return ResponseEntity.ok(user);
    }

    /**
     *
     * 头像上传接口
     *
     * @param file 上传头像
     * @param request servlet对象，自动注入
     * @return
     */
    @RequestMapping(value = "/upload")
    public ResponseEntity<H> UploadFile(@RequestParam("file")MultipartFile file, HttpServletRequest request) {
        String token = request.getHeader("Authorization").split(" ")[1];
        Integer userId = Token.decode(token);

        File dir = new File(uploadPath+"/user/");

        if (!dir.exists()){
            dir.mkdirs();
        }
        log.debug(dir.getAbsolutePath());
        String originalFilename = file.getOriginalFilename();
        int beginIndex = originalFilename.lastIndexOf(".");
        String suffix ="";
        if(beginIndex!=-1) {
            suffix = originalFilename.substring(beginIndex);
        }
        String filename = UUID.randomUUID() +suffix;

        File dest = new File(dir, filename);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new CustomException(1401,e.getMessage());
        }


        User user = userService.queryById(userId);
        user.setUserAvatar(filename);
        userService.update(user);
        return ResponseEntity.ok(H.success(user));
    }


    @GetMapping(value = "/get_avatar/{userId}")
    public ResponseEntity<String> getAvatar(@PathVariable Integer userId){
        User user = userService.queryById(userId);
        String s = Image.convertFileToBase64(uploadPath + "/user/" + user.getUserAvatar());
        return ResponseEntity.ok("data:image/png;base64,"+s);
    }



    @PostMapping(value = "login", produces ="application/json")
    public ResponseEntity<String> Login(HttpServletRequest request, @RequestBody Map<String, String> data){
        String account = data.get("account");
        String password = data.get("password");

        User user = userService.Login(account, password);
        if (null == user){
            return ResponseEntity.badRequest().body("");
        }
        request.getSession(true).setAttribute("userId",user.getUserId());
        return ResponseEntity.ok(Token.encode(user));
    }


    /**
     *
     * 查询所有内容
     *
     */
    @GetMapping("queryAll")
    public ResponseEntity<Page<User>> queryPage(){

        return ResponseEntity.ok(this.userService.queryAll());
    }

    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Integer id) {
        User user = this.userService.queryById(id);
        user.setPassword("");
        return ResponseEntity.ok(user);
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping(value = "/register",produces ="application/json")
    public ResponseEntity<User> add(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<User> edit(User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

}

