CREATE TABLE IF NOT EXISTS decanter(
    id INT PRIMARY KEY,
	amount DOUBLE PRECISION NOT NULL,
	status VARCHAR(255),
	supply_time TIMESTAMP NOT NULL,
  	output_time TIMESTAMP NOT NULL
);