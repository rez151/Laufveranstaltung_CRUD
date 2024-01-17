package backend.service;

import backend.model.Laufveranstaltung;
import backend.repository.LaufveranstaltungRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaufveranstaltungService {

  @Autowired
  private LaufveranstaltungRepository laufveranstaltungRepository;

  public List<Laufveranstaltung> getAllLaufveranstaltungen() {
    return laufveranstaltungRepository.findAll();
  }

  public Laufveranstaltung getLaufveranstaltungById(int id) {
    Optional<Laufveranstaltung> optionalLaufveranstaltung = laufveranstaltungRepository.findById(id);
    return optionalLaufveranstaltung.orElse(null);
  }

  public void addLaufveranstaltung(Laufveranstaltung laufveranstaltung) {
    laufveranstaltungRepository.save(laufveranstaltung);
  }

  public void updateLaufveranstaltung(int id, Laufveranstaltung updatedLaufveranstaltung) {
    Optional<Laufveranstaltung> optionalLaufveranstaltung = laufveranstaltungRepository.findById(id);
    if (optionalLaufveranstaltung.isPresent()) {
      Laufveranstaltung existingLaufveranstaltung = optionalLaufveranstaltung.get();
      existingLaufveranstaltung.setName(updatedLaufveranstaltung.getName());
      existingLaufveranstaltung.setDistanz(updatedLaufveranstaltung.getDistanz());
      existingLaufveranstaltung.setTermin(updatedLaufveranstaltung.getTermin());
      existingLaufveranstaltung.setStartgebuehr(updatedLaufveranstaltung.getStartgebuehr());
      existingLaufveranstaltung.setGemeldeteTeilnehmer(updatedLaufveranstaltung.getGemeldeteTeilnehmer());
      laufveranstaltungRepository.save(existingLaufveranstaltung);
    }
  }

  public void deleteLaufveranstaltung(int id) {
    laufveranstaltungRepository.deleteById(id);
  }
}
