package backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "laufveranstaltungen")
public class Laufveranstaltung {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;
  private String distanz;
  private Date termin;
  private double startgebuehr;
  private int gemeldeteTeilnehmer;

  public Laufveranstaltung() {
  }

  public Laufveranstaltung(int id, String name, String distanz, Date termin, double startgebuehr, int gemeldeteTeilnehmer) {
    this.id = id;
    this.name = name;
    this.distanz = distanz;
    this.termin = termin;
    this.startgebuehr = startgebuehr;
    this.gemeldeteTeilnehmer = gemeldeteTeilnehmer;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDistanz() {
    return distanz;
  }

  public void setDistanz(String distanz) {
    this.distanz = distanz;
  }

  public Date getTermin() {
    return termin;
  }

  public void setTermin(Date termin) {
    this.termin = termin;
  }

  public double getStartgebuehr() {
    return startgebuehr;
  }

  public void setStartgebühr(double startgebühr) {
    this.startgebuehr = startgebühr;
  }

  public int getGemeldeteTeilnehmer() {
    return gemeldeteTeilnehmer;
  }

  public void setGemeldeteTeilnehmer(int gemeldeteTeilnehmer) {
    this.gemeldeteTeilnehmer = gemeldeteTeilnehmer;
  }
}
