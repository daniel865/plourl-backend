package com.plourlbackend.service;

import com.plourlbackend.dao.PackageRepository;
import com.plourlbackend.domain.Availability;
import com.plourlbackend.domain.Package;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PackageService {

    private static final Logger log = LoggerFactory.getLogger(PackageService.class);

    @Autowired
    private PackageRepository packageRepository;

    public PackageService() {
    }

    public Package cretePackage(Package aPackage) {
        return packageRepository.save(aPackage);
    }

    public Package getPackage(Long id) {
        return packageRepository.findOne(id);
    }

    public Package updatePackage(Package aPackage) {
        return packageRepository.save(aPackage);
    }

    public Package deletePackage(Long id) {
        Optional<Package> packageOptional = Optional.ofNullable(packageRepository.findOne(id));
        if (packageOptional.isPresent()) {
            packageRepository.delete(packageOptional.get().getId());
            return packageOptional.get();
        } else {
            throw new IllegalArgumentException("El paquete no existe");
        }
    }

}
