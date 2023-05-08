package com.bjpowernode.crm.workbench.web.controller;

import com.bjpowernode.crm.commons.constants.Constants;
import com.bjpowernode.crm.commons.domain.ReturnObject;
import com.bjpowernode.crm.commons.utils.DateUtils;
import com.bjpowernode.crm.commons.utils.UUIDUtils;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.workbench.domain.ActivityRemark;
import com.bjpowernode.crm.workbench.service.ActivityRemarkService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ActivityRemarkController {

    @Autowired
    private ActivityRemarkService activityRemarkService;

    @RequestMapping("/workbench/activity/saveCreateActivityRemark.do")
    public @ResponseBody Object saveCreateActivityRemark(ActivityRemark remark, HttpSession session){
        User user = (User) session.getAttribute(Constants.SESSION_USER);

        remark.setId(UUIDUtils.getUUID());
        remark.setCreateTime(DateUtils.FormatDateTime(new Date()));
        remark.setCreateBy(user.getId());
        remark.setEditFlag(Constants.REMARK_EDIT_FLAG_NO_EDITED);

        ReturnObject returnObject = new ReturnObject();
        try {
            int ret = activityRemarkService.saveCreateActivityRemark(remark);
            if (ret>0){
                returnObject.setCode(Constants.RETURN_OBJECT_SUCCESS);
                returnObject.setRetData(remark);
            }else {
                returnObject.setCode(Constants.RETURN_OBJECT_FAIL);
                returnObject.setMessage("系统繁忙，请稍后再试......");
            }
        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Constants.RETURN_OBJECT_FAIL);
            returnObject.setMessage("系统繁忙，请稍后再试......");
        }
        return returnObject;
    }

    @RequestMapping("/workbench/activity/deleteActivityRemarkById.do")
    public @ResponseBody Object deleteActivityRemarkById(String id){
        ReturnObject returnObject = new ReturnObject();
        try {
            int ret = activityRemarkService.deleteActivityRemarkById(id);
            if (ret > 0) {
                returnObject.setCode(Constants.RETURN_OBJECT_SUCCESS);
            } else{
                returnObject.setCode(Constants.RETURN_OBJECT_FAIL);
                returnObject.setMessage("系统繁忙，请稍后再试........");
            }
        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Constants.RETURN_OBJECT_FAIL);
            returnObject.setMessage("系统繁忙，请稍后再试........");
        }
        return returnObject;
    }

    @RequestMapping("/workbench/activity/saveEditActivityRemark.do")
    public @ResponseBody Object saveEditActivityRemark(ActivityRemark remark,HttpSession session){
        User user = (User) session.getAttribute(Constants.SESSION_USER);

        remark.setEditTime(DateUtils.FormatDateTime(new Date()));
        remark.setEditBy(user.getId());
        remark.setEditFlag(Constants.REMARK_EDIT_FLAG_YES_EDITED);

        ReturnObject returnObject = new ReturnObject();
        try {
            int ret = activityRemarkService.saveEditActivityRemark(remark);
            if (ret>0){
                returnObject.setCode(Constants.RETURN_OBJECT_SUCCESS);
                returnObject.setRetData(remark);
            }else {
                returnObject.setCode(Constants.RETURN_OBJECT_FAIL);
                returnObject.setMessage("系统繁忙，请稍后再试.........");
            }
        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Constants.RETURN_OBJECT_FAIL);
            returnObject.setMessage("系统繁忙，请稍后再试.........");
        }
        return  returnObject;
    }
}
