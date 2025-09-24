-- orders
INSERT INTO orders (id, customer_id, total_price) VALUES (1, 1, 55.0);
INSERT INTO orders (id, customer_id, total_price) VALUES (2, 2, 28.0);
INSERT INTO orders (id, customer_id, total_price) VALUES (3, 3, 60.0);

-- element collection: list of CDs
INSERT INTO order_list_of_cds (order_id, disc_id) VALUES (1, 1);
INSERT INTO order_list_of_cds (order_id, disc_id) VALUES (1, 2);

INSERT INTO order_list_of_cds (order_id, disc_id) VALUES (2, 3);

INSERT INTO order_list_of_cds (order_id, disc_id) VALUES (3, 2);
INSERT INTO order_list_of_cds (order_id, disc_id) VALUES (3, 4);