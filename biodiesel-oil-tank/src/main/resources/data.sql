INSERT INTO oil_tank(id, amount, supply_time, output_time) values(0, 0.0, current_timestamp, current_timestamp) ON CONFLICT DO NOTHING;