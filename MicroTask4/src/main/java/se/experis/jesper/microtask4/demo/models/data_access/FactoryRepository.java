package se.experis.jesper.microtask4.demo.models.data_access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.experis.jesper.microtask4.demo.models.Factory;

@Repository
public interface FactoryRepository extends JpaRepository<Factory, Integer> {
}
