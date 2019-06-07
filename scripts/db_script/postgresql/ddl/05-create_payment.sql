-- Table: public.payment

-- DROP TABLE public.payment;

CREATE TABLE public.payment
(
    payment_id bigint NOT NULL,
    code character varying(255) COLLATE pg_catalog."default" NOT NULL,
    create_date timestamp without time zone NOT NULL,
    status character varying(255) COLLATE pg_catalog."default" NOT NULL,
    total_amount integer NOT NULL,
    total_value numeric(19,2) NOT NULL,
    update_date timestamp without time zone,
    order_id bigint NOT NULL,
    CONSTRAINT payment_pkey PRIMARY KEY (payment_id),
    CONSTRAINT uk_mf7n8wo2rwrxsd6f3t9ub2mep UNIQUE (order_id)
,
    CONSTRAINT uk_opor0kv54jt58n364jog9bu2i UNIQUE (code)
,
    CONSTRAINT fkei5nq0ww9b8t0m22cs7ji1dvn FOREIGN KEY (order_id)
        REFERENCES public.order_sales (order_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.payment
    OWNER to postgres;