package com.gjs.controller;

import com.gjs.entity.Club;
import com.gjs.entity.User;
import com.gjs.exception.H;
import com.gjs.exception.exceptionImpl.CustomException;
import com.gjs.service.ClubService;
import com.gjs.utils.Image;
import com.gjs.utils.Token;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 社团(Club)表控制层
 *
 * @author makejava
 * @since 2021-11-01 14:48:20
 */
@RestController
@RequestMapping("club")
public class ClubController {
    /**
     * 服务对象
     */
    @Resource
    private ClubService clubService;

    @Value(value = "${file.upload}")
    String uploadPath;



    @GetMapping("/query_manager_clubs/{userId}")
    public ResponseEntity<List<Club>> queryManagerClubs(@PathVariable("userId") Integer userId){
        return ResponseEntity.ok(clubService.queryManagerClubs(userId));
    }


    /**
     * 分页查询
     *
     * @param club        筛选条件
     * @param size 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Club>> queryByPage(Club club, int page,int size) {
        return ResponseEntity.ok(this.clubService.queryByPage(club, PageRequest.of(page,size)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Club> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.clubService.queryById(id));
    }


    @PostMapping(value = "/queryByState/{state}")
    public ResponseEntity<List<Club>> queryByState(@PathVariable Integer state){
        return ResponseEntity.ok(clubService.queryByState(state));
    }


    /**
     * 新增数据
     *
     * @param club 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Club> add(@RequestBody Club club) {
        club.setCreateTime(System.currentTimeMillis());
        club.setState(0);
        File dir = new File(uploadPath+"/club/");

        if (!dir.exists()){
            dir.mkdirs();
        }
        String filename = UUID.randomUUID() +".png";
        Image.convertBase64ToFile(club.getClubAvatar(),dir.getAbsolutePath(),filename);
        club.setClubAvatar(filename);
        return ResponseEntity.ok(this.clubService.insert(club));
    }


    /**
     *
     * @param clubId 社团id
     * @return 头像
     */
    @GetMapping(value = "/get_avatar/{clubId}")
    public ResponseEntity<String> getAvatar(@PathVariable Integer clubId){
        Club club = clubService.queryById(clubId);
        String s = Image.convertFileToBase64(uploadPath + "/club/" + club.getClubAvatar());
        return ResponseEntity.ok("data:image/png;base64,"+s);
    }


    /**
     * 编辑数据
     *
     * @param club 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Club> edit(@RequestBody Club club) {
        return ResponseEntity.ok(this.clubService.update(club));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.clubService.deleteById(id));
    }

}

