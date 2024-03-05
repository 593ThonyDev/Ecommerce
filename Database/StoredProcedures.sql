DELIMITER //
CREATE PROCEDURE selectusers()
BEGIN
    SELECT 
        user.username, 
        user.role,
        user.status, 
        user.created,
        employe.idemploye AS id,
        employe.fullname AS fullname,
        employe.photo AS photo
    FROM user
    INNER JOIN employe ON user.email = employe.email 
    UNION ALL
    SELECT 
        user.username, 
        user.role,
        user.status, 
        user.created,
        customer.idcustomer AS id,
        customer.fullname AS fullname,
        customer.photo AS photo
    FROM user
    INNER JOIN customer ON user.email = customer.email;
END //

DROP PROCEDURE IF EXISTS searchuser;
DELIMITER //
CREATE PROCEDURE searchuser(IN search_term VARCHAR(255))
BEGIN
    SELECT 
        user.iduser,
        user.username, 
        user.role,
        user.status, 
        user.created,
        employe.idemploye AS id,
        employe.fullname AS fullname,
        employe.photo AS photo
    FROM user
    INNER JOIN employe ON user.email = employe.email 
    WHERE user.username LIKE CONCAT('%', search_term, '%')
        OR employe.fullname LIKE CONCAT('%', search_term, '%')
        OR user.email LIKE CONCAT('%', search_term, '%')
    UNION ALL
    SELECT 
        user.iduser,
        user.username, 
        user.role,
        user.status, 
        user.created,
        customer.idcustomer AS id,
        customer.fullname AS fullname,
        customer.photo AS photo
    FROM user
    INNER JOIN customer ON user.email = customer.email 
    WHERE customer.fullname LIKE CONCAT('%', search_term, '%')
        OR user.username LIKE CONCAT('%', search_term, '%')
        OR user.email LIKE CONCAT('%', search_term, '%');
END //
DELIMITER ;
