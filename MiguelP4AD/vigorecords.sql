PGDMP     (    
                y            vigorecords    13.1    13.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16395    vigorecords    DATABASE     g   CREATE DATABASE vigorecords WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE vigorecords;
                vradmin    false            �            1259    16404    producto    TABLE     �   CREATE TABLE public.producto (
    id integer NOT NULL,
    referencia character varying(10) NOT NULL,
    nombre character varying(50) NOT NULL,
    descripcion character varying(200),
    cantidad integer,
    precio double precision
);
    DROP TABLE public.producto;
       public         heap    vradmin    false            �            1259    16402    producto_id_seq    SEQUENCE     �   CREATE SEQUENCE public.producto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.producto_id_seq;
       public          vradmin    false    201            �           0    0    producto_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.producto_id_seq OWNED BY public.producto.id;
          public          vradmin    false    200            "           2604    16407    producto id    DEFAULT     j   ALTER TABLE ONLY public.producto ALTER COLUMN id SET DEFAULT nextval('public.producto_id_seq'::regclass);
 :   ALTER TABLE public.producto ALTER COLUMN id DROP DEFAULT;
       public          vradmin    false    200    201    201            �          0    16404    producto 
   TABLE DATA           Y   COPY public.producto (id, referencia, nombre, descripcion, cantidad, precio) FROM stdin;
    public          vradmin    false    201   �
       �           0    0    producto_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.producto_id_seq', 14, true);
          public          vradmin    false    200            $           2606    16409    producto producto_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.producto DROP CONSTRAINT producto_pkey;
       public            vradmin    false    201            �   r  x�m�;�1�k�<�1����f��") H�����F2$ـ��H�s�P��,=��'R2��c#fd��x��S����#g�q"[d%�1��^)����e�]��b�fn��t�n7Ѷ�>�����F�sly��FO�r���Z�����y'��!�%���1�j�8�n�t��!�!�>gI���xf�%&�t2�C�Yy�b(RHM��9f��w�C棏���ӓ2�wR��4c�f�u�����LWJ�Ԥ̨�-8��p��ʉ ���u�'�]�sL�>�sL�����[m�0�/Ԧ��n����U�m �?���'N|�_����1�ЉC�$�O8��eZ��j+�/�������?vZ�9ͥ�     