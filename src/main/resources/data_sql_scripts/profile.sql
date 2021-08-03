--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: profile; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profile (
    profile_id integer NOT NULL,
    acct_name character varying(255),
    acct_num character varying(255),
    available_credit_limit double precision NOT NULL,
    credit_card_num character varying(255),
    credit_limit double precision NOT NULL,
    reward_points_earned double precision NOT NULL
);


ALTER TABLE public.profile OWNER TO postgres;

--
-- Data for Name: profile; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.profile VALUES (1, 'rakesh', '1234', 685, '1234', 1000, 70);


--
-- Name: profile profile_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile
    ADD CONSTRAINT profile_pkey PRIMARY KEY (profile_id);


--
-- PostgreSQL database dump complete
--

