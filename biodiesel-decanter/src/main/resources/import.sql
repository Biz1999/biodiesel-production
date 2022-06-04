CREATE TABLE IF NOT EXISTS decanter(
    id INT PRIMARY KEY,
	amount DOUBLE PRECISION NOT NULL,
	status String,
	supply_time TIMESTAMP NOT NULL,
  	output_time TIMESTAMP NOT NULL
);


INSERT INTO decanter VALUES (0, 'AVAILABLE', now(), now())