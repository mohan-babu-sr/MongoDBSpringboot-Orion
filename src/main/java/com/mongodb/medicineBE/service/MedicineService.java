package com.mongodb.medicineBE.service;

import com.mongodb.medicineBE.model.Medicine;

import java.util.List;

public interface MedicineService {

    public Medicine saveMedicine(Medicine medicine);
    public List<Medicine> getMedicine();
    public Medicine updateMedicine(int id, Medicine medicine);
    Medicine getMedicineById(int id);
    void deleteMedicine(int id);
}
