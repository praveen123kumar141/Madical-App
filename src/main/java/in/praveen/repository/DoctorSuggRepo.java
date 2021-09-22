package in.praveen.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.praveen.entity.DoctorSugg;

@Repository
public interface DoctorSuggRepo  extends JpaRepository< DoctorSugg,Integer>{

}
