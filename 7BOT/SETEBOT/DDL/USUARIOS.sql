drop table SETEBOT_USUARIO;

drop table SETEBOT_ADM;

drop table PERIODO;

drop table SETEBOT_ALUNO cascade CONSTRAINTS;

drop sequence setb;
drop sequence setb_aluno;

create sequence setb_aluno;
create sequence setb;

create table SETEBOT_USUARIO (
    ID_USUARIO number primary key,
    NOME VARCHAR2(70),
    EMAIL VARCHAR2(80) unique,
    SENHA VARCHAR2(80)
);

create table SETEBOT_ADM (
    ID_ADM number primary key,
    CHAVE CHAR(8) unique,
    ID_USUARIO number,
    FOREIGN KEY (ID_USUARIO) REFERENCES SETEBOT_USUARIO(ID_USUARIO)
);

create table PERIODO (
    ID_PERIODO number primary key,
    PERIODO VARCHAR2(10)    
);
insert into PERIODO VALUES(1, 'MANHA');
insert into PERIODO VALUES(2,'TARDE');
insert into PERIODO VALUES(3,'NOITE');

create table SETEBOT_ALUNO (
    ID_ALUNO number primary key,
    DATA_NASC CHAR(11),
    ESTADO CHAR(2),
    USUARIO_ESTUDA CHAR(1),
    NOME_INSTITUICAO VARCHAR2(70) null,
    PERIODO number,
    ID_USUARIO number,
    FOREIGN KEY (PERIODO) REFERENCES PERIODO(ID_PERIODO),
    FOREIGN KEY (ID_USUARIO) REFERENCES SETEBOT_USUARIO(ID_USUARIO)
);

insert into SETEBOT_USUARIO VALUES (setb.nextval, 'Wagner', 'wagner@hotmail.com', '132456789');

insert into SETEBOT_ADM VALUES (setb.nextval, '1234tred', (SELECT ID_USUARIO FROM SETEBOT_USUARIO WHERE EMAIL = 'wagner@hotmail.com') );

insert into SETEBOT_USUARIO VALUES (setb.nextval, 'Joao', 'Joao@hotmail.com', '132456789');

insert into SETEBOT_ALUNO VALUES(setb_aluno.nextval, '12-08-2001', 'SP', '1', 'FIAP', 1, (SELECT ID_USUARIO FROM SETEBOT_USUARIO WHERE EMAIL = 'Joao@hotmail.com'));

select * from SETEBOT_USUARIO;
select * from SETEBOT_ADM;
select * from SETEBOT_ALUNO;
select * from PERIODO;