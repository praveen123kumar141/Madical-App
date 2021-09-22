package in.praveen.repository;
import in.praveen.entity.Contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
@Repository
public interface ContactRepository extends JpaRepository<Contact,Serializable> {

}
