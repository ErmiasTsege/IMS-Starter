DROP TABLE IF EXISTS `customers`;
CREATE TABLE IF NOT EXISTS `customers`
(
   `id` Long NOT NULL AUTO_INCREMENT,
   `first_name` VARCHAR (40) DEFAULT NULL,
   `surname` VARCHAR (40) DEFAULT NULL,
   PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `items`;
create table IF NOT EXISTS `items`
(
   `item_id` Long not null auto_increment,
   `product_name` varchar (50) not null,
   `price` double not null,
   primary key (`item_id`)
);
DROP TABLE IF EXISTS `orders`;
create table IF NOT EXISTS `orders`
(
   `order_id` Long not null auto_increment,
   `customer_id` Long not null,
   foreign key (`customer_id`) references customers (`id`),
   primary key (`order_id`)
);
DROP TABLE IF EXISTS `orderlines`;

create table IF NOT EXISTS `orderlines`
(
   `order_items_id` Long not null auto_increment,
   `order_id` Long not null,
   `item_id` Long not null,
   `quantity` Long not null,
   `cost` Double not null,
   foreign key (`order_id`) references orders (`order_id`),
   foreign key (`item_id`) references items (`item_id`),
   primary key (`order_items_id`)
);