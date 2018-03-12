package pl.maslowskis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.maslowskis.entity.User;

/**
 * Created by oro-6 on 3/12/2018.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
