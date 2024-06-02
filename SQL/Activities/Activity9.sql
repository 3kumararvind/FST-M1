select customers.customer_name, customers.city, salesman.name, salesman.commission from
  customers inner join salesman on customers.salesman_id = salesman.salesman_id;

select customers.customer_name, customers.city, customers.grade, salesman.name, salesman.city from customers left outer join salesman
on customers.salesman_id = salesman.salesman_id where customers.grade<300 order by customers.customer_id;

select customers.customer_name, customers.city, salesman.name, salesman.commission from customers inner join salesman on 
  customers.salesman_id = salesman.salesman_id where salesman.commission>12;
