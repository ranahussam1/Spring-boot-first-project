package com.rana.first_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rana.first_project.StaffModel;
import com.rana.first_project.service.Staffservice;

import jakarta.validation.Valid;

@Controller
public class StaffController{
   @Autowired
    Staffservice staffService;

    @GetMapping("/")
    public String addModifyForm(Model model , @RequestParam (required =false) String id){
        model.addAttribute("addstaff", staffService.getFinalIndex(id));
        return "addmodifystaff";
    }


    @PostMapping("/submitform")
    public String submitStaff(@Valid @ModelAttribute("addstaff") StaffModel staff, BindingResult result){
        if(result.hasErrors()){
            return "addmodifystaff";
        }
        staffService.addORmodify(staff);
        return ("redirect:/showallstaff");
    }

@GetMapping("/showallstaff")
    public String showStaff(Model model){
        model.addAttribute("stafflist",staffService.getStaffList());
        return("stafflist");
    }

}


