package com.wh.kettlescheduler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录controller
 * @author wuhe
 * @date 2020年1月11日14:54:38
 */
@Controller
@RequestMapping("/web")
public class WebController {

    /**
     * 请求登录页面
     * @return /login
     */
    @RequestMapping("/login")
    public String loginWeb() {
        return "login";
    }

    /**
     * 登录成功后跳转的页面
     *
     * @return /index
     */
    @RequestMapping("/index")
    public String indexWeb() {
        return "index";
    }

    /**
     * 首页统计页面
     *
     * @return /main
     */
    @RequestMapping("/main")
    public String mainWeb() {
        return "main";
    }

    //=============================================资源库=================================================//
    /**
     * 资源库列表页面
     *
     * @return /repository/list
     */
    @RequestMapping("/repository/list")
    public String repositoryListWeb() {
        return "repository/list";
    }

    /**
     * 资源库添加页面
     *
     * @return /repository/add
     */
    @RequestMapping("/repository/add")
    public String repositoryAddWeb() {
        return "repository/add";
    }

    /**
     * 资源库编辑页面
     *
     * @return /repository/edit
     */
    @RequestMapping("/repository/edit")
    public String repositoryEditWeb(Integer repositoryId, Model model) {
        model.addAttribute("repositoryId", repositoryId);
        return "repository/edit";
    }

    //=============================================定时策略=================================================//
    /**
     * 定时策略列表页面
     *
     * @return /quartz/list
     */
    @RequestMapping("/quartz/list")
    public String quartzListWeb() {
        return "quartz/list";
    }

    /**
     * 定时策略添加页面
     *
     * @return /quartz/add
     */
    @RequestMapping("/quartz/add")
    public String quartzAddWeb() {
        return "quartz/add";
    }

    /**
     * 定时策略编辑页面
     *
     * @return /quartz/edit
     */
    @RequestMapping("/quartz/edit")
    public String quartzEditWeb(Integer quartzId, Model model) {
        model.addAttribute("quartzId", quartzId);
        return "quartz/edit";
    }

    //=============================================用户管理=================================================//
    /**
     * 用户管理列表页面
     *
     * @return /user/list
     */
    @RequestMapping("/user/list")
    public String userListWeb() {
        return "user/list";
    }

    /**
     * 用户管理添加页面
     *
     * @return /user/add
     */
    @RequestMapping("/user/add")
    public String userAddWeb() {
        return "user/add";
    }

    /**
     * 用户管理编辑页面
     *
     * @return /user/edit
     */
    @RequestMapping("/user/edit")
    public String userEditWeb(Integer userId, Model model) {
        model.addAttribute("userId", userId);
        return "user/edit";
    }

    //=============================================任务分类=================================================//
    /**
     * 任务分类列表页面
     *
     * @return /category/list
     */
    @RequestMapping("/category/list")
    public String categoryListWeb() {
        return "category/list";
    }

    /**
     * 任务分类添加页面
     *
     * @return /category/add
     */
    @RequestMapping("/category/add")
    public String categoryAddWeb() {
        return "category/add";
    }

    /**
     * 任务分类编辑页面
     *
     * @return /category/edit
     */
    @RequestMapping("/category/edit")
    public String categoryEditWeb(Integer categoryId, Model model) {
        model.addAttribute("categoryId", categoryId);
        return "category/edit";
    }

    //=============================================转换管理=================================================//
    /**
     * 转换管理列表页面
     *
     * @return /trans/list
     */
    @RequestMapping("/trans/list")
    public String transListWeb() {
        return "trans/list";
    }

    /**
     * 转换管理添加页面
     *
     * @return /trans/add
     */
    @RequestMapping("/trans/add")
    public String transAddWeb() {
        return "trans/add";
    }

    /**
     * 转换管理编辑页面
     *
     * @return /trans/edit
     */
    @RequestMapping("/trans/edit")
    public String transEditWeb(Integer transId, Model model) {
        model.addAttribute("transId", transId);
        return "trans/edit";
    }

    //=============================================作业管理=================================================//
    /**
     * 作业管理列表页面
     *
     * @return /job/list
     */
    @RequestMapping("/job/list")
    public String jobListWeb() {
        return "job/list";
    }

    /**
     * 作业管理添加页面
     *
     * @return /job/add
     */
    @RequestMapping("/job/add")
    public String jobAddWeb() {
        return "job/add";
    }

    /**
     * 作业管理编辑页面
     *
     * @return /job/edit
     */
    @RequestMapping("/job/edit")
    public String jobEditWeb(Integer jobId, Model model) {
        model.addAttribute("jobId", jobId);
        return "job/edit";
    }

    //=============================================监控管理=================================================//
    /**
     * 作业监控管理列表页面
     *
     * @return /monitor/j-list
     */
    @RequestMapping("/job/monitor/list")
    public String jobMonitorListWeb() {
        return "monitor/j-list";
    }

    /**
     * 转换监控管理列表页面
     *
     * @return /monitor/t-list
     */
    @RequestMapping("/trans/monitor/list")
    public String transMonitorListWeb() {
        return "monitor/t-list";
    }

    //=============================================记录管理=================================================//
    /**
     * 作业记录管理列表页面
     *
     * @return /record/j-list
     */
    @RequestMapping("/job/record/list")
    public String jobMonitorRecordListWeb(Integer jobId, Model model) {
        model.addAttribute("jobId", jobId);
        return "record/j-list";
    }

    /**
     * 转换记录管理列表页面
     *
     * @return /record/t-list
     */
    @RequestMapping("/trans/record/list")
    public String transMonitorRecordListWeb(Integer transId, Model model) {
        model.addAttribute("transId", transId);
        return "record/t-list";
    }
}
