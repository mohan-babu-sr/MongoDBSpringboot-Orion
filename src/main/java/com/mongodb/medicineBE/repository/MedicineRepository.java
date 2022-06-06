package com.mongodb.medicineBE.repository;

import com.mongodb.medicineBE.model.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends MongoRepository<Medicine,Integer>  {
}
