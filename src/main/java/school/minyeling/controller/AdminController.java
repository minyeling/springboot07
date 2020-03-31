package school.minyeling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import school.minyeling.domain.Admin;
import school.minyeling.service.AdminService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("allAdmin")
    public @ResponseBody
    List<Admin> allAdmin(){
        List<Admin> adminList=adminService.allAdmin();
        System.out.println(adminList);
        return adminList;
    }

    @RequestMapping("allAdmin2")
    public ModelAndView allAdmin2(HttpServletResponse response){
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        List<Admin> adminList=adminService.allAdmin();
        System.out.println(adminList);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("lists",adminList);
        modelAndView.setViewName("admin-list");
        return modelAndView;
    }

}
