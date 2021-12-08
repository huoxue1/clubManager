package com.gjs.controller;

import com.gjs.entity.Grade;
import com.gjs.service.GradeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 班级(Grade)表控制层
 *
 * @author makejava
 * @since 2021-11-01 14:48:54
 */
@RestController
@RequestMapping("grade")
public class GradeController {
    /**
     * 服务对象
     */
    @Resource
    private GradeService gradeService;


    @GetMapping("/queryAll")
    public ResponseEntity<Page<Grade>> queryAll() {
        return ResponseEntity.ok(this.gradeService.queryAll());
    }

    /**
     * 分页查询
     *
     * @param grade       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Grade>> queryByPage(Grade grade, PageRequest pageRequest) {
        return ResponseEntity.ok(this.gradeService.queryByPage(grade, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Grade> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.gradeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param grade 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Grade> add(Grade grade) {
        return ResponseEntity.ok(this.gradeService.insert(grade));
    }

    /**
     * 编辑数据
     *
     * @param grade 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Grade> edit(Grade grade) {
        return ResponseEntity.ok(this.gradeService.update(grade));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.gradeService.deleteById(id));
    }

}

