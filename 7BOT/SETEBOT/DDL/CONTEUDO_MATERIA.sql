drop table setebot_material;
drop table SETEBOT_DISCIPLINA;
drop table SETEBOT_CONTEUDO;



create table SETEBOT_DISCIPLINA (
    ID_DISCIPLINA number primary key,
    NOME VARCHAR2(70)
);

create table SETEBOT_CONTEUDO (
    ID_CONTEUDO number primary key,
    NOME VARCHAR2(70),
    ID_DISCIPLINA NUMBER,
    FOREIGN KEY (ID_DISCIPLINA) REFERENCES SETEBOT_DISCIPLINA(ID_DISCIPLINA)
);





create table SETEBOT_MATERIAL (
    ID_MATERIAL number primary key,
    TITULO VARCHAR2(70),
    ESCOPO VARCHAR(4000),
    ESCOPO2 VARCHAR(4000) null,
    ID_CONTEUDO number,
    FOREIGN KEY (ID_CONTEUDO) REFERENCES SETEBOT_CONTEUDO(ID_CONTEUDO)
);


insert into setebot_disciplina values(1, 'Matematica');

insert into setebot_conteudo values(1, 'Matematica baseica', 1);

insert into setebot_material values(1, 'Principios', 'Analisando a fórmula acima temos, por exemplo, Ab, que representa a medida da área da base do prisma. Então, para calcular a área da base do prisma temos que verificar qual o formato da base; nesse sentido, se for uma base triangular, a área da base é calculada usando a fórmula da área do 
triângulo; se for uma base retangular, a área é calculada usando a área do retângulo, e assim por diante.', null, 1);

select * from SETEBOT_DISCIPLINA;
select * from SETEBOT_CONTEUDO;
select escopo from setebot_material;
