CREATE TABLE oil_tank (
   id INT PRIMARY KEY,
	amount DOUBLE PRECISION NOT NULL,
	supply_time TIMESTAMP NOT NULL,
    output_time TIMESTAMP NOT NULL
);

INSERT INTO oil_tank(id, amount, supply_time, output_time) values(0, 0.0, current_timestamp, current_timestamp);

CREATE TABLE etoh_tank(
   id INT PRIMARY KEY,
	amount DOUBLE PRECISION NOT NULL,
	supply_time TIMESTAMP NOT NULL,
    output_time TIMESTAMP NOT NULL
);

INSERT INTO etoh_tank(id, amount, supply_time, output_time) values(0, 0.0, current_timestamp, current_timestamp);

CREATE TABLE naoh_tank(
   id INT PRIMARY KEY,
	amount DOUBLE PRECISION NOT NULL,
	supply_time TIMESTAMP NOT NULL,
    output_time TIMESTAMP NOT NULL
);

INSERT INTO naoh_tank(id, amount, supply_time, output_time) values(0, 0.0, current_timestamp, current_timestamp);

CREATE TABLE reactor(
    id INT PRIMARY KEY,
    status VARCHAR(255) NOT NULL,
	amount DOUBLE PRECISION NOT NULL,
	oil_amount DOUBLE PRECISION NOT NULL,
	naoh_amount DOUBLE PRECISION NOT NULL,
	etoh_amount DOUBLE PRECISION NOT NULL,
	oil_supply_time TIMESTAMP NOT NULL,
	naoh_supply_time TIMESTAMP NOT NULL,
	etoh_supply_time TIMESTAMP NOT NULL,
    output_time TIMESTAMP NOT NULL
);

INSERT INTO reactor(id, status, amount, oil_amount, naoh_amount, etoh_amount, oil_supply_time, naoh_supply_time, etoh_supply_time, output_time)
values(0, 'AVAILABLE',0.0, 0.0, 0.0, 0.0, current_timestamp, current_timestamp, current_timestamp, current_timestamp);


CREATE TABLE biodiesel_tank(
    id INT PRIMARY KEY,
	amount DOUBLE PRECISION NOT NULL,
	supply_time TIMESTAMP NOT NULL
);

INSERT INTO biodiesel_tank(id, amount, supply_time) values(0, 0.0, current_timestamp);


CREATE TABLE glycerin_tank(
    id INT PRIMARY KEY,
	amount DOUBLE PRECISION NOT NULL,
	supply_time TIMESTAMP NOT NULL
);

INSERT INTO glycerin_tank(id, amount, supply_time) values(0, 0.0, current_timestamp);

CREATE TABLE etoh_dryer(
    id INT PRIMARY KEY,
	amount DOUBLE PRECISION NOT NULL,
	supply_time TIMESTAMP NOT NULL,
  	output_time TIMESTAMP NOT NULL
);

INSERT INTO etoh_dryer(id, amount, supply_time, output_time) values(0, 0.0, current_timestamp, current_timestamp);


CREATE TABLE dryer(
    id INT PRIMARY KEY,
	amount DOUBLE PRECISION NOT NULL,
	supply_time TIMESTAMP NOT NULL,
  	output_time TIMESTAMP NOT NULL
);

INSERT INTO dryer(id, amount, supply_time, output_time) values(0, 0.0, current_timestamp, current_timestamp);


CREATE TABLE first_washer(
    id INT PRIMARY KEY,
	amount DOUBLE PRECISION NOT NULL,
  	emulsion DOUBLE PRECISION NOT NULL,
	supply_time TIMESTAMP NOT NULL,
  	output_time TIMESTAMP NOT NULL
);

INSERT INTO first_washer(id, amount, emulsion, supply_time, output_time) values(0, 0.0, 0.0, current_timestamp, current_timestamp);