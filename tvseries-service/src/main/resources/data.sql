insert into series (id,  director, duration_in_minutes, genre, number_of_episodes, number_of_seasons, release_date,title)
values (1,'Woody Allen',150,'Action',15,2,'2002-12-23','Annie Hall');

insert into actor (id, first_name, last_name)
values (1,'Carol','Kane');

insert into actor (id, first_name, last_name)
values (2,'Tony','Roberts');

insert into actors_series (actor_id, series_id) values (1,1);
insert into actors_series (actor_id, series_id) values (2,1);