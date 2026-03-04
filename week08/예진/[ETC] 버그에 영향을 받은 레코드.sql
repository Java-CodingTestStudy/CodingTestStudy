-- 각 카트의 총 상품 가격 합이 쿠폰의 minimum보다 작으면 버그이므로 1
SELECT prod.cart_id
     , (CASE WHEN COALESCE(SUM(prod.price), 0) < coup.minimum_requirement THEN 1 ELSE 0 END) AS abused
  FROM cart_products prod
 RIGHT JOIN coupons coup
    ON prod.cart_id = coup.cart_id
 GROUP BY prod.cart_id, coup.minimum_requirement
 ORDER BY prod.cart_id
