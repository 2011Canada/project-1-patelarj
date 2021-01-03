drop schema if exists project1 cascade;
create schema project1;
set schema 'project1';


create table ers_user_roles (

ers_user_role_id serial unique primary key,
user_role text not null

);


create table ers_reimbursement_type (

reimb_type_id serial unique primary key,
reimb_type text not null

);



create table ers_reimbursement_status (

reimb_status_id serial unique primary key,
reimb_status text not null
	
);


create table ers_users (

ers_users_id serial unique primary key,
ers_username text unique not null,
ers_password text not null,
user_first_name text not null,
user_last_name text not null,
user_email text unique not null,
user_role_id int references ers_user_roles (ers_user_role_id) not null



);


create table ers_reimbursement(

reimb_id serial unique primary key,
reimb_amout double precision not null,
reimb_submitted timestamp DEFAULT current_timestamp,
reimb_resolved timestamp,
reimb_description text not null,
reimb_receipt text,
reimb_author int references ers_users (ers_users_id) not null,
reimb_resolver int references ers_users (ers_users_id),
reimb_status_id int references ers_reimbursement_status (reimb_status_id) not null,
reimb_type_id int references ers_reimbursement_type ( reimb_type_id) not null

);


insert into ers_user_roles (user_role)
			values('Employee');
insert into ers_user_roles (user_role)
			values('Finance Manager');

insert into ers_reimbursement_type (reimb_type)
			values('Lodging');
insert into ers_reimbursement_type (reimb_type)
			values('Travel');
insert into ers_reimbursement_type (reimb_type)
			values('Food');
insert into ers_reimbursement_type (reimb_type)
			values('Other');
		
insert into ers_reimbursement_status(reimb_status)
			values('Submitted');
insert into ers_reimbursement_status(reimb_status)
			values('Approved');
insert into ers_reimbursement_status(reimb_status)
			values('Denied');
		
insert into ers_users (user_first_name, user_last_name, user_email, ers_username, ers_password, user_role_id )
			  values('Ruchita', 'Patel', 'ru@gmail.com', 'ru', 'password', 1),
					('Arjun', 'Patel', 'ar@gmail.com', 'AP', 'password', 1),
					('Brayan', 'Adams', 'arB@gmail.com', 'BA', 'password', 2);
					


