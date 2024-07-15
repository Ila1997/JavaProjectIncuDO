# Java Project - IncuDO :computer:
Questa applicazione Java è realizzata con Eclipse IDE per una azienda ipotetica di nome "IncuDO". </br> 
Tramite gli appositi tasti permette di:

[1] Visuallizare i corsi </br>
[2] Prenotare i corsi </br>
[3] Disdire una prenotazione </br>
[4] Aggiungere un utente </br>
[5] Esportare le prenotazioni disponibili, </br>
[6] Visualizzare gli utenti </br>
[7] Visualizzare le prenotazioni </br>
[0] Terminare il programma

## Requisiti:

[Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/).

## Verifica le versioni:

Per verificare la giusta versione di java eseguire il seguente comando:
`java -version`

## Inizializzazione

### Clonare il Repository:

Puoi clonare il repository eseguendo il seguente comando:

`git clone https://github.com/Ila1997/JavaProjectIncuDO.git`

## Eseguire l'applicazione:

1. Creare il file "MANIFEST.MF" contenente le seguenti righe: </br> `Manifest-Version: 1.0` </br> `Main-Class: view.Main`
2. Da Eclipse fare clic destro sulla cartella <strong>src</strong>, selezionare <strong>Export</strong>, espandere la categoria <strong>Java</strong>, selezionare <strong>Runnable JAR file</strong> e fare click su <strong>next</strong>. </br> Selezionare il progetto e la classe 'view.Main', dare il nome al file, assicurarsi di aver selezionato l'opzione <strong>Package required libraries into generated JAR</strong> e fare click su <strong>Finish</strong>.
3. Per lanciare l'applicazione attraverso il file .jar appena generato, eseguire il seguente comando: </br>
`java -jar nomeFileJar.jar`

## Eseguire l'applicazione solo con il file `.JAR`:

Per lanciare l'applicazione utilizzando solo il file .jar eseguire il comando </br>`java -jar nomeFileJar.jar`
