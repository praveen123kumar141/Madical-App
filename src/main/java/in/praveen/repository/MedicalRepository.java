package in.praveen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.praveen.entity.madical;

@Repository
public interface MedicalRepository  extends JpaRepository<madical,Integer>{

}
