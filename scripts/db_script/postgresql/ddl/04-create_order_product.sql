-- Table: public.order_sales_product

-- DROP TABLE public.order_sales_product;

CREATE TABLE public.order_sales_product
(
    order_product_id bigint NOT NULL,
    total_amount integer NOT NULL,
    total_value numeric(19,2) NOT NULL,
    order_order_id bigint NOT NULL,
    product_id bigint NOT NULL,
    CONSTRAINT order_sales_product_pkey PRIMARY KEY (order_product_id),
    CONSTRAINT uk_order_product UNIQUE (order_order_id, product_id)
,
    CONSTRAINT fkd1j8wikk8v07qminx6hsht14o FOREIGN KEY (product_id)
        REFERENCES public.product (product_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkh4144oihjcitajsaov9ys3iyp FOREIGN KEY (order_order_id)
        REFERENCES public.order_sales (order_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.order_sales_product
    OWNER to postgres;