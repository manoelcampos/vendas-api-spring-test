insert into estado(descricao, sigla) values ('São Paulo', 'SP');
insert into estado(descricao, sigla) values ('Paraná', 'PR');
insert into estado(descricao, sigla) values ('Santa Catarina', 'SC');
insert into estado(descricao, sigla) values ('Rio Grande do Sul', 'RS');
insert into estado(descricao, sigla) values ('Mato Grosso do Sul', 'MS');
insert into estado(descricao, sigla) values ('Rondônia', 'RO');
insert into estado(descricao, sigla) values ('Acre', 'AC');
insert into estado(descricao, sigla) values ('Amazonas', 'AM');
insert into estado(descricao, sigla) values ('Roraima', 'RR');
insert into estado(descricao, sigla) values ('Pará', 'PA');
insert into estado(descricao, sigla) values ('Amapá', 'AP');
insert into estado(descricao, sigla) values ('Tocantins', 'TO');
insert into estado(descricao, sigla) values ('Maranhão', 'MA');
insert into estado(descricao, sigla) values ('Rio Grande do Norte', 'RN');
insert into estado(descricao, sigla) values ('Paraíba', 'PB');
insert into estado(descricao, sigla) values ( 'Pernambuco', 'PE');
insert into estado(descricao, sigla) values ( 'Alagoas', 'AL');
insert into estado(descricao, sigla) values ( 'Sergipe', 'SE');
insert into estado(descricao, sigla) values ( 'Bahia', 'BA');
insert into estado(descricao, sigla) values ( 'Minas Gerais', 'MG');
insert into estado(descricao, sigla) values ( 'Rio de Janeiro', 'RJ');
insert into estado(descricao, sigla) values ( 'Mato Grosso', 'MT');
insert into estado(descricao, sigla) values ( 'Goiás', 'GO');
insert into estado(descricao, sigla) values ( 'Distrito Federal', 'DF');
insert into estado(descricao, sigla) values ( 'Piauí', 'PI');
insert into estado(descricao, sigla) values ( 'Ceará', 'CE');
insert into estado(descricao, sigla) values ( 'Espírito Santo', 'ES');

-- Capitais de cada Estado
insert into cidade (estado_id, descricao) values (1,'São Paulo'); -- São Paulo
insert into cidade (estado_id, descricao) values (2, 'Curitiba'); -- Paraná
insert into cidade (estado_id, descricao) values (3,'Florianópolis'); -- Santa Catarina
insert into cidade (estado_id, descricao) values (4,'Porto Alegre'); -- Rio Grande do Sul
insert into cidade (estado_id, descricao) values (5,'Campo Grande'); -- Mato Grosso do Sul
insert into cidade (estado_id, descricao) values (6, 'Porto Velho'); -- Rondônia
insert into cidade (estado_id, descricao) values (7, 'Rio Branco'); -- Acre
insert into cidade (estado_id, descricao) values (8, 'Manaus'); -- Amazonas
insert into cidade (estado_id, descricao) values (9, 'Boa Vista'); -- Roraima
insert into cidade (estado_id, descricao) values (10, 'Belém'); -- Pará
insert into cidade (estado_id, descricao) values (11, 'Macapá'); -- Amapá
insert into cidade (estado_id, descricao) values (12, 'Palmas'); -- Tocantins
insert into cidade (estado_id, descricao) values (13,'São Luís'); -- Maranhão
insert into cidade (estado_id, descricao) values (14,'Natal'); -- Rio Grande do Norte
insert into cidade (estado_id, descricao) values (15,'João Pessoa'); -- Paraíba
insert into cidade (estado_id, descricao) values (16,'Recife'); -- Pernambuco
insert into cidade (estado_id, descricao) values (17, 'Maceió'); -- Alagoas
insert into cidade (estado_id, descricao) values (18, 'Aracaju'); -- Sergipe
insert into cidade (estado_id, descricao) values (19, 'Salvador'); -- Bahia
insert into cidade (estado_id, descricao) values (20,'Belo Horizonte'); -- Minas Gerais
insert into cidade (estado_id, descricao) values (21,'Rio de Janeiro'); -- Rio de Janeiro
insert into cidade (estado_id, descricao) values (22, 'Cuiabá'); -- Mato Grosso
insert into cidade (estado_id, descricao) values (23,'Goiânia'); -- Goiás
insert into cidade (estado_id, descricao) values (24,'Brasília'); -- Distrito Federal
insert into cidade (estado_id, descricao) values (25, 'Teresina'); -- Piauí
insert into cidade (estado_id, descricao) values (26, 'Fortaleza'); -- Ceará
insert into cidade (estado_id, descricao) values (27,'Vitória'); -- Espírito Santo

insert into cliente(nome, cpf, cidade_id) values ('Manoel', '11111111111', 1)
