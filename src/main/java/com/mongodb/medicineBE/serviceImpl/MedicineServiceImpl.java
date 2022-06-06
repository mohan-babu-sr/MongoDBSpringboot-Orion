package com.mongodb.medicineBE.serviceImpl;

import com.mongodb.medicineBE.exception.MedicineException;
import com.mongodb.medicineBE.model.Medicine;
import com.mongodb.medicineBE.repository.MedicineRepository;
import com.mongodb.medicineBE.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public Medicine saveMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
        return null ;
    }

    @Override
    public List<Medicine> getMedicine() {
        return medicineRepository.findAll();
    }

    @Override
    public Medicine updateMedicine(int id, Medicine medicine) {
        Optional<Medicine> findById = medicineRepository.findById(id);
        if (findById.isPresent()){
            Medicine userEntity = findById.get();
            if (medicine.getName()!=null && !medicine.getName().isEmpty())
                userEntity.setName(medicine.getName());
            if (medicine.getPrice()!=null && !medicine.getPrice().isEmpty())
                userEntity.setPrice(medicine.getPrice());
            return  medicineRepository.save(userEntity);
        }
        return medicine;
    }

    @Override
    public void deleteMedicine(int id) {
        medicineRepository.deleteById(id);
    }

    @Override
    public Medicine getMedicineById(int id) {
        return medicineRepository.findById(id).orElseThrow(() ->
                new MedicineException("Medicine", "Id", id));

    }
}
