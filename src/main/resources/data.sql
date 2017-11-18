DELETE FROM `GlobalFeatures`;
INSERT INTO `GlobalFeatures` ( id, appVersion, activeFeatures ) VALUES
( '1', '0.1', 'f1, f2, f3, f4, f6' ), 
( '2', '0.2', 'f1,f2,f4,f5,f6' ), 
( '3', '0.3', 'f1,f2,f4,f5,f6,f7,f9' );


DELETE FROM `User`;
INSERT INTO `User` ( id, name, activeFeatures, inactiveFeatures ) VALUES
( '1', 'user_x', 'f5', '' ), 
( '2', 'user_y', 'f1, f2, f3', 'f6' ), 
( '3', 'user_z', 'f3', '' ),
( '4', 'user_k', '', '' );