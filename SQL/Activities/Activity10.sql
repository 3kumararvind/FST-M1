select * from orders where salesman_id=(select distinct salesman_id from orders where customer_id=3007);

 select * from orders where salesman_id in (select salesman_id from salesman where salesman_city='new york');

select grade, count(*) from customers group by grade having grade>(select avg(grade) from customers where salesman_city='new york');

select order_no, purchase_amount, order_date, salesman_id from orders where salesman_id in( select salesman_id from salesman
where commission=( select max(commission) from salesman));
