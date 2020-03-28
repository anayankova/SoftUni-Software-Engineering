package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.domain.entities.Player;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findByFirstNameAndLastName(String firstName, String lastName);

    //@Query("SELECT p FROM Player AS P WHERE p.team.name = :name")
    List<Player> findAllByTeamName(String name);

    List<Player> findAllBySalaryIsGreaterThanOrderBySalaryDesc(BigDecimal salary);

}
