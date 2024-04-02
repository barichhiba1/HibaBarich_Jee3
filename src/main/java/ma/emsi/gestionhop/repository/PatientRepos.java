package ma.emsi.gestionhop.repository;

import ma.emsi.gestionhop.GestionHopApplication;
import ma.emsi.gestionhop.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepos
extends JpaRepository<Patient,Long> {
    //Methode de recherche
    Page<Patient> findByNomContains(String nom, Pageable p);//le deuxieme para c pour faire la pagination
    @Query("select p from Patient p where p.nom like :x")
    Page<Patient> chercher(@Param("x") String keyword,Pageable p);
}
