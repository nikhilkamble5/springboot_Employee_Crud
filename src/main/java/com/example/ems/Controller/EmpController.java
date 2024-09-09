package com.example.ems.Controller;

import com.example.ems.Entity.Employee;
import com.example.ems.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmpController {
         @Autowired
        EmpRepo empRepo;

    @GetMapping("/emp/")
   List<Employee> showAll(){
      return  empRepo.findAll();

    }

//    @GetMapping("/emp/{id}/")
//  Employee showEmp(@PathVariable Long id){
//    return empRepo.findById(id);
//    }

    @GetMapping("/emp/{id}/")
    public Employee showEmp(@PathVariable Long id) {
        return empRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }


    @PostMapping("/emp/")
    Employee addEmp(@RequestBody Employee emp){
      return   empRepo.save(emp);
    }
//        @GetMapping("/emp/delete/{id}/")
//    Employee deleteEMp(@PathVariable  Long id){
//       Employee emp= empRepo.findById(id);
//        empRepo.deleteById(id);
//        return emp;
//
//    }

    @GetMapping("/emp/delete/{id}/")
    public Employee deleteEmp(@PathVariable Long id) {
        Employee emp = empRepo.findById(id).orElse(null);  // Get the employee or null if not found
        if (emp != null) {
            empRepo.deleteById(id);
        }
        return emp;
    }


}
