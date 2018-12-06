
insert ignore into security_group(groupname, groupdescription) values('Owners','This group contains owners.');
insert ignore into security_group(groupname, groupdescription) values('Managers','This group contains store managers');


insert ignore into security_user(username, password, enabled) values('ow1',SHA2('ow1',256), true); 
insert ignore into security_user(username, password, enabled) values('ow2', SHA2('ow2',256), true); 
insert ignore into security_user(username, password, enabled) values('manager1', SHA2('manager1',256), true); 
insert ignore into security_user(username, password, enabled) values('manager2', SHA2('manager2',256), true); 




insert ignore into security_user_groups(username, groupname) values('ow1','Owners');
insert ignore into security_user_groups(username, groupname) values('ow2','Owners');
insert ignore into security_user_groups(username, groupname) values('manager1','Managers');
insert ignore into security_user_groups(username, groupname) values('manager2','Managers');


insert into manager(id, name, username) values(98, 'Manager One', 'manager1');
insert into manager(id, name, username) values(99, 'Manager Two', 'manager2');




insert into storeinventory(ID,customerName,productName,purchase_date,qauntity,STRING) values(98,'Smith','books','1970-12-12',2,'This group contains store information');
insert into storeinventory(ID,customerName,productName,purchase_date,qauntity,STRING) values(99,'William','food','1945-12-12',3,'This group contains store information');



insert into owner(id, datejoined, email, name, si_id,username) values (98, '1995-08-01', 'stirpude@iit.edu', 'Shruti', 98,'ow1');
insert into owner(id, datejoined, email, name, si_id,username) values (99, '1996-08-01', 'smith@iit.edu', 'Smith', 99,'ow2');



insert into shifts(id, shiftname) values (98,'Morning');



insert into owner_shift(owners_id, shifts_id) values (98,98);