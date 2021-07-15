package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import web.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
