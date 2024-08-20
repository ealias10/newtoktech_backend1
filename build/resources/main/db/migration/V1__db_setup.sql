CREATE TABLE roles (
  id BIGINT AUTO_INCREMENT NOT NULL,
   created_by VARCHAR(255) NOT NULL,
   created_at BIGINT NOT NULL,
   modified_by VARCHAR(255) NOT NULL,
   modified_at BIGINT NOT NULL,
   name VARCHAR(255) NULL,
   CONSTRAINT pk_roles PRIMARY KEY (id)
);
CREATE TABLE users (
  id BIGINT AUTO_INCREMENT NOT NULL,
   created_by VARCHAR(255) NOT NULL,
   created_at BIGINT NOT NULL,
   modified_by VARCHAR(255) NOT NULL,
   modified_at BIGINT NOT NULL,
   username VARCHAR(255) NULL,
   password VARCHAR(255) NULL,
   role_id BIGINT NULL,
   CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users ADD CONSTRAINT uc_users_username UNIQUE (username);

ALTER TABLE users ADD CONSTRAINT FK_USERS_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (id);

CREATE TABLE country (
  id BIGINT AUTO_INCREMENT NOT NULL,
   created_by VARCHAR(255) NOT NULL,
   created_at BIGINT NOT NULL,
   modified_by VARCHAR(255) NOT NULL,
   modified_at BIGINT NOT NULL,
   name VARCHAR(255) NULL,
   state VARCHAR(255) NULL,
   district VARCHAR(255) NULL,
   city VARCHAR(255) NULL,
   CONSTRAINT pk_country PRIMARY KEY (id)
);

ALTER TABLE country ADD CONSTRAINT uc_country_name UNIQUE (name);

CREATE TABLE wather (
  id BIGINT AUTO_INCREMENT NOT NULL,
   created_by VARCHAR(255) NOT NULL,
   created_at BIGINT NOT NULL,
   modified_by VARCHAR(255) NOT NULL,
   modified_at BIGINT NOT NULL,
   report VARCHAR(255) NULL,
   country_id BIGINT NULL,
   CONSTRAINT pk_wather PRIMARY KEY (id)
);

ALTER TABLE wather ADD CONSTRAINT FK_WATHER_ON_COUNTRY FOREIGN KEY (country_id) REFERENCES country (id);

INSERT INTO roles VALUES(1, 'system', UNIX_TIMESTAMP(), 'system', UNIX_TIMESTAMP(), 'USER');
INSERT INTO roles VALUES(2, 'system', UNIX_TIMESTAMP(), 'system', UNIX_TIMESTAMP(), 'ADMIN');

INSERT INTO Users VALUES(1,'system', UNIX_TIMESTAMP(), 'system', UNIX_TIMESTAMP(),'ealias','ealias',1);
INSERT INTO Users VALUES(2,'system', UNIX_TIMESTAMP(), 'system', UNIX_TIMESTAMP(),'ealias1','ealias1',2);