package backend.repository;

import backend.model.Laufveranstaltung;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LaufveranstaltungRepository extends JpaRepository<Laufveranstaltung, Integer> {
}
