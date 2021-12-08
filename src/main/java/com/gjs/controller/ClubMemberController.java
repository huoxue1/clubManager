package com.gjs.controller;

import com.gjs.dao.ClubMemberDao;
import com.gjs.entity.ClubMember;
import com.gjs.service.ClubMemberService;
import com.gjs.utils.Token;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 社团成员记录(ClubMember)表控制层
 *
 * @author makejava
 * @since 2021-11-01 15:24:02
 */
@RestController
@RequestMapping("clubMember")
public class ClubMemberController {
    /**
     * 服务对象
     */
    @Resource
    private ClubMemberService clubMemberService;

    @Resource
    private ClubMemberDao clubMemberDao;

    /**
     * 分页查询
     *
     * @param clubMember 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ClubMember>> queryByPage(ClubMember clubMember) {
        return ResponseEntity.ok(this.clubMemberService.queryByPage(clubMember, PageRequest.of(0,200)));
    }

    /**
     *
     * @param clubId 社团id
     * @param request request对象
     * @return 是否加入社团
     */
    @GetMapping(value = "/is_join_club/{clubId}")
    public ResponseEntity<Boolean> IsJoinClub(@PathVariable Integer clubId, HttpServletRequest request){
        ClubMember clubMember = new ClubMember();
        String token = request.getHeader("Authorization").split(" ")[1];
        Integer userId = Token.decode(token);
        clubMember.setUserId(userId);
        clubMember.setClubId(clubId);
        long count = this.clubMemberDao.count(clubMember);
        return ResponseEntity.ok(count>0);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ClubMember> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.clubMemberService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param clubMember 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ClubMember> add(@RequestBody ClubMember clubMember, HttpServletRequest request) {
        clubMember.setState(0);
        clubMember.setApplyTime(System.currentTimeMillis());
        String token = request.getHeader("Authorization").split(" ")[1];
        Integer userId = Token.decode(token);
        clubMember.setUserId(userId);
        return ResponseEntity.ok(this.clubMemberService.insert(clubMember));
    }

    /**
     * 编辑数据
     *
     * @param clubMember 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ClubMember> edit(@RequestBody ClubMember clubMember) {
        clubMember.setPassTime(System.currentTimeMillis());
        return ResponseEntity.ok(this.clubMemberService.update(clubMember));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.clubMemberService.deleteById(id));
    }

}

