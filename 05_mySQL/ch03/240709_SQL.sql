use world;
select * from city
where CountryCode = 'kor'
order by Population desc;

select *from city
where countrycode = 'kor' and
	name like 'c%';
    
select population from city
where Name = 'Cheju';

select name, Population from city
where CountryCode = 'kor' and
	  Population < 
					(select population
					 from city
                     where Name = 'Cheju');