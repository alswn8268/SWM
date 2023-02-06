create table if not exists member (
    id int not null auto_increment,
    username varchar(30) not null,
    password varchar(30) not null,
    nickname varchar(30) not null,
    introduce varchar(30) not null,
    todo varchar(30) not null,
    Primary key (id)
);