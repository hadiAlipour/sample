package com.example.university.service;

import com.example.university.model.Manager;
import com.example.university.repository.ManagerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    private final ManagerRepo managerRepo;

    public ManagerService(ManagerRepo managerRepo) {
        this.managerRepo = managerRepo;
    }

    public Manager register(Manager manager) {
        return managerRepo.save(manager);
    }

    public List<Manager> findAllManger(){
        return (List<Manager>) managerRepo.findAll();
    }
}
