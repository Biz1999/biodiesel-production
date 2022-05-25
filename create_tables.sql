CREATE TABLE oil_tank (
   id INT PRIMARY KEY,
	amount DOUBLE PRECISION NOT NULL,
	supply_time TIMESTAMP NOT NULL,
    output_time TIMESTAMP NOT NULL
);

INSERT INTO oil_tank(id,amount, supply_time, output_time) values(0, 0.0, current_timestamp, current_timestamp);

CREATE TABLE etoh_tank(
   id INT PRIMARY KEY,
	amount DOUBLE PRECISION NOT NULL,
	supply_time TIMESTAMP NOT NULL,
    output_time TIMESTAMP NOT NULL
);

INSERT INTO etoh_tank(id,amount, supply_time, output_time) values(0, 0.0, current_timestamp, current_timestamp);

CREATE TABLE naoh_tank(
   id INT PRIMARY KEY,
	amount DOUBLE PRECISION NOT NULL,
	supply_time TIMESTAMP NOT NULL,
    output_time TIMESTAMP NOT NULL
);

INSERT INTO naoh_tank(id,amount, supply_time, output_time) values(0, 0.0, current_timestamp, current_timestamp);