package se.experis.jesper.microtask4.demo.models.data_access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.experis.jesper.microtask4.demo.models.Candy;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface CandyRepository extends JpaRepository<Candy, Integer> {
    @Query(value = "SELECT * FROM candy WHERE candy_type = ?1 AND cost_per_unit = ?2", nativeQuery = true)
    Candy getCandiesByType(String candy_type, int cost_per_unit);

    List<Candy> findCandyByWeightPerUnitEquals(int weight_per_unit);

    List<Candy> findCandyByTypeEquals(String candy_type);

}
