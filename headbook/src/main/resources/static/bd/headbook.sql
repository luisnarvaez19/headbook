CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE headbook.likes
(
    post uuid NOT NULL,
    usuario uuid NOT NULL,
    CONSTRAINT likes_pkey PRIMARY KEY (post, usuario)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE headbook.likes
    OWNER to headbook;
    
    
       
CREATE TABLE headbook.usuario
(
    id uuid NOT NULL DEFAULT uuid_generate_v1mc(),
    avatar character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    surname character varying(255) COLLATE pg_catalog."default",
    likesid_post uuid,
    likesid_usuario uuid,
    username character varying(20) COLLATE pg_catalog."default" NOT NULL,
    password character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT fk_usuario_likes FOREIGN KEY (likesid_post, likesid_usuario)
        REFERENCES headbook.likes (post, usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE headbook.usuario
    OWNER to headbook;
    
    
CREATE TABLE headbook.post
(
    id uuid NOT NULL default uuid_generate_v1mc(),
    content character varying(1200) COLLATE pg_catalog."default",
    date timestamp without time zone,
    title character varying(255) COLLATE pg_catalog."default",
    likesid_post uuid,
    likesid_usuario uuid,
    usuario uuid,
    CONSTRAINT post_pkey PRIMARY KEY (id),
    CONSTRAINT fk_post_likes FOREIGN KEY (likesid_post, likesid_usuario)
        REFERENCES headbook.likes (post, usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_post_usuario FOREIGN KEY (usuario)
        REFERENCES headbook.usuario (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE headbook.post
    OWNER to headbook;
    
  
ALTER TABLE headbook.likes
    ADD CONSTRAINT fk_likes_post FOREIGN KEY (post)
    REFERENCES headbook.post (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE RESTRICT;

ALTER TABLE headbook.likes
    ADD CONSTRAINT fk_likes_usuario FOREIGN KEY (usuario)
    REFERENCES headbook.usuario (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE RESTRICT;
    
INSERT INTO headbook.usuario (id,avatar,"name",surname,likesid_post,likesid_usuario,username,"password") VALUES 
('3bffb3b6-053d-11e9-a890-2f7374de4daa','Posts tecnologicos','Francisco','Correa',NULL,NULL,'user1','password')
,('881e14d2-064a-11e9-9be4-13628b2452a5','Tecnologia varios','Pedro','Torres',NULL,NULL,'user2','password')
;

INSERT INTO headbook.post (id,"content","date",title,likesid_post,likesid_usuario,usuario) VALUES
('5c981604-053d-11e9-a890-2b2b1ebf1bb4','Al trabajar con bases de datos como MySql es común utilizar una clave primaría entera autoincremental que permita distinguir y referenciar cada uno de los registros. El problema surge cuando se tienen muchas computadoras remotas escribiendo una gran cantidad de registros al mismo tiempo, en este caso el proceso de inserción sería el cuello de botella ya que la generación de claves, aunque rápida, podría retrasar el ingreso de datos. Si, en cambio, se generan bases por separado para que cada una maneje una carga de inserción menor entonces las claves se repetirían y se perdería la función principal de la clave primaria. Una solución para estos escenarios en la utilización de un UUID como clave primaria.','2018-12-18 00:00:00.000','Campos UUID',NULL,NULL,'3bffb3b6-053d-11e9-a890-2f7374de4daa')
,('e39125f6-053d-11e9-a890-2f722157a746','Se garantiza la individualidad de cada clave : Aunque se utilicen varias tables, bases de datos y servidores las UUID seran diferentes.
Facilidad de unión de tablas: Si se trabaja en paralelo es posible unir registros o tablas enteras sin generar un conflicto por claves duplicadas
Permite la creación de relaciones sin necesidad de esperar a una de las partes: Si la tabla B tiene una relación con la tabla A es posible generar el registro de la tabla B con un UUID y luego agregar el registro en A con el UUID ya generado. En el caso de una clave primaria autoincremental es necesario crear antes el registro A para que pueda asignarse su clave.
La creación de claves puede ser externa : Aún trabajando en una misma base de datos la tarea de la creación de la clave puede generarse de manera paralela.','2018-12-19 00:00:00.000','Ventajas campos UUID',NULL,NULL,'3bffb3b6-053d-11e9-a890-2f7374de4daa')
,('2681778a-053e-11e9-a890-3385026e7856','Ocupan más espacio que una clave autoincremental: Utiliza 128 bytes mientras que un entero utiliza solo 4 bytes.
No permiten ordenar rápidamente por fecha de creación: Al utilizar claves autoincrementales el orden se genera automáticamente ya que los números son secuenciales.
El proceso de inserción puede ser lento para grandes volúmenes de datos: En algunos experimentos se ha detectado un aumento del tiempo de inserción al aumentar el volumen de datos.','2018-12-17 00:00:00.000','Desventajas campos UUID',NULL,NULL,'3bffb3b6-053d-11e9-a890-2f7374de4daa')
,('a191a0b7-7679-47d9-b866-b588029cfb00','DeepMind, el laboratorio londinense de inteligencia artificial que Google compró en 2014, ya ha creado programas que ganan siempre al ajedrez, al shogi y al Go, los juegos de tablero más complejos. Pero el objetivo final de la empresa no está en los pasatiempos, sino en resolver acuciantes problemas científicos. Su algoritmo AlphaFold, presentado a principios de diciembre en Cancún, México, ha ganado una competición mundial en predecir la estructura tridimensional de proteínas.

MÁS INFORMACIÓN
La inteligencia artificial de Google logra un hito frente a uno de los mayores retos de la biología Una máquina se enseña a sí misma a ganar en todo
La inteligencia artificial de Google logra un hito frente a uno de los mayores retos de la biología Así ha pasado la inteligencia artificial de diagnosticar el cáncer a tratarlo
La inteligencia artificial de Google logra un hito frente a uno de los mayores retos de la biología Científicos españoles crean un programa que predice la estructura de las proteínas

Las proteínas son las máquinas moleculares de los seres vivos. ','2018-12-20 00:00:00.000','La inteligencia artificial de Google',NULL,NULL,'881e14d2-064a-11e9-9be4-13628b2452a5')
,('7bf39b77-71a7-495d-a6dd-93f83dbaaa2c','Muchos no entendían cómo se podía ganar dinero con el Open Source, pero Red Hat comenzó a demostrar que tenía muy claras las cosas cuando a mediados de los 90 comenzó a dedicar todos sus esfuerzos a dar servicios empresariales centrados en sus soluciones basadas en Linux.

Aquel camino la convirtió en la primera empresa de ese ámbito en lograr unos ingresos de 1.000 millones de dólares, pero su crecimiento gracias a sus soluciones en la nube, por ejemplo, la han convertido en una potencia absoluta en el mundo Open Source. En un acuerdo histórico IBM se hace con Red Hat por 34.000 millones de dólares, la mayor cantidad jamás pagada por una empresa software.','2018-12-19 00:00:00.000','Muchos no entendían cómo se podía ganar dinero con el Open Source',NULL,NULL,'881e14d2-064a-11e9-9be4-13628b2452a5')
,('3c46f10d-4ae2-44c2-a950-86e491b959fc','Colocar en el mercado un televisor con resolución 8K en un momento en el que la resolución 4K UHD aún lucha por afianzarse parece una apuesta arriesgada. Y en gran medida lo es. Si además añadimos a la ecuación que los contenidos 8K fuera de Japón ni están ni se los espera a medio plazo, el contexto no parece el adecuado para que a este televisor de Samsung le vaya bien.

A pesar de este clima a priori tan desapacible, el panorama, en realidad, no es tan desfavorable a esta propuesta como puede parecer. Y no lo es porque la marca surcoreana ha apostado por «vendernos» la resolución 8K como una tecnología de mejora de la calidad de imagen más, equiparable, en cierta medida, a los nanocristales o el HDR. De hecho, gracias a un escalado que recurre al aprendizaje automático promete mejorar nuestra experiencia aunque nos limitemos a reproducir contenidos 4K UHD o Full HD.','2018-12-18 00:00:00.000','Samsung QLED 8K Q900R, análisis: en ausencia de contenidos 8K',NULL,NULL,'3bffb3b6-053d-11e9-a890-2f7374de4daa')
,('c3f4a72e-cfa4-43d4-a1c8-52bddff1dab4','Los smartwatches y relojes con conectividad para niños son una categoría de producto que goza de cierto éxito entre los padres y madres de niños de edades tempranas. Este tipo de relojes avanzados incluyen conectividad y GPS integrado para conocer en todo momento dónde se encuentra un niño y poder comunicarnos con él.

Aunque los diferentes modelos que existen en el mercado parecen similares, hemos estado probando cuatro relojes/móvil para niños para conocer sus diferencias y saber qué modelos son los más recomendables.

Aquí tienes nuestra guía-comparativa con los mejores relojes con GPS para niños.

Nuestro recomendado: Alcatel Move Time','2018-12-22 00:00:00.000','El mejor smartwatch para localizar y hablar con los niños',NULL,NULL,'881e14d2-064a-11e9-9be4-13628b2452a5')
;

INSERT INTO headbook.likes (post,usuario) VALUES 
('5c981604-053d-11e9-a890-2b2b1ebf1bb4','3bffb3b6-053d-11e9-a890-2f7374de4daa')
,('2681778a-053e-11e9-a890-3385026e7856','3bffb3b6-053d-11e9-a890-2f7374de4daa')
,('a191a0b7-7679-47d9-b866-b588029cfb00','881e14d2-064a-11e9-9be4-13628b2452a5')
,('e39125f6-053d-11e9-a890-2f722157a746','3bffb3b6-053d-11e9-a890-2f7374de4daa')
,('a191a0b7-7679-47d9-b866-b588029cfb00','3bffb3b6-053d-11e9-a890-2f7374de4daa')
,('5c981604-053d-11e9-a890-2b2b1ebf1bb4','881e14d2-064a-11e9-9be4-13628b2452a5')
,('3c46f10d-4ae2-44c2-a950-86e491b959fc','3bffb3b6-053d-11e9-a890-2f7374de4daa')
;