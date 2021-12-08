package com.gjs.controller;

import com.gjs.entity.ActiveRecord;
import com.gjs.service.ActiveRecordService;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 活动包名记录(ActiveRecord)表控制层
 *
 * @author makejava
 * @since 2021-11-01 15:40:23
 */
@Api()
@RestController
@RequestMapping("activeRecord")
public class ActiveRecordController {
    /**
     * 服务对象
     */
    @Resource
    private ActiveRecordService activeRecordService;

    /**
     * 分页查询
     *
     * @param activeRecord 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ActiveRecord>> queryByPage(ActiveRecord activeRecord, PageRequest pageRequest) {
        return ResponseEntity.ok(this.activeRecordService.queryByPage(activeRecord, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ActiveRecord> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.activeRecordService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param activeRecord 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ActiveRecord> add(ActiveRecord activeRecord) {
        return ResponseEntity.ok(this.activeRecordService.insert(activeRecord));
    }

    /**
     * 编辑数据
     *
     * @param activeRecord 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ActiveRecord> edit(ActiveRecord activeRecord) {
        return ResponseEntity.ok(this.activeRecordService.update(activeRecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.activeRecordService.deleteById(id));
    }

}

