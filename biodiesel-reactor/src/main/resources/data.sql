INSERT INTO reactor(id, status, amount, oil_amount, naoh_amount, etoh_amount, oil_supply_time, naoh_supply_time, etoh_supply_time, output_time)
values(0, 'AVAILABLE',0.0, 0.0, 0.0, 0.0, current_timestamp, current_timestamp, current_timestamp, current_timestamp) ON CONFLICT DO NOTHING;