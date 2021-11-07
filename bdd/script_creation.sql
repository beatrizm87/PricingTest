-- create the supplier table
CREATE TABLE supplier
(
    id bigint NOT NULL,
    name character varying NOT NULL,
    email character varying NOT NULL,
    CONSTRAINT supplier_id_pk PRIMARY KEY (id),
    CONSTRAINT supplier_email_unique UNIQUE (email)
);

-- create product table
CREATE TABLE product
(
    id bigint NOT NULL,
    name character varying NOT NULL,
    category int NOT NULL,
    CONSTRAINT product_id_pk PRIMARY KEY (id)
);

   
-- create the supplier_product table
CREATE TABLE supplier_product
(
    id bigint NOT NULL,
    product_id bigint NOT NULL,
    supplier_id bigint NOT NULL,
	status integer NOT NULL,
	price double precision NOT NULL,
    CONSTRAINT supplier_product_id_pk PRIMARY KEY (id),
	CONSTRAINT supplier_product_product_fk
      FOREIGN KEY(product_id) 
	  REFERENCES product(id),
	CONSTRAINT supplier_product_supplier_fk
      FOREIGN KEY(supplier_id) 
	  REFERENCES supplier(id)
);

