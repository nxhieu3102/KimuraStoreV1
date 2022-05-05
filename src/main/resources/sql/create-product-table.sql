create table product (
	id int(11) auto_increment primary key,
    category_id int(11),
    name varchar(255),
    price double,
    detail longtext,
	discount_id int(11),
    quantity_sell int(11),
    create_at timestamp default current_timestamp,
    modify_at timestamp default current_timestamp,
    image varchar(255)	
)	