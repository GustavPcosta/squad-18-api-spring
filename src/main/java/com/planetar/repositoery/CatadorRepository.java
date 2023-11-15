package com.planetar.repositoery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.planetar.model.Catadador;
@Repository
public interface CatadorRepository extends JpaRepository<Catadador,Long> {

}
