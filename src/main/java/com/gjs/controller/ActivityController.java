package com.gjs.controller;

import com.gjs.entity.Activity;
import com.gjs.service.ActivityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 活动记录(Activity)表控制层
 *
 * @author makejava
 * @since 2021-11-01 15:32:56
 */
@RestController
@RequestMapping("activity")
public class ActivityController {
    /**
     * 服务对象
     */
    @Resource
    private ActivityService activityService;

    /**
     * 分页查询
     *
     * @param activity    筛选条件
     * @param size 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Activity>> queryByPage(Activity activity, int page,int size) {
        return ResponseEntity.ok(this.activityService.queryByPage(activity, PageRequest.of(page,size)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Activity> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.activityService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param activity 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Activity> add(@RequestBody Activity activity) {
        activity.setState(0);
        return ResponseEntity.ok(this.activityService.insert(activity));
    }

    /**
     * 编辑数据
     *
     * @param activity 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Activity> edit(@RequestBody Activity activity) {
        return ResponseEntity.ok(this.activityService.update(activity));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.activityService.deleteById(id));
    }

}

