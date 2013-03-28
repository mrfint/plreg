DROP TABLE user IF EXISTS;
DROP TABLE patient IF EXISTS;
DROP TABLE doctor IF EXISTS;
DROP TABLE appointment IF EXISTS;

CREATE TABLE user (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  password VARCHAR(30)
);

CREATE TABLE patient (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  mid_name VARCHAR(30)
);

CREATE TABLE doctor (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  mid_name VARCHAR(30),
  specialization VARCHAR(30)
);

CREATE TABLE appointment (
  id         INTEGER IDENTITY PRIMARY KEY,
  patient_id INTEGER,
  doctor_id  INTEGER,
  hospital VARCHAR(30)
);

ALTER TABLE appointment ADD CONSTRAINT fk_app_patient FOREIGN KEY (patient_id) REFERENCES patient (id);
ALTER TABLE appointment ADD CONSTRAINT fk_app_doctor FOREIGN KEY (doctor_id) REFERENCES doctor (id);