DROP TABLE IF EXISTS `GlobalFeatures`;
CREATE TABLE `GlobalFeatures` (
    `id` int(11) NOT NULL,
    `appVersion` varchar(255) NOT NULL,
    `activeFeatures` varchar(1023),
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
    `id` int(11) NOT NULL,
    `name` varchar(255) NOT NULL,
    `activeFeatures` varchar(1023),
    `inactiveFeatures` varchar(1023),
    PRIMARY KEY (`id`)
);