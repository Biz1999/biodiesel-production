CREATE TABLE IF NOT EXISTS etoh_tank(
   id INT PRIMARY KEY,
	amount DOUBLE PRECISION NOT NULL,
	supply_time TIMESTAMP NOT NULL,
    output_time TIMESTAMP NOT NULL
);