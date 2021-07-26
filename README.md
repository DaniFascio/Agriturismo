# Agriturismo

Durante la mia esperienza scolastica presso un istituto tecnico industriale nell'indirizzo informatico, ho studiato alcuni linguaggi di programmazione.
Arrivando all'ultimo anno durante l'esame di maturità, mi è stato assegnato un compito scritto detto "Elaborato" di cui in seguito riporto la traccia.




TRACCIA:
-
-
-
-
Due strutture agrituristiche vengono acquistate da un nuovo proprietario il quale, in occasione di lavori di ristrutturazione edilizia, vuole dotare gli ambienti di una infrastruttura informatica per offrire nuovi servizi agli ospiti.

Entrambe le strutture sono organizzate in un comprensorio con i seguenti edifici:
- Un casale a due piani che offre ai clienti la possibilità di soggiornare. Una parte del piano terra di questo casale è riservato agli uffici, l’altra parte dello stesso piano e il primo piano è riservata alle camere.

- Nell’edificio vicino, anch’esso a due piani, sono stati allestiti una pizzeria e un ristorante che propone la degustazione di piatti tipici locali. Gli ambienti per la cucina della pizzeria e per la preparazione dei piatti tipici sono distinti.

- In un apposito capanno vengono gestite le attività ippiche e le escursioni guidate che l’agriturismo propone ai villeggianti.
Per ottimizzare l’intera gestione dell’agriturismo si vuole realizzare una rete di comunicazione che offra, ai clienti, i seguenti servizi:
- consultazione del menu, dai tavoli o da qualunque altra zona della struttura;

- ordinazione delle portate, sia dai tavoli che da qualunque altra zona della struttura;
- prenotazione delle attività ippiche e delle escursioni;

- connettività gratuita.



Le ordinazioni effettuate dai clienti devono essere trasmesse nelle apposite cucine, essere soddisfatte da cuochi e camerieri, inoltrate alla cassa o al centro amministrativo per l’emissione delle fatture.
Le prenotazioni delle attività ippiche e delle escursioni invece devono essere trasmesse al capanno.
I clienti possono effettuare le prenotazioni per i soggiorni, le escursioni e le attività ippiche tramite il portale dell’agriturismo; tutte le prenotazioni e ordinazioni devono essere archiviate sia per permettere ai clienti di apportare delle modifiche sia per consentire al proprietario di monitorare le varie attività.
Le escursioni e le attività ippiche si svolgono in determinate fasce orarie e sono affidate a personale esperto.
Delle prenotazioni interessano:

- per i soggiorni: il cliente, la data di prenotazione, il periodo, il tipo e il numero di camera
- per le attività ippiche: il cliente, la data, la fascia oraria e l’addetto.
- per le escursioni: il cliente, la data, la meta e la guida.

La gestione dell’offerta della pizzeria e del ristorante è affidata a un responsabile che periodicamente aggiorna l’elenco dei piatti tipici locali disponibili. I clienti possono effettuare le loro ordinazioni accedendo all’area dedicata del portale.
Il candidato analizzi la realtà di riferimento, fornendo anche uno schema che evidenzi le principali funzionalità del sistema, formuli le necessarie ipotesi iniziali e aggiuntive.
  



Individui una soluzione che a suo motivato giudizio sia la più idonea a sviluppare i seguenti punti:

1. fornisca una possibile soluzione per il progetto della WAN che consenta la comunicazione fra tutte le sedi dislocate nei diversi punti del territorio nazionale, motivando le scelte fatte;

2. fornisca una possibile soluzione per il progetto delle reti LAN facendo riferimento agli standard utilizzati, alla topologia di rete, disegnando lo schema fisico e lo schema logico della rete, spiegando le scelte fatte in relazione al posizionamento dei centri stella e dei locali, al cablaggio verticale e orizzontale. Disegni in dettaglio l’architettura dei centri stella e descriva gli elementi hardware utilizzati. Definisca il piano di indirizzamento delle reti;

3. fornisca una soluzione per la segmentazione fisica delle reti definendo il piano di indirizzamento per le sottoreti create;

4. definisca i servizi offerti dai server ai client della LAN e i servizi offerti dai server per fornire all’agriturismo visibilità all’esterno; fornisca una soluzione per la presenza di server ipotizzando la loro collocazione interna alla struttura e la loro protezione; si individui anche una soluzione per la sicurezza della LAN;

5. proponga le diverse soluzioni alternative alla collocazione dei server all’interno della struttura, esponendone vantaggi e svantaggi;

6. fornisca una soluzione per la segmentazione logica delle reti definendo il piano di indirizzamento per le sottoreti create;

7. la comunicazione in rete comporta l’esposizione delle trasmissioni dei dati a numerosi rischi di violazione. Il candidato proponga una tecnica per garantire la segretezza dei dati che viaggiano in linea;

8. progetti il diagramma E/R relative alla base di dati necessaria all’archiviazione e gestione dei dati;

9. derivi lo schema logico della base di dati;

10. definisca in linguaggio SQL l’intera base di dati;

11. scriva le seguenti interrogazioni espresse in linguaggio SQL:

    a) Meta dell’escursione più richiesta
    b) Elenco delle fasce orarie per attività ippiche che non sono state mai prenotate nel mese di maggio dell’anno in corso
    c) Elenco dei piatti tipici locali che sono stati ordinati più di 100 volte
    d) Elenco delle camere libere
    12. descriva l’organizzazione del portale;
    13. codifichi in qualsiasi linguaggio una parte del portale che si ritiene significativa.









PIANTINE EDIFICI:


EDIFICIO PERNOTTAMENTO

![schema_fisico-edificio 1](https://user-images.githubusercontent.com/65457329/126991452-bc0d6676-15a1-4e8c-ba5f-3bed25497472.jpg)



EDIFICIO RISTORAZIONE

![schema_fisico-edificio 2](https://user-images.githubusercontent.com/65457329/126992031-6f3cb317-d290-4570-8030-fdba8440f3bf.jpg)



EDIFICIO ATTIVITA' IPPICHE ED ESCURSIONI

![schema_fisico-edificio 3](https://user-images.githubusercontent.com/65457329/126992045-023d7550-c8cd-4c9c-b3bc-37a26ed5956b.jpg)



SVILUPPO:


Le tecnologie utilizzate per la realizzazione dell'applicazione web sono:

- Back-end:
    - Spring: Boot, Data, MVC
    - Hibernate

- Front-end:
    - Thymeleaf
    - Bootstrap

