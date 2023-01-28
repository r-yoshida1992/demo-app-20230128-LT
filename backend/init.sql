create database demo_lt;
create user demo_lt_admin@localhost identified by 'demoltadmin';
grant all on demo_lt.* to demo_lt_admin;
