CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE Doctor
(
    id             BIGINT NOT NULL,
    name           VARCHAR(255),
    organization   VARCHAR(255),
    specialization VARCHAR(255),
    CONSTRAINT pk_doctor PRIMARY KEY (id)
);

CREATE TABLE Doctor_records
(
    Doctor_id  BIGINT NOT NULL,
    records_id BIGINT NOT NULL,
    CONSTRAINT pk_doctor_records PRIMARY KEY (Doctor_id, records_id)
);

ALTER TABLE Doctor_records
    ADD CONSTRAINT uc_doctor_records_records UNIQUE (records_id);

ALTER TABLE Doctor_records
    ADD CONSTRAINT fk_docrec_on_doctor FOREIGN KEY (Doctor_id) REFERENCES Doctor (id);

ALTER TABLE Doctor_records
    ADD CONSTRAINT fk_docrec_on_record FOREIGN KEY (records_id) REFERENCES Record (id);

CREATE TABLE Organization
(
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_organization PRIMARY KEY (name)
);

CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE Record
(
    id   BIGINT NOT NULL,
    time TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_record PRIMARY KEY (id)
);

CREATE TABLE Specialization
(
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_specialization PRIMARY KEY (name)
);