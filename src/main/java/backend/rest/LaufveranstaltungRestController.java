package backend.rest;

import backend.model.Laufveranstaltung;
import backend.service.LaufveranstaltungService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/laufveranstaltungen")
public class LaufveranstaltungRestController {

  @Autowired
  private LaufveranstaltungService laufveranstaltungService;

  // CRUD Operationen

  @GetMapping
  public List<Laufveranstaltung> getAllLaufveranstaltungen() {
    return laufveranstaltungService.getAllLaufveranstaltungen();
  }

  @GetMapping("/{id}")
  public Laufveranstaltung getLaufveranstaltungById(@PathVariable int id) {
    return laufveranstaltungService.getLaufveranstaltungById(id);
  }

  @PostMapping
  public void addLaufveranstaltung(@RequestBody Laufveranstaltung laufveranstaltung) {
    laufveranstaltungService.addLaufveranstaltung(laufveranstaltung);
  }

  @PutMapping("/{id}")
  public void updateLaufveranstaltung(@PathVariable int id, @RequestBody Laufveranstaltung laufveranstaltung) {
    laufveranstaltungService.updateLaufveranstaltung(id, laufveranstaltung);
  }

  @DeleteMapping("/{id}")
  public void deleteLaufveranstaltung(@PathVariable int id) {
    laufveranstaltungService.deleteLaufveranstaltung(id);
  }
}
