// Funktion zum Laden der Laufveranstaltungen beim Start der Seite
window.onload = function () {
  loadLaufveranstaltungen();
};

// Funktion zum Laden der Laufveranstaltungen von der Spring Boot-Anwendung
function loadLaufveranstaltungen() {
  fetch('http://localhost:8080/api/laufveranstaltungen')
    .then(response => response.json())
    .then(data => {
      laufveranstaltungen = data;
      renderLaufveranstaltungen();
    })
    .catch(error => console.error('Fehler beim Laden der Laufveranstaltungen:', error));
}

// Dummy-Daten für die lokale Anzeige
let laufveranstaltungen = [];

// Funktion zum Hinzufügen einer Laufveranstaltung
function addLaufveranstaltung() {
  const name = document.getElementById('name').value;
  const distanz = document.getElementById('distanz').value;
  const termin = document.getElementById('termin').value;
  const startgebuehr = document.getElementById('startgebuehr').value;
  const teilnehmer = document.getElementById('teilnehmer').value;

  const newLaufveranstaltung = {
    name: name,
    distanz: distanz,
    termin: termin,
    startgebuehr: startgebuehr,
    gemeldeteTeilnehmer: teilnehmer
  };

  fetch('http://localhost:8080/api/laufveranstaltungen', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(newLaufveranstaltung)
  })
    .then(response => {
      if (!response.ok) {
        throw new Error('Fehler beim Hinzufügen der Laufveranstaltung');
      }
      return response.json();
    })
    .then(data => {
      laufveranstaltungen.push(data);
      renderLaufveranstaltungen();
      clearForm();
    })
    .catch(error => console.error('Fehler beim Hinzufügen der Laufveranstaltung:', error));
    location.reload();
}

// Funktion zum Rendern der Laufveranstaltungen in der Tabelle
function renderLaufveranstaltungen() {
  const tableBody = document.getElementById('laufveranstaltungenTableBody');
  tableBody.innerHTML = '';

  laufveranstaltungen.forEach(laufveranstaltung => {
    const row = document.createElement('tr');
    row.innerHTML = `
            <td>${laufveranstaltung.id}</td>
            <td>${laufveranstaltung.name}</td>
            <td>${laufveranstaltung.distanz}</td>
            <td>${laufveranstaltung.termin}</td>
            <td>${laufveranstaltung.startgebuehr}</td>
            <td>${laufveranstaltung.gemeldeteTeilnehmer}</td>
            <td>
                <button onclick="editLaufveranstaltung(${laufveranstaltung.id})">Bearbeiten</button>
                <button onclick="deleteLaufveranstaltung(${laufveranstaltung.id})">Löschen</button>
            </td>
        `;
    tableBody.appendChild(row);
  });
}

// Funktion zum Löschen einer Laufveranstaltung
function deleteLaufveranstaltung(id) {
  fetch(`http://localhost:8080/api/laufveranstaltungen/${id}`, {
    method: 'DELETE'
  })
    .then(response => {
      if (!response.ok) {
        throw new Error('Fehler beim Löschen der Laufveranstaltung');
      }
      return response.json();
    })
    .then(() => {
      laufveranstaltungen = laufveranstaltungen.filter(l => l.id !== id);
      renderLaufveranstaltungen();
    })
    .catch(error => console.error('Fehler beim Löschen der Laufveranstaltung:', error));
    location.reload();
}

// Funktion zum Bearbeiten einer Laufveranstaltung (nicht implementiert)
function editLaufveranstaltung(id) {
  // Hier könntest du die Logik zum Bearbeiten implementieren
  alert('Edit-Funktion noch nicht implementiert');
}

// Funktion zum Leeren des Formulars nach dem Hinzufügen
function clearForm() {
  document.getElementById('name').value = '';
  document.getElementById('distanz').value = '';
  document.getElementById('termin').value = '';
  document.getElementById('startgebuehr').value = '';
  document.getElementById('teilnehmer').value = '';
}

// Beim Laden der Seite Laufveranstaltungen rendern
renderLaufveranstaltungen();
