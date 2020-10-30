package se.experis.jesper.microtask4.demo.models.data_access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.experis.jesper.microtask4.demo.models.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
