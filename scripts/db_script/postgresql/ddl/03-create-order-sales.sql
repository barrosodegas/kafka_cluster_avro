-- Table: public.order_sales

-- DROP TABLE public.order_sales;

CREATE TABLE public.order_sales
(
    order_id bigint NOT NULL,
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    create_date timestamp without time zone NOT NULL,
    status character varying(255) COLLATE pg_catalog."default" NOT NULL,
    update_date timestamp without time zone,
    customer_id bigint NOT NULL,
    CONSTRAINT order_sales_pkey PRIMARY KEY (order_id),
    CONSTRAINT uk_7yl5bs8pqw7e901bnmesrj1ji UNIQUE (code)
,
    CONSTRAINT fkr6ohibd9vcl53qwmhcgugbah6 FOREIGN KEY (customer_id)
        REFERENCES public.customer (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.order_sales
    OWNER to postgres;