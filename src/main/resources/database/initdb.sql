CREATE TABLE IF NOT EXISTS employee(
                                       employee_id SERIAL PRIMARY KEY,
                                       first_name CHARACTER VARYING(30) NOT NULL ,
                                       last_name CHARACTER VARYING(30) NOT NULL ,
                                       department_id INTEGER NOT NULL ,
                                       job_title CHARACTER VARYING(30) NOT NULL ,
                                       gender CHARACTER VARYING(5) NOT NULL ,
                                       date_of_birth DATE
);