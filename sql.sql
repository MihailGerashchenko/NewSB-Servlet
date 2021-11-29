CREATE TABLE CustomersOne
(
    id       SERIAL PRIMARY KEY,
    login    varchar(50),
    password varchar(100),
    role     varchar(50),
    email    varchar(50),
    phone    varchar(50),
    address  varchar(50)
);

CREATE TABLE TestsOne
(
    id SERIAL PRIMARY KEY,
    subject varchar(50),
    question1 varchar(50),
    question2 varchar(50),
    question3 varchar(50),
    time varchar(50),
    degree varchar(50),
    customer_id varchar(50)
);

INSERT INTO CustomersOne(login, password, role, email, phone, address)
VALUES('StudentOne', '$2a$10$eYTGqKXbu2QJyiNpK2.5Ee3bTh/QROSU.U5ilU6Q2byZYz94WLak6', 'STUDENT', 'student@gmail.com', '+380952641578', 'Los Angeles');

INSERT INTO TestsOne(subject, question1, question2, question3, time, degree, customer_id)
VALUES('Geometry', 'Triangle', 'Square', 'Angle 60', '15.00', 'A', null);

