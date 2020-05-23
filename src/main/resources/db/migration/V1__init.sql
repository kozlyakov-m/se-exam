create table departments
(
    id            int not null auto_increment primary key,
    department    varchar(255),
    tel           int
);

create table employees
(
    id              int not null auto_increment primary key,
    name            varchar(255),
    department_id   int,
    foreign key (department_id) references departments (id)
);

create table tel
(
    id              int not null auto_increment primary key,
    number          int,
    employee_id     int,
    foreign key (employee_id) references employees (id)
);