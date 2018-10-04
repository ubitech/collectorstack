DROP TABLE IF EXISTS node;
DROP TABLE IF EXISTS nodestat;
DROP TABLE IF EXISTS peer;
DROP TABLE IF EXISTS commandlog;
DROP TABLE IF EXISTS peerstat;
DROP TABLE IF EXISTS peerreport;

CREATE TABLE node
(
   id varchar(40) not null,
   gateway varchar(40),
   osarch varchar(40),
   osname varchar(40),
   bootdate timestamp, 
   username varchar(40),
   password varchar(40),
   vcpus integer,
   cpuspeed integer,
   totalmemory integer,
   primary key(id)
);

CREATE TABLE nodestat
(
   nodeid varchar(40) not null,
   gateway varchar(40),
   osarch varchar(40),
   osname varchar(40),
   bootdate timestamp,
   vcpus integer,
   cpuspeed integer,
   totalmemory integer,
   checkdate timestamp,
   bandwidth varchar(40),
   rttdelay varchar(40),
   packetloss varchar(40),
   container varchar(500) default null,
   primary key(nodeid)
);

CREATE TABLE peer
(
   id bigint auto_increment,   
   fromnode varchar(40) not null,
   tonode varchar(40) not null,
   registrationdate timestamp,
   isactive boolean default false, 
   reportingnode varchar(40)
);


CREATE TABLE commandlog
(
   cid varchar(40) not null,
   cdate timestamp, 
   primary key(cid)
);