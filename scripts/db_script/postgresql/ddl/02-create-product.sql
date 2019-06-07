-- Table: public.product

-- DROP TABLE public.product;

CREATE TABLE public.product
(
    product_id bigint NOT NULL,
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    create_date timestamp without time zone NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    price numeric(19,2) NOT NULL,
    update_date timestamp without time zone,
    CONSTRAINT product_pkey PRIMARY KEY (product_id),
    CONSTRAINT uk_h3w5r1mx6d0e5c6um32dgyjej UNIQUE (code)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.product
    OWNER to postgres;