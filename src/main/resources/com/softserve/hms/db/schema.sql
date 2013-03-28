DROP TABLE user IF EXISTS;
DROP TABLE patient IF EXISTS;
DROP TABLE appointment IF EXISTS;

CREATE TABLE patient (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  mid_name   VARCHAR(30)
);

CREATE TABLE user (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  mid_name VARCHAR(30),
  login VARCHAR(30),
  password VARCHAR(30),
);

CREATE TABLE appointment (
  id         INTEGER IDENTITY PRIMARY KEY,
  patient_id INTEGER,
  appoint_date DATE,
  appoint_type VARCHAR(30),
  location VARCHAR(30),
  dob DATE,
  phone VARCHAR(10),
  mrn VARCHAR(10),
  pcn VARCHAR(10),
  resource   VARCHAR(30),
  hospital   VARCHAR(30)
);

ALTER TABLE appointment ADD CONSTRAINT fk_app_patient FOREIGN KEY (patient_id) REFERENCES patient (id);