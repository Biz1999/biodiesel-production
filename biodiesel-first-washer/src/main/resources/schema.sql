CREATE TABLE IF NOT EXISTS first_washer(
    id INT PRIMARY KEY,
	amount DOUBLE PRECISION NOT NULL,
  	emulsion DOUBLE PRECISION NOT NULL,
	supply_time TIMESTAMP NOT NULL,
  	output_time TIMESTAMP NOT NULL
);