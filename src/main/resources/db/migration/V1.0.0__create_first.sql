CREATE SEQUENCE IF NOT EXISTS pius.hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE pius.doctor
(
    id             BIGINT NOT NULL,
    name           VARCHAR(255),
    organization   VARCHAR(255),
    specialization VARCHAR(255),
    CONSTRAINT pk_doctor PRIMARY KEY (id)
);

CREATE TABLE pius.record
(
    id        BIGINT NOT NULL,
    time      TIMESTAMP WITHOUT TIME ZONE,
    doctor_id BIGINT,
    CONSTRAINT pk_record PRIMARY KEY (id)
);

ALTER TABLE pius.record
    ADD CONSTRAINT FK_RECORD_ON_DOCTOR FOREIGN KEY (doctor_id) REFERENCES pius.doctor (id);

CREATE TABLE pius.specialization
(
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_specialization PRIMARY KEY (name)
);

CREATE TABLE pius.organization
(
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_organization PRIMARY KEY (name)
);