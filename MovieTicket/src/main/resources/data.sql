INSERT INTO role(name) VALUES('USER');

INSERT INTO role(name) VALUES('ADMIN');

CREATE TABLE `app_user_roles` (
  `user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_aate0r8fqojgqdbyi5n29iy7g` (`roles_id`),
  KEY `FK3lwiahkol5aetc57pto5olacf` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci