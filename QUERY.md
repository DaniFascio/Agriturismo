# Esame di stato 2020-21

***

# Queries

```
1)
select distinct camere.numero
from camere,
	 prenotazioni_soggiorni
where camere.numero not in (
        select prenotazioni_soggiorni.numero 
        from prenotazioni_soggiorni);
```

```
2)
select distinct ai.id_attivita, ai.data_checkin orario_inizio, ai.data_checkout orario_fine 
From attivitaippiche ai 

where ai.id_attivita not in (
    select pai.id_attivita 
    from prenotazioni_attivitaippiche pai 

    Where date_part('month', pai.data) = 05 
    and date_part('year', pai.data) = date_part('year', current_date))
     
order by ai.id_attivita;
```

```
3)
select piatti.descrizione from piatti,OrdinaPiatti 

where piatti.id_piatto = ordinaPiatti.id_piatto 

group by piatti.descrizione 
having sum(ordinapiatti.id_piatto) > 100;
```

```
4)
select distinct camere.numero from camere, prenotazioni_soggiorni 
where camere.numero not in (
    select prenotazioni_soggiorni.numero from prenotazioni_soggiorni);
```