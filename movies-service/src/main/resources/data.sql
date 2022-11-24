insert into movies (id, title, director, duration_in_minutes, genre, release_date)
values (1,'The Shawshank Redemption','Frank Darabont',162, 'Drama' ,'1994-09-10');
insert into movies (id, title, director, duration_in_minutes, genre, release_date)
values (2,'The Dark Knight','Christopher Nolan',153,'Action','2007-07-14');


insert into actor (id, first_name, last_name)
values (1,'Tim','Robbins');
insert into actor (id, first_name, last_name)
values (2,'Morgan','Freeman');
insert into actor (id, first_name, last_name)
values (3,'Christian','Bale');


insert into actors_movies (actor_id, movie_id)
values (1,1);
insert into actors_movies (actor_id, movie_id)
values (2,1);
insert into actors_movies (actor_id, movie_id)
values (2,2);
insert into actors_movies (actor_id, movie_id)
values (3,2);