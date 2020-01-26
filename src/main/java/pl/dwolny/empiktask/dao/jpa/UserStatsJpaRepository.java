package pl.dwolny.empiktask.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dwolny.empiktask.dao.entity.UserStats;

import java.util.Optional;

@Repository
public interface UserStatsJpaRepository extends JpaRepository<UserStats, Long> {

	Optional<UserStats> findByLogin(String login);
}
