# Java Project - IncuDO
Questa applicazione Java è realizzata con Eclipse IDE per una azienda ipotetica di nome "IncuDO", e tramite gli appositi tasti permette di:

[1] Visuallizare i corsi,

[2] Prenotare i corsi,

[3] Disdire una prenotazione,

[4] Aggiungere un utente,

[5] Esportare le prenotazioni disponibili

[6] Visualizzare gli utenti

[7] Visualizzare le prenotazioni

[0] Terminare il programma

## Requisiti

[Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/).

## Verifica le versioni:

Per verificare la giusta versione di java eseguire il seguente comando:
`java -version`

## Inizializzazione

### Clonare il Repository

Puoi clonare il repository eseguendo il seguente comando:

`git clone https://github.com/Ila1997/JavaProjectIncuDO.git`

## Eseguire l'applicazione

1. Creare il file "MANIFEST.MF" contenente le seguenti righe: </br> `Manifest-Version: 1.0` </br> `Main-Class: view.Main`
2. Da Eclipse fare clic destro sulla cartella <strong>src</strong>, selezionare <strong>Export</strong>, espandere la categoria <strong>Java</strong>, selezionare <strong>Runnable JAR file</strong> e fare click su <strong>next</strong>. </br> Selezionare il progetto e la classe 'view.Main', dare il nome al file, assicurarsi di aver selezionato l'opzione <strong>Package required libraries into generated JAR</strong> e fare click su <strong>Finish</strong>.
3. Per lanciare l'applicazione attraverso il file .jar appena generato, eseguire il seguente comando: </br>
`java -jar nomeFileJar.jar`

## Eseguire l'applicazione solo con il file `.JAR`

Per lanciare l'applicazione utilizzando solo il file .jar eseguire il comando </br>`java -jar nomeFileJar.jar`
