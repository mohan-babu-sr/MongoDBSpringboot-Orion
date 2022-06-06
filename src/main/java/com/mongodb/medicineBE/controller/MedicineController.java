package com.mongodb.medicineBE.controller;

import com.mongodb.medicineBE.model.Medicine;
import com.mongodb.medicineBE.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PostMapping("/saveMedicine")
    public ResponseEntity<Medicine> saveMedicine(@RequestBody Medicine medicine) {
        return new ResponseEntity<Medicine>(medicineService.saveMedicine(medicine), HttpStatus.CREATED);
    }

    @GetMapping("/getMedicine")
    public ResponseEntity<List<Medicine>> getMedicine() {
        List<Medicine> medicine = medicineService.getMedicine();
        return new ResponseEntity<List<Medicine>>(medicine, HttpStatus.OK);
    }

    @PutMapping("/updateMedicine/{medicine_id}")
    public String updateMedicine(@RequestBody Medicine medicine,@PathVariable("medicine_id")int id) {
        medicineService.updateMedicine(id,medicine);
        return "updated successfully";
    }

    @DeleteMapping("/deleteMedicine/{medicine_id}")
    public String deleteMedicine(@PathVariable("medicine_id")int id) {
        medicineService.deleteMedicine(id);
        return "deleted successfully";
    }

    @GetMapping("/getMedicine/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable("id") int medicineId){
        return new ResponseEntity<Medicine>(medicineService.getMedicineById(medicineId), HttpStatus.OK);
    }

//    @PutMapping("{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id
//            ,@RequestBody Employee employee){
//        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
//    }
}
