/* DELETE 'auctions_user' database*/
DROP SCHEMA strava;
/* DELETE USER 'auctions_user' AT LOCAL SERVER*/
DROP USER 'root'@'%';

/* CREATE ''auctionsdb' DATABASE */
CREATE SCHEMA strava;
/* CREATE THE USER 'auctions_user' AT LOCAL SERVER WITH PASSWORD 'auctions_user' */
CREATE USER 'root'@'%' IDENTIFIED BY 'Teledali1';
/* GRANT FULL ACCESS TO THE DATABASE 'auctionsdb' FOR THE USER 'auctions_user' AT LOCAL SERVER*/
GRANT ALL ON strava.* TO 'root'@'%';