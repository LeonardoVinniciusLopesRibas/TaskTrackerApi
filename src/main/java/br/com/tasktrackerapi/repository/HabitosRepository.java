package br.com.tasktrackerapi.repository;

import br.com.tasktrackerapi.model.Habitos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitosRepository extends JpaRepository<Habitos, Long> {
}
