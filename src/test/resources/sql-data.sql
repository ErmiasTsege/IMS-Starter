INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');


INSERT INTO `items` (`product_name`, `price`) VALUES ('Tv', 10.00);

INSERT INTO `orders` (customer_id`) VALUES (3L);

INSERT INTO `orderlines` (`order_id`,`item_id`,`quantity`,`cost`) VALUES (1L,3L,15L,70.00);