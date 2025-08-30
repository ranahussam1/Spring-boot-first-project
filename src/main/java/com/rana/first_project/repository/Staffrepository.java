package com.rana.first_project.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rana.first_project.Constant;
import com.rana.first_project.StaffModel;

@Repository
public class Staffrepository {
     private List <StaffModel> staffList = new ArrayList<>();

    public List<StaffModel> getStaffList(){
        return staffList;
        }
    public StaffModel getStaffbyIndex(int index){
        return staffList.get(index);
        }

    public void addStaff(StaffModel staff){
        staffList.add(staff);
        }

    public void modifyStaff(int index,StaffModel staff){
        staffList.set(index, staff);
        }

    public int staffListSize(){
        return staffList.size();
        }

    public int getStaffIndex(String id){
        for(int i=0;i<staffList.size();i++){
            if(staffList.get(i).getId().equals(id))
            {
                return i;
            }
        }
        return Constant.NO_MATCH;
    }
}
