package com.atmae.myrabc.task;

import com.atmae.myrabc.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Mae
 * @Date: 2022/2/19
 * @Time: 9:19
 * @Description:
 */
@Component
public class MyTask {

    @Autowired
    private ITaskService taskService;

    /**
     * 自动统计数据
     */
    public void count() {
        taskService.doCount();
    }
}
