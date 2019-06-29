create table TbItem
(
	id int auto_increment
		primary key,
	title varchar(80) null,
	sellPoint varchar(80) null,
	price double null,
	num int null,
	barcode varchar(40) null,
	image varchar(80) null,
	cid int null,
	status tinyint null,
	created date null,
	updated date null
)
;

INSERT INTO db1.TbItem (id, title, sellPoint, price, num, barcode, image, cid, status, created, updated) VALUES (1, 'aaaa', null, 20, 2, null, null, null, 2, '2019-06-05', '2019-06-28');
INSERT INTO db1.TbItem (id, title, sellPoint, price, num, barcode, image, cid, status, created, updated) VALUES (2, 'bbbbb', null, 30, 5, null, null, null, 3, '2019-02-04', '2019-04-11');