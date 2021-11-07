-- insert suppliers
INSERT INTO public.supplier(
	id, name, email)
	VALUES (1, 'AMAZON', 'amazon@amazon.fr');
	
INSERT INTO public.supplier(
	id, name, email)
	VALUES (2, 'Games-planete', 'games@planete.fr');
	
INSERT INTO public.supplier(
	id, name, email)
	VALUES (3, 'France-video', 'france@video.fr');
	
INSERT INTO public.supplier(
	id, name, email)
	VALUES (4, 'BC jeux', 'abc@jeux.fr');
	
INSERT INTO public.supplier(
	id, name, email)
	VALUES (5, 'Micro-jeux', 'micro@jeux.fr');
	
INSERT INTO public.supplier(
	id, name, email)
	VALUES (6, 'XBOX', 'ps4@xbox.com');
	
-- insert products
INSERT INTO public.product(
	id, name, category)
	VALUES (1, 'KAWAZAKI 222', 0);
	
INSERT INTO public.product(
	id, name, category)
	VALUES (2, 'PS4', 2);
	
INSERT INTO public.product(
	id, name, category)
	VALUES (3, 'PS5', 2);
	
INSERT INTO public.product(
	id, name, category)
	VALUES (4, 'Saint Georges et le dragon', 3);
	
INSERT INTO public.product(
	id, name, category)
	VALUES (5, 'Robe noir', 4);	
	
INSERT INTO public.product(
	id, name, category)
	VALUES (6, 'Clash Royale', 2);
	
-- insert into supplier_product
INSERT INTO public.supplier_product(
	id, product_id, supplier_id, status, price)
	VALUES (1, 2, 5, 4, 30.99);
	
INSERT INTO public.supplier_product(
	id, product_id, supplier_id, status, price)
	VALUES (2, 2, 2, 3, 29);

INSERT INTO public.supplier_product(
	id, product_id, supplier_id, status, price)
	VALUES (3, 2, 2, 1, 24.44);
	
INSERT INTO public.supplier_product(
	id, product_id, supplier_id, status, price)
	VALUES (4, 2, 3, 2, 20);
	
INSERT INTO public.supplier_product(
	id, product_id, supplier_id, status, price)
	VALUES (5, 2, 4, 0, 14.10);
	
INSERT INTO public.supplier_product(
	id, product_id, supplier_id, status, price)
	VALUES (6, 2, 4, 0, 16.20);
	
	