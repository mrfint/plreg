INSERT INTO user VALUES (1, 'Joahn', 'Carter','','admin','admin');
INSERT INTO user VALUES (2, 'User', 'User','','user','user');

INSERT INTO patient VALUES (1, 'James', 'Carter','E');
INSERT INTO patient VALUES (2, 'Helen', 'Leary','A');
INSERT INTO patient VALUES (3, 'Linda', 'Douglas','Esd');
INSERT INTO patient VALUES (4, 'Rafael', 'Ortega','G');
INSERT INTO patient VALUES (5, 'Henry', 'Stevens','Bd');
INSERT INTO patient VALUES (6, 'Sharon', 'Jenkins','A');

INSERT INTO appointment(id, patient_id, hospital, appoint_date, appoint_type, location, dob, phone, mrn, pcn, resource) VALUES (1,1,'HMS Hospital 1', '2012-09-04', 'Clinic Visit 90', 'HMS Test Hospital 1', '2012-09-04', '035656545', '125687', '4986513', 'Nate Cristopher');
INSERT INTO appointment(id, patient_id, hospital, appoint_date, appoint_type, location, dob, phone, mrn, pcn, resource) VALUES (2,2,'BOSTON CHILDREN`S HOSPITAL', '2013-03-12', 'Clinic Visit 3', 'BOSTON CHILDREN`S HOSPITAL', '2013-03-12', '6173556000', '895687', '4486513', 'Shari Abramowitz');
INSERT INTO appointment(id, patient_id, hospital, appoint_date, appoint_type, location, dob, phone, mrn, pcn, resource) VALUES (4,4,'The Johns Hopkins Hospital', '2013-05-15', 'Clinic Visit 96', 'The Johns Hopkins Hospital','2013-05-15', '4109556190', '8927827', '41223313', 'Dr Keith McNeil');
INSERT INTO appointment(id, patient_id, hospital, appoint_date, appoint_type, location, dob, phone, mrn, pcn, resource) VALUES (5,5,'Brigham and Women`s Hospital','2013-06-16','Clinic Visit 22', 'Brigham and Women`s Hospital', '2013-06-16', '4109006190', '8922627', '41269113', 'Elisa Abdulhayoglu, MD, MS');
INSERT INTO appointment(id, patient_id, hospital, appoint_date, appoint_type, location, dob, phone, mrn, pcn, resource) VALUES (7,3,'HMS Hospital 1', '2012-09-04', 'Clinic Visit 90', 'HMS Test Hospital 1', '2012-09-04', '035656545', '125687', '4986513', 'Nate Cristopher');