WITH A AS (
    SELECT 
        cp.cart_id, 
        SUM(cp.price) AS s,
        c.MINIMUM_REQUIREMENT AS m
    FROM cart_products cp
    JOIN coupons c ON cp.cart_id = c.CART_ID
    GROUP BY cp.cart_id
)

SELECT 
    cart_id,
    CASE 
        WHEN s < m THEN 1 
        ELSE 0 
    END AS ABUSED
FROM A
ORDER BY cart_id;