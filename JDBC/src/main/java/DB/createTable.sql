CREATE TABLE `department` (
                              `id` int(11) NOT NULL,
                              `name` varchar(45) NOT NULL,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `staff` (
                         `FIO` varchar(45) NOT NULL,
                         `salary` decimal(10,0) NOT NULL,
                         `position` varchar(45) NOT NULL,
                         `id` int(11) NOT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `FIO_UNIQUE` (`FIO`),
                         UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;