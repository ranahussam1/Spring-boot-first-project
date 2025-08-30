package com.rana.first_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rana.first_project.Constant;
import com.rana.first_project.StaffModel;
import com.rana.first_project.repository.Staffrepository;

@Service
public class Staffservice {
    @Autowired
    Staffrepository staffRepository;

    public List<StaffModel> getStaffList(){
        return staffRepository.getStaffList();
        }
    public StaffModel getStaffbyIndex(int index){
        return staffRepository.getStaffbyIndex(index);
        }

    public void addStaff(StaffModel staff){
        staffRepository.addStaff(staff);
        }

    public void modifyStaff(int index,StaffModel staff){
        staffRepository.modifyStaff(index, staff);
        }

    public int staffListSize(){
        return staffRepository.staffListSize();
        }

    public int getStaffIndex(String id){
        for(int i=0;i<staffRepository.staffListSize();i++){
            if(staffRepository.getStaffList().get(i).getId().equals(id))
            {
                return i;
            }
        }
        return Constant.NO_MATCH;
    }


    public StaffModel getFinalIndex(String id){
         int index = getStaffIndex(id);
         return index == Constant.NO_MATCH ? new StaffModel() : getStaffbyIndex(index);
    }
    
    public void addORmodify( StaffModel staff){
         int index = getStaffIndex(staff.getId());
        if(index == Constant.NO_MATCH){
           addStaff(staff);
        }
        else{
            modifyStaff(index, staff);
        }
    }
}