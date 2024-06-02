select distinct salesman_id from orders;
select order_no from orders order by order_date;
select order_no from orders order by purchase_amount desc;
select * from orders where purchase_amount < 500;
select * from orders where purchase_amount > 1000 and purchase_amount <2000;
