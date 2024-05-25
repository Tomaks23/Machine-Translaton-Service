--liquibase formatted sql

--preconditions onFail:HALT onError:HALT

--changeset milos:1_initial_tables
--comment: adding initial tables
CREATE TABLE `content_domain` (
  `id` int NOT NULL AUTO_INCREMENT,
  `domain` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `lang_code` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--changeset milos:1_adding_data
--comment: adding initial data
INSERT INTO lang_code (code, name) VALUES
('en-GB', 'English (United Kingdom)'),
('en-US', 'English (United States)'),
('fr-FR', 'French'),
('de-DE', 'German');

INSERT INTO content_domain (domain) VALUES
('academic'),
('business'),
('general'),
('casual'),
('creative');
